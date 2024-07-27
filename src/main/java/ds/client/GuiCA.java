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


public class GuiCA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_Temperature;
	private JTextField textField_2;
	
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
		setBounds(100, 100, 692, 348);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERVICE 1");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 14, 139, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SERVICE 2");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(33, 103, 98, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SERVICE 3");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(33, 194, 98, 13);
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
		
		JButton btnNewButton_1 = new JButton("START");
		btnNewButton_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(243, 131, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(350, 209, 247, 77);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_Temperature = new JTextField();
		textField_Temperature.setFont(new Font("Tahoma", Font.PLAIN, 9));
		textField_Temperature.setColumns(10);
		textField_Temperature.setBounds(292, 23, 386, 49);
		contentPane.add(textField_Temperature);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(347, 103, 250, 77);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Temperature Control");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(43, 37, 184, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1_1 = new JButton("START");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1_1.setBounds(243, 236, 85, 21);
		contentPane.add(btnNewButton_1_1);
	}
}
