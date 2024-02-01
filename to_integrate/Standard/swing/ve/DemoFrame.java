package swing.ve;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import swing.graphics2d.RollingPolygon;

@SuppressWarnings("serial")
public class DemoFrame extends JFrame {
	private JPanel jContentPane;
	private JPanel jPanel;
	private JButton jButton;
	private JButton renameButton;
	private JSplitPane jSplitPane;
	private JTree jTree;
	private JScrollPane jScrollPane;
	private JPanel jPanel1;
	private JMenuBar jJMenuBar;
	private JMenu jMenu;
	private JMenuItem jMenuItem;

	/**
	 * This method initializes jContentPane
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), BorderLayout.SOUTH);
			jContentPane.add(getJSplitPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			jPanel = new JPanel();
			jPanel.setLayout(flowLayout);
			jPanel.add(getJButton(), null);
			jPanel.add(getRenameButton(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Delete");
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("actionPerformed()");
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes renameButton
	 */
	private JButton getRenameButton() {
		if (renameButton == null) {
			renameButton = new JButton();
			renameButton.setText("Rename");
			renameButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					renameButton.setText("Rename");
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					renameButton.setText("Well...?");
				}
			});
		}
		return renameButton;
	}

	/**
	 * This method initializes jSplitPane
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
			jSplitPane.setDividerLocation(100);
			jSplitPane.setRightComponent(getJScrollPane());
			jSplitPane.setLeftComponent(getJTree());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jTree
	 */
	private JTree getJTree() {
		if (jTree == null) {
			jTree = new JTree();
		}
		return jTree;
	}

	/**
	 * This method initializes jScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJPanel1());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jPanel1
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());

			RollingPolygon poly = new RollingPolygon();
			poly.init();
			poly.setRunning(true);
			poly.setToolTipText("rolling polygon");
			jPanel1.add(poly, BorderLayout.CENTER);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jJMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("File");
			jMenu.add(getJMenuItem());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setMnemonic(KeyEvent.VK_X);
			jMenuItem.setText("Exit");
		}
		return jMenuItem;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				DemoFrame thisClass = new DemoFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public DemoFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * @return void
	 */
	private void initialize() {
		this.setSize(456, 333);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

} // @jve:decl-index=0:visual-constraint="72,9"
