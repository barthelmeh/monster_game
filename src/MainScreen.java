import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MainScreen {

	private JFrame window;
	private MainGame manager;
	private MainScreen screen;
	private ArrayList<Monster> team;
	private ArrayList<Item> inventory;
	private ArrayList<Monster> battle1;
	private ArrayList<Monster> battle2;
	private ArrayList<Monster> battle3;
	private ArrayList<Monster> battle4;
	private JLabel lblRandomMonsterLeave;
	private JLabel lblRandomMonsterEnter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen() {
		initialize();
	}
	public MainScreen(MainGame incomingManager) {
		screen = this;
		manager = incomingManager;
		setTeam(manager.getPlayer().getTeam());
		setInventory(manager.getPlayer().getInventory());
		setBattles(manager.getBattles());
		initialize();
		window.setVisible(true);
	}
	public MainScreen(MainGame incomingManager, String s, String s2) {
		screen = this;
		manager = incomingManager;
		setTeam(manager.getPlayer().getTeam());
		setInventory(manager.getPlayer().getInventory());
		setBattles(manager.getBattles());
		
		initialize();
		lblRandomMonsterLeave.setText(s);
		lblRandomMonsterEnter.setText(s2);
		window.setVisible(true);
	}

	public void setTeam(ArrayList<Monster> newTeam) {
		team = newTeam;
	}
	public void setInventory(ArrayList<Item> newInventory) {
		inventory = newInventory;
	}
	public void setBattles(ArrayList<Battle> newBattles) {
		battle1 = newBattles.get(0).getTeam();
		battle2 = newBattles.get(1).getTeam();
		battle3 = newBattles.get(2).getTeam();
		battle4 = newBattles.get(3).getTeam();
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow(String s) {
		manager.closeMainScreen(this, s);
	}
	public void finishedWindow(int i) {
		manager.closeMainScreen(this, i);

	}

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Main Game");
		window.setBounds(0, 0, 1450, 979);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		
		JPanel panelBattles = new JPanel();
		panelBattles.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelTeam = new JPanel();
		
		JPanel panelInventory = new JPanel();
		panelInventory.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnMoveTeam = new JButton("Move Monster");
		btnMoveTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("move");
			}
		});
		btnMoveTeam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnApplyItem = new JButton("Apply Item");
		btnApplyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow("apply");
			}
		});
		btnApplyItem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		lblRandomMonsterLeave = new JLabel("");
		lblRandomMonsterLeave.setForeground(Color.RED);
		lblRandomMonsterLeave.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomMonsterLeave.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		lblRandomMonsterEnter = new JLabel("");
		lblRandomMonsterEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomMonsterEnter.setForeground(Color.RED);
		lblRandomMonsterEnter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelBattles, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
								.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelTeam, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelInventory, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMoveTeam, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRandomMonsterLeave, GroupLayout.PREFERRED_SIZE, 1416, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRandomMonsterEnter, GroupLayout.PREFERRED_SIZE, 1416, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBattles, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInventory, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMoveTeam, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRandomMonsterLeave, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblRandomMonsterEnter, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel panelItem = new JPanel();
		panelItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem);
		
		JLabel lblItemName = new JLabel("Open Slot");
		JLabel lblItemCost = new JLabel((String) null);
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName.setText(inventory.get(0).getItemName());
			lblItemCost.setText("Cost " + Integer.toString(inventory.get(0).getItemCost()));
		} catch (Exception e) {
			lblItemName.setText("Open Slot");
			lblItemCost.setText("Cost 0");
		}
		panelItem.setLayout(new BorderLayout(0, 0));
		panelItem.add(lblItemName, BorderLayout.CENTER);
		
		lblItemCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem.add(lblItemCost, BorderLayout.SOUTH);
		
		JPanel panelItem_1 = new JPanel();
		panelItem_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_1);
		
		JLabel lblItemName_1 = new JLabel("");
		JLabel lblItemCost_1 = new JLabel("");
		lblItemName_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_1.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_1.setText(inventory.get(1).getItemName());
			lblItemCost_1.setText(Integer.toString(inventory.get(1).getItemCost()));
		} catch (Exception e) {
			lblItemName_1.setText("Open Slot");
			lblItemCost_1.setText("Cost 0");
		}
		panelItem_1.setLayout(new BorderLayout(0, 0));
		panelItem_1.add(lblItemName_1, BorderLayout.CENTER);
		
		
		lblItemCost_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_1.add(lblItemCost_1, BorderLayout.SOUTH);
		
		JPanel panelItem_2 = new JPanel();
		panelItem_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_2);
		
		JLabel lblItemName_2 = new JLabel("Open Slot");
		JLabel lblItemCost_2 = new JLabel("Cost 0");
		lblItemName_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_2.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_2.setText(inventory.get(2).getItemName());
			lblItemCost_2.setText(Integer.toString(inventory.get(2).getItemCost()));
		} catch (Exception e) {
			lblItemName_2.setText("Open Slot");
			lblItemCost_2.setText("Cost 0");
		}
		panelItem_2.setLayout(new BorderLayout(0, 0));
		panelItem_2.add(lblItemName_2);
		
		
		lblItemCost_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_2.add(lblItemCost_2, BorderLayout.SOUTH);
		
		JPanel panelItem_3 = new JPanel();
		panelItem_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_3);
		
		JLabel lblItemName_3 = new JLabel("Open Slot");
		JLabel lblItemCost_3 = new JLabel("Cost 0");
		lblItemName_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_3.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_3.setText(inventory.get(3).getItemName());
			lblItemCost_3.setText(Integer.toString(inventory.get(3).getItemCost()));
		} catch (Exception e) {
			lblItemName_3.setText("Open Slot");
		}
		panelItem_3.setLayout(new BorderLayout(0, 0));
		panelItem_3.add(lblItemName_3);
		
		
		lblItemCost_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_3.add(lblItemCost_3, BorderLayout.SOUTH);
		
		panelTeam.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelMonster = new JPanel();
		panelMonster.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster);
		
		GridBagLayout gbl_panelMonster = new GridBagLayout();
		gbl_panelMonster.columnWidths = new int[]{333};
		gbl_panelMonster.rowHeights = new int[]{29, 29, 29, 0, 0, 0};
		gbl_panelMonster.columnWeights = new double[]{1.0};
		gbl_panelMonster.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMonster.setLayout(gbl_panelMonster);
		
		JLabel lblMonsterName = new JLabel("");
		JLabel lblLevel = new JLabel("");
		JLabel lblMonsterHealth = new JLabel("");
		
		try {
			Monster monster = team.get(0);
			lblMonsterName.setText(monster.getName());
			lblLevel.setText("Level: " + Integer.toString(monster.getMonsterLevel()) + monster.checkIfLeveledUp());
			lblMonsterHealth.setText("Health: " + Double.toString(monster.getMonsterCurrentHealth()));
			
		} catch (Exception e) {
			lblMonsterName.setText("Open Slot");
		}
		
		lblMonsterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterName = new GridBagConstraints();
		gbc_lblMonsterName.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterName.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterName.gridx = 0;
		gbc_lblMonsterName.gridy = 0;
		panelMonster.add(lblMonsterName, gbc_lblMonsterName);
	
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.anchor = GridBagConstraints.NORTH;
		gbc_lblLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLevel.insets = new Insets(0, 0, 5, 0);
		gbc_lblLevel.gridx = 0;
		gbc_lblLevel.gridy = 1;
		panelMonster.add(lblLevel, gbc_lblLevel);
		
		lblMonsterHealth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterHealth = new GridBagConstraints();
		gbc_lblMonsterHealth.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterHealth.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterHealth.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterHealth.gridx = 0;
		gbc_lblMonsterHealth.gridy = 2;
		panelMonster.add(lblMonsterHealth, gbc_lblMonsterHealth);
		
		JPanel panelMonster_1 = new JPanel();
		panelMonster_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_1);
		GridBagLayout gbl_panelMonster_1 = new GridBagLayout();
		gbl_panelMonster_1.columnWidths = new int[]{333, 0};
		gbl_panelMonster_1.rowHeights = new int[]{29, 29, 29, 0, 0, 0};
		gbl_panelMonster_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMonster_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMonster_1.setLayout(gbl_panelMonster_1);
		
		JLabel lblMonsterName_1 = new JLabel((String) null);
		JLabel lblLevel_1 = new JLabel("");
		JLabel lblMonsterHealth_1 = new JLabel("");
		
		try {
			Monster monster1 = team.get(1);
			lblMonsterName_1.setText(monster1.getName());
			lblMonsterHealth_1.setText("Health: " + Double.toString(monster1.getMonsterCurrentHealth()));	
			lblLevel_1.setText("Level: " + Integer.toString(monster1.getMonsterLevel()) + monster1.checkIfLeveledUp());
		} catch (Exception e) {
			lblMonsterName_1.setText("Open Slot");
		}
		
		lblMonsterName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterName_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterName_1 = new GridBagConstraints();
		gbc_lblMonsterName_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterName_1.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterName_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterName_1.gridx = 0;
		gbc_lblMonsterName_1.gridy = 0;
		panelMonster_1.add(lblMonsterName_1, gbc_lblMonsterName_1);
		
		lblLevel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLevel_1 = new GridBagConstraints();
		gbc_lblLevel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLevel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblLevel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblLevel_1.gridx = 0;
		gbc_lblLevel_1.gridy = 1;
		panelMonster_1.add(lblLevel_1, gbc_lblLevel_1);
		
		lblMonsterHealth_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterHealth_1 = new GridBagConstraints();
		gbc_lblMonsterHealth_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterHealth_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterHealth_1.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterHealth_1.gridx = 0;
		gbc_lblMonsterHealth_1.gridy = 2;
		panelMonster_1.add(lblMonsterHealth_1, gbc_lblMonsterHealth_1);
		
		
		JPanel panelMonster_2 = new JPanel();
		panelMonster_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_2);
		GridBagLayout gbl_panelMonster_2 = new GridBagLayout();
		gbl_panelMonster_2.columnWidths = new int[]{333, 0};
		gbl_panelMonster_2.rowHeights = new int[]{29, 29, 29, 0, 0, 0};
		gbl_panelMonster_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMonster_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMonster_2.setLayout(gbl_panelMonster_2);
		
		JLabel lblMonsterName_2 = new JLabel("");
		JLabel lblLevel_2 = new JLabel("");
		JLabel lblMonsterHealth_2 = new JLabel("");
		
		try {
			Monster monster2 = team.get(2);
			lblMonsterName_2.setText(monster2.getName());
			lblLevel_2.setText("Level: " + Integer.toString(monster2.getMonsterLevel()) + monster2.checkIfLeveledUp());
			lblMonsterHealth_2.setText("Health: " + Double.toString(monster2.getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblMonsterName_2.setText("Open Slot");
		}
		
		lblMonsterName_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterName_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterName_2 = new GridBagConstraints();
		gbc_lblMonsterName_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterName_2.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterName_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterName_2.gridx = 0;
		gbc_lblMonsterName_2.gridy = 0;
		panelMonster_2.add(lblMonsterName_2, gbc_lblMonsterName_2);
		
		lblLevel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLevel_2 = new GridBagConstraints();
		gbc_lblLevel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLevel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblLevel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblLevel_2.gridx = 0;
		gbc_lblLevel_2.gridy = 1;
		panelMonster_2.add(lblLevel_2, gbc_lblLevel_2);
		
		lblMonsterHealth_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterHealth_2 = new GridBagConstraints();
		gbc_lblMonsterHealth_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterHealth_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterHealth_2.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterHealth_2.gridx = 0;
		gbc_lblMonsterHealth_2.gridy = 2;
		panelMonster_2.add(lblMonsterHealth_2, gbc_lblMonsterHealth_2);
		
		JPanel panelMonster_3 = new JPanel();
		panelMonster_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_3);
		GridBagLayout gbl_panelMonster_3 = new GridBagLayout();
		gbl_panelMonster_3.columnWidths = new int[]{333, 0};
		gbl_panelMonster_3.rowHeights = new int[]{29, 29, 29, 0, 0, 0};
		gbl_panelMonster_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMonster_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMonster_3.setLayout(gbl_panelMonster_3);
		
		JLabel lblMonsterName_3 = new JLabel((String) null);
		JLabel lblLevel_3 = new JLabel("");
		JLabel lblMonsterHealth_3 = new JLabel("");
		
		try {
			Monster monster3 = team.get(3);
			lblMonsterName_3.setText(monster3.getName());
			lblLevel_3.setText("Level: " + Integer.toString(monster3.getMonsterLevel()) + monster3.checkIfLeveledUp());
			lblMonsterHealth_3.setText("Health: " + Double.toString(monster3.getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblMonsterName_3.setText("Open Slot");
		}
		
		lblMonsterName_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterName_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterName_3 = new GridBagConstraints();
		gbc_lblMonsterName_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterName_3.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterName_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterName_3.gridx = 0;
		gbc_lblMonsterName_3.gridy = 0;
		panelMonster_3.add(lblMonsterName_3, gbc_lblMonsterName_3);
		
		lblLevel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLevel_3 = new GridBagConstraints();
		gbc_lblLevel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLevel_3.anchor = GridBagConstraints.NORTH;
		gbc_lblLevel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblLevel_3.gridx = 0;
		gbc_lblLevel_3.gridy = 1;
		panelMonster_3.add(lblLevel_3, gbc_lblLevel_3);
		
		
		lblMonsterHealth_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblMonsterHealth_3 = new GridBagConstraints();
		gbc_lblMonsterHealth_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonsterHealth_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMonsterHealth_3.anchor = GridBagConstraints.NORTH;
		gbc_lblMonsterHealth_3.gridx = 0;
		gbc_lblMonsterHealth_3.gridy = 2;
		panelMonster_3.add(lblMonsterHealth_3, gbc_lblMonsterHealth_3);
		
		panelBattles.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelBattle1 = new JPanel();
		panelBattle1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle1);
		
		JLabel lblBattle1Title = new JLabel("Battle 1");
		lblBattle1Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBattle1Title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelBattle1Team = new JPanel();
		
		JButton btnBattle = new JButton("Battle!");
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(0);
			}
		});
		btnBattle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelBattle1Team.setLayout(new GridLayout(1, 0, 0, 0));
		JLabel lblBattleMonster = new JLabel();
		lblBattleMonster.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblBattleMonster.setText(battle1.get(0).getName());
		} catch (Exception e) {
			lblBattleMonster.setText("");
		}
		panelBattle1Team.add(lblBattleMonster);
		
		JLabel lblBattleMonster1 = new JLabel();
		lblBattleMonster1.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblBattleMonster1.setText(battle1.get(1).getName());
		} catch (Exception e) {
			lblBattleMonster1.setText("");
		}
		panelBattle1Team.add(lblBattleMonster1);
		
		JLabel lblBattleMonster2 = new JLabel();
		lblBattleMonster2.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblBattleMonster2.setText(battle1.get(2).getName());
		} catch (Exception e) {
			lblBattleMonster2.setText("");
		}
		panelBattle1Team.add(lblBattleMonster2);
		
		JLabel lblBattleMonster3 = new JLabel();
		lblBattleMonster3.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblBattleMonster3.setText(battle1.get(3).getName());
		} catch (Exception e) {
			lblBattleMonster3.setText("");
		}
		panelBattle1Team.add(lblBattleMonster3);
		panelBattle1.setLayout(new BorderLayout(0, 0));
		panelBattle1.add(lblBattle1Title, BorderLayout.NORTH);
		panelBattle1.add(panelBattle1Team);
		panelBattle1.add(btnBattle, BorderLayout.SOUTH);
		
		JPanel panelBattle2 = new JPanel();
		panelBattle2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle2);
		
		JLabel lblBattle2Title = new JLabel("Battle 2");
		lblBattle2Title.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle2Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel panelBattle1Team_1 = new JPanel();
		panelBattle1Team_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblBattle2Monster = new JLabel();
		try {
			lblBattle2Monster.setText(battle2.get(0).getName());
		} catch (Exception e){
			lblBattle2Monster.setText("");
		}
		lblBattle2Monster.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster);
		
		JLabel lblBattle2Monster1 = new JLabel();
		try {
			lblBattle2Monster1.setText(battle2.get(1).getName());
		} catch (Exception e){
			lblBattle2Monster1.setText("");
		}
		lblBattle2Monster1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster1);
		
		JLabel lblBattle2Monster2 = new JLabel();
		try {
			lblBattle2Monster2.setText(battle2.get(2).getName());
		} catch (Exception e){
			lblBattle2Monster2.setText("");
		}
		lblBattle2Monster2.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster2);
		
		JLabel lblBattle2Monster3 = new JLabel();
		try {
			lblBattle2Monster3.setText(battle2.get(3).getName());
		} catch (Exception e){
			lblBattle2Monster3.setText("");
		}
		lblBattle2Monster3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster3);
		panelBattle2.setLayout(new BorderLayout(0, 0));
		panelBattle2.add(lblBattle2Title, BorderLayout.NORTH);
		panelBattle2.add(panelBattle1Team_1);
		
		JButton btnBattle2 = new JButton("Battle!");
		btnBattle2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(1);
			}
		});
		btnBattle2.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelBattle2.add(btnBattle2, BorderLayout.SOUTH);
		
		JPanel panelBattle3 = new JPanel();
		panelBattle3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle3);
		panelBattle3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBattle3Title = new JLabel("Battle 3");
		lblBattle3Title.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle3Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle3.add(lblBattle3Title, BorderLayout.NORTH);
		
		JPanel panelBattle3Team = new JPanel();
		panelBattle3.add(panelBattle3Team, BorderLayout.CENTER);
		panelBattle3Team.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblBattle3Monster = new JLabel();
		try {
			lblBattle3Monster.setText(battle3.get(0).getName());
		} catch (Exception e){
			lblBattle3Monster.setText("");
		}
		lblBattle3Monster.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster);
		
		JLabel lblBattle3Monster1 = new JLabel();
		try {
			lblBattle3Monster1.setText(battle3.get(1).getName());
		} catch (Exception e){
			lblBattle3Monster1.setText("");
		}
		lblBattle3Monster1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster1);
		
		JLabel lblBattle3Monster2 = new JLabel();
		try {
			lblBattle3Monster2.setText(battle3.get(2).getName());
		} catch (Exception e){
			lblBattle3Monster2.setText("");
		};
		lblBattle3Monster2.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster2);
		
		JLabel lblBattle3Monster3 = new JLabel();
		try {
			lblBattle3Monster3.setText(battle3.get(3).getName());
		} catch (Exception e){
			lblBattle3Monster3.setText("");
		}
		lblBattle3Monster3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster3);
		
		JButton btnBattle3 = new JButton("Battle!");
		btnBattle3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(2);
			}
		});
		btnBattle3.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelBattle3.add(btnBattle3, BorderLayout.SOUTH);
		
		JPanel panelBattle4 = new JPanel();
		panelBattle4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle4);
		panelBattle4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBattle4 = new JLabel("Battle 4");
		lblBattle4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle4.add(lblBattle4, BorderLayout.NORTH);
		
		JPanel panelBattle4Team = new JPanel();
		panelBattle4.add(panelBattle4Team, BorderLayout.CENTER);
		panelBattle4Team.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblBattle4Monster = new JLabel();
		try {
			lblBattle4Monster.setText(battle4.get(0).getName());
		} catch (Exception e){
			lblBattle4Monster.setText("");
		}
		lblBattle4Monster.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster);
		
		JLabel lblBattle4Monster1 = new JLabel();
		try {
			lblBattle4Monster1.setText(battle4.get(1).getName());
		} catch (Exception e){
			lblBattle4Monster1.setText("");
		}
		lblBattle4Monster1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster1);
		
		JLabel lblBattle4Monster2 = new JLabel();
		try {
			lblBattle4Monster2.setText(battle4.get(2).getName());
		} catch (Exception e){
			lblBattle4Monster2.setText("");
		}
		lblBattle4Monster2.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster2);
		
		JLabel lblBattle4Monster3 = new JLabel();
		try {
			lblBattle4Monster3.setText(battle4.get(3).getName());
		} catch (Exception e){
			lblBattle4Monster3.setText("");
		}
		lblBattle4Monster3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster3);
		
		JButton btnBattle4 = new JButton("Battle!");
		btnBattle4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(3);
			}
		});
		btnBattle4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelBattle4.add(btnBattle4, BorderLayout.SOUTH);
		panelTop.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblScore = new JLabel("Score: " + manager.getPlayer().getScore());
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblScore);
		
		JLabel lblDaysLeft = new JLabel("Days Left: " + manager.getDaysLeft());
		lblDaysLeft.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDaysLeft.setHorizontalAlignment(SwingConstants.CENTER);
		panelTop.add(lblDaysLeft);
		
		JLabel lblMoney = new JLabel("Coins: " + manager.getPlayer().getCurrentMoney());
		lblMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblMoney);
		window.getContentPane().setLayout(groupLayout);
	}
}
