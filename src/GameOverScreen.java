
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameOverScreen {

	private JFrame window;
	private MainGame manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOverScreen window = new GameOverScreen();
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
	public GameOverScreen() {
		initialize();
	}
	
	public GameOverScreen(MainGame incomingManager) {
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeGameOverScreen(this);
	}
	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1125, 514);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblGameOverLabel = new JLabel("Game Over");
		lblGameOverLabel.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblGameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOverLabel.setBounds(10, 11, 1099, 398);
		window.getContentPane().add(lblGameOverLabel);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnNewButton.setBounds(486, 420, 102, 44);
		window.getContentPane().add(btnNewButton);
	}

}
