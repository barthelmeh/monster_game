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

public class setupScreen {
	public ButtonGroup difficultyButtonGroup = new ButtonGroup();
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Setup Screen");
		window.setBounds(100, 100, 1184, 806);
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
			}
		});
		btnStartGameButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(356, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(maxDaySlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(rdbtnEasy)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMedium)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnHard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)))
							.addGap(345))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addGap(409))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnStartGameButton, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnMedium, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(rdbtnHard, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
						.addComponent(rdbtnEasy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addComponent(maxDaySlider, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(203)
					.addComponent(btnStartGameButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		window.getContentPane().setLayout(groupLayout);
	}
}
