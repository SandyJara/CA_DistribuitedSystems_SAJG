package ds.client;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.lang.System.Logger;
import java.awt.Color;
import ds.service1.client1;//creating this and the next 3 lines to read my client1 class from the other package
import ds.service2.client2;
import ds.service1.ControlRequest;
import ds.service1.ControlResponse;
import io.grpc.stub.StreamObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.UIManager;


public class GuiCA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField textField_Temperature;
	private JTextField textField_name;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_turnON;
//	private JTextField passwordField;
	private JTextField textField_password;
	private JTextField textField_status;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
    private static client2 client2; // Declare static / instantiate when is needed
    private static client1 client1; // same as above
    private JPasswordField passwordField; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCA frame = new GuiCA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiCA() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERVICE 1");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 10, 139, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SERVICE 2");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(33, 179, 98, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SERVICE 3");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(33, 453, 98, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton ButtonTemperature = new JButton("START");
		ButtonTemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		             //   textField_Temperature.setText("Hola");    I used this just to test at the beginning
				new Thread(() -> {
                    
						try {
							  String response = client1.startTemperatureControl();
		                        textField_Temperature.setText("Action from server received: " + response);						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace(); //eclipse helped my to correct using try/catch 
						}                                       
                }).start();
				
			}
		});
		ButtonTemperature.setBackground(new Color(168, 51, 159));
		ButtonTemperature.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonTemperature.setBounds(197, 35, 85, 21);
		contentPane.add(ButtonTemperature);
		
		JButton TurnOn = new JButton("TURN ON");
		TurnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call the static method to control lights and get the result
                String result = client1.controlLights(true); // Turn on the lights, i had before in client public static void instead of public static string, and that why i got the error before

                // Update the JTextField with the result
                textField_turnON.setText(result); // Display result in the text field
            }
		});
		
		TurnOn.setBackground(new Color(168, 51, 159));
		TurnOn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TurnOn.setBounds(197, 95, 85, 21);
		contentPane.add(TurnOn);
		
		nameField = new JTextField();
		nameField.setBackground(new Color(235, 252, 177));
		nameField.setBounds(298, 209, 130, 21);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		textField_Temperature = new JTextField();
		textField_Temperature.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField_Temperature.setColumns(10);
		textField_Temperature.setBounds(316, 23, 333, 49);
		contentPane.add(textField_Temperature);
		
		JLabel lblNewLabel_3 = new JLabel("Temperature Control");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(43, 37, 184, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String status = null;
				try {
					status = client2.logIn(name, password);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                textField_status.setText(status);		
			}    
			});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogIn.setBackground(new Color(168, 51, 159));
		btnLogIn.setBounds(438, 214, 85, 21);
		contentPane.add(btnLogIn);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ligth Control");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(43, 111, 184, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 160));
		separator.setForeground(new Color(160, 160, 160));
		separator.setBounds(10, 167, 639, 2);
		contentPane.add(separator);
		
		JLabel LogIn = new JLabel("Log In");
		LogIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LogIn.setBounds(43, 217, 184, 13);
		contentPane.add(LogIn);
		
		JLabel updateProfile = new JLabel("Update profile");
		updateProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateProfile.setBounds(43, 313, 184, 13);
		contentPane.add(updateProfile);
		
		JButton btnNewButton_UpdateProfile = new JButton("UPDATE");
		btnNewButton_UpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_UpdateProfile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_UpdateProfile.setBackground(new Color(168, 51, 159));
		btnNewButton_UpdateProfile.setBounds(438, 396, 85, 21);
		contentPane.add(btnNewButton_UpdateProfile);
		
		textField_name = new JTextField();
		textField_name.setBackground(new Color(235, 252, 177));
		textField_name.setColumns(10);
		textField_name.setBounds(277, 298, 89, 21);
		contentPane.add(textField_name);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Temperature Control");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_1.setBounds(43, 489, 184, 13);
		contentPane.add(lblNewLabel_3_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("START");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1_1_1.setBounds(197, 486, 85, 21);
		contentPane.add(btnNewButton_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(297, 476, 299, 43);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(292, 547, 304, 49);
		contentPane.add(textField_4);
		
		JButton btnNewButton_1_2_1 = new JButton("START");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_2_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1_2_1.setBounds(197, 560, 85, 21);
		contentPane.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Ligth Control");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(43, 563, 184, 13);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JButton turnOff = new JButton("TURN OFF");
		turnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Call the static method to control lights and get the result
                String result = client1.controlLights(false); // Turn on the lights, i had before in client public static void instead of public static string, and that why i got the error before

                // Update the JTextField with the result
                textField_turnON.setText(result); // Display result in the text field
				
			}
		});
		turnOff.setFont(new Font("Tahoma", Font.PLAIN, 12));
		turnOff.setBackground(new Color(168, 51, 159));
		turnOff.setBounds(197, 123, 89, 21);
		contentPane.add(turnOff);
		
		textField_turnON = new JTextField();
		textField_turnON.setColumns(10);
		textField_turnON.setBounds(316, 102, 333, 35);
		contentPane.add(textField_turnON);
		
		JLabel LogIn_1 = new JLabel("Name:");
		LogIn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LogIn_1.setBounds(197, 211, 50, 13);
		contentPane.add(LogIn_1);
		
		JLabel LogIn_1_1 = new JLabel("Password:");
		LogIn_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LogIn_1_1.setBounds(197, 240, 85, 13);
		contentPane.add(LogIn_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(235, 252, 177));
		passwordField.setColumns(10);
		passwordField.setBounds(298, 238, 130, 21);
		contentPane.add(passwordField);
		
		JRadioButton rdbtn_name = new JRadioButton("name");
		rdbtn_name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_name.setBounds(192, 297, 79, 21);
		contentPane.add(rdbtn_name);
		
		JRadioButton rdbtnPassword = new JRadioButton("password");
		rdbtnPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnPassword.setBounds(192, 332, 79, 21);
		contentPane.add(rdbtnPassword);
		
		JRadioButton rdbtn_status = new JRadioButton("status");
		rdbtn_status.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_status.setBounds(192, 365, 79, 21);
		contentPane.add(rdbtn_status);
		
		JRadioButton rdbtn_address = new JRadioButton("address");
		rdbtn_address.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_address.setBounds(372, 297, 79, 21);
		contentPane.add(rdbtn_address);
		
		JRadioButton rdbtn_phoneNumber = new JRadioButton("phone number");
		rdbtn_phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_phoneNumber.setBounds(372, 332, 107, 21);
		contentPane.add(rdbtn_phoneNumber);
		
		textField_password = new JTextField();
		textField_password.setBackground(new Color(235, 252, 177));
		textField_password.setColumns(10);
		textField_password.setBounds(277, 333, 89, 20);
		contentPane.add(textField_password);
		
		textField_status = new JTextField();
		textField_status.setBackground(new Color(255, 255, 255));
		textField_status.setColumns(10);
		textField_status.setBounds(533, 195, 116, 58);
		contentPane.add(textField_status);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(235, 252, 177));
		textField_1.setColumns(10);
		textField_1.setBounds(485, 298, 89, 21);
		contentPane.add(textField_1);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(235, 252, 177));
		textField_5.setColumns(10);
		textField_5.setBounds(485, 333, 89, 20);
		contentPane.add(textField_5);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(66, 269, 551, 3);
		contentPane.add(separator_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(UIManager.getColor("Button.shadow"));
		separator_1.setBackground(new Color(0, 0, 160));
		separator_1.setBounds(10, 440, 639, 3);
		contentPane.add(separator_1);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(235, 252, 177));
		textField_6.setColumns(10);
		textField_6.setBounds(277, 365, 89, 21);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(533, 373, 116, 44);
		contentPane.add(textField_7);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(55, 82, 551, 3);
		contentPane.add(separator_1_1_1);
	}
}
