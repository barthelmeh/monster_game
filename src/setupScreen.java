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
	public ButtonGroup starterButtonGroup = new ButtonGroup();
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
		window.setBounds(100, 100, 1185, 794);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(0)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 1150, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(315)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(0, 0, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(maxDaySlider, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnEasy, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMedium)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnHard, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
									.addGap(79)))
							.addGap(366))
						.addComponent(btnStartGameButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnMedium, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
							.addComponent(rdbtnEasy, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnHard, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(maxDaySlider, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStartGameButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{245, 81, 81, 81, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.anchor = GridBagConstraints.EAST;
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 0;
		gbc_lblHealth.gridy = 1;
		panel.add(lblHealth, gbc_lblHealth);

		
		JLabel lblStarterMonsterHealth = new JLabel(Integer.toString(manager.getStarterMonsters().get(0).getMonsterMaxHealth()));
		lblStarterMonsterHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterHealth = new GridBagConstraints();
		gbc_lblStarterMonsterHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterHealth.gridx = 1;
		gbc_lblStarterMonsterHealth.gridy = 1;
		panel.add(lblStarterMonsterHealth, gbc_lblStarterMonsterHealth);
		
		JLabel lblStarterMonster1Health = new JLabel(Integer.toString(manager.getStarterMonsters().get(1).getMonsterMaxHealth()));
		lblStarterMonster1Health.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster1Health = new GridBagConstraints();
		gbc_lblStarterMonster1Health.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonster1Health.gridx = 2;
		gbc_lblStarterMonster1Health.gridy = 1;
		panel.add(lblStarterMonster1Health, gbc_lblStarterMonster1Health);
		
		JLabel lblStarterMonster2Health = new JLabel(Integer.toString(manager.getStarterMonsters().get(2).getMonsterMaxHealth()));
		lblStarterMonster2Health.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster2Health = new GridBagConstraints();
		gbc_lblStarterMonster2Health.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterMonster2Health.gridx = 3;
		gbc_lblStarterMonster2Health.gridy = 1;
		panel.add(lblStarterMonster2Health, gbc_lblStarterMonster2Health);
		
		JLabel lblDamage = new JLabel("Damage:");
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.anchor = GridBagConstraints.EAST;
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 0;
		gbc_lblDamage.gridy = 2;
		panel.add(lblDamage, gbc_lblDamage);
		
		JLabel lblStarterMonsterDamage = new JLabel(Integer.toString(manager.getStarterMonsters().get(0).getDamage()));
		lblStarterMonsterDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterDamage = new GridBagConstraints();
		gbc_lblStarterMonsterDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterDamage.gridx = 1;
		gbc_lblStarterMonsterDamage.gridy = 2;
		panel.add(lblStarterMonsterDamage, gbc_lblStarterMonsterDamage);
		
		JLabel lblStarterMonster1Damage = new JLabel(Integer.toString(manager.getStarterMonsters().get(1).getDamage()));
		lblStarterMonster1Damage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster1Damage = new GridBagConstraints();
		gbc_lblStarterMonster1Damage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonster1Damage.gridx = 2;
		gbc_lblStarterMonster1Damage.gridy = 2;
		panel.add(lblStarterMonster1Damage, gbc_lblStarterMonster1Damage);
		
		JLabel lblStarterMonster2Damage = new JLabel(Integer.toString(manager.getStarterMonsters().get(2).getDamage()));
		lblStarterMonster2Damage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster2Damage = new GridBagConstraints();
		gbc_lblStarterMonster2Damage.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterMonster2Damage.gridx = 3;
		gbc_lblStarterMonster2Damage.gridy = 2;
		panel.add(lblStarterMonster2Damage, gbc_lblStarterMonster2Damage);
		
		JLabel lblCriticalChance = new JLabel("Critical Chance:");
		lblCriticalChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCriticalChance = new GridBagConstraints();
		gbc_lblCriticalChance.anchor = GridBagConstraints.EAST;
		gbc_lblCriticalChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblCriticalChance.gridx = 0;
		gbc_lblCriticalChance.gridy = 3;
		panel.add(lblCriticalChance, gbc_lblCriticalChance);
		
		JLabel lblStarterMonsterCritChance = new JLabel(toPercentage(manager.getStarterMonsters().get(0).getCriticalStrike()));
		lblStarterMonsterCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance.gridx = 1;
		gbc_lblStarterMonsterCritChance.gridy = 3;
		panel.add(lblStarterMonsterCritChance, gbc_lblStarterMonsterCritChance);
		
		JLabel lblStarterMonsterCritChance_1 = new JLabel(toPercentage(manager.getStarterMonsters().get(1).getCriticalStrike()));
		lblStarterMonsterCritChance_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance_1 = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance_1.gridx = 2;
		gbc_lblStarterMonsterCritChance_1.gridy = 3;
		panel.add(lblStarterMonsterCritChance_1, gbc_lblStarterMonsterCritChance_1);
		
		JLabel lblStarterMonsterCritChance_2 = new JLabel(toPercentage(manager.getStarterMonsters().get(2).getCriticalStrike()));
		lblStarterMonsterCritChance_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance_2 = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterMonsterCritChance_2.gridx = 3;
		gbc_lblStarterMonsterCritChance_2.gridy = 3;
		panel.add(lblStarterMonsterCritChance_2, gbc_lblStarterMonsterCritChance_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Selection:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3.gridx = 0;
		gbc_lblNewLabel_2_3.gridy = 4;
		panel.add(lblNewLabel_2_3, gbc_lblNewLabel_2_3);
		
		JRadioButton rdbtnStarterMonster = new JRadioButton(manager.getStarterMonsters().get(0).getName());
		rdbtnStarterMonster.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterMonster = new GridBagConstraints();
		gbc_rdbtnStarterMonster.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterMonster.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStarterMonster.gridx = 1;
		gbc_rdbtnStarterMonster.gridy = 4;
		panel.add(rdbtnStarterMonster, gbc_rdbtnStarterMonster);
		
		starterButtonGroup.add(rdbtnStarterMonster);
		
		JRadioButton rdbtnStarterMonster1 = new JRadioButton(manager.getStarterMonsters().get(1).getName());
		rdbtnStarterMonster1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterMonster1 = new GridBagConstraints();
		gbc_rdbtnStarterMonster1.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterMonster1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnStarterMonster1.gridx = 2;
		gbc_rdbtnStarterMonster1.gridy = 4;
		panel.add(rdbtnStarterMonster1, gbc_rdbtnStarterMonster1);
		starterButtonGroup.add(rdbtnStarterMonster1);
		
		JRadioButton rdbtnStarterMonster2 = new JRadioButton(manager.getStarterMonsters().get(2).getName());
		rdbtnStarterMonster2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_rdbtnStarterMonster2 = new GridBagConstraints();
		gbc_rdbtnStarterMonster2.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnStarterMonster2.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnStarterMonster2.gridx = 3;
		gbc_rdbtnStarterMonster2.gridy = 4;
		panel.add(rdbtnStarterMonster2, gbc_rdbtnStarterMonster2);
		starterButtonGroup.add(rdbtnStarterMonster2);
		
		window.getContentPane().setLayout(groupLayout);
	}
}
