import java.awt.EventQueue;

import javax.swing.JFrame;

public class battleScreen {

	private JFrame window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					battleScreen window = new battleScreen();
					window.window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public battleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 450, 300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
