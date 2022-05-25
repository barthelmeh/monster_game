package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreScreen {

	private JFrame window;
	private MainGame manager;
	private Player player;
	private StoreScreen screen;
	private Monster firstStoreMonster;
	private Monster secondStoreMonster;
	private Monster thirdStoreMonster;
	private Item firstStoreItem;
	private Item secondStoreItem;
	private Item thirdStoreItem;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StoreScreen window = new StoreScreen();
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
	public StoreScreen() {
		initialize();
	}
	public StoreScreen(MainGame incomingManager, Player incomingPlayer) {
		manager = incomingManager;
		player = incomingPlayer;
		firstStoreMonster = manager.getStoreMonsters().get(0);
		secondStoreMonster = manager.getStoreMonsters().get(1);
		thirdStoreMonster = manager.getStoreMonsters().get(2);
		firstStoreItem = manager.getStoreItems().get(0);
		secondStoreItem = manager.getStoreItems().get(1);
		thirdStoreItem = manager.getStoreItems().get(2);
		screen = this;
		initialize();
		window.setVisible(true);
		
	}
	public void restartWindow() {
		manager.closeStoreScreen(screen, true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow(String s) {
		manager.closeStoreScreen(this, s);
	}
	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1185, 705);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMonster = new JPanel();
		panelMonster.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagLayout gbl_panelMonster = new GridBagLayout();
		gbl_panelMonster.columnWidths = new int[]{245, 81, 81, 81, 0};
		gbl_panelMonster.rowHeights = new int[]{42, 42, 0, 0, 0, 0, 0};
		gbl_panelMonster.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelMonster.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMonster.setLayout(gbl_panelMonster);
		
		JLabel lblNotEnoughMoney = new JLabel("Not enough money!");
		lblNotEnoughMoney.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotEnoughMoney.setForeground(Color.RED);
		lblNotEnoughMoney.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.anchor = GridBagConstraints.EAST;
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 0;
		gbc_lblHealth.gridy = 0;
		panelMonster.add(lblHealth, gbc_lblHealth);
		
		JLabel lblMonsterHealth = new JLabel(Double.toString(firstStoreMonster.getMonsterCurrentHealth()));
		lblMonsterHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterHealth = new GridBagConstraints();
		gbc_lblMonsterHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterHealth.gridx = 1;
		gbc_lblMonsterHealth.gridy = 0;
		panelMonster.add(lblMonsterHealth, gbc_lblMonsterHealth);
		
		JLabel lblMonsterHealth1 = new JLabel(Double.toString(secondStoreMonster.getMonsterCurrentHealth()));
		lblMonsterHealth1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterHealth1 = new GridBagConstraints();
		gbc_lblMonsterHealth1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterHealth1.gridx = 2;
		gbc_lblMonsterHealth1.gridy = 0;
		panelMonster.add(lblMonsterHealth1, gbc_lblMonsterHealth1);
		
		JLabel lblMonsterHealth2 = new JLabel(Double.toString(thirdStoreMonster.getMonsterCurrentHealth()));
		lblMonsterHealth2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterHealth2 = new GridBagConstraints();
		gbc_lblMonsterHealth2.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterHealth2.gridx = 3;
		gbc_lblMonsterHealth2.gridy = 0;
		panelMonster.add(lblMonsterHealth2, gbc_lblMonsterHealth2);
		
		JLabel lblDamage = new JLabel("Damage:");
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.anchor = GridBagConstraints.EAST;
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 0;
		gbc_lblDamage.gridy = 1;
		panelMonster.add(lblDamage, gbc_lblDamage);
		
		JLabel lblMonsterDamage = new JLabel(Double.toString(firstStoreMonster.getDamage()));
		lblMonsterDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterDamage = new GridBagConstraints();
		gbc_lblMonsterDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterDamage.gridx = 1;
		gbc_lblMonsterDamage.gridy = 1;
		panelMonster.add(lblMonsterDamage, gbc_lblMonsterDamage);
		
		JLabel lblMonsterDamage1 = new JLabel(Double.toString(secondStoreMonster.getDamage()));
		lblMonsterDamage1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterDamage1 = new GridBagConstraints();
		gbc_lblMonsterDamage1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterDamage1.gridx = 2;
		gbc_lblMonsterDamage1.gridy = 1;
		panelMonster.add(lblMonsterDamage1, gbc_lblMonsterDamage1);
		
		JLabel lblMonsterDamage2 = new JLabel(Double.toString(thirdStoreMonster.getDamage()));
		lblMonsterDamage2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterDamage2 = new GridBagConstraints();
		gbc_lblMonsterDamage2.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterDamage2.gridx = 3;
		gbc_lblMonsterDamage2.gridy = 1;
		panelMonster.add(lblMonsterDamage2, gbc_lblMonsterDamage2);
		
		JLabel lblCriticalChance = new JLabel("Critical Chance:");
		lblCriticalChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCriticalChance = new GridBagConstraints();
		gbc_lblCriticalChance.anchor = GridBagConstraints.EAST;
		gbc_lblCriticalChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblCriticalChance.gridx = 0;
		gbc_lblCriticalChance.gridy = 2;
		panelMonster.add(lblCriticalChance, gbc_lblCriticalChance);
		
		JLabel lblMonsterCritChance = new JLabel(manager.toPercentage(firstStoreMonster.getCriticalStrike()));
		lblMonsterCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterCritChance = new GridBagConstraints();
		gbc_lblMonsterCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterCritChance.gridx = 1;
		gbc_lblMonsterCritChance.gridy = 2;
		panelMonster.add(lblMonsterCritChance, gbc_lblMonsterCritChance);
		
		JLabel lblMonsterCritChance1 = new JLabel(manager.toPercentage(secondStoreMonster.getCriticalStrike()));
		lblMonsterCritChance1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterCritChance1 = new GridBagConstraints();
		gbc_lblMonsterCritChance1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterCritChance1.gridx = 2;
		gbc_lblMonsterCritChance1.gridy = 2;
		panelMonster.add(lblMonsterCritChance1, gbc_lblMonsterCritChance1);
		
		JLabel lblMonsterCritChance2 = new JLabel(manager.toPercentage(thirdStoreMonster.getCriticalStrike()));
		lblMonsterCritChance2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterCritChance2 = new GridBagConstraints();
		gbc_lblMonsterCritChance2.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterCritChance2.gridx = 3;
		gbc_lblMonsterCritChance2.gridy = 2;
		panelMonster.add(lblMonsterCritChance2, gbc_lblMonsterCritChance2);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		panelMonster.add(lblName, gbc_lblName);
		
		JLabel lblMonsterName = new JLabel(firstStoreMonster.getName());
		lblMonsterName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterName = new GridBagConstraints();
		gbc_lblMonsterName.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterName.gridx = 1;
		gbc_lblMonsterName.gridy = 3;
		panelMonster.add(lblMonsterName, gbc_lblMonsterName);
		
		JLabel lblMonsterName_1 = new JLabel(secondStoreMonster.getName());
		lblMonsterName_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterName_1 = new GridBagConstraints();
		gbc_lblMonsterName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterName_1.gridx = 2;
		gbc_lblMonsterName_1.gridy = 3;
		panelMonster.add(lblMonsterName_1, gbc_lblMonsterName_1);
		
		JLabel lblMonsterName_2 = new JLabel(thirdStoreMonster.getName());
		lblMonsterName_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterName_2 = new GridBagConstraints();
		gbc_lblMonsterName_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterName_2.gridx = 3;
		gbc_lblMonsterName_2.gridy = 3;
		panelMonster.add(lblMonsterName_2, gbc_lblMonsterName_2);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.EAST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 4;
		panelMonster.add(lblCost, gbc_lblCost);
		
		JLabel lblMonsterCost = new JLabel(manager.toDollar(firstStoreMonster.getCost()));
		lblMonsterCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterCost = new GridBagConstraints();
		gbc_lblMonsterCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterCost.gridx = 1;
		gbc_lblMonsterCost.gridy = 4;
		panelMonster.add(lblMonsterCost, gbc_lblMonsterCost);
		
		JLabel lblMonsterCost_1 = new JLabel(manager.toDollar(secondStoreMonster.getCost()));
		lblMonsterCost_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterCost_1 = new GridBagConstraints();
		gbc_lblMonsterCost_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonsterCost_1.gridx = 2;
		gbc_lblMonsterCost_1.gridy = 4;
		panelMonster.add(lblMonsterCost_1, gbc_lblMonsterCost_1);
		
		JLabel lblMonsterCost_2 = new JLabel(manager.toDollar(thirdStoreMonster.getCost()));
		lblMonsterCost_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblMonsterCost_2 = new GridBagConstraints();
		gbc_lblMonsterCost_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterCost_2.gridx = 3;
		gbc_lblMonsterCost_2.gridy = 4;
		panelMonster.add(lblMonsterCost_2, gbc_lblMonsterCost_2);
		
		JLabel lblMoney = new JLabel("Money: " + player.getCurrentMoney());
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		JPanel panelItem = new JPanel();
		panelItem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagLayout gbl_panelItem = new GridBagLayout();
		gbl_panelItem.columnWidths = new int[]{245, 81, 81, 81, 0};
		gbl_panelItem.rowHeights = new int[]{42, 42, 0, 0, 0};
		gbl_panelItem.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelItem.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelItem.setLayout(gbl_panelItem);
		
		JLabel lblCost_1 = new JLabel("Cost:");
		lblCost_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCost_1 = new GridBagConstraints();
		gbc_lblCost_1.anchor = GridBagConstraints.EAST;
		gbc_lblCost_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost_1.gridx = 0;
		gbc_lblCost_1.gridy = 0;
		panelItem.add(lblCost_1, gbc_lblCost_1);
		
		JLabel lblStarterItemCost = new JLabel(manager.toDollar(firstStoreItem.getItemCost()));
		lblStarterItemCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemCost = new GridBagConstraints();
		gbc_lblStarterItemCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemCost.gridx = 1;
		gbc_lblStarterItemCost.gridy = 0;
		panelItem.add(lblStarterItemCost, gbc_lblStarterItemCost);
		
		JLabel lblStarterItemCost1 = new JLabel(manager.toDollar(secondStoreItem.getItemCost()));
		lblStarterItemCost1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemCost1 = new GridBagConstraints();
		gbc_lblStarterItemCost1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemCost1.gridx = 2;
		gbc_lblStarterItemCost1.gridy = 0;
		panelItem.add(lblStarterItemCost1, gbc_lblStarterItemCost1);
		
		JLabel lblStarterItemCost2 = new JLabel(manager.toDollar(thirdStoreItem.getItemCost()));
		lblStarterItemCost2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemCost2 = new GridBagConstraints();
		gbc_lblStarterItemCost2.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterItemCost2.gridx = 3;
		gbc_lblStarterItemCost2.gridy = 0;
		panelItem.add(lblStarterItemCost2, gbc_lblStarterItemCost2);
		
		JLabel lblIncreasePercentage = new JLabel("Percentage Increase:");
		lblIncreasePercentage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblIncreasePercentage = new GridBagConstraints();
		gbc_lblIncreasePercentage.anchor = GridBagConstraints.EAST;
		gbc_lblIncreasePercentage.insets = new Insets(0, 0, 5, 5);
		gbc_lblIncreasePercentage.gridx = 0;
		gbc_lblIncreasePercentage.gridy = 1;
		panelItem.add(lblIncreasePercentage, gbc_lblIncreasePercentage);
		
		JLabel lblStarterItemIncrease = new JLabel(manager.toPercentage(firstStoreItem.getItemIncrease()));
		lblStarterItemIncrease.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease = new GridBagConstraints();
		gbc_lblStarterItemIncrease.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemIncrease.gridx = 1;
		gbc_lblStarterItemIncrease.gridy = 1;
		panelItem.add(lblStarterItemIncrease, gbc_lblStarterItemIncrease);
		
		JLabel lblStarterItemIncrease1 = new JLabel(manager.toPercentage(secondStoreItem.getItemIncrease()));
		lblStarterItemIncrease1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease1 = new GridBagConstraints();
		gbc_lblStarterItemIncrease1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemIncrease1.gridx = 2;
		gbc_lblStarterItemIncrease1.gridy = 1;
		panelItem.add(lblStarterItemIncrease1, gbc_lblStarterItemIncrease1);
		
		JLabel lblStarterItemIncrease2 = new JLabel(manager.toPercentage(thirdStoreItem.getItemIncrease()));
		lblStarterItemIncrease2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease2 = new GridBagConstraints();
		gbc_lblStarterItemIncrease2.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterItemIncrease2.gridx = 3;
		gbc_lblStarterItemIncrease2.gridy = 1;
		panelItem.add(lblStarterItemIncrease2, gbc_lblStarterItemIncrease2);
		
		JLabel lblSelection = new JLabel("Name:");
		lblSelection.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSelection = new GridBagConstraints();
		gbc_lblSelection.anchor = GridBagConstraints.EAST;
		gbc_lblSelection.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelection.gridx = 0;
		gbc_lblSelection.gridy = 2;
		panelItem.add(lblSelection, gbc_lblSelection);
		
		JLabel lblItemName = new JLabel(firstStoreItem.getItemName());
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemName = new GridBagConstraints();
		gbc_lblItemName.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName.gridx = 1;
		gbc_lblItemName.gridy = 2;
		panelItem.add(lblItemName, gbc_lblItemName);
		
		JLabel lblItemName_1 = new JLabel(secondStoreItem.getItemName());
		lblItemName_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemName_1 = new GridBagConstraints();
		gbc_lblItemName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName_1.gridx = 2;
		gbc_lblItemName_1.gridy = 2;
		panelItem.add(lblItemName_1, gbc_lblItemName_1);
		
		JLabel lblItemName_2 = new JLabel(thirdStoreItem.getItemName());
		lblItemName_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemName_2 = new GridBagConstraints();
		gbc_lblItemName_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblItemName_2.gridx = 3;
		gbc_lblItemName_2.gridy = 2;
		panelItem.add(lblItemName_2, gbc_lblItemName_2);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.increaseDay();
				if (manager.getCurrentDay() == manager.getMaxDay()) {
					finishedWindow("Game Over");
				}else {
					finishedWindow("Next Day");
				}
					
			}
		});
		btnSleep.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelItem, GroupLayout.PREFERRED_SIZE, 1150, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStore, GroupLayout.PREFERRED_SIZE, 1150, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelMonster, GroupLayout.PREFERRED_SIZE, 1150, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(201)
							.addComponent(lblNotEnoughMoney, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(917, Short.MAX_VALUE)
					.addComponent(btnSleep, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStore, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMoney, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNotEnoughMoney, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMonster, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSleep, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		
		JButton btnBuyItem = new JButton("Buy!");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.getCurrentMoney() >= firstStoreItem.getItemCost()) {
					lblNotEnoughMoney.setVisible(false);
					player.addItem(firstStoreItem);
					restartWindow();
				} else {
					lblNotEnoughMoney.setVisible(true);
				}
			}
		});
		btnBuyItem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBuyItem = new GridBagConstraints();
		gbc_btnBuyItem.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuyItem.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuyItem.gridx = 1;
		gbc_btnBuyItem.gridy = 3;
		panelItem.add(btnBuyItem, gbc_btnBuyItem);
		
		JButton btnBuyItem1 = new JButton("Buy!");
		btnBuyItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.getCurrentMoney() >= secondStoreItem.getItemCost()) {
					lblNotEnoughMoney.setVisible(false);
					player.addItem(secondStoreItem);
					restartWindow();
				} else {
					lblNotEnoughMoney.setVisible(true);
				}
			}
		});
		btnBuyItem1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBuyItem1 = new GridBagConstraints();
		gbc_btnBuyItem1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuyItem1.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuyItem1.gridx = 2;
		gbc_btnBuyItem1.gridy = 3;
		panelItem.add(btnBuyItem1, gbc_btnBuyItem1);
		
		JButton btnBuyItem2 = new JButton("Buy!");
		btnBuyItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.getCurrentMoney() >= thirdStoreItem.getItemCost()) {
					lblNotEnoughMoney.setVisible(false);
					player.addItem(thirdStoreItem);
					restartWindow();
				} else {
					lblNotEnoughMoney.setVisible(true);
				}
			}
		});
		btnBuyItem2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBuyItem2 = new GridBagConstraints();
		gbc_btnBuyItem2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuyItem2.gridx = 3;
		gbc_btnBuyItem2.gridy = 3;
		panelItem.add(btnBuyItem2, gbc_btnBuyItem2);
		
		JButton btnBuyMonster = new JButton("Buy!");
		btnBuyMonster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.getCurrentMoney() >= firstStoreMonster.getCost()) {
					lblNotEnoughMoney.setVisible(false);
					player.addMonster(firstStoreMonster);
					restartWindow();
				} else { // Not enough money
					lblNotEnoughMoney.setVisible(true);
				}
			}
		});
		btnBuyMonster.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBuyMonster = new GridBagConstraints();
		gbc_btnBuyMonster.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuyMonster.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuyMonster.gridx = 1;
		gbc_btnBuyMonster.gridy = 5;
		panelMonster.add(btnBuyMonster, gbc_btnBuyMonster);
		
		JButton btnBuyMonster1 = new JButton("Buy!");
		btnBuyMonster1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.getCurrentMoney() >= secondStoreMonster.getCost()) {
					lblNotEnoughMoney.setVisible(false);
					player.addMonster(secondStoreMonster);
					restartWindow();
				} else {
					lblNotEnoughMoney.setVisible(true);
				}
			}
		});
		btnBuyMonster1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBuyMonster1 = new GridBagConstraints();
		gbc_btnBuyMonster1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuyMonster1.insets = new Insets(0, 0, 0, 5);
		gbc_btnBuyMonster1.gridx = 2;
		gbc_btnBuyMonster1.gridy = 5;
		panelMonster.add(btnBuyMonster1, gbc_btnBuyMonster1);
		
		JButton btnBuyMonster2 = new JButton("Buy!");
		btnBuyMonster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (player.getCurrentMoney() >= thirdStoreMonster.getCost()) {
					lblNotEnoughMoney.setVisible(false);
					player.addMonster(thirdStoreMonster);
					restartWindow();
				} else {
					lblNotEnoughMoney.setVisible(true);
				}
			}
		});
		btnBuyMonster2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnBuyMonster2 = new GridBagConstraints();
		gbc_btnBuyMonster2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuyMonster2.gridx = 3;
		gbc_btnBuyMonster2.gridy = 5;
		panelMonster.add(btnBuyMonster2, gbc_btnBuyMonster2);
		window.getContentPane().setLayout(groupLayout);
	}
}
