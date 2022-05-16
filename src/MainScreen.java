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

public class MainScreen {

	private JFrame window;
	private MainGame manager;
	private MainScreen screen;
	private ArrayList<Monster> team;
	private ArrayList<Item> inventory;
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
		initialize();
		window.setVisible(true);
	}
	public void setTeam(ArrayList<Monster> newTeam) {
		team = newTeam;
	}
	public void setInventory(ArrayList<Item> newInventory) {
		inventory = newInventory;
	}
	public void closeWindow() {
		window.dispose();
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
		window.setBounds(0, 0, 1450, 973);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		
		JPanel panelBattles = new JPanel();
		panelBattles.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelTeam = new JPanel();
		panelTeam.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelInventory = new JPanel();
		panelInventory.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnMoveTeam = new JButton("Move Monster");
		btnMoveTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchMoveTeamScreen(btnMoveTeam);
			}
		});
		btnMoveTeam.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnApplyItem = new JButton("Apply Item");
		btnApplyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchApplyItemScreen(btnApplyItem);
			}
		});
		btnApplyItem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTeam, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addComponent(panelBattles, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addComponent(panelInventory, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnMoveTeam, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBattles, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelTeam, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInventory, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMoveTeam, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		
		JPanel panelItem = new JPanel();
		panelItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem);
		
		JLabel lblItemName = new JLabel("Open Slot");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName.setText(inventory.get(0).getItemName());
		} catch (Exception e) {
			System.out.println("Open Slot/");
		}
		panelItem.setLayout(new BorderLayout(0, 0));
		panelItem.add(lblItemName, BorderLayout.CENTER);

		
		JLabel lblItemCost = new JLabel((String) null);
		try {
			lblItemCost.setText("Cost " + Integer.toString(inventory.get(0).getItemCost()));
		} catch (Exception e) {
			System.out.println("Open Slot");
		}
		lblItemCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem.add(lblItemCost, BorderLayout.SOUTH);
		
		JPanel panelItem_1 = new JPanel();
		panelItem_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_1);
		
		JLabel lblItemName_1 = new JLabel("Open Slot");
		lblItemName_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_1.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_1.setText(inventory.get(1).getItemName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelItem_1.setLayout(new BorderLayout(0, 0));
		panelItem_1.add(lblItemName_1, BorderLayout.CENTER);
		
		JLabel lblItemCost_1 = new JLabel("Cost 0");
		lblItemCost_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_1.add(lblItemCost_1, BorderLayout.SOUTH);
		
		JPanel panelItem_2 = new JPanel();
		panelItem_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_2);
		
		JLabel lblItemName_2 = new JLabel("Open Slot");
		lblItemName_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_2.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_2.setText(inventory.get(2).getItemName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelItem_2.setLayout(new BorderLayout(0, 0));
		panelItem_2.add(lblItemName_2);
		
		JLabel lblItemCost_2 = new JLabel("Cost 0");
		lblItemCost_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_2.add(lblItemCost_2, BorderLayout.SOUTH);
		
		JPanel panelItem_3 = new JPanel();
		panelItem_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_3);
		
		JLabel lblItemName_3 = new JLabel("Open Slot");
		lblItemName_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_3.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_3.setText(inventory.get(3).getItemName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelItem_3.setLayout(new BorderLayout(0, 0));
		panelItem_3.add(lblItemName_3);
		
		JLabel lblItemCost_3 = new JLabel("Cost 0");
		lblItemCost_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_3.add(lblItemCost_3, BorderLayout.SOUTH);
		
		JPanel panelItem_4 = new JPanel();
		panelItem_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_4);
		
		JLabel lblItemName_4 = new JLabel("Open Slot");
		lblItemName_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_4.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_4.setText(inventory.get(4).getItemName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelItem_4.setLayout(new BorderLayout(0, 0));
		panelItem_4.add(lblItemName_4);
		
		JLabel lblItemCost_4 = new JLabel("Cost 0");
		lblItemCost_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_4.add(lblItemCost_4, BorderLayout.SOUTH);
		
		JPanel panelItem_5 = new JPanel();
		panelItem_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelInventory.add(panelItem_5);
		
		JLabel lblItemName_5 = new JLabel("Open Slot");
		lblItemName_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblItemName_5.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblItemName_5.setText(inventory.get(5).getItemName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelItem_5.setLayout(new BorderLayout(0, 0));
		panelItem_5.add(lblItemName_5);
		
		JLabel lblItemCost_5 = new JLabel("Cost 0");
		lblItemCost_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemCost_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panelItem_5.add(lblItemCost_5, BorderLayout.SOUTH);
		panelTeam.setLayout(new GridLayout(1, 0, 0, 0));
		if (manager.getPlayer().getTeam().size() == 1) {
			JPanel panelMonster = new JPanel();
			panelMonster.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelTeam.add(panelMonster);
		
			JLabel lblMonsterName = new JLabel(team.get(0).getName());
			lblMonsterName.setFont(new Font("Tahoma", Font.PLAIN, 24));
			panelMonster.add(lblMonsterName);
		} else if (manager.getPlayer().getTeam().size() == 2) {
			JPanel panelMonster_1 = new JPanel();
			panelMonster_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelTeam.add(panelMonster_1);
		
		
				JLabel lblMonsterName_1 = new JLabel(team.get(1).getName());
				lblMonsterName_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
				panelMonster_1.add(lblMonsterName_1);
		} else if (manager.getPlayer().getTeam().size() == 3) {
			JPanel panelMonster_2 = new JPanel();
			panelMonster_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelTeam.add(panelMonster_2);
			
			JLabel lblMonsterName_2 = new JLabel("Open Slot");
			lblMonsterName_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblMonsterName_2.setText(team.get(2).getName()); 
			panelMonster_2.add(lblMonsterName_2);
		} else {
			JPanel panelMonster_3 = new JPanel();
			panelMonster_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelTeam.add(panelMonster_3);
		
			JLabel lblMonsterName_3 = new JLabel(team.get(3).getName());
			lblMonsterName_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
			panelMonster_3.add(lblMonsterName_3);
		}
		
		panelBattles.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelBattle1 = new JPanel();
		panelBattle1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle1);
		
		JLabel lblBattle1Title = new JLabel("Battle 1");
		lblBattle1Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBattle1Title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelBattle1Team = new JPanel();
		
		JButton btnBattleButton = new JButton("Battle!");
		btnBattleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(0);
				
			}

			
		});
		btnBattleButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		GroupLayout gl_panelBattle1 = new GroupLayout(panelBattle1);
		gl_panelBattle1.setHorizontalGroup(
			gl_panelBattle1.createParallelGroup(Alignment.LEADING)
				.addComponent(lblBattle1Title, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
				.addComponent(panelBattle1Team, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
				.addComponent(btnBattleButton, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
		);
		gl_panelBattle1.setVerticalGroup(
			gl_panelBattle1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBattle1.createSequentialGroup()
					.addComponent(lblBattle1Title, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBattle1Team, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBattleButton, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
		);
		panelBattle1Team.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblEnemyTeamMonster = new JLabel("Open Slot");
		panelBattle1Team.add(lblEnemyTeamMonster);
		
		JLabel lblEnemyTeamMonster1 = new JLabel();
		panelBattle1Team.add(lblEnemyTeamMonster1);
		
		JLabel lblEnemyTeamMonster2 = new JLabel("Open Slot");
		panelBattle1Team.add(lblEnemyTeamMonster2);
		
		JLabel lblEnemyTeamMonster3 = new JLabel("Open Slot");
		panelBattle1Team.add(lblEnemyTeamMonster3);
		panelBattle1.setLayout(gl_panelBattle1);
		
		JPanel panelBattle2 = new JPanel();
		panelBattle2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle2);
		
		JLabel lblBattle2Title = new JLabel("Battle 2");
		lblBattle2Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle2.add(lblBattle2Title);
		
		JPanel panelBattle3 = new JPanel();
		panelBattle3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle3);
		
		JLabel lblBattle3Title = new JLabel("Battle 3");
		lblBattle3Title.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle3Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle3.add(lblBattle3Title);
		
		JPanel panelBattle4 = new JPanel();
		panelBattle4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle4);
		
		JLabel lblBattle4Title = new JLabel("Battle 4");
		lblBattle4Title.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle4Title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle4.add(lblBattle4Title);
		panelTop.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblScore = new JLabel("Score: " + manager.getPlayer().getPoints());
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblScore);
		
		JLabel lblDaysLeft = new JLabel("Days Left: " + manager.getDaysLeft());
		lblDaysLeft.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDaysLeft.setHorizontalAlignment(SwingConstants.CENTER);
		panelTop.add(lblDaysLeft);
		
		JLabel lblMoney = new JLabel("Money: " + manager.getPlayer().getCurrentMoney());
		lblMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblMoney);
		window.getContentPane().setLayout(groupLayout);
	}
}
