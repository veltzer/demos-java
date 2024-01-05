package swing.layout_managers.htmllayout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.Hashtable;

/**
 * HtmlLayout uses a string containing HTML like table tags to layout
 * components. <BR> Ex: <BR> <pre> &lt;table rows=2 cols=2&gt; &lt;tr&gt;
 * &lt;td&gt; A label &lt;td component=someName&gt; &lt;tr&gt; &lt;td
 * component=anotherName vert=max&gt; &lt;td component="some other name"
 * horz=max&gt; </pre> <H1>Tags and their options</H1> <H2>Table</H2> <UL>
 * <LI>Contains TR <BR> <BR> <LI>horz= LEFT | RIGHT | CENTER | FIT | (MAX) <BR>
 * Specifies how the table fills the available width <LI>vert= TOP | BOTTOM |
 * CENTER | FIT | (MAX) <BR> Specifies how the table fills the available height
 * <LI>rows=y ; y = rowCount (req) <LI>cols=y ; y = colCount (req) <LI>hgap=y ;
 * y = horizontal gap between components <LI>vgap=y ; y = vertical gap between
 * components <LI>hpad=y ; y = horizontal padding (components made wider)
 * <LI>vpad=y ; y = vertical padding (components made taller) </UL> <H2>TR</H2>
 * <UL> <LI>Contains TD <BR> <BR> <LI>vgap=y ; y = gap between this row and the
 * row above </UL> <H2>TD</H2> <UL> <LI>Contains text (creates a label) or TABLE
 * but only if no component is specified. Nested tables inherit the gaps and
 * pads of their enclosing table. <BR> <BR> <LI>colspan=y <LI>rowspan=y
 * <LI>horz= (LEFT) | RIGHT | CENTER | FIT | MAX <BR> Specifies how the
 * component fills the available cell width <LI>vert= TOP | BOTTOM | (CENTER) |
 * FIT | MAX <BR> Specifies how the component fills the available cell height
 * <LI>hgap=y ; y = horizontal gap between components <LI>vgap=y ; y = vertical
 * gap between components <LI>hpad=y ; y = horizontal padding <LI>vpad=y ; y =
 * vertical padding (components made larger) <LI>component="componentName" ;
 * this is the name that must be used when add is called, as in add(comp,
 * "componentName") </UL>
 */
public class HtmlLayout implements LayoutManager {
	static final String ANONLABELNAME = new String("Anonymous label");
	private boolean labelsAdded;

	// x in xLayoutSize()
	static final int MIN = 0, PREF = 1;

	// alignment
	static final int LEFT = 0, RIGHT = 1, CENTER = 2, FIT = 3, MAX = 4, TOP = 5,
			BOTTOM = 6;

	static final String[] ALIGNNAMES = {
			"LEFT", "RIGHT", "CENTER", "FIT", "MAX", "TOP", "BOTTOM"
	};

	/* these tables are shared by the layout and all nested layouts */
	private Hashtable<String, Cell> nameToCell;
	private Hashtable<Component, Cell> compToCell;

	/* this belongs only to this layout */
	private Cell[] cells, cellsColFirst;
	private int rows, cols;
	private int horzAlign = MAX, vertAlign = MAX;
	private Dimension prefDim = new Dimension(-1, -1);

	/**
	 * Creates an HtmlLayout with the specified "HTML" string.
	 * @param html The "HTML" which specifies the layout, if this is not valid
	 * table-html a BadTableHtmlException will be thrown. Html can be tested
	 * ahead of time using HtmlLayoutTest.
	 * @see htmllayout.BadTableHtmlException
	 * @see htmllayout.HtmlLayoutTest
	 */
	public HtmlLayout(String html) {
		nameToCell = new Hashtable<String, Cell>(30);
		compToCell = new Hashtable<Component, Cell>(30);
		parse(new Scanner(html), true, null);

		addCellsToTable(nameToCell);
	}

	HtmlLayout(TableParser parent) {
		parse(parent.getIn(), false, parent);
	}

	/**
	 * If this layout includes any automatic lables (text within a TD) this will
	 * add them to container parent. It is not always necessary to call this, if
	 * you don't it will automatically be called when the container is first
	 * sized or layed out. Ordinarily this is ok but not always, such as when
	 * using CardLayout. Calling addLabels manually at the same time as the
	 * other components are added will never be a problem.
	 */
	public void addLabels(Container parent) {
		for (int i = 0; i < getCells().length; i++) {
			getCells()[i].addLabels(parent);
		}

		labelsAdded = true;
	}

	public void addLayoutComponent(String name, Component comp) {
		prefDim.width = -1;
		if (name == ANONLABELNAME) {
			return;
		}

		if (name == null) {
			throw new IllegalArgumentException("null component name");
		}

		Cell c = nameToCell.get(name);

		if (c == null) {
			throw new IllegalArgumentException(
					"Cannot add to layout: unknown component name " + name);
		}

		compToCell.put(comp, c);
		c.setComp(comp);
	}

	public void removeLayoutComponent(Component comp) {
		prefDim.width = -1;
		Cell c = compToCell.remove(comp);
		if (c != null) {
			c.setComp(null);
		}
	}

	public Dimension preferredLayoutSize(Container parent) {
		return layoutSize(parent, PREF);
	}

	public Dimension minimumLayoutSize(Container parent) {
		return layoutSize(parent, MIN);
	}

	void parse(Scanner s, boolean eatTable, TableParser parent) {
		TableParser tp = new TableParser(s, eatTable, parent);
		rows = tp.getRows();
		cols = tp.getCols();
		horzAlign = tp.getHorz();
		vertAlign = tp.getVert();

		setCells(new Cell[tp.getCellCount()]);
		int cpos = 0;

		cellsColFirst = new Cell[tp.getCellCount()];
		int ccfpos = 0;

		for (int i = 0; i < rows * cols; i++) {
			if (tp.getCells()[i / cols][i % cols] != null) {
				getCells()[cpos] = tp.getCells()[i / cols][i % cols];
				cpos++;
			}
			if (tp.getCells()[i % rows][i / rows] != null) {
				cellsColFirst[ccfpos] = tp.getCells()[i % rows][i / rows];
				ccfpos++;
			}
		}
	}

	Dimension layoutSize(Container parent, int whichSize) {
		if (!labelsAdded) {
			addLabels(parent);
		}

		return layoutSize(parent.getInsets(), whichSize);
	}

	Dimension layoutSize(Insets insets, int whichSize) {
		int[] ypos = new int[rows + 1];
		int[] xpos = new int[cols + 1];

		for (int i = 0; i < getCells().length; i++) {
			getCells()[i].updateSize(whichSize);
		}

		for (int i = 0; i < getCells().length; i++) {
			getCells()[i].addToYTable(ypos);
			cellsColFirst[i].addToXTable(xpos);
		}

		Dimension d = new Dimension(xpos[cols], ypos[rows]);

		prefDim.width = d.width;
		prefDim.height = d.height;
		d.width += insets.left + insets.right;
		d.height += insets.top + insets.bottom;
		return d;
	}

	public void layoutContainer(Container parent) {
		if (!labelsAdded) {
			addLabels(parent);
		}

		Insets insets = parent.getInsets();
		Dimension d = parent.getSize();
		int top = insets.top;
		int bottom = d.height - insets.bottom;
		int left = insets.left;
		int right = d.width - insets.right;

		preferredLayoutSize(parent); // will set prefDim
		if (right - left < prefDim.width || bottom - top < prefDim.height) {
			minimumLayoutSize(parent); // will set prefDim to minSize
		}

		layout(top, bottom, left, right);
	}

	void layout(int top, int bottom, int left, int right) {

		if (right - left > prefDim.width) {
			if (horzAlign != MAX && horzAlign != FIT) {
				left = calcTopOrLeft(left, right, prefDim.width, horzAlign);
				right = left + prefDim.width;
			}
		}

		if (bottom - top > prefDim.height) {
			if (vertAlign != MAX && vertAlign != FIT) {
				top = calcTopOrLeft(top, bottom, prefDim.height, vertAlign);
				bottom = top + prefDim.height;
			}
		}

		doLayout(top, bottom, left, right);
	}

	private void doLayout(int top, int bottom, int left, int right) {
		int[] ypos = new int[rows + 1];
		int[] xpos = new int[cols + 1];

		layoutDim(xpos, left, right, true);
		layoutDim(ypos, top, bottom, false);

		for (int i = 0; i < getCells().length; i++) {
			getCells()[i].finalLayout(xpos, ypos);
		}
	}

	private void layoutDim(int[] pos, int start, int end, boolean isX) {
		pos[0] = start;

		boolean[] want = new boolean[pos.length - 1];

		for (int i = 0; i < getCells().length; i++) {
			if (isX) {
				cellsColFirst[i].firstXLayout(pos, want);
			} else {
				getCells()[i].firstYLayout(pos, want);
			}
		}

		int diff = end - pos[want.length];

		if (diff < 0) {
			squeeze(-diff, pos, isX);
		} else if (diff > 0) {
			grow(diff, pos, want);
		}

		pos[pos.length - 1] = end;
	}

	// squeeze the components to make this 'pixels' pixels smaller
	private void squeeze(int pixels, int[] vals, boolean isX) {
		int size;
		if (isX) {
			size = rows;
		} else {
			size = cols;
		}
		int[][] touch = new int[vals.length][size];
		int[] limit = new int[vals.length];

		int downto = vals[vals.length - 1] - pixels;

		// less than 2 is dumb and I think bad things could happen
		if (downto < 2) {
			return;
		}

		while (vals[vals.length - 1] > downto) {
			int[] count = new int[vals.length];
			for (int i = 0; i < limit.length; i++) {
				limit[i] = Integer.MAX_VALUE;
			}

			for (int i = 0; i < getCells().length; i++) {
				if (isX) {
					cellsColFirst[i].squeezeX(vals, touch, count, limit);
				} else {
					getCells()[i].squeezeY(vals, touch, count, limit);
				}
			}

			boolean[] scale = new boolean[vals.length];
			int max = maxSqueeze(vals.length - 1, touch, count, limit, vals,
					scale);

			int amount = Math.min(pixels, max);
			int width = vals[vals.length - 1] - vals[0];
			int slide = 0;

			for (int i = 0; i < vals.length; i++) {
				if (scale[i]) {
					slide = amount * (vals[i] - vals[0]) / width;
				}
				vals[i] -= slide;
			}
			pixels -= slide;
		}
	}

	private int maxSqueeze(int rule, int[][] touch, int[] count, int[] limit,
			int[] vals, boolean[] scale) {

		// this rule will be scaled, not slidden
		scale[rule] = true;

		// how much can we go before more parts touch our left side?
		int max = limit[rule];

		for (int i = 0; i < count[rule]; i++) {
			int othermax = maxSqueeze(touch[rule][i], touch, count, limit, vals,
					scale);

			if (othermax < max) {
				max = othermax;
			}
		}

		return max;
	}

	private void grow(int pixels, int[] vals, boolean[] where) {

		int count = 0;
		for (int i = 0; i < where.length; i++) {
			if (where[i]) {
				count++;
			}
		}

		boolean all = count == 0;

		if (all) {
			count = where.length;
		}

		double dif = (pixels - 0.001) / count;
		double a = 0.0;

		for (int i = 0; i < where.length; i++) {
			if (all || where[i]) {
				a += dif;
			}

			vals[i + 1] += (int) a;
		}
	}

	static int calcTopOrLeft(int tol, int bor, int wid, int align) {
		int newTol;

		switch (align) {
		case LEFT:
		case TOP:
			newTol = tol;
			break;

		case RIGHT:
		case BOTTOM:
			newTol = bor - wid;
			break;

		case CENTER:
			newTol = tol + (bor - tol - wid) / 2;
			break;

		default:
			throw new Error("illegal align value");
		}

		return newTol;
	}

	void addCellsToTable(Hashtable<String, Cell> nToCell) {
		for (int i = 0; i < getCells().length; i++) {
			getCells()[i].addToNameTable(nToCell);
		}
	}

	private String descString() {
		return " dim = " + cols + ", " + rows + " fill = " + horzAlign + ", "
				+ vertAlign;
	}

	void dump(int space) {
		for (int i = 0; i < space; i++) {
			System.err.print(' ');
		}

		System.err.println("HtmlLayout" + descString());

		for (int i = 0; i < getCells().length; i++) {
			getCells()[i].dump(space + 2);
		}
	}

	public String toString() {
		String s = "[HtmlLayout" + descString() + " cells =";

		for (int i = 0; i < getCells().length; i++) {
			s += " " + getCells()[i];
		}

		return s + "]";
	}

	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] icells) {
		cells = icells;
	}
}
