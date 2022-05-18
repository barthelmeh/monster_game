import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplyItemScreen {

	private JFrame window;
	private ApplyItemScreen screen;
	private MainGame manager;
	private JButton button;
	private ArrayList<Item> inventory;
	private ArrayList<Monster> team;
	private final ButtonGroup monsterSelection = new ButtonGroup();
	private final ButtonGroup itemSelection = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplyItemScreen window = new ApplyItemScreen();
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
	public ApplyItemScreen() {
		initialize();
	}
	public ApplyItemScreen(MainGame incomingManager, JButton incomingButton) {
		screen = this;
		manager = incomingManager;
		button = incomingButton;
		setInventory(manager.getPlayer().getInventory());
		setTeam(manager.getPlayer().getTeam());
		initialize();
		window.setVisible(true);
	}
	private void setTeam(ArrayList<Monster> newTeam) {
		team = newTeam;
	}
	private void setInventory(ArrayList<Item> newInventory) {
		inventory = newInventory;
	}

	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeApplyItemScreen(screen, button);
	}
	public void applyItem() {
		
	}
	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1151, 622);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTeam = new JPanel();
		panelTeam.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gbl_panelTeam = new GridBagLayout();
		gbl_panelTeam.columnWidths = new int[]{0, 82, 78, 52, 87, 0};
		gbl_panelTeam.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelTeam.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelTeam.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelTeam.setLayout(gbl_panelTeam);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 0;
		gbc_lblHealth.gridy = 0;
		panelTeam.add(lblHealth, gbc_lblHealth);
		
		JLabel lblHealth_1 = new JLabel("");
		try {
			lblHealth_1.setText(Integer.toString(team.get(0).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth_1.setText("");
		}
		lblHealth_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth_1 = new GridBagConstraints();
		gbc_lblHealth_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth_1.gridx = 1;
		gbc_lblHealth_1.gridy = 0;
		panelTeam.add(lblHealth_1, gbc_lblHealth_1);
		
		JLabel lblHealth_2 = new JLabel("");
		try {
			lblHealth_2.setText(Integer.toString(team.get(1).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth_2.setText("");
		}
		lblHealth_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth_2 = new GridBagConstraints();
		gbc_lblHealth_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth_2.gridx = 2;
		gbc_lblHealth_2.gridy = 0;
		panelTeam.add(lblHealth_2, gbc_lblHealth_2);
		
		JLabel lblHealth_3 = new JLabel("");
		try {
			lblHealth_3.setText(Integer.toString(team.get(2).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth_3.setText("");
		}
		lblHealth_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth_3 = new GridBagConstraints();
		gbc_lblHealth_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth_3.gridx = 3;
		gbc_lblHealth_3.gridy = 0;
		panelTeam.add(lblHealth_3, gbc_lblHealth_3);
		
		JLabel lblHealth_4 = new JLabel("");
		try {
			lblHealth_4.setText(Integer.toString(team.get(3).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth_4.setText("");
		}
		lblHealth_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth_4 = new GridBagConstraints();
		gbc_lblHealth_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblHealth_4.gridx = 4;
		gbc_lblHealth_4.gridy = 0;
		panelTeam.add(lblHealth_4, gbc_lblHealth_4);
		
		JLabel lblDamage = new JLabel("Damage:");
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 0;
		gbc_lblDamage.gridy = 1;
		panelTeam.add(lblDamage, gbc_lblDamage);
		
		JLabel lblDamage_1 = new JLabel();
		try {
			lblDamage_1.setText(Integer.toString(team.get(0).getDamage()));
		} catch (Exception e) {
			lblDamage_1.setText("");
		}
		lblDamage_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage_1 = new GridBagConstraints();
		gbc_lblDamage_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage_1.gridx = 1;
		gbc_lblDamage_1.gridy = 1;
		panelTeam.add(lblDamage_1, gbc_lblDamage_1);
		
		JLabel lblDamage_2 = new JLabel("");
		try {
			lblDamage_2.setText(Integer.toString(team.get(1).getDamage()));
		} catch (Exception e) {
			lblDamage_2.setText("");
		}
		lblDamage_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage_2 = new GridBagConstraints();
		gbc_lblDamage_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage_2.gridx = 2;
		gbc_lblDamage_2.gridy = 1;
		panelTeam.add(lblDamage_2, gbc_lblDamage_2);
		
		JLabel lblDamage_3 = new JLabel("");
		try {
			lblDamage_3.setText(Integer.toString(team.get(2).getDamage()));
		} catch (Exception e) {
			lblDamage_3.setText("");
		}
		lblDamage_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage_3 = new GridBagConstraints();
		gbc_lblDamage_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage_3.gridx = 3;
		gbc_lblDamage_3.gridy = 1;
		panelTeam.add(lblDamage_3, gbc_lblDamage_3);
		
		JLabel lblDamage_4 = new JLabel("");
		try {
			lblDamage_4.setText(Integer.toString(team.get(3).getDamage()));
		} catch (Exception e) {
			lblDamage_4.setText("");
		}
		lblDamage_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage_4 = new GridBagConstraints();
		gbc_lblDamage_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblDamage_4.gridx = 4;
		gbc_lblDamage_4.gridy = 1;
		panelTeam.add(lblDamage_4, gbc_lblDamage_4);
		
		JLabel lblCritChance = new JLabel("Crit Chance:");
		lblCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCritChance = new GridBagConstraints();
		gbc_lblCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance.gridx = 0;
		gbc_lblCritChance.gridy = 2;
		panelTeam.add(lblCritChance, gbc_lblCritChance);
		
		JLabel lblCritChance_1 = new JLabel("");
		try {
			lblCritChance_1.setText(manager.toPercentage(team.get(0).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance_1.setText("");
		}
		lblCritChance_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCritChance_1 = new GridBagConstraints();
		gbc_lblCritChance_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance_1.gridx = 1;
		gbc_lblCritChance_1.gridy = 2;
		panelTeam.add(lblCritChance_1, gbc_lblCritChance_1);
		
		JLabel lblCritChance_2 = new JLabel("");
		try {
			lblCritChance_2.setText(manager.toPercentage(team.get(1).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance_2.setText("");
		}
		lblCritChance_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCritChance_2 = new GridBagConstraints();
		gbc_lblCritChance_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance_2.gridx = 2;
		gbc_lblCritChance_2.gridy = 2;
		panelTeam.add(lblCritChance_2, gbc_lblCritChance_2);
		
		JLabel lblCritChance_3 = new JLabel("");
		try {
			lblCritChance_3.setText(manager.toPercentage(team.get(2).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance_3.setText("");
		}
		lblCritChance_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCritChance_3 = new GridBagConstraints();
		gbc_lblCritChance_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance_3.gridx = 3;
		gbc_lblCritChance_3.gridy = 2;
		panelTeam.add(lblCritChance_3, gbc_lblCritChance_3);
		
		JLabel lblCritChance_4 = new JLabel("");
		try {
			lblCritChance_4.setText(manager.toPercentage(team.get(3).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance_4.setText("");
		}
		lblCritChance_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCritChance_4 = new GridBagConstraints();
		gbc_lblCritChance_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblCritChance_4.gridx = 4;
		gbc_lblCritChance_4.gridy = 2;
		panelTeam.add(lblCritChance_4, gbc_lblCritChance_4);
		
		JLabel lblSelection = new JLabel("Selection:");
		lblSelection.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSelection = new GridBagConstraints();
		gbc_lblSelection.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelection.gridx = 0;
		gbc_lblSelection.gridy = 3;
		panelTeam.add(lblSelection, gbc_lblSelection);
		
		JToggleButton tglbtnMonsterSelect = new JToggleButton();
		try {
			tglbtnMonsterSelect.setText(team.get(0).getName());
		} catch (Exception e){
			tglbtnMonsterSelect.setEnabled(false);
		}
		monsterSelection.add(tglbtnMonsterSelect);
		tglbtnMonsterSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnMonsterSelect = new GridBagConstraints();
		gbc_tglbtnMonsterSelect.fill = GridBagConstraints.BOTH;
		gbc_tglbtnMonsterSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnMonsterSelect.gridx = 1;
		gbc_tglbtnMonsterSelect.gridy = 3;
		panelTeam.add(tglbtnMonsterSelect, gbc_tglbtnMonsterSelect);
		
		JToggleButton tglbtnMonsterSelect_1 = new JToggleButton();
		try {
			tglbtnMonsterSelect_1.setText(team.get(1).getName());
		} catch (Exception e){
			tglbtnMonsterSelect_1.setEnabled(false);
		}
		monsterSelection.add(tglbtnMonsterSelect_1);
		tglbtnMonsterSelect_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnMonsterSelect_1 = new GridBagConstraints();
		gbc_tglbtnMonsterSelect_1.fill = GridBagConstraints.BOTH;
		gbc_tglbtnMonsterSelect_1.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnMonsterSelect_1.gridx = 2;
		gbc_tglbtnMonsterSelect_1.gridy = 3;
		panelTeam.add(tglbtnMonsterSelect_1, gbc_tglbtnMonsterSelect_1);
		
		JToggleButton tglbtnMonsterSelect_2 = new JToggleButton("Select");
		try {
			tglbtnMonsterSelect_2.setText(team.get(2).getName());
		} catch (Exception e){
			tglbtnMonsterSelect_2.setEnabled(false);
		}
		monsterSelection.add(tglbtnMonsterSelect_2);
		tglbtnMonsterSelect_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnMonsterSelect_2 = new GridBagConstraints();
		gbc_tglbtnMonsterSelect_2.fill = GridBagConstraints.BOTH;
		gbc_tglbtnMonsterSelect_2.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnMonsterSelect_2.gridx = 3;
		gbc_tglbtnMonsterSelect_2.gridy = 3;
		panelTeam.add(tglbtnMonsterSelect_2, gbc_tglbtnMonsterSelect_2);
		
		JToggleButton tglbtnMonsterSelect_3 = new JToggleButton("Select");
		try {
			tglbtnMonsterSelect_3.setText(team.get(3).getName());
		} catch (Exception e){
			tglbtnMonsterSelect_3.setEnabled(false);
		}
		monsterSelection.add(tglbtnMonsterSelect_3);
		tglbtnMonsterSelect_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnMonsterSelect_3 = new GridBagConstraints();
		gbc_tglbtnMonsterSelect_3.fill = GridBagConstraints.BOTH;
		gbc_tglbtnMonsterSelect_3.gridx = 4;
		gbc_tglbtnMonsterSelect_3.gridy = 3;
		panelTeam.add(tglbtnMonsterSelect_3, gbc_tglbtnMonsterSelect_3);
		
		JPanel panelInventory = new JPanel();
		panelInventory.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gbl_panelInventory = new GridBagLayout();
		gbl_panelInventory.columnWidths = new int[]{0, 82, 78, 52, 87, 0};
		gbl_panelInventory.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelInventory.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelInventory.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelInventory.setLayout(gbl_panelInventory);
		
		JLabel lblName = new JLabel("Cost:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panelInventory.add(lblName, gbc_lblName);
		
		JLabel lblItemName = new JLabel("");
		try {
			lblItemName.setText(inventory.get(0).getItemName());
		} catch (Exception e) {
			lblItemName.setText("");
		}
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemName = new GridBagConstraints();
		gbc_lblItemName.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName.gridx = 1;
		gbc_lblItemName.gridy = 0;
		panelInventory.add(lblItemName, gbc_lblItemName);
		
		JLabel lblItemName_1 = new JLabel("");
		try {
			lblItemName_1.setText(inventory.get(1).getItemName());
		} catch (Exception e) {
			lblItemName_1.setText("");
		}
		lblItemName_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemName_1 = new GridBagConstraints();
		gbc_lblItemName_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName_1.gridx = 2;
		gbc_lblItemName_1.gridy = 0;
		panelInventory.add(lblItemName_1, gbc_lblItemName_1);
		
		JLabel lblItemName_2 = new JLabel("");
		try {
			lblItemName_2.setText(inventory.get(2).getItemName());
		} catch (Exception e) {
			lblItemName_2.setText("");
		}
		lblItemName_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemName_2 = new GridBagConstraints();
		gbc_lblItemName_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemName_2.gridx = 3;
		gbc_lblItemName_2.gridy = 0;
		panelInventory.add(lblItemName_2, gbc_lblItemName_2);
		
		JLabel lblItemName_3 = new JLabel("");
		try {
			lblItemName_3.setText(inventory.get(3).getItemName());
		} catch (Exception e) {
			lblItemName_3.setText("");
		}
		lblItemName_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemName_3 = new GridBagConstraints();
		gbc_lblItemName_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblItemName_3.gridx = 4;
		gbc_lblItemName_3.gridy = 0;
		panelInventory.add(lblItemName_3, gbc_lblItemName_3);
		
		JLabel lblPercentageIncrease = new JLabel("Percentage Increase:");
		lblPercentageIncrease.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentageIncrease.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblPercentageIncrease = new GridBagConstraints();
		gbc_lblPercentageIncrease.insets = new Insets(0, 0, 5, 5);
		gbc_lblPercentageIncrease.gridx = 0;
		gbc_lblPercentageIncrease.gridy = 1;
		panelInventory.add(lblPercentageIncrease, gbc_lblPercentageIncrease);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnApplyItem = new JButton("Apply Item");
		btnApplyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnApplyItem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelInventory, GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
						.addComponent(panelTeam, GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 625, Short.MAX_VALUE)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelInventory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnApplyItem, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		
		
		JLabel lblItemIncrease = new JLabel("");
		try {
			lblItemIncrease.setText(manager.toPercentage(inventory.get(0).getItemIncrease()));
		} catch (Exception e) {
			lblItemIncrease.setText("");
		}
		lblItemIncrease.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemIncrease = new GridBagConstraints();
		gbc_lblItemIncrease.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemIncrease.gridx = 1;
		gbc_lblItemIncrease.gridy = 1;
		panelInventory.add(lblItemIncrease, gbc_lblItemIncrease);
		
		JLabel lblItemIncrease_1 = new JLabel("");
		try {
			lblItemIncrease_1.setText(manager.toPercentage(inventory.get(1).getItemIncrease()));
		} catch (Exception e) {
			lblItemIncrease_1.setText("");
		}
		lblItemIncrease_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemIncrease_1 = new GridBagConstraints();
		gbc_lblItemIncrease_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemIncrease_1.gridx = 2;
		gbc_lblItemIncrease_1.gridy = 1;
		panelInventory.add(lblItemIncrease_1, gbc_lblItemIncrease_1);
		
		JLabel lblItemIncrease_2 = new JLabel("");
		try {
			lblItemIncrease_2.setText(manager.toPercentage(inventory.get(2).getItemIncrease()));
		} catch (Exception e) {
			lblItemIncrease_2.setText("");
		}
		lblItemIncrease_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemIncrease_2 = new GridBagConstraints();
		gbc_lblItemIncrease_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemIncrease_2.gridx = 3;
		gbc_lblItemIncrease_2.gridy = 1;
		panelInventory.add(lblItemIncrease_2, gbc_lblItemIncrease_2);
		
		JLabel lblItemIncrease_3 = new JLabel("");
		try {
			lblItemIncrease_3.setText(manager.toPercentage(inventory.get(3).getItemIncrease()));
		} catch (Exception e) {
			lblItemIncrease_3.setText("");
		}
		lblItemIncrease_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblItemIncrease_3 = new GridBagConstraints();
		gbc_lblItemIncrease_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblItemIncrease_3.gridx = 4;
		gbc_lblItemIncrease_3.gridy = 1;
		panelInventory.add(lblItemIncrease_3, gbc_lblItemIncrease_3);
		
		JLabel lblSelection_1 = new JLabel("Selection:");
		lblSelection_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSelection_1 = new GridBagConstraints();
		gbc_lblSelection_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelection_1.gridx = 0;
		gbc_lblSelection_1.gridy = 2;
		panelInventory.add(lblSelection_1, gbc_lblSelection_1);
		
		JToggleButton tglbtnItemSelect = new JToggleButton("Select");
		itemSelection.add(tglbtnItemSelect);
		
		tglbtnItemSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnItemSelect = new GridBagConstraints();
		gbc_tglbtnItemSelect.fill = GridBagConstraints.BOTH;
		gbc_tglbtnItemSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnItemSelect.gridx = 1;
		gbc_tglbtnItemSelect.gridy = 2;
		panelInventory.add(tglbtnItemSelect, gbc_tglbtnItemSelect);
		
		JToggleButton tglbtnItemSelect_1 = new JToggleButton("Select");
		itemSelection.add(tglbtnItemSelect_1);
		tglbtnItemSelect_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnItemSelect_1 = new GridBagConstraints();
		gbc_tglbtnItemSelect_1.fill = GridBagConstraints.BOTH;
		gbc_tglbtnItemSelect_1.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnItemSelect_1.gridx = 2;
		gbc_tglbtnItemSelect_1.gridy = 2;
		panelInventory.add(tglbtnItemSelect_1, gbc_tglbtnItemSelect_1);
		
		JToggleButton tglbtnItemSelect_2 = new JToggleButton("Select");
		itemSelection.add(tglbtnItemSelect_2);
		tglbtnItemSelect_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnItemSelect_2 = new GridBagConstraints();
		gbc_tglbtnItemSelect_2.fill = GridBagConstraints.BOTH;
		gbc_tglbtnItemSelect_2.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnItemSelect_2.gridx = 3;
		gbc_tglbtnItemSelect_2.gridy = 2;
		panelInventory.add(tglbtnItemSelect_2, gbc_tglbtnItemSelect_2);
		
		JToggleButton tglbtnItemSelect_3 = new JToggleButton("Select");
		itemSelection.add(tglbtnItemSelect_3);
		tglbtnItemSelect_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_tglbtnItemSelect_3 = new GridBagConstraints();
		gbc_tglbtnItemSelect_3.fill = GridBagConstraints.BOTH;
		gbc_tglbtnItemSelect_3.gridx = 4;
		gbc_tglbtnItemSelect_3.gridy = 2;
		panelInventory.add(tglbtnItemSelect_3, gbc_tglbtnItemSelect_3);
		
		if (inventory.size() == 0) {
			tglbtnItemSelect.setEnabled(false);
			tglbtnItemSelect_1.setEnabled(false);
			tglbtnItemSelect_2.setEnabled(false);
			tglbtnItemSelect_3.setEnabled(false);
		} else if (inventory.size() == 1) {
			tglbtnItemSelect_1.setEnabled(false);
			tglbtnItemSelect_2.setEnabled(false);
			tglbtnItemSelect_3.setEnabled(false);
		} else if (inventory.size() == 2) {
			tglbtnItemSelect_2.setEnabled(false);
			tglbtnItemSelect_3.setEnabled(false);
		} else if (inventory.size() == 3) {
			tglbtnItemSelect_3.setEnabled(false);
		}
		
		window.getContentPane().setLayout(groupLayout);
	}
}
