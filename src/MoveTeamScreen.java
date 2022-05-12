import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class MoveTeamScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoveTeamScreen window = new MoveTeamScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MoveTeamScreen() {
		initialize();
	}
	public void maxSelected(ButtonGroup group) {
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 851, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTeam = new JPanel();
		panelTeam.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTeam, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
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
		
		JLabel lblHealth_1 = new JLabel("0");
		lblHealth_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth_1 = new GridBagConstraints();
		gbc_lblHealth_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHealth_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth_1.gridx = 1;
		gbc_lblHealth_1.gridy = 0;
		panelTeam.add(lblHealth_1, gbc_lblHealth_1);
		
		JLabel lblHealth_1_1 = new JLabel("0");
		lblHealth_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth_1_1 = new GridBagConstraints();
		gbc_lblHealth_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth_1_1.gridx = 2;
		gbc_lblHealth_1_1.gridy = 0;
		panelTeam.add(lblHealth_1_1, gbc_lblHealth_1_1);
		
		JLabel lblHealth_1_2 = new JLabel("0");
		lblHealth_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth_1_2 = new GridBagConstraints();
		gbc_lblHealth_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth_1_2.gridx = 3;
		gbc_lblHealth_1_2.gridy = 0;
		panelTeam.add(lblHealth_1_2, gbc_lblHealth_1_2);
		
		JLabel lblHealth_1_3 = new JLabel("0");
		lblHealth_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth_1_3 = new GridBagConstraints();
		gbc_lblHealth_1_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblHealth_1_3.gridx = 4;
		gbc_lblHealth_1_3.gridy = 0;
		panelTeam.add(lblHealth_1_3, gbc_lblHealth_1_3);
		
		JLabel lblDamage = new JLabel("Damage:");
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 0;
		gbc_lblDamage.gridy = 1;
		panelTeam.add(lblDamage, gbc_lblDamage);
		
		JLabel lblDamage_1 = new JLabel("0");
		lblDamage_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamage_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage_1 = new GridBagConstraints();
		gbc_lblDamage_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDamage_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage_1.gridx = 1;
		gbc_lblDamage_1.gridy = 1;
		panelTeam.add(lblDamage_1, gbc_lblDamage_1);
		
		JLabel lblDamage_1_1 = new JLabel("0");
		lblDamage_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamage_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage_1_1 = new GridBagConstraints();
		gbc_lblDamage_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage_1_1.gridx = 2;
		gbc_lblDamage_1_1.gridy = 1;
		panelTeam.add(lblDamage_1_1, gbc_lblDamage_1_1);
		
		JLabel lblDamage_1_2 = new JLabel("0");
		lblDamage_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamage_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage_1_2 = new GridBagConstraints();
		gbc_lblDamage_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage_1_2.gridx = 3;
		gbc_lblDamage_1_2.gridy = 1;
		panelTeam.add(lblDamage_1_2, gbc_lblDamage_1_2);
		
		JLabel lblDamage_1_3 = new JLabel("0");
		lblDamage_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage_1_3 = new GridBagConstraints();
		gbc_lblDamage_1_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblDamage_1_3.gridx = 4;
		gbc_lblDamage_1_3.gridy = 1;
		panelTeam.add(lblDamage_1_3, gbc_lblDamage_1_3);
		
		JLabel lblCritChance = new JLabel("Crit Chance:");
		lblCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCritChance = new GridBagConstraints();
		gbc_lblCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance.gridx = 0;
		gbc_lblCritChance.gridy = 2;
		panelTeam.add(lblCritChance, gbc_lblCritChance);
		
		JLabel lblCritChance_1 = new JLabel("0");
		lblCritChance_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCritChance_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance_1 = new GridBagConstraints();
		gbc_lblCritChance_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCritChance_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance_1.gridx = 1;
		gbc_lblCritChance_1.gridy = 2;
		panelTeam.add(lblCritChance_1, gbc_lblCritChance_1);
		
		JLabel lblCritChance_1_1 = new JLabel("0");
		lblCritChance_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance_1_1 = new GridBagConstraints();
		gbc_lblCritChance_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance_1_1.gridx = 2;
		gbc_lblCritChance_1_1.gridy = 2;
		panelTeam.add(lblCritChance_1_1, gbc_lblCritChance_1_1);
		
		JLabel lblCritChance_1_2 = new JLabel("0");
		lblCritChance_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance_1_2 = new GridBagConstraints();
		gbc_lblCritChance_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance_1_2.gridx = 3;
		gbc_lblCritChance_1_2.gridy = 2;
		panelTeam.add(lblCritChance_1_2, gbc_lblCritChance_1_2);
		
		JLabel lblCritChance_1_3 = new JLabel("0");
		lblCritChance_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance_1_3 = new GridBagConstraints();
		gbc_lblCritChance_1_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblCritChance_1_3.gridx = 4;
		gbc_lblCritChance_1_3.gridy = 2;
		panelTeam.add(lblCritChance_1_3, gbc_lblCritChance_1_3);
		
		JLabel lblSelection = new JLabel("Selection:");
		lblSelection.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSelection = new GridBagConstraints();
		gbc_lblSelection.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelection.gridx = 0;
		gbc_lblSelection.gridy = 3;
		panelTeam.add(lblSelection, gbc_lblSelection);
		
		JCheckBox chckbxSelection = new JCheckBox("Selection");
		chckbxSelection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection = new GridBagConstraints();
		gbc_chckbxSelection.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSelection.gridx = 1;
		gbc_chckbxSelection.gridy = 3;
		panelTeam.add(chckbxSelection, gbc_chckbxSelection);
		
		JCheckBox chckbxSelection_1 = new JCheckBox("Selection");
		chckbxSelection_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection_1 = new GridBagConstraints();
		gbc_chckbxSelection_1.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSelection_1.gridx = 2;
		gbc_chckbxSelection_1.gridy = 3;
		panelTeam.add(chckbxSelection_1, gbc_chckbxSelection_1);
		
		JCheckBox chckbxSelection_2 = new JCheckBox("Selection");
		chckbxSelection_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection_2 = new GridBagConstraints();
		gbc_chckbxSelection_2.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSelection_2.gridx = 3;
		gbc_chckbxSelection_2.gridy = 3;
		panelTeam.add(chckbxSelection_2, gbc_chckbxSelection_2);
		
		JCheckBox chckbxSelection_3 = new JCheckBox("Selection");
		chckbxSelection_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection_3 = new GridBagConstraints();
		gbc_chckbxSelection_3.gridx = 4;
		gbc_chckbxSelection_3.gridy = 3;
		panelTeam.add(chckbxSelection_3, gbc_chckbxSelection_3);
		panel.setLayout(null);
		
		JButton btnSwap = new JButton("Swap");
		btnSwap.setBounds(0, 0, 246, 67);
		panel.add(btnSwap);
		btnSwap.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(569, 0, 246, 67);
		panel.add(btnExit);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().setLayout(groupLayout);
	}
}
