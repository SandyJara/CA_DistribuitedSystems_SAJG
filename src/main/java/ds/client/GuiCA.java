package ds.client;

import java.awt.EventQueue;

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
import ds.service1.ControlRequest;
import ds.service1.ControlResponse;
import io.grpc.stub.StreamObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;


public class GuiCA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_Temperature;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_turnON;
	
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
		setBounds(100, 100, 644, 564);
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
		lblNewLabel_1.setBounds(33, 186, 98, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SERVICE 3");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(33, 367, 98, 13);
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
		
		textField = new JTextField();
		textField.setBounds(297, 204, 299, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_Temperature = new JTextField();
		textField_Temperature.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField_Temperature.setColumns(10);
		textField_Temperature.setBounds(316, 23, 304, 49);
		contentPane.add(textField_Temperature);
		
		JLabel lblNewLabel_3 = new JLabel("Temperature Control");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(43, 37, 184, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1_1 = new JButton("START");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1_1.setBounds(197, 214, 85, 21);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ligth Control");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(43, 111, 184, 13);
		contentPane.add(lblNewLabel_3_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 167, 591, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3_2 = new JLabel("Temperature Control");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(43, 217, 184, 13);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Ligth Control");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(43, 291, 184, 13);
		contentPane.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton_1_2 = new JButton("START");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_2.setBackground(new Color(168, 51, 159));
		btnNewButton_1_2.setBounds(197, 288, 85, 21);
		contentPane.add(btnNewButton_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(292, 275, 304, 49);
		contentPane.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 348, 591, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Temperature Control");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_1.setBounds(43, 403, 184, 13);
		contentPane.add(lblNewLabel_3_2_1);
		
		JButton btnNewButton_1_1_1 = new JButton("START");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1_1_1.setBounds(197, 400, 85, 21);
		contentPane.add(btnNewButton_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(297, 390, 299, 43);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(292, 461, 304, 49);
		contentPane.add(textField_4);
		
		JButton btnNewButton_1_2_1 = new JButton("START");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_2_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1_2_1.setBounds(197, 474, 85, 21);
		contentPane.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Ligth Control");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(43, 477, 184, 13);
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
		textField_turnON.setBounds(316, 102, 304, 35);
		contentPane.add(textField_turnON);
	}
}
