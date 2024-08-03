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
import java.util.List;
import java.awt.Color;
import ds.service1.client1;//creating this and the next 3 lines to read my client1 class from the other package
import ds.service2.client2;
import ds.service3.client3;
import ds.service2.updateProfileRequest;
import ds.service2.updateProfileResponse;
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
	private JTextField textField_nameUpdate;
	private JTextField textField_Search;
	private JTextField textField_4;
	private JTextField textField_turnON;
//	private JTextField passwordField;
	private JTextField textField_passwordUpdate;
	private JTextField textField_LogInResponse;
	private JTextField textField_address;
	private JTextField textField_phone;
	private JTextField textField_statusProfileToUpdate;
	private JTextField textField_UpdateResponse;
    private static client2 client2; // Declare static / instantiate when is needed
    private static client1 client1; // same as above
    private static client3 client3; // same as above
    private JPasswordField passwordField; 
    private JList<String> genreList;
    private JButton Button_SearchBook;
    private JTextField textField_SearchResults;
    
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
		setBounds(100, 100, 684, 728);
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
		lblNewLabel_2.setBounds(33, 466, 98, 13);
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
		TurnOn.setBounds(197, 95, 109, 21);
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
                textField_LogInResponse.setText(status);		
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
				
				
				//Here was just for testing with data to print in the properly field, the method has been called after click the button but was printing nothing of the information introduce in the field camps
		        // String testResponse = "Name TESTING";
		       //  textField_UpdateResponse.setText("Update response: " + testResponse);
			
				System.out.println("Update button clicked."); // to test if recognising the action
					String name = textField_nameUpdate.getText();
	                String password = textField_passwordUpdate.getText();
	                String status = textField_statusProfileToUpdate.getText();
	                String address = textField_address.getText();
	                String phone = textField_phone.getText();

	             // Debug: Print field values
	                System.out.println("Name: " + name);
	                System.out.println("Password: " + password);
	                System.out.println("Status: " + status);
	                System.out.println("Address: " + address);
	                System.out.println("Phone: " + phone);
	                
	                
	                // Create UpdateProfileRequest(s)
	                updateProfileRequest.Builder builder = updateProfileRequest.newBuilder();
	                if (!name.isEmpty()) builder.setName(name);
	                if (!password.isEmpty()) builder.setPassword(password);
	                if (!status.isEmpty()) builder.setStatus(status);
	                if (!address.isEmpty()) builder.setAddress(address);
	                if (!phone.isEmpty()) builder.setPhoneNumber(phone);

	                updateProfileRequest request = builder.build();

	             // Create a list of requests
	                List<updateProfileRequest> requests = List.of(request);

	                // just showing that the info was sent to update
	                textField_UpdateResponse.setText("information sended to Update"); //until here is printing in my GUI, its working properly

	                // with this is possible to update the answer showed once the information was updates
	                new Thread(() -> {
	                    // showing my message response after the updating of the information
	                    String responseMessage = ds.service2.client2.updateProfile(requests, null); //my code has error, its updating the message but taking long time

	                    SwingUtilities.invokeLater(() -> {
	                        textField_UpdateResponse.setText(responseMessage);
	                    });

	                    System.out.println("Profile update request sent.");
	                }).start();
	            }
	        });
	                
	                       
		btnNewButton_UpdateProfile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_UpdateProfile.setBackground(new Color(168, 51, 159));
		btnNewButton_UpdateProfile.setBounds(438, 365, 85, 21);
		contentPane.add(btnNewButton_UpdateProfile);
		
		textField_nameUpdate = new JTextField();
		textField_nameUpdate.setBackground(new Color(235, 252, 177));
		textField_nameUpdate.setColumns(10);
		textField_nameUpdate.setBounds(277, 298, 89, 21);
		contentPane.add(textField_nameUpdate);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Search Book: ");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_1.setBounds(43, 489, 184, 13);
		contentPane.add(lblNewLabel_3_2_1);
	
			
		textField_Search = new JTextField();
		textField_Search.setColumns(10);
		textField_Search.setBounds(297, 476, 352, 71);
		contentPane.add(textField_Search);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(298, 603, 351, 49);
		contentPane.add(textField_4);
		
		JButton btnNewButton_1_2_1 = new JButton("RESERVE");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1_2_1.setBackground(new Color(168, 51, 159));
		btnNewButton_1_2_1.setBounds(197, 605, 85, 21);
		contentPane.add(btnNewButton_1_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Reserve Book");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(43, 608, 184, 13);
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
		turnOff.setBounds(197, 123, 109, 21);
		contentPane.add(turnOff);
		
		textField_turnON = new JTextField();
		textField_turnON.setColumns(10);
		textField_turnON.setBounds(316, 102, 333, 35);
		contentPane.add(textField_turnON);
		
		JLabel Name = new JLabel("Name:");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Name.setBounds(197, 211, 50, 13);
		contentPane.add(Name);
		
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
		
		JRadioButton rdbtn_password = new JRadioButton("password");
		rdbtn_password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_password.setBounds(192, 332, 79, 21);
		contentPane.add(rdbtn_password);
		
		JRadioButton rdbtn_statusProfileToUpdate = new JRadioButton("status");
		rdbtn_statusProfileToUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_statusProfileToUpdate.setBounds(192, 365, 79, 21);
		contentPane.add(rdbtn_statusProfileToUpdate);
		
		JRadioButton rdbtn_address = new JRadioButton("address");
		rdbtn_address.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_address.setBounds(372, 297, 79, 21);
		contentPane.add(rdbtn_address);
		
		JRadioButton rdbtn_phoneNumber = new JRadioButton("phone number");
		rdbtn_phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtn_phoneNumber.setBounds(372, 332, 107, 21);
		contentPane.add(rdbtn_phoneNumber);
		
		textField_passwordUpdate = new JTextField();
		textField_passwordUpdate.setBackground(new Color(235, 252, 177));
		textField_passwordUpdate.setColumns(10);
		textField_passwordUpdate.setBounds(277, 333, 89, 20);
		contentPane.add(textField_passwordUpdate);
		
		textField_LogInResponse = new JTextField();
		textField_LogInResponse.setBackground(new Color(255, 255, 255));
		textField_LogInResponse.setColumns(10);
		textField_LogInResponse.setBounds(533, 195, 116, 58);
		contentPane.add(textField_LogInResponse);
		
		textField_address = new JTextField();
		textField_address.setBackground(new Color(235, 252, 177));
		textField_address.setColumns(10);
		textField_address.setBounds(485, 298, 89, 21);
		contentPane.add(textField_address);
		
		textField_phone = new JTextField();
		textField_phone.setBackground(new Color(235, 252, 177));
		textField_phone.setColumns(10);
		textField_phone.setBounds(485, 333, 89, 20);
		contentPane.add(textField_phone);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(67, 285, 551, 3);
		contentPane.add(separator_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(UIManager.getColor("Button.shadow"));
		separator_1.setBackground(new Color(0, 0, 160));
		separator_1.setBounds(10, 451, 639, 3);
		contentPane.add(separator_1);
		
		textField_statusProfileToUpdate = new JTextField();
		textField_statusProfileToUpdate.setBackground(new Color(235, 252, 177));
		textField_statusProfileToUpdate.setColumns(10);
		textField_statusProfileToUpdate.setBounds(277, 365, 89, 21);
		contentPane.add(textField_statusProfileToUpdate);
		
		textField_UpdateResponse = new JTextField();
		textField_UpdateResponse.setColumns(10);
		textField_UpdateResponse.setBounds(438, 399, 222, 44);
		contentPane.add(textField_UpdateResponse);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(55, 82, 551, 3);
		contentPane.add(separator_1_1_1);
		
		Button_SearchBook = new JButton("SEARCH");
		Button_SearchBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Button_SearchBook.setBackground(new Color(168, 51, 159));
		Button_SearchBook.setBounds(197, 500, 85, 21);
		contentPane.add(Button_SearchBook);
		
		//JList list = new JList();    I used the next line to give options for the search of books
		String[] topic = {"Science", "Fiction", "Literature", "Thriller"};
		JList<String> list = new JList<>(topic);
		list.setBounds(91, 512, 81, 71);
		contentPane.add(list);
		setVisible(true);

		JButton Button_SearchBook = new JButton("SEARCH");
		Button_SearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                		
				 // Get selected genre
                String selectedGenre = genreList.getSelectedValue();
                if (selectedGenre != null) {
                    //performSearch(selectedGenre);
                	textField_Search.setText("testing");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a genre.");
                }
            }
        });
		
		
		
		
		
        setVisible(true);
		} 
}
