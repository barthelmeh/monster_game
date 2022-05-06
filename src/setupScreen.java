import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class setupScreen {
	public ButtonGroup difficultyButtonGroup = new ButtonGroup();
	public ButtonGroup starterMonsterButtonGroup = new ButtonGroup();
	public ButtonGroup starterItemButtonGroup = new ButtonGroup();
	public JTextField userNameTextField = new JTextField();
	public JSlider maxDaySlider = new JSlider();
	private JFrame window;
	private mainGame manager;
	private setupScreen screen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setupScreen window = new setupScreen();
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
	public setupScreen(mainGame incomingManager) {
		screen = this;
		manager = incomingManager;
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeSetupScreen(this);
	}
	public setupScreen() {
		initialize();
	}
	public String toPercentage(double n){
		return String.format("%.0f",n*100)+"%";
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Setup Screen");
		window.setBounds(100, 100, 1185, 811);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Monster Hunt");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		

		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Difficulty:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JLabel lblNewLabel_1_2 = new JLabel("Days:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setSelected(true);
		rdbtnMedium.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		difficultyButtonGroup.add(rdbtnEasy);
		difficultyButtonGroup.add(rdbtnMedium);
		difficultyButtonGroup.add(rdbtnHard);
		
		maxDaySlider.setValue(5);
		maxDaySlider.setSnapToTicks(true);
		maxDaySlider.setFont(new Font("Tahoma", Font.PLAIN, 30));
		maxDaySlider.setPaintTicks(true);
		maxDaySlider.setPaintLabels(true);
		maxDaySlider.setMinorTickSpacing(1);
		maxDaySlider.setMinimum(5);
		maxDaySlider.setMaximum(15);
		maxDaySlider.setMajorTickSpacing(5);
		
		JButton btnStartGameButton = new JButton("Start Adventure");
		btnStartGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUp setup = new setUp(manager,screen);
				manager.closeSetupScreen(screen);
			}
		});
		btnStartGameButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JPanel panelMonster = new JPanel();
		panelMonster.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panelItem = new JPanel();
		panelItem.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagLayout gbl_panelItem = new GridBagLayout();
		gbl_panelItem.columnWidths = new int[]{245, 81, 81, 81, 0};
		gbl_panelItem.rowHeights = new int[]{42, 42, 0, 0};
		gbl_panelItem.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelItem.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelItem.setLayout(gbl_panelItem);
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.EAST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 0;
		panelItem.add(lblCost, gbc_lblCost);
		
		JLabel lblStarterItemCost = new JLabel(Integer.toString(manager.getStarterItems().get(0).getItemCost()));
		lblStarterItemCost.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemCost = new GridBagConstraints();
		gbc_lblStarterItemCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemCost.gridx = 1;
		gbc_lblStarterItemCost.gridy = 0;
		panelItem.add(lblStarterItemCost, gbc_lblStarterItemCost);
		
		JLabel lblStarterItemCost1 = new JLabel(Integer.toString(manager.getStarterItems().get(1).getItemCost()));
		lblStarterItemCost1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemCost1 = new GridBagConstraints();
		gbc_lblStarterItemCost1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemCost1.gridx = 2;
		gbc_lblStarterItemCost1.gridy = 0;
		panelItem.add(lblStarterItemCost1, gbc_lblStarterItemCost1);
		
		JLabel lblStarterItemCost2 = new JLabel(Integer.toString(manager.getStarterItems().get(2).getItemCost()));
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
		
		JLabel lblStarterItemIncrease = new JLabel(toPercentage(manager.getStarterItems().get(0).getItemEffect()));
		lblStarterItemIncrease.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease = new GridBagConstraints();
		gbc_lblStarterItemIncrease.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemIncrease.gridx = 1;
		gbc_lblStarterItemIncrease.gridy = 1;
		panelItem.add(lblStarterItemIncrease, gbc_lblStarterItemIncrease);
		
		JLabel lblStarterItemIncrease1 = new JLabel(toPercentage(manager.getStarterItems().get(1).getItemEffect()));
		lblStarterItemIncrease1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease1 = new GridBagConstraints();
		gbc_lblStarterItemIncrease1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemIncrease1.gridx = 2;
		gbc_lblStarterItemIncrease1.gridy = 1;
		panelItem.add(lblStarterItemIncrease1, gbc_lblStarterItemIncrease1);
		
		JLabel lblStarterItemIncrease2 = new JLabel(toPercentage(manager.getStarterItems().get(2).getItemEffect()));
		lblStarterItemIncrease2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease2 = new GridBagConstraints();
		gbc_lblStarterItemIncrease2.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterItemIncrease2.gridx = 3;
		gbc_lblStarterItemIncrease2.gridy = 1;
		panelItem.add(lblStarterItemIncrease2, gbc_lblStarterItemIncrease2);
		
		JLabel lblSelection = new JLabel("Selection:");
		lblSelection.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSelection = new GridBagConstraints();
		gbc_lblSelection.anchor = GridBagConstraints.EAST;
		gbc_lblSelection.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelection.gridx = 0;
		gbc_lblSelection.gridy = 2;
		panelItem.add(lblSelection, gbc_lblSelection);
		
		JRadioButton rdbtnStarterItem = new JRadioButton(manager.getStarterItems().get(0).getItemName());
		rdbtnStarterItem.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterItem = new GridBagConstraints();
		gbc_rdbtnStarterItem.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterItem.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnStarterItem.gridx = 1;
		gbc_rdbtnStarterItem.gridy = 2;
		panelItem.add(rdbtnStarterItem, gbc_rdbtnStarterItem);
		starterItemButtonGroup.add(rdbtnStarterItem);
		
		JRadioButton rdbtnStarterItem1 = new JRadioButton(manager.getStarterItems().get(1).getItemName());
		rdbtnStarterItem1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterItem1 = new GridBagConstraints();
		gbc_rdbtnStarterItem1.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterItem1.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnStarterItem1.gridx = 2;
		gbc_rdbtnStarterItem1.gridy = 2;
		panelItem.add(rdbtnStarterItem1, gbc_rdbtnStarterItem1);
		starterItemButtonGroup.add(rdbtnStarterItem1);
		
		JRadioButton rdbtnStarterItem2 = new JRadioButton(manager.getStarterItems().get(2).getItemName());
		rdbtnStarterItem2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterItem2 = new GridBagConstraints();
		gbc_rdbtnStarterItem2.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterItem2.gridx = 3;
		gbc_rdbtnStarterItem2.gridy = 2;
		panelItem.add(rdbtnStarterItem2, gbc_rdbtnStarterItem2);
		starterItemButtonGroup.add(rdbtnStarterItem2);
		
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelMonster, GroupLayout.PREFERRED_SIZE, 1150, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelItem, GroupLayout.PREFERRED_SIZE, 1150, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(313)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(maxDaySlider, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnEasy, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnMedium)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnHard, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
											.addGap(2))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(366))
								.addComponent(btnStartGameButton))
							.addGap(476))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(397)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
							.addComponent(rdbtnMedium, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnEasy, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnHard, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(maxDaySlider, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMonster, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStartGameButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		GridBagLayout gbl_panelMonster = new GridBagLayout();
		gbl_panelMonster.columnWidths = new int[]{245, 81, 81, 81, 0};
		gbl_panelMonster.rowHeights = new int[]{42, 42, 0, 0, 0};
		gbl_panelMonster.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelMonster.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMonster.setLayout(gbl_panelMonster);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.anchor = GridBagConstraints.EAST;
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 0;
		gbc_lblHealth.gridy = 0;
		panelMonster.add(lblHealth, gbc_lblHealth);
		
		
		JLabel lblStarterMonsterHealth = new JLabel(Integer.toString(manager.getStarterMonsters().get(0).getMonsterMaxHealth()));
		lblStarterMonsterHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterHealth = new GridBagConstraints();
		gbc_lblStarterMonsterHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterHealth.gridx = 1;
		gbc_lblStarterMonsterHealth.gridy = 0;
		panelMonster.add(lblStarterMonsterHealth, gbc_lblStarterMonsterHealth);
		
		JLabel lblStarterMonster1Health = new JLabel(Integer.toString(manager.getStarterMonsters().get(1).getMonsterMaxHealth()));
		lblStarterMonster1Health.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster1Health = new GridBagConstraints();
		gbc_lblStarterMonster1Health.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonster1Health.gridx = 2;
		gbc_lblStarterMonster1Health.gridy = 0;
		panelMonster.add(lblStarterMonster1Health, gbc_lblStarterMonster1Health);
		
		JLabel lblStarterMonster2Health = new JLabel(Integer.toString(manager.getStarterMonsters().get(2).getMonsterMaxHealth()));
		lblStarterMonster2Health.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster2Health = new GridBagConstraints();
		gbc_lblStarterMonster2Health.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterMonster2Health.gridx = 3;
		gbc_lblStarterMonster2Health.gridy = 0;
		panelMonster.add(lblStarterMonster2Health, gbc_lblStarterMonster2Health);
		
		JLabel lblDamage = new JLabel("Damage:");
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.anchor = GridBagConstraints.EAST;
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 0;
		gbc_lblDamage.gridy = 1;
		panelMonster.add(lblDamage, gbc_lblDamage);
		
		JLabel lblStarterMonsterDamage = new JLabel(Integer.toString(manager.getStarterMonsters().get(0).getDamage()));
		lblStarterMonsterDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterDamage = new GridBagConstraints();
		gbc_lblStarterMonsterDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterDamage.gridx = 1;
		gbc_lblStarterMonsterDamage.gridy = 1;
		panelMonster.add(lblStarterMonsterDamage, gbc_lblStarterMonsterDamage);
		
		JLabel lblStarterMonster1Damage = new JLabel(Integer.toString(manager.getStarterMonsters().get(1).getDamage()));
		lblStarterMonster1Damage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster1Damage = new GridBagConstraints();
		gbc_lblStarterMonster1Damage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonster1Damage.gridx = 2;
		gbc_lblStarterMonster1Damage.gridy = 1;
		panelMonster.add(lblStarterMonster1Damage, gbc_lblStarterMonster1Damage);
		
		JLabel lblStarterMonster2Damage = new JLabel(Integer.toString(manager.getStarterMonsters().get(2).getDamage()));
		lblStarterMonster2Damage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster2Damage = new GridBagConstraints();
		gbc_lblStarterMonster2Damage.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterMonster2Damage.gridx = 3;
		gbc_lblStarterMonster2Damage.gridy = 1;
		panelMonster.add(lblStarterMonster2Damage, gbc_lblStarterMonster2Damage);
		
		JLabel lblCriticalChance = new JLabel("Critical Chance:");
		lblCriticalChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCriticalChance = new GridBagConstraints();
		gbc_lblCriticalChance.anchor = GridBagConstraints.EAST;
		gbc_lblCriticalChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblCriticalChance.gridx = 0;
		gbc_lblCriticalChance.gridy = 2;
		panelMonster.add(lblCriticalChance, gbc_lblCriticalChance);
		
		JLabel lblStarterMonsterCritChance = new JLabel(toPercentage(manager.getStarterMonsters().get(0).getCriticalStrike()));
		lblStarterMonsterCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance.gridx = 1;
		gbc_lblStarterMonsterCritChance.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance, gbc_lblStarterMonsterCritChance);
		
		JLabel lblStarterMonsterCritChance_1 = new JLabel(toPercentage(manager.getStarterMonsters().get(1).getCriticalStrike()));
		lblStarterMonsterCritChance_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance_1 = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance_1.gridx = 2;
		gbc_lblStarterMonsterCritChance_1.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance_1, gbc_lblStarterMonsterCritChance_1);
		
		JLabel lblStarterMonsterCritChance_2 = new JLabel(toPercentage(manager.getStarterMonsters().get(2).getCriticalStrike()));
		lblStarterMonsterCritChance_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance_2 = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterMonsterCritChance_2.gridx = 3;
		gbc_lblStarterMonsterCritChance_2.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance_2, gbc_lblStarterMonsterCritChance_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Selection:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2_3.gridx = 0;
		gbc_lblNewLabel_2_3.gridy = 3;
		panelMonster.add(lblNewLabel_2_3, gbc_lblNewLabel_2_3);
		
		JRadioButton rdbtnStarterMonster = new JRadioButton(manager.getStarterMonsters().get(0).getName());
		rdbtnStarterMonster.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterMonster = new GridBagConstraints();
		gbc_rdbtnStarterMonster.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterMonster.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnStarterMonster.gridx = 1;
		gbc_rdbtnStarterMonster.gridy = 3;
		panelMonster.add(rdbtnStarterMonster, gbc_rdbtnStarterMonster);
		
		starterMonsterButtonGroup.add(rdbtnStarterMonster);
		
		JRadioButton rdbtnStarterMonster1 = new JRadioButton(manager.getStarterMonsters().get(1).getName());
		rdbtnStarterMonster1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterMonster1 = new GridBagConstraints();
		gbc_rdbtnStarterMonster1.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterMonster1.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnStarterMonster1.gridx = 2;
		gbc_rdbtnStarterMonster1.gridy = 3;
		panelMonster.add(rdbtnStarterMonster1, gbc_rdbtnStarterMonster1);
		starterMonsterButtonGroup.add(rdbtnStarterMonster1);
		
		JRadioButton rdbtnStarterMonster2 = new JRadioButton(manager.getStarterMonsters().get(2).getName());
		rdbtnStarterMonster2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterMonster2 = new GridBagConstraints();
		gbc_rdbtnStarterMonster2.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterMonster2.gridx = 3;
		gbc_rdbtnStarterMonster2.gridy = 3;
		panelMonster.add(rdbtnStarterMonster2, gbc_rdbtnStarterMonster2);
		starterMonsterButtonGroup.add(rdbtnStarterMonster2);
		
		window.getContentPane().setLayout(groupLayout);
	}

	private String String(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
