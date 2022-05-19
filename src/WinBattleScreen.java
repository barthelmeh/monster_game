import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WinBattleScreen {

	private JFrame window;
	private MainGame manager;
	
	public JLabel gainedCoinsLabel;
	public JLabel gainedScoreLabel;
	private Battle battleManager;
	private int coinsGained;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinBattleScreen window = new WinBattleScreen();
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
	public WinBattleScreen() {
		initialize();
	}
	
	public WinBattleScreen(MainGame incomingManager, Battle incomingBattle) {
		manager = incomingManager;
		battleManager = incomingBattle;
		coinsGained = battleManager.getCoinsGained();
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
		manager.setUpStore();
	}
	public void finishedWindow() {
		closeWindow();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(0, 0, 800, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel youWinLabel = new JLabel("You have won the battle!");
		youWinLabel.setForeground(Color.BLUE);
		youWinLabel.setBounds(10, 11, 764, 43);
		youWinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		youWinLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		window.getContentPane().add(youWinLabel);
		
		JLabel gainedLabel = new JLabel("You gained:");
		gainedLabel.setBounds(10, 103, 764, 43);
		gainedLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		gainedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		window.getContentPane().add(gainedLabel);
		
		JLabel coinsLabel = new JLabel(coinsGained + " coins");
		gainedCoinsLabel = coinsLabel;
		coinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		coinsLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		coinsLabel.setBounds(10, 168, 764, 43);
		window.getContentPane().add(coinsLabel);
		
		JLabel scoreLabel = new JLabel("x points");
		gainedScoreLabel = scoreLabel;
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		scoreLabel.setBounds(10, 222, 764, 43);
		window.getContentPane().add(scoreLabel);
		
		JButton storeButton = new JButton("Okay");
		storeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		storeButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		storeButton.setBounds(10, 361, 764, 39);
		window.getContentPane().add(storeButton);
	}
}
