package swing.ve;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	private JEditorPane jEditorPanenull;
	private JPanel jContentPane;
	private JPanel centralPanel;
	private JPanel bottomPanel;
	private JButton playButton;
	private JButton pauseButton;
	private JButton stopButton;
	private JScrollPane jScrollPane;

	/**
	 * This method initializes centralPanel
	 */
	private JPanel getCentralPanel() {
		if (centralPanel == null) {
			centralPanel = new JPanel();
			centralPanel.setLayout(new BorderLayout());
			centralPanel.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return centralPanel;
	}

	/**
	 * This method initializes bottomPanel
	 */
	private JPanel getBottomPanel() {
		if (bottomPanel == null) {
			bottomPanel = new JPanel();
			bottomPanel.setLayout(new FlowLayout());
			bottomPanel.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createEmptyBorder(5, 5, 5, 5),
					BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
			bottomPanel.add(getPlayButton(), null);
			bottomPanel.add(getPauseButton(), null);
			bottomPanel.add(getStopButton(), null);
		}
		return bottomPanel;
	}

	/**
	 * This method initializes playButton
	 */
	private JButton getPlayButton() {
		if (playButton == null) {
			playButton = new JButton();
			playButton.setText("Play");
			playButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseExited(MouseEvent e) {
					playButton.setText("Play");
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					playButton.setText("Well?");
				}
			});
			playButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("actionPerformed()");
				}
			});
		}
		return playButton;
	}

	/**
	 * This method initializes pauseButton
	 */
	private JButton getPauseButton() {
		if (pauseButton == null) {
			pauseButton = new JButton();
			pauseButton.setText("Pause");
			pauseButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("actionPerformed()");
				}
			});
		}
		return pauseButton;
	}

	/**
	 * This method initializes stopButton
	 */
	private JButton getStopButton() {
		if (stopButton == null) {
			stopButton = new JButton();
			stopButton.setText("Stop");
		}
		return stopButton;
	}

	/**
	 * This method initializes jEditorPane
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPanenull == null) {
			jEditorPanenull = new JEditorPane();
		}
		return jEditorPanenull;
	}

	/**
	 * This method initializes jScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJEditorPane());
		}
		return jScrollPane;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyFrame thisClass = new MyFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public MyFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getCentralPanel(), BorderLayout.CENTER);
			jContentPane.add(getBottomPanel(), BorderLayout.SOUTH);
		}
		return jContentPane;
	}

}
