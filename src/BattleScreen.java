import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleScreen {

	private JFrame window;
	private MainGame manager;
	private ArrayList<Monster> playerTeam;
	private Battle currBattle;
	private BattleScreen screen;
	private ArrayList<Monster> enemyTeam;

	public JLabel playerNextMonster;
	public JLabel enemyNextMonster;
	public JLabel playerMonsterName;
	public JLabel playerMonsterHealth;
	public JLabel playerMonsterDamage;
	public JLabel enemyMonsterHealth;
	public JLabel enemyMonsterName;
	public JLabel enemyMonsterDamage;
	public JLabel scoreLabel;
	public JLabel currentTurn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleScreen window = new BattleScreen();
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
	
	public BattleScreen() {
		initialize();
	}
	
	public BattleScreen(MainGame incomingManager, Battle battleManager) {
		manager = incomingManager;
		screen = this;
		currBattle = battleManager;
		enemyTeam = currBattle.getTeam();
		playerTeam = manager.getPlayer().getTeam();
		initialize();
		window.setVisible(true);
	}
	
	public Battle getCurrentBattle() {
		return currBattle;
	}
	
	public void closeWindow() {
		window.dispose();
	}
	public void winWindow() {
		manager.closeBattleScreen(this, true);
	}
	public void loseWindow() {
		manager.closeBattleScreen(this, false);
	}

	public void updateMonsters(String team) {
		switch(team) {
			case "Player":
				//Enemy has just attacked so players turn next
				currentTurn.setText("Current Turn: Player");
				
				// Update next monster text
				String PlayerNextMonsterString = "No Next Monster";
				if(playerTeam.size() > 1) {
					PlayerNextMonsterString = playerTeam.get(1).getName();
				}
				playerNextMonster.setText(PlayerNextMonsterString);
				
				// Update player monster
				if (playerTeam.size() > 0) {
					Monster nextMonster = playerTeam.get(0);
					playerMonsterName.setText(nextMonster.getName());
					playerMonsterDamage.setText("Damage: " + Integer.toString(nextMonster.getDamage()));
					playerMonsterHealth.setText("Health: " + Integer.toString(nextMonster.getMonsterCurrentHealth()));

				} else {
					playerMonsterName.setText("you lost");
					playerMonsterDamage.setText("");
					playerMonsterHealth.setText("");
				}
				break;
			case "Enemy":
				// Player has just attacked so enemy turn next
				currentTurn.setText("Current Turn: Enemy");
				
				// Update next monster text
				String EnemyNextMonsterString = "No Next Monster";
				if(enemyTeam.size() > 1) {
					EnemyNextMonsterString = enemyTeam.get(1).getName();
				}
				enemyNextMonster.setText(EnemyNextMonsterString);
				
				// Update enemy monster
				if (enemyTeam.size() > 0) {
					Monster nextMonster = enemyTeam.get(0);
					enemyMonsterName.setText(nextMonster.getName());
					enemyMonsterDamage.setText("Damage: " + Integer.toString(nextMonster.getDamage()));
					enemyMonsterHealth.setText("Health: " + Integer.toString(nextMonster.getMonsterCurrentHealth()));

				} else {
					// Enemy has died
					enemyMonsterName.setText("");
					enemyMonsterDamage.setText("");
					enemyMonsterHealth.setText("");
				}
				break;
			default:
				break;
		}
	}

	/**
	 * Initialize the contents of the window.
	 */
	public void initialize() {
		window = new JFrame();
		window.setBounds(0, 0, 800, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panelPlayerTeam = new JPanel();
		
		JPanel panelEnemy = new JPanel();
		panelEnemy.setLayout(null);
		panelEnemy.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel EnemyHealth = new JLabel("Health: "+currBattle.getTeam().get(0).getMonsterCurrentHealth());
		enemyMonsterHealth = EnemyHealth;
		EnemyHealth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EnemyHealth.setBounds(10, 43, 125, 14);
		panelEnemy.add(EnemyHealth);
		
		JLabel EnemyName = new JLabel(currBattle.getTeam().get(0).getName());
		enemyMonsterName = EnemyName;
		EnemyName.setHorizontalAlignment(SwingConstants.CENTER);
		EnemyName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EnemyName.setBounds(10, 11, 125, 21);
		panelEnemy.add(EnemyName);
		
		JLabel EnemyDamage = new JLabel("Damage: "+currBattle.getTeam().get(0).getDamage());
		enemyMonsterDamage = EnemyDamage;
		EnemyDamage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EnemyDamage.setBounds(10, 90, 125, 21);
		panelEnemy.add(EnemyDamage);
		
		JLabel lblNewLabel_3 = new JLabel("VS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelEnemyTeam = new JPanel();
		panelEnemyTeam.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Next:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 47, 304, 33);
		panelEnemyTeam.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Enemy Team:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_4_1.setBounds(10, 11, 304, 25);
		panelEnemyTeam.add(lblNewLabel_4_1);
		
		JPanel enemyNextMonsterPanel = new JPanel();
		enemyNextMonsterPanel.setBounds(73, 47, 219, 33);
		panelEnemyTeam.add(enemyNextMonsterPanel);

		String enemyNextMonsterString = "No Next Monster";
		if(enemyTeam.size() > 1) {
			enemyNextMonsterString = enemyTeam.get(1).getName();
		}
		
		JLabel enemyNextMonsterLabel = new JLabel(enemyNextMonsterString);
		enemyNextMonster = enemyNextMonsterLabel;
		enemyNextMonsterLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		enemyNextMonsterPanel.add(enemyNextMonsterLabel);
		
		JButton btnNewButton = new JButton("Next Turn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currBattle.runBattle(screen);
			}
		});
		
		JLabel currentTurnLabel = new JLabel("Current Turn: Player");
		currentTurn = currentTurnLabel;
		currentTurnLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		currentTurnLabel.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(currentTurnLabel, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelPlayerTeam, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelPlayer, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(panelEnemy, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
									.addGap(179))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panelEnemyTeam, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelEnemy, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelPlayer, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(lblNewLabel_3)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(currentTurnLabel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelPlayerTeam, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelEnemyTeam, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(23))))
		);
		panelPlayer.setLayout(null);
		
		JLabel CurrentHealth = new JLabel("Health: "+playerTeam.get(0).getMonsterCurrentHealth());
		playerMonsterHealth = CurrentHealth;
		CurrentHealth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CurrentHealth.setBounds(10, 43, 125, 14);
		panelPlayer.add(CurrentHealth);

		JLabel playerMonster = new JLabel(playerTeam.get(0).getName());
		playerMonsterName = playerMonster;
		playerMonster.setFont(new Font("Tahoma", Font.PLAIN, 13));
		playerMonster.setHorizontalAlignment(SwingConstants.CENTER);
		playerMonster.setBounds(10, 11, 125, 21);
		panelPlayer.add(playerMonster);
		
		JLabel damageLabel = new JLabel("Damage: " + playerTeam.get(0).getDamage());
		playerMonsterDamage = damageLabel;
		damageLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		damageLabel.setBounds(10, 90, 125, 21);
		panelPlayer.add(damageLabel);
		panelPlayerTeam.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Next:");
		lblNewLabel_1.setBounds(10, 47, 304, 33);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelPlayerTeam.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Player Team:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(10, 11, 304, 25);
		panelPlayerTeam.add(lblNewLabel_4);
		
		JPanel nextMonsterPanel = new JPanel();
		nextMonsterPanel.setBounds(73, 47, 219, 33);
		panelPlayerTeam.add(nextMonsterPanel);
		
		String nextMonsterString = "No Next Monster";
		if(playerTeam.size() > 1) {
			nextMonsterString = playerTeam.get(1).getName();
		}
		
		JLabel nextMonsterLabel = new JLabel(nextMonsterString);
		playerNextMonster = nextMonsterLabel;
		nextMonsterLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nextMonsterPanel.add(nextMonsterLabel);
		panelTop.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Day: "+manager.getCurrentDay());
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Score: "+manager.getPlayer().getPoints());
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblNewLabel_2);
		window.getContentPane().setLayout(groupLayout);
	}
}
