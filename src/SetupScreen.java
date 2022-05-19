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

public class SetupScreen {
	public ButtonGroup difficultyButtonGroup = new ButtonGroup();
	public ButtonGroup starterMonsterButtonGroup = new ButtonGroup();
	public ButtonGroup starterItemButtonGroup = new ButtonGroup();
	private JFrame window;
	private MainGame manager;
	private SetupScreen screen;
	private JTextField userNameTextField;
	private JSlider maxDaySlider;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
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
	public SetupScreen(MainGame incomingManager) {
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
	public SetupScreen() {
		initialize();
	}
	
	public JTextField getUserNameTextField() {
		return userNameTextField;
	}

	public JSlider getMaxDaySlider() {
		return maxDaySlider;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Setup Screen");
		window.setBounds(100, 100, 1280, 783);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblErrorLabel = new JLabel("");
		lblErrorLabel.setForeground(Color.RED);
		
		JButton btnStartGameButton = new JButton("Start Adventure");
		btnStartGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetUp getButtons = new SetUp(screen);
				if (getButtons.getPlayerName().length() < 3 || getButtons.getPlayerName().length() > 15) {
					lblErrorLabel.setText("Please input name between 3 and 15 characters");
				} else if (manager.getSelectedButtonText(starterMonsterButtonGroup) == null) {
					lblErrorLabel.setText("Please select a monster");
				} else if (manager.getSelectedButtonText(starterItemButtonGroup) == null) {
					lblErrorLabel.setText("Please select a item");
				} else {
					SetUp setup = new SetUp(manager, screen);
					manager.closeSetupScreen(screen);
				}
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
		
		JLabel lblStarterItemIncrease = new JLabel(manager.toPercentage(manager.getStarterItems().get(0).getItemIncrease()));
		lblStarterItemIncrease.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease = new GridBagConstraints();
		gbc_lblStarterItemIncrease.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemIncrease.gridx = 1;
		gbc_lblStarterItemIncrease.gridy = 1;
		panelItem.add(lblStarterItemIncrease, gbc_lblStarterItemIncrease);
		
		JLabel lblStarterItemIncrease1 = new JLabel(manager.toPercentage(manager.getStarterItems().get(1).getItemIncrease()));
		lblStarterItemIncrease1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterItemIncrease1 = new GridBagConstraints();
		gbc_lblStarterItemIncrease1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterItemIncrease1.gridx = 2;
		gbc_lblStarterItemIncrease1.gridy = 1;
		panelItem.add(lblStarterItemIncrease1, gbc_lblStarterItemIncrease1);
		
		JLabel lblStarterItemIncrease2 = new JLabel(manager.toPercentage(manager.getStarterItems().get(2).getItemIncrease()));
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
		
		JPanel panel = new JPanel();
		
		
		lblErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblErrorLabel, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnStartGameButton))
						.addComponent(panelMonster, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE)
						.addComponent(panelItem, GroupLayout.DEFAULT_SIZE, 1246, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelMonster, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStartGameButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblErrorLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Monster Hunt");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblTitle.setBounds(10, 11, 1226, 61);
		panel.add(lblTitle);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblName.setBounds(410, 83, 131, 41);
		panel.add(lblName);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		userNameTextField.setBounds(551, 83, 319, 41);
		panel.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDifficulty.setBounds(410, 131, 131, 37);
		panel.add(lblDifficulty);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		difficultyButtonGroup.add(rdbtnEasy);
		rdbtnEasy.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnEasy.setBounds(551, 127, 87, 41);
		panel.add(rdbtnEasy);
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setSelected(true);
		difficultyButtonGroup.add(rdbtnMedium);
		rdbtnMedium.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnMedium.setBounds(640, 127, 131, 41);
		panel.add(rdbtnMedium);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		difficultyButtonGroup.add(rdbtnHard);
		rdbtnHard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnHard.setBounds(773, 127, 97, 41);
		panel.add(rdbtnHard);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDays.setBounds(410, 179, 131, 57);
		panel.add(lblDays);
		
		maxDaySlider = new JSlider();
		maxDaySlider.setFont(new Font("Tahoma", Font.PLAIN, 30));
		maxDaySlider.setMajorTickSpacing(5);
		maxDaySlider.setMinorTickSpacing(1);
		maxDaySlider.setValue(5);
		maxDaySlider.setSnapToTicks(true);
		maxDaySlider.setPaintTicks(true);
		maxDaySlider.setPaintLabels(true);
		maxDaySlider.setMinimum(5);
		maxDaySlider.setMaximum(15);
		maxDaySlider.setBounds(551, 175, 319, 61);
		panel.add(maxDaySlider);
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
		
		JLabel lblStarterMonsterCritChance = new JLabel(manager.toPercentage(manager.getStarterMonsters().get(0).getCriticalStrike()));
		lblStarterMonsterCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance.gridx = 1;
		gbc_lblStarterMonsterCritChance.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance, gbc_lblStarterMonsterCritChance);
		
		JLabel lblStarterMonsterCritChance_1 = new JLabel(manager.toPercentage(manager.getStarterMonsters().get(1).getCriticalStrike()));
		lblStarterMonsterCritChance_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance_1 = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance_1.gridx = 2;
		gbc_lblStarterMonsterCritChance_1.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance_1, gbc_lblStarterMonsterCritChance_1);
		
		JLabel lblStarterMonsterCritChance_2 = new JLabel(manager.toPercentage(manager.getStarterMonsters().get(2).getCriticalStrike()));
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
}
