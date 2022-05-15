import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class StoreScreen {

	private JFrame window;

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

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 1185, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTop = new JPanel();
		panelTop.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblMoney = new JLabel("Money: 0");
		lblMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblMoney.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblMoney);
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblStore);
		
		JLabel lblDaysLeft = new JLabel("Days Left: 0");
		lblDaysLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDaysLeft.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panelTop.add(lblDaysLeft);
		
		JPanel panelMonster = new JPanel();
		panelMonster.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		GridBagLayout gbl_panelMonster = new GridBagLayout();
		gbl_panelMonster.columnWidths = new int[]{245, 81, 81, 81, 0};
		gbl_panelMonster.rowHeights = new int[]{42, 42, 0, 0, 0, 0, 0};
		gbl_panelMonster.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelMonster.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelMonster.setLayout(gbl_panelMonster);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.anchor = GridBagConstraints.EAST;
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 0;
		gbc_lblHealth.gridy = 0;
		panelMonster.add(lblHealth, gbc_lblHealth);
		
		JLabel lblStarterMonsterHealth = new JLabel("0");
		lblStarterMonsterHealth.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterHealth = new GridBagConstraints();
		gbc_lblStarterMonsterHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterHealth.gridx = 1;
		gbc_lblStarterMonsterHealth.gridy = 0;
		panelMonster.add(lblStarterMonsterHealth, gbc_lblStarterMonsterHealth);
		
		JLabel lblStarterMonster1Health = new JLabel("0");
		lblStarterMonster1Health.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster1Health = new GridBagConstraints();
		gbc_lblStarterMonster1Health.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonster1Health.gridx = 2;
		gbc_lblStarterMonster1Health.gridy = 0;
		panelMonster.add(lblStarterMonster1Health, gbc_lblStarterMonster1Health);
		
		JLabel lblStarterMonster2Health = new JLabel("0");
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
		
		JLabel lblStarterMonsterDamage = new JLabel("0");
		lblStarterMonsterDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterDamage = new GridBagConstraints();
		gbc_lblStarterMonsterDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterDamage.gridx = 1;
		gbc_lblStarterMonsterDamage.gridy = 1;
		panelMonster.add(lblStarterMonsterDamage, gbc_lblStarterMonsterDamage);
		
		JLabel lblStarterMonster1Damage = new JLabel("0");
		lblStarterMonster1Damage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonster1Damage = new GridBagConstraints();
		gbc_lblStarterMonster1Damage.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonster1Damage.gridx = 2;
		gbc_lblStarterMonster1Damage.gridy = 1;
		panelMonster.add(lblStarterMonster1Damage, gbc_lblStarterMonster1Damage);
		
		JLabel lblStarterMonster2Damage = new JLabel("0");
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
		
		JLabel lblStarterMonsterCritChance = new JLabel((String) null);
		lblStarterMonsterCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance.gridx = 1;
		gbc_lblStarterMonsterCritChance.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance, gbc_lblStarterMonsterCritChance);
		
		JLabel lblStarterMonsterCritChance_1 = new JLabel((String) null);
		lblStarterMonsterCritChance_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance_1 = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStarterMonsterCritChance_1.gridx = 2;
		gbc_lblStarterMonsterCritChance_1.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance_1, gbc_lblStarterMonsterCritChance_1);
		
		JLabel lblStarterMonsterCritChance_2 = new JLabel((String) null);
		lblStarterMonsterCritChance_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblStarterMonsterCritChance_2 = new GridBagConstraints();
		gbc_lblStarterMonsterCritChance_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblStarterMonsterCritChance_2.gridx = 3;
		gbc_lblStarterMonsterCritChance_2.gridy = 2;
		panelMonster.add(lblStarterMonsterCritChance_2, gbc_lblStarterMonsterCritChance_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Name:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3.gridx = 0;
		gbc_lblNewLabel_2_3.gridy = 3;
		panelMonster.add(lblNewLabel_2_3, gbc_lblNewLabel_2_3);
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMonster, GroupLayout.PREFERRED_SIZE, 1150, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelMonster, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(463, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Cost:");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblNewLabel_2_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_3_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_3_1.gridx = 0;
		gbc_lblNewLabel_2_3_1.gridy = 4;
		panelMonster.add(lblNewLabel_2_3_1, gbc_lblNewLabel_2_3_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		panelMonster.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 5;
		panelMonster.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 5;
		panelMonster.add(btnNewButton_2, gbc_btnNewButton_2);
		window.getContentPane().setLayout(groupLayout);
	}
}
