import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplyItemScreen {

	private JFrame window;
	private ApplyItemScreen screen;
	private MainGame manager;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyItemScreen window = new ApplyItemScreen();
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
	public ApplyItemScreen() {
		initialize();
	}
	public ApplyItemScreen(MainGame incomingManager, JButton incomingButton) {
		screen = this;
		manager = incomingManager;
		button = incomingButton;
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeApplyItemScreen(screen, button);
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
