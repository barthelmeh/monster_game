import java.awt.EventQueue;
import javax.swing.JFrame;
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
import java.util.Collections;
import javax.swing.border.LineBorder;
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
	private ArrayList<JCheckBox> teamButtonList = new ArrayList<JCheckBox>();
	private ArrayList<Monster> playerTeam;
	private JLabel lblErrorLabel;

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
	public MoveTeamScreen(MainGame incomingManager) {
		screen = this;
		manager = incomingManager;
		playerTeam = manager.getPlayer().getTeam();
		initialize();
		window.setVisible(true);
	}
	public void closeWindow() {
		window.dispose();
	}
	public void finishedWindow() {
		manager.closeMoveTeamScreen(screen, true);
	}
	public void restartWindow() {
		manager.closeMoveTeamScreen(screen, false);
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
                	System.out.println("here");
                }
            }

        } else {
        	for (JCheckBox checkbox : checkboxes) {
                if (checkbox.isSelected() == false && checkbox.getText() == (String) null) {
                	checkbox.setEnabled(true);
                	System.out.println("asdf" +checkbox.getText());
                }
            }
        }
    }
	public ArrayList<JCheckBox> getTeamButtonList() {
		return teamButtonList;
	}
	public void swapMonsters() {
		int counter = 0;
		Integer first = (Integer) null;
		Integer second = (Integer) null;
		
		for (JCheckBox box : getTeamButtonList()) {
			if (counter == 0 && box.isSelected()) {
				first = getTeamButtonList().indexOf(box);
				counter++;
			} else if (counter == 1 && box.isSelected()) {
				second = getTeamButtonList().indexOf(box);
				counter++;
			}
		}
		if (first == (Integer) null) {
			lblErrorLabel.setText("Please select two more monsters");
		} else if (second == (Integer) null) {
			lblErrorLabel.setText("Please select one more monster");
		}else {
			Collections.swap(playerTeam, first, second);
			restartWindow();
		}
		
		
		
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
		
		lblErrorLabel = new JLabel("");
		lblErrorLabel.setForeground(Color.RED);
		lblErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblErrorLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
						.addComponent(panelTeam, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTeam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblErrorLabel, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
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
		
		JLabel lblHealth1 = new JLabel();
		try {
			lblHealth1.setText(Double.toString(playerTeam.get(0).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth1.setText("");
		}
		lblHealth1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth1 = new GridBagConstraints();
		gbc_lblHealth1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHealth1.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth1.gridx = 1;
		gbc_lblHealth1.gridy = 0;
		panelTeam.add(lblHealth1, gbc_lblHealth1);

		JLabel lblDamage1 = new JLabel();
		try {
			lblDamage1.setText(Double.toString(playerTeam.get(0).getDamage()));
		} catch (Exception e) {
			lblDamage1.setText("");
		}
		lblDamage1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamage1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage1 = new GridBagConstraints();
		gbc_lblDamage1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage1.gridx = 1;
		gbc_lblDamage1.gridy = 1;
		panelTeam.add(lblDamage1, gbc_lblDamage1);

		JLabel lblCritChance1 = new JLabel();
		try {
			lblCritChance1.setText(manager.toPercentage(playerTeam.get(0).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance1.setText("");
		}
		
		lblCritChance1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCritChance1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance1 = new GridBagConstraints();
		gbc_lblCritChance1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCritChance1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance1.gridx = 1;
		gbc_lblCritChance1.gridy = 2;
		panelTeam.add(lblCritChance1, gbc_lblCritChance1);

		JCheckBox chckbxSelection = new JCheckBox();
		try {
			
			chckbxSelection.setText(playerTeam.get(0).getName());
			chckbxSelection.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
		} catch (Exception e){
			chckbxSelection.setEnabled(false);
		}
		
		chckbxSelection.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection = new GridBagConstraints();
		gbc_chckbxSelection.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSelection.gridx = 1;
		gbc_chckbxSelection.gridy = 3;
		panelTeam.add(chckbxSelection, gbc_chckbxSelection);
		teamButtonList.add(chckbxSelection);
			
		JLabel lblHealth2 = new JLabel();
		try {
			lblHealth2.setText(Double.toString(playerTeam.get(1).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth2.setText("");
		}
		lblHealth2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth2 = new GridBagConstraints();
		gbc_lblHealth2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHealth2.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth2.gridx = 2;
		gbc_lblHealth2.gridy = 0;
		panelTeam.add(lblHealth2, gbc_lblHealth2);

		JLabel lblDamage2 = new JLabel();
		try {
			lblDamage2.setText(Double.toString(playerTeam.get(1).getDamage()));
		} catch (Exception e) {
			lblDamage2.setText("");
		}
		lblDamage2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamage2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage2 = new GridBagConstraints();
		gbc_lblDamage2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage2.gridx = 2;
		gbc_lblDamage2.gridy = 1;
		panelTeam.add(lblDamage2, gbc_lblDamage2);

		JLabel lblCritChance2 = new JLabel();
		try {
			lblCritChance2.setText(manager.toPercentage(playerTeam.get(1).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance2.setText("");
		}
		lblCritChance2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance2 = new GridBagConstraints();
		gbc_lblCritChance2.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance2.gridx = 2;
		gbc_lblCritChance2.gridy = 2;
		panelTeam.add(lblCritChance2, gbc_lblCritChance2);

		JCheckBox chckbxSelection_1 = new JCheckBox();
		try {
			chckbxSelection_1.setText(playerTeam.get(1).getName());
			chckbxSelection_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
		} catch (Exception e) {
			chckbxSelection_1.setEnabled(false);
		}
		
		chckbxSelection_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection_1 = new GridBagConstraints();
		gbc_chckbxSelection_1.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSelection_1.gridx = 2;
		gbc_chckbxSelection_1.gridy = 3;
		panelTeam.add(chckbxSelection_1, gbc_chckbxSelection_1);
		teamButtonList.add(chckbxSelection_1);
		
		JLabel lblHealth3 = new JLabel();
		try {
			lblHealth3.setText(Double.toString(playerTeam.get(2).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth3.setText("");
		}
		lblHealth3.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth3 = new GridBagConstraints();
		gbc_lblHealth3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHealth3.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth3.gridx = 3;
		gbc_lblHealth3.gridy = 0;
		panelTeam.add(lblHealth3, gbc_lblHealth3);

		JLabel lblDamage3 = new JLabel();
		try {
			lblDamage3.setText(Double.toString(playerTeam.get(2).getDamage()));
		} catch (Exception e) {
			lblDamage3.setText("");
		}
		lblDamage3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamage3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage3 = new GridBagConstraints();
		gbc_lblDamage3.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage3.gridx = 3;
		gbc_lblDamage3.gridy = 1;
		panelTeam.add(lblDamage3, gbc_lblDamage3);

		JLabel lblCritChance3 = new JLabel();
		try {
			lblCritChance3.setText(manager.toPercentage(playerTeam.get(2).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance3.setText("");
		}
		lblCritChance3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance3 = new GridBagConstraints();
		gbc_lblCritChance3.insets = new Insets(0, 0, 5, 5);
		gbc_lblCritChance3.gridx = 3;
		gbc_lblCritChance3.gridy = 2;
		panelTeam.add(lblCritChance3, gbc_lblCritChance3);

		JCheckBox chckbxSelection_2 = new JCheckBox();
		try {
			chckbxSelection_2.setText(manager.toPercentage(playerTeam.get(2).getCriticalStrike()));
			chckbxSelection_2.setEnabled(true);
			chckbxSelection_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
		} catch (Exception e) {
			chckbxSelection_2.setEnabled(false);
		}
		
		chckbxSelection_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection_2 = new GridBagConstraints();
		gbc_chckbxSelection_2.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxSelection_2.gridx = 3;
		gbc_chckbxSelection_2.gridy = 3;
		panelTeam.add(chckbxSelection_2, gbc_chckbxSelection_2);
		teamButtonList.add(chckbxSelection_2);
		
		JLabel lblHealth4 = new JLabel();
		try {
			lblHealth4.setText(Double.toString(playerTeam.get(3).getMonsterCurrentHealth()));
		} catch (Exception e) {
			lblHealth4.setText("");
		}
		lblHealth4.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHealth4 = new GridBagConstraints();
		gbc_lblHealth4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHealth4.insets = new Insets(0, 0, 5, 0);
		gbc_lblHealth4.gridx = 4;
		gbc_lblHealth4.gridy = 0;
		panelTeam.add(lblHealth4, gbc_lblHealth4);

		JLabel lblDamage4 = new JLabel();
		try {
			lblDamage4.setText(Double.toString(playerTeam.get(3).getDamage()));
		} catch (Exception e) {
			lblDamage4.setText("");
		}
		lblDamage4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDamage4 = new GridBagConstraints();
		gbc_lblDamage4.insets = new Insets(0, 0, 5, 0);
		gbc_lblDamage4.gridx = 4;
		gbc_lblDamage4.gridy = 1;
		panelTeam.add(lblDamage4, gbc_lblDamage4);

		JLabel lblCritChance4 = new JLabel();
		try {
			lblCritChance4.setText(manager.toPercentage(playerTeam.get(3).getCriticalStrike()));
		} catch (Exception e) {
			lblCritChance4.setText("");
		}
		lblCritChance4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCritChance4 = new GridBagConstraints();
		gbc_lblCritChance4.insets = new Insets(0, 0, 5, 0);
		gbc_lblCritChance4.gridx = 4;
		gbc_lblCritChance4.gridy = 2;
		panelTeam.add(lblCritChance4, gbc_lblCritChance4);

		JCheckBox chckbxSelection_3 = new JCheckBox();
		try {
			chckbxSelection_3.setText(playerTeam.get(3).getName());
			chckbxSelection_3.setEnabled(true);
			chckbxSelection_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					getMaxSelected(getTeamButtonList());
				}
			});
		} catch (Exception e) {
			chckbxSelection_3.setEnabled(false);
		}
		
		chckbxSelection_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_chckbxSelection_3 = new GridBagConstraints();
		gbc_chckbxSelection_3.gridx = 4;
		gbc_chckbxSelection_3.gridy = 3;
		panelTeam.add(chckbxSelection_3, gbc_chckbxSelection_3);
		teamButtonList.add(chckbxSelection_3);

		JButton btnSwap = new JButton("Swap");
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				swapMonsters();
			}
		});
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
