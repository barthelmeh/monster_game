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
	private JLabel lblRandomLevelUp;
	private JLabel lblRandomMonsterLeave;
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
		lblRandomMonsterLeave.setText(s);
		lblRandomLevelUp.setText(s2);
		initialize();
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
		
		lblRandomLevelUp = new JLabel("");
		lblRandomLevelUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomLevelUp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		lblRandomMonsterLeave = new JLabel("");
		lblRandomMonsterLeave.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandomMonsterLeave.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBattles, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addComponent(panelTeam, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addComponent(panelInventory, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnMoveTeam, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblRandomLevelUp, GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
						.addComponent(lblRandomMonsterLeave, GroupLayout.PREFERRED_SIZE, 1416, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(panelTeam, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInventory, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnMoveTeam, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRandomLevelUp)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRandomMonsterLeave, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
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
			lblItemName.setText("Empty Slot");
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
	
		JLabel lblMonsterName = new JLabel("");
		try {
			lblMonsterName.setText(team.get(0).getName());
		} catch (Exception e) {
			lblMonsterName.setText("Open Slot");
		}
		lblMonsterName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelMonster.add(lblMonsterName);
		JPanel panelMonster_1 = new JPanel();
		panelMonster_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_1);
	
	
		JLabel lblMonsterName_1 = new JLabel("");
		try {
			lblMonsterName_1.setText(team.get(1).getName());
		} catch (Exception e) {
			lblMonsterName_1.setText("Open Slot");
		}
		lblMonsterName_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelMonster_1.add(lblMonsterName_1);
		JPanel panelMonster_2 = new JPanel();
		panelMonster_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_2);
		
		JLabel lblMonsterName_2 = new JLabel("Open Slot");
		try {
			lblMonsterName_2.setText(team.get(2).getName());
		} catch (Exception e) {
			lblMonsterName_2.setText("Open Slot");
		}
		lblMonsterName_2.setFont(new Font("Tahoma", Font.PLAIN, 24)); 
		panelMonster_2.add(lblMonsterName_2);
		JPanel panelMonster_3 = new JPanel();
		panelMonster_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_3);
	
		JLabel lblMonsterName_3 = new JLabel("Open Slot");
		try {
			lblMonsterName_3.setText(team.get(3).getName());
		} catch (Exception e) {
			lblMonsterName_3.setText("Open Slot");
		}
		lblMonsterName_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panelMonster_3.add(lblMonsterName_3);
		
		
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
			lblBattleMonster.setText("Open");
		}
		panelBattle1Team.add(lblBattleMonster);
		
		JLabel lblBattleMonster1 = new JLabel();
		lblBattleMonster1.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblBattleMonster1.setText(battle1.get(1).getName());
		} catch (Exception e) {
			lblBattleMonster1.setText("Open");
		}
		panelBattle1Team.add(lblBattleMonster1);
		
		JLabel lblBattleMonster2 = new JLabel();
		lblBattleMonster2.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblBattleMonster2.setText(battle1.get(2).getName());
		} catch (Exception e) {
			lblBattleMonster2.setText("Open");
		}
		panelBattle1Team.add(lblBattleMonster2);
		
		JLabel lblBattleMonster3 = new JLabel();
		lblBattleMonster3.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			lblBattleMonster3.setText(battle1.get(3).getName());
		} catch (Exception e) {
			lblBattleMonster3.setText("Open");
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
			lblBattle2Monster.setText("Open");
		}
		lblBattle2Monster.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster);
		
		JLabel lblBattle2Monster1 = new JLabel();
		try {
			lblBattle2Monster1.setText(battle2.get(1).getName());
		} catch (Exception e){
			lblBattle2Monster1.setText("Open");
		}
		lblBattle2Monster1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster1);
		
		JLabel lblBattle2Monster2 = new JLabel();
		try {
			lblBattle2Monster2.setText(battle2.get(2).getName());
		} catch (Exception e){
			lblBattle2Monster2.setText("Open");
		}
		lblBattle2Monster2.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster2);
		
		JLabel lblBattle2Monster3 = new JLabel();
		try {
			lblBattle2Monster3.setText(battle2.get(3).getName());
		} catch (Exception e){
			lblBattle2Monster3.setText("Open");
		}
		lblBattle2Monster3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1Team_1.add(lblBattle2Monster3);
		panelBattle2.setLayout(new BorderLayout(0, 0));
		panelBattle2.add(lblBattle2Title, BorderLayout.NORTH);
		panelBattle2.add(panelBattle1Team_1);
		
		JButton btnBattle2 = new JButton("Battle!");
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
			lblBattle3Monster.setText("Open");
		}
		lblBattle3Monster.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster);
		
		JLabel lblBattle3Monster1 = new JLabel();
		try {
			lblBattle3Monster1.setText(battle3.get(1).getName());
		} catch (Exception e){
			lblBattle3Monster1.setText("Open");
		}
		lblBattle3Monster1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster1);
		
		JLabel lblBattle3Monster2 = new JLabel();
		try {
			lblBattle3Monster2.setText(battle3.get(2).getName());
		} catch (Exception e){
			lblBattle3Monster2.setText("Open");
		};
		lblBattle3Monster2.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster2);
		
		JLabel lblBattle3Monster3 = new JLabel();
		try {
			lblBattle3Monster3.setText(battle3.get(3).getName());
		} catch (Exception e){
			lblBattle3Monster3.setText("Open");
		}
		lblBattle3Monster3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle3Team.add(lblBattle3Monster3);
		
		JButton btnBattle3 = new JButton("Battle!");
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
			lblBattle4Monster.setText("Open");
		}
		lblBattle4Monster.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster);
		
		JLabel lblBattle4Monster1 = new JLabel();
		try {
			lblBattle4Monster1.setText(battle4.get(1).getName());
		} catch (Exception e){
			lblBattle4Monster1.setText("Open");
		}
		lblBattle4Monster1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster1);
		
		JLabel lblBattle4Monster2 = new JLabel();
		try {
			lblBattle4Monster2.setText(battle4.get(2).getName());
		} catch (Exception e){
			lblBattle4Monster2.setText("Open");
		}
		lblBattle4Monster2.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster2);
		
		JLabel lblBattle4Monster3 = new JLabel();
		try {
			lblBattle4Monster3.setText(battle4.get(3).getName());
		} catch (Exception e){
			lblBattle4Monster3.setText("Open");
		}
		lblBattle4Monster3.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle4Team.add(lblBattle4Monster3);
		
		JButton btnBattle4 = new JButton("Battle!");
		btnBattle4.setFont(new Font("Tahoma", Font.PLAIN, 35));
		panelBattle4.add(btnBattle4, BorderLayout.SOUTH);
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
