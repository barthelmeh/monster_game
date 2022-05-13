import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.border.LineBorder;

import java.awt.CheckboxGroup;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoveTeamScreen {

	private JFrame window;
	private MoveTeamScreen screen;
	private MainGame manager;
	private JButton button;
	private ArrayList<JCheckBox> teamButtonList = new ArrayList<JCheckBox>();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoveTeamScreen window = new MoveTeamScreen();
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
	public MoveTeamScreen() {
		initialize();
	}
	public MoveTeamScreen(MainGame incomingManager, JButton incomingButton) {
		screen = this;
		manager = incomingManager;
		button = incomingButton;
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeMoveTeamScreen(screen, button);
	}
	public void getMaxSelected(ArrayList<JCheckBox> checkboxes) {
		int max = 2;
		int checkboxCount = 0;
        for (JCheckBox checkbox : checkboxes) {
            
            if (checkbox.isSelected()) {
            	checkboxCount += 1;
            }
        }
        if (max == checkboxCount) {
        	for (JCheckBox checkbox : checkboxes) {
                if (checkbox.isSelected() == false) {
                	checkbox.setEnabled(false);
                }
            }

        }else {
        	for (JCheckBox checkbox : checkboxes) {
                if (checkbox.isSelected() == false) {
                	checkbox.setEnabled(true);
                }
            }
        }
        
    }
	public ArrayList<JCheckBox> getTeamButtonList() {
		return teamButtonList;
	}

	/**
	 * Initialize the contents of the window.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 851, 373);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTeam = new JPanel();
		panelTeam.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
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
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
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
		
		JLabel lblDamage = new JLabel("Damage:");
		lblDamage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 0;
		gbc_lblDamage.gridy = 1;
		panelTeam.add(lblDamage, gbc_lblDamage);
		
		JLabel lblCritChance = new JLabel("Crit Chance:");
		lblCritChance.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblCritChance = new GridBagConstraints();
		gbc_lblCritChance.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance.gridx = 0;
		gbc_lblCritChance.gridy = 2;
		panelTeam.add(lblCritChance, gbc_lblCritChance);
		
		JLabel lblSelection = new JLabel("Selection:");
		lblSelection.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_lblSelection = new GridBagConstraints();
		gbc_lblSelection.insets = new Insets(0, 0, 0, 5);
		gbc_lblSelection.gridx = 0;
		gbc_lblSelection.gridy = 3;
		panelTeam.add(lblSelection, gbc_lblSelection);
		if (manager.getPlayer().getTeam().size() == 1){
			JLabel lblHealth_1 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(0).getMonsterCurrentHealth()));
			lblHealth_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblHealth_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblHealth_1 = new GridBagConstraints();
			gbc_lblHealth_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblHealth_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblHealth_1.gridx = 1;
			gbc_lblHealth_1.gridy = 0;
			panelTeam.add(lblHealth_1, gbc_lblHealth_1);

			JLabel lblDamage_1 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(0).getDamage()));
			lblDamage_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblDamage_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblDamage_1 = new GridBagConstraints();
			gbc_lblDamage_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblDamage_1.gridx = 1;
			gbc_lblDamage_1.gridy = 1;
			panelTeam.add(lblDamage_1, gbc_lblDamage_1);

			JLabel lblCritChance_1 = new JLabel(manager.toPercentage(manager.getPlayer().getTeam().get(0).getCriticalStrike()));
			lblCritChance_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblCritChance_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblCritChance_1 = new GridBagConstraints();
			gbc_lblCritChance_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblCritChance_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblCritChance_1.gridx = 1;
			gbc_lblCritChance_1.gridy = 2;
			panelTeam.add(lblCritChance_1, gbc_lblCritChance_1);

			JCheckBox chckbxSelection = new JCheckBox(manager.getPlayer().getTeam().get(0).getName());
			chckbxSelection.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
			chckbxSelection.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_chckbxSelection = new GridBagConstraints();
			gbc_chckbxSelection.insets = new Insets(0, 0, 0, 5);
			gbc_chckbxSelection.gridx = 1;
			gbc_chckbxSelection.gridy = 3;
			panelTeam.add(chckbxSelection, gbc_chckbxSelection);
			teamButtonList.add(chckbxSelection);
		} else if (manager.getPlayer().getTeam().size() == 2){
			JLabel lblHealth_1_1 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(1).getMonsterCurrentHealth()));
			lblHealth_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblHealth_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblHealth_1_1 = new GridBagConstraints();
			gbc_lblHealth_1_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblHealth_1_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblHealth_1_1.gridx = 2;
			gbc_lblHealth_1_1.gridy = 0;
			panelTeam.add(lblHealth_1_1, gbc_lblHealth_1_1);

			JLabel lblDamage_1_1 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(1).getDamage()));
			lblDamage_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblDamage_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblDamage_1_1 = new GridBagConstraints();
			gbc_lblDamage_1_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblDamage_1_1.gridx = 2;
			gbc_lblDamage_1_1.gridy = 1;
			panelTeam.add(lblDamage_1_1, gbc_lblDamage_1_1);

			JLabel lblCritChance_1_1 = new JLabel(manager.toPercentage(manager.getPlayer().getTeam().get(1).getCriticalStrike()));
			lblCritChance_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblCritChance_1_1 = new GridBagConstraints();
			gbc_lblCritChance_1_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblCritChance_1_1.gridx = 2;
			gbc_lblCritChance_1_1.gridy = 2;
			panelTeam.add(lblCritChance_1_1, gbc_lblCritChance_1_1);

			JCheckBox chckbxSelection_1 = new JCheckBox(manager.getPlayer().getTeam().get(1).getName());
			chckbxSelection_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
			chckbxSelection_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_chckbxSelection_1 = new GridBagConstraints();
			gbc_chckbxSelection_1.insets = new Insets(0, 0, 0, 5);
			gbc_chckbxSelection_1.gridx = 2;
			gbc_chckbxSelection_1.gridy = 3;
			panelTeam.add(chckbxSelection_1, gbc_chckbxSelection_1);
			teamButtonList.add(chckbxSelection_1);
		} else if (manager.getPlayer().getTeam().size() == 3){
			JLabel lblHealth_1_2 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(2).getMonsterCurrentHealth()));
			lblHealth_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblHealth_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblHealth_1_2 = new GridBagConstraints();
			gbc_lblHealth_1_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblHealth_1_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblHealth_1_2.gridx = 3;
			gbc_lblHealth_1_2.gridy = 0;
			panelTeam.add(lblHealth_1_2, gbc_lblHealth_1_2);

			JLabel lblDamage_1_2 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(2).getDamage()));
			lblDamage_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblDamage_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblDamage_1_2 = new GridBagConstraints();
			gbc_lblDamage_1_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblDamage_1_2.gridx = 3;
			gbc_lblDamage_1_2.gridy = 1;
			panelTeam.add(lblDamage_1_2, gbc_lblDamage_1_2);

			JLabel lblCritChance_1_2 = new JLabel(manager.toPercentage(manager.getPlayer().getTeam().get(2).getCriticalStrike()));
			lblCritChance_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblCritChance_1_2 = new GridBagConstraints();
			gbc_lblCritChance_1_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblCritChance_1_2.gridx = 3;
			gbc_lblCritChance_1_2.gridy = 2;
			panelTeam.add(lblCritChance_1_2, gbc_lblCritChance_1_2);

			JCheckBox chckbxSelection_2 = new JCheckBox(manager.getPlayer().getTeam().get(2).getName());
			chckbxSelection_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
			chckbxSelection_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_chckbxSelection_2 = new GridBagConstraints();
			gbc_chckbxSelection_2.insets = new Insets(0, 0, 0, 5);
			gbc_chckbxSelection_2.gridx = 3;
			gbc_chckbxSelection_2.gridy = 3;
			panelTeam.add(chckbxSelection_2, gbc_chckbxSelection_2);
			teamButtonList.add(chckbxSelection_2);
		} else {
			JLabel lblHealth_1_3 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(3).getMonsterCurrentHealth()));
			lblHealth_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblHealth_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblHealth_1_3 = new GridBagConstraints();
			gbc_lblHealth_1_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblHealth_1_3.insets = new Insets(0, 0, 5, 0);
			gbc_lblHealth_1_3.gridx = 4;
			gbc_lblHealth_1_3.gridy = 0;
			panelTeam.add(lblHealth_1_3, gbc_lblHealth_1_3);

			JLabel lblDamage_1_3 = new JLabel(Integer.toString(manager.getPlayer().getTeam().get(3).getDamage()));
			lblDamage_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblDamage_1_3 = new GridBagConstraints();
			gbc_lblDamage_1_3.insets = new Insets(0, 0, 5, 0);
			gbc_lblDamage_1_3.gridx = 4;
			gbc_lblDamage_1_3.gridy = 1;
			panelTeam.add(lblDamage_1_3, gbc_lblDamage_1_3);

			JLabel lblCritChance_1_3 = new JLabel(manager.toPercentage(manager.getPlayer().getTeam().get(3).getCriticalStrike()));
			lblCritChance_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_lblCritChance_1_3 = new GridBagConstraints();
			gbc_lblCritChance_1_3.insets = new Insets(0, 0, 5, 0);
			gbc_lblCritChance_1_3.gridx = 4;
			gbc_lblCritChance_1_3.gridy = 2;
			panelTeam.add(lblCritChance_1_3, gbc_lblCritChance_1_3);

			JCheckBox chckbxSelection_3 = new JCheckBox(manager.getPlayer().getTeam().get(3).getName());
			chckbxSelection_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
			chckbxSelection_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			GridBagConstraints gbc_chckbxSelection_3 = new GridBagConstraints();
			gbc_chckbxSelection_3.gridx = 4;
			gbc_chckbxSelection_3.gridy = 3;
			panelTeam.add(chckbxSelection_3, gbc_chckbxSelection_3);
			teamButtonList.add(chckbxSelection_3);
		} 	

		JButton btnSwap = new JButton("Swap");
		btnSwap.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addGap(323)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnSwap, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
		);
		panel.setLayout(gl_panel);
		window.getContentPane().setLayout(groupLayout);
	}
}
