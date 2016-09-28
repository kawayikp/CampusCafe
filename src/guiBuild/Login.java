package guiBuild;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ItemSelectable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import coen275project.*;

public class Login {
	public static User USER;
	private JFrame frame;
	private JTextField userAccountField;
	private JTextField userPasswordField;
	private JButton loginButton;
	private JLabel lblWelcomeTo;
	private JComboBox extensionComboBox;
	
	private String accountNumber;
	private String password;
	private String extension = "0";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Login window2 = new Login();
					window2.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*Thread bWorker = new Thread() {
			public void run(){       
				try{ 
					Login window = new Login();
					window.frame.setVisible(true);}          
				catch(Exception ex){} 
			}
		};*/
		
	}
	
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		addListeners();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(200, 202, 117, 29);
		frame.getContentPane().add(loginButton);

		
		lblWelcomeTo = new JLabel("Welcome to CampusSmartCafe");
		lblWelcomeTo.setBounds(129, 49, 218, 16);
		frame.getContentPane().add(lblWelcomeTo);
		
		JLabel lblUserAccount = new JLabel("Account No.:");
		lblUserAccount.setBounds(104, 104, 84, 16);
		frame.getContentPane().add(lblUserAccount);
		
		userAccountField = new JTextField();
		userAccountField.setBounds(188, 98, 134, 28);
		frame.getContentPane().add(userAccountField);
		userAccountField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(104, 147, 84, 16);
		frame.getContentPane().add(lblPassword);
		
		userPasswordField = new JTextField();
		userPasswordField.setBounds(188, 141, 134, 28);
		frame.getContentPane().add(userPasswordField);
		userPasswordField.setColumns(10);
		
		String [] extension = {"0", "1","2","3","4", "5", "6", "7", "8", "9"};
		extensionComboBox = new JComboBox(extension);
		extensionComboBox.setBounds(334, 100, 52, 27);
		extensionComboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(extensionComboBox);  	
	          
	}
	
	public void addListeners() {
		// add ActionListener to loginButton
		loginButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {   
	        	accountNumber = userAccountField.getText();
	        	password = userPasswordField.getText();  
	        		        	
	        	Boolean judge = false;
	        	if (!accountNumber.equals("") && !password.equals("")){
	        		judge = LoginCheck.loginCheckCard(accountNumber, extension, password);
	        	} 
	        	
	            if (judge) {
	            	lblWelcomeTo.setText("Succeed!");
	            	userAccountField.setText("");
	            	userPasswordField.setText("");
	            	
	            	Navigation.main(new String[]{accountNumber, extension});
	            } else {
	            	lblWelcomeTo.setText("Failed! Wrong account/password.");
	            }
	        }
		});
		
		// add stateChanged listener to extension comboBox
		ItemListener itemListener = new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED){	            		            	
					ItemSelectable is = itemEvent.getItemSelectable();
					Object selected[] = is.getSelectedObjects();
					if (selected.length != 0){
						extension = (String)selected[0];
					}
				}
			}
		};
		extensionComboBox.addItemListener(itemListener);	  
		
	}
}
