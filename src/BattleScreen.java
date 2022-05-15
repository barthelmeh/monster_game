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

public class BattleScreen {

	private JFrame window;
	private MainGame manager;
	private ArrayList<Monster> playerTeam;
	private Battle currBattle;

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
		currBattle = battleManager;
		playerTeam = manager.getPlayer().getTeam();
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeBattleScreen(this);
	}
	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(0, 0, 800, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		
		JPanel panelPlayer = new JPanel();
		panelPlayer.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panelPlayerTeam = new JPanel();
		
		JPanel panelEnemyTeam = new JPanel();
		
		JPanel panelEnemy = new JPanel();
		panelEnemy.setLayout(null);
		panelEnemy.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel EnemyHealth = new JLabel("Health: "+currBattle.getTeam().get(0).getMonsterCurrentHealth());
		EnemyHealth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EnemyHealth.setBounds(10, 43, 125, 14);
		panelEnemy.add(EnemyHealth);
		
		JLabel EnemyName = new JLabel(currBattle.getTeam().get(0).getName());
		EnemyName.setHorizontalAlignment(SwingConstants.CENTER);
		EnemyName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EnemyName.setBounds(10, 11, 125, 21);
		panelEnemy.add(EnemyName);
		
		JLabel EnemyDamage = new JLabel("Damage: "+currBattle.getTeam().get(0).getDamage());
		EnemyDamage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		EnemyDamage.setBounds(10, 90, 125, 21);
		panelEnemy.add(EnemyDamage);
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(panelPlayer, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addComponent(panelPlayerTeam, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
							.addGap(92)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelEnemy, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelEnemyTeam, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelEnemy, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelPlayer, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(51)
							.addComponent(panelPlayerTeam, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
						.addComponent(panelEnemyTeam, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelPlayer.setLayout(null);
		
		JLabel CurrentHealth = new JLabel("Health: "+playerTeam.get(0).getMonsterCurrentHealth());
		CurrentHealth.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CurrentHealth.setBounds(10, 43, 125, 14);
		panelPlayer.add(CurrentHealth);
		JLabel playerMonster = new JLabel(playerTeam.get(0).getName());
		playerMonster.setFont(new Font("Tahoma", Font.PLAIN, 13));
		playerMonster.setHorizontalAlignment(SwingConstants.CENTER);
		playerMonster.setBounds(10, 11, 125, 21);
		panelPlayer.add(playerMonster);
		
		JLabel damageLabel = new JLabel("Damage: " + playerTeam.get(0).getDamage());
		damageLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		damageLabel.setBounds(10, 90, 125, 21);
		panelPlayer.add(damageLabel);
		panelPlayerTeam.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelPlayerTeam.add(lblNewLabel_1);
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
