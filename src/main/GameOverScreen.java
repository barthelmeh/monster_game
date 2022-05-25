package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class GameOverScreen {

	private JFrame window;
	private MainGame manager;
	
	public int daysLasted = 0;
	public int score = 0;
	

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
	/**
	 * Class Constructor that specifies the main game in the background
	 * @param incomingManager Main Game the is running in the background
	 */
	public GameOverScreen(MainGame incomingManager) {
		manager = incomingManager;
		score = manager.getPlayer().getScore();
		daysLasted = manager.getCurrentDay();
		
		initialize();
		window.setVisible(true);
	}
	/**
	 * closes window to user
	 */
	public void closeWindow() {
		window.dispose();
	}
	/**
	 * closes window to user via manager to continue game running
	 */
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
		
		JLabel lblGameOverLabel = new JLabel("Game Over");
		lblGameOverLabel.setForeground(Color.BLUE);
		lblGameOverLabel.setVerticalAlignment(SwingConstants.TOP);
		lblGameOverLabel.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblGameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		
		JLabel lblScoreLabel = new JLabel("Score: " + score);
		lblScoreLabel.setForeground(Color.BLACK);
		lblScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblDaysLasted = new JLabel("Days lasted: " + daysLasted);
		lblDaysLasted.setForeground(Color.BLACK);
		lblDaysLasted.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDaysLasted.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDaysLasted, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(495)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblGameOverLabel, GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblScoreLabel, GroupLayout.DEFAULT_SIZE, 1101, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(lblGameOverLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblScoreLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(lblDaysLasted, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
		);
		window.getContentPane().setLayout(groupLayout);
	}
}
