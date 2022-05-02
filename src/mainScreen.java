import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class mainScreen {

	private JFrame window;
	private mainGame manager;
	private mainScreen screen;
	private ArrayList<Monster> team;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainScreen window = new mainScreen();
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
	public mainScreen() {
		initialize();
	}
	public mainScreen(mainGame incomingManager) {
		screen = this;
		manager = incomingManager;
		setTeam(manager.getPlayer().getTeam());
		initialize();
		window.setVisible(true);
	}
	public void setTeam(ArrayList<Monster> newTeam) {
		team = newTeam;
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeMainScreen(this);
	}

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Main Game");
		window.setBounds(0, 0, 1450, 1300);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		
		JPanel panelBattles = new JPanel();
		panelBattles.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelTeam = new JPanel();
		panelTeam.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelInventory = new JPanel();
		panelInventory.setLayout(new GridLayout(1, 0, 0, 0));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTeam, GroupLayout.DEFAULT_SIZE, 1414, Short.MAX_VALUE)
						.addComponent(panelBattles, GroupLayout.DEFAULT_SIZE, 1414, Short.MAX_VALUE)
						.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 1414, Short.MAX_VALUE)
						.addComponent(panelInventory, GroupLayout.PREFERRED_SIZE, 1414, GroupLayout.PREFERRED_SIZE))
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
					.addContainerGap(261, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		panelInventory.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTable table = new JTable();
		panel.add(table);
		panelTeam.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelMonster = new JPanel();
		panelMonster.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster);
		JLabel lblMonsterName = new JLabel("Open Slot");
		lblMonsterName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		try {
			lblMonsterName.setText(team.get(0).getName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		
		panelMonster.add(lblMonsterName);
		
		JPanel panelMonster_1 = new JPanel();
		panelMonster_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_1);
		
		JLabel lblMonsterName_1 = new JLabel("Open Slot");
		lblMonsterName_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		try {
			lblMonsterName_1.setText(team.get(1).getName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelMonster_1.add(lblMonsterName_1);
		
		JPanel panelMonster_2 = new JPanel();
		panelMonster_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_2);
		
		JLabel lblMonsterName_2 = new JLabel("Open Slot");
		lblMonsterName_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		try {
			lblMonsterName_2.setText(team.get(1).getName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelMonster_2.add(lblMonsterName_2);
		
		JPanel panelMonster_3 = new JPanel();
		panelMonster_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTeam.add(panelMonster_3);
		
		JLabel lblMonsterName_3 = new JLabel("Open Slot");
		lblMonsterName_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		try {
			lblMonsterName_3.setText(team.get(1).getName());
		} catch (Exception e) {
			System.out.println("Not enough monsters");
		}
		panelMonster_3.add(lblMonsterName_3);
		panelBattles.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelBattle1 = new JPanel();
		panelBattle1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle1);
		
		JLabel lblBattleTitle1 = new JLabel("Battle 1");
		lblBattleTitle1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBattleTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		panelBattle1.add(lblBattleTitle1);
		
		JPanel panelBattle2 = new JPanel();
		panelBattle2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle2);
		
		JLabel lblBattleTitle2 = new JLabel("Battle 2");
		lblBattleTitle2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle2.add(lblBattleTitle2);
		
		JPanel panelBattle3 = new JPanel();
		panelBattle3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle3);
		
		JLabel lblBattleTitle3 = new JLabel("Battle 3");
		lblBattleTitle3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattleTitle3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle3.add(lblBattleTitle3);
		
		JPanel panelBattle4 = new JPanel();
		panelBattle4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelBattles.add(panelBattle4);
		
		JLabel lblBattleTitle4 = new JLabel("Battle 4");
		lblBattleTitle4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattleTitle4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelBattle4.add(lblBattleTitle4);
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
