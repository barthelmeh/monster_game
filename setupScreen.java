import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class setupScreen {

	private JFrame frame;
	private JTextField userNameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setupScreen window = new setupScreen();
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
	public setupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 825, 710);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(28, 24, 95, 63);
		frame.getContentPane().add(lblNewLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		userNameTextField.setBounds(171, 24, 344, 63);
		frame.getContentPane().add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDifficulty.setBounds(28, 98, 125, 63);
		frame.getContentPane().add(lblDifficulty);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnEasy.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnEasy.setBounds(171, 98, 95, 63);
		frame.getContentPane().add(rdbtnEasy);
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMedium.setSelected(true);
		rdbtnMedium.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnMedium.setBounds(278, 98, 140, 63);
		frame.getContentPane().add(rdbtnMedium);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnHard.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdbtnHard.setBounds(420, 98, 95, 63);
		frame.getContentPane().add(rdbtnHard);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnEasy);
		group.add(rdbtnMedium);
		group.add(rdbtnHard);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDays.setBounds(28, 172, 95, 63);
		frame.getContentPane().add(lblDays);
		
		JSlider slider = new JSlider();
		slider.setValue(5);
		slider.setFont(new Font("Tahoma", Font.PLAIN, 30));
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setMajorTickSpacing(5);
		slider.setBounds(171, 172, 344, 63);
		frame.getContentPane().add(slider);
		
		JButton btnNewButton = new JButton("Start Adventure");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(548, 598, 253, 64);
		frame.getContentPane().add(btnNewButton);
	}
}
