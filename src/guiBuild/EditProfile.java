package guiBuild;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import coen275project.CheckUpdateProfile;
import coen275project.DietaryProfile;
import coen275project.ExpenseProfile;
import coen275project.Serialization;
import coen275project.User;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class EditProfile extends JPanel {
	User user = null;
	ExpenseProfile myExpenseProfile = null;
	DietaryProfile myDietaryProfile = null;

	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private JTextField textfield_fund;
	private JTextField textfield_calorie;
	private JButton button_save;
	private JCheckBox checkbox_lowsugar;
	private JCheckBox checkbox_lowsodium;
	private JCheckBox checkbox_Lowcholesterol;
	private JLabel label_result;
	
	public static void main(String[] args) {
		String filename = "database/user_1000_0.ser";
		User user = Serialization.deSerialize(filename);
		EditProfile editProfile = new EditProfile(user);

		JFrame frame = new JFrame();
		frame.getContentPane().add(editProfile);
		frame.pack();
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public EditProfile(User user) {
		initializeData(user);
		initializeGUI();
	}

	private void initializeData(User user) {
		this.user = user;
		myExpenseProfile = user.getExpenseProfile();
		myDietaryProfile = user.getDietaryProfile();
		
	}


	public void initializeGUI() {
		this.setSize(600, 400);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(5, 5));

		/********************************************** NORTH **********************************************/

		panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		panel_1.setPreferredSize(new Dimension(600, 50));
		add(panel_1, BorderLayout.NORTH);
		
		JLabel label_cardnumber = new JLabel("Card Number: " + myExpenseProfile.getCardNumber());
		JLabel label_username = new JLabel("User Name : " + myExpenseProfile.getUserName());
		
		panel_1.add(label_cardnumber);
		panel_1.add(label_username);
		
		/********************************************** CENTER **********************************************/
		
		panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		panel_2.setPreferredSize(new Dimension(600, 250));
		add(panel_2, BorderLayout.CENTER);
		
		// expense
		JPanel panel_expenseprofile = new JPanel();
		panel_expenseprofile.setLayout(new BoxLayout(panel_expenseprofile, BoxLayout.Y_AXIS));
		panel_expenseprofile.setPreferredSize(new Dimension(300, 200));
		panel_expenseprofile.setBorder(BorderFactory.createTitledBorder(null, "Expense profile", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_2.add(panel_expenseprofile);
		
		// expense: row 1
		JPanel panel_expenseprofile_fund = new JPanel();
		panel_expenseprofile_fund.setLayout(new BoxLayout(panel_expenseprofile_fund, BoxLayout.X_AXIS));
		panel_expenseprofile_fund.setPreferredSize(new Dimension(300, 20));
		panel_expenseprofile.add(panel_expenseprofile_fund);
	
		JLabel lblFundLimitation = new JLabel("Fund limitation of next month");
		lblFundLimitation.setPreferredSize(new Dimension(200,20));
		textfield_fund = new JTextField(myExpenseProfile.getNextFund() +"");
		textfield_fund.setPreferredSize(new Dimension(100,20));
		panel_expenseprofile_fund.add(lblFundLimitation);
		panel_expenseprofile_fund.add(textfield_fund);
		
		// expense: region
		panel_expenseprofile.add(Box.createRigidArea(new Dimension(0, 230)));


		// dietary
		JPanel panel_dietaryprofile = new JPanel();
		panel_dietaryprofile.setLayout(new BoxLayout(panel_dietaryprofile, BoxLayout.Y_AXIS));
		panel_dietaryprofile.setPreferredSize(new Dimension(300, 300));
		panel_dietaryprofile.setBorder(BorderFactory.createTitledBorder(null, "Dietary profile", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		panel_2.add(panel_dietaryprofile);

		
		// dietary: row 1
		JPanel panel_dietaryprofile_calorie = new JPanel();
		panel_dietaryprofile_calorie.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_dietaryprofile_calorie.setLayout(new BoxLayout(panel_dietaryprofile_calorie, BoxLayout.X_AXIS));
		panel_dietaryprofile_calorie.setPreferredSize(new Dimension(300, 20));
		panel_dietaryprofile.add(panel_dietaryprofile_calorie);
		
		JLabel lblCalorieLimitation = new JLabel("Calorie limitation of one day");
		lblCalorieLimitation.setPreferredSize(new Dimension(200, 20));
		textfield_calorie = new JTextField(myDietaryProfile.getCurrentCalorie()+"");
		textfield_calorie.setPreferredSize(new Dimension(100, 20));
		panel_dietaryprofile_calorie.add(lblCalorieLimitation);
		panel_dietaryprofile_calorie.add(textfield_calorie);
		
		
		// dietary: row 2
		JPanel panel_dietaryprofile_checkbox1 = new JPanel();
		panel_dietaryprofile_checkbox1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_dietaryprofile_checkbox1.setLayout(new BoxLayout(panel_dietaryprofile_checkbox1, BoxLayout.X_AXIS));
		panel_dietaryprofile_checkbox1.setPreferredSize(new Dimension(300, 20));
		panel_dietaryprofile.add(panel_dietaryprofile_checkbox1);
		
		
		checkbox_lowsugar = new JCheckBox("Low Sugar");
		checkbox_lowsugar.setSelected(myDietaryProfile.getLowSugar());
		checkbox_lowsugar.setPreferredSize(new Dimension(300, 20));
		panel_dietaryprofile_checkbox1.add(checkbox_lowsugar);
		
		// dietary: row 3
		JPanel panel_dietaryprofile_checkbox2 = new JPanel();
		panel_dietaryprofile_checkbox2.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_dietaryprofile_checkbox2.setLayout(new BoxLayout(panel_dietaryprofile_checkbox2, BoxLayout.X_AXIS));
		panel_dietaryprofile_checkbox2.setPreferredSize(new Dimension(300, 20));
		panel_dietaryprofile.add(panel_dietaryprofile_checkbox2);
		
		checkbox_lowsodium = new JCheckBox("Low Sodium");
		checkbox_lowsodium.setAlignmentX(Component.LEFT_ALIGNMENT);
		checkbox_lowsodium.setSelected(myDietaryProfile.getLowSodium());
		checkbox_lowsodium.setPreferredSize(new Dimension(300, 20));
		panel_dietaryprofile_checkbox2.add(checkbox_lowsodium);
	
		// dietary: row 4
		JPanel panel_dietaryprofile_checkbox3 = new JPanel();
		panel_dietaryprofile_checkbox3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_dietaryprofile_checkbox3.setLayout(new BoxLayout(panel_dietaryprofile_checkbox3, BoxLayout.X_AXIS));
		panel_dietaryprofile_checkbox3.setPreferredSize(new Dimension(300, 20));
		panel_dietaryprofile.add(panel_dietaryprofile_checkbox3);
		
		checkbox_Lowcholesterol = new JCheckBox("Low Cholesterol");
		checkbox_Lowcholesterol.setSelected(myDietaryProfile.getLowCholesterol());
		checkbox_Lowcholesterol.setPreferredSize(new Dimension(300, 20));
		panel_dietaryprofile_checkbox3.add(checkbox_Lowcholesterol);
		
		// region
		panel_dietaryprofile.add(Box.createRigidArea(new Dimension(0, 170)));



		/********************************************** SOUTH **********************************************/
		
		panel_3 = new JPanel();
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.setPreferredSize(new Dimension(600, 100));
		add(panel_3, BorderLayout.SOUTH);

		// show result
		JPanel panel_3_result = new JPanel();
		panel_3_result.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_3_result.setPreferredSize(new Dimension(600, 50));
		panel_3.add(panel_3_result);
		
		label_result= new JLabel("Result");
		label_result.setHorizontalAlignment(SwingConstants.CENTER);
		label_result.setPreferredSize(new Dimension(600, 50));
		panel_3_result.add(label_result);
		
		
		// button
		JPanel panel_3_button = new JPanel();
		panel_3_button.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_3_button.setPreferredSize(new Dimension(600, 50));
		panel_3.add(panel_3_button);

		button_save = new JButton("DONE");
		button_save.setPreferredSize(new Dimension(600, 30));
		button_save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				float fund;
				int calorie;
				try {
					fund = Float.parseFloat(textfield_fund.getText());
					calorie = (int)Integer.parseInt(textfield_calorie.getText());
				} catch(NumberFormatException e1) {
					label_result.setText("please input number");
					label_result.setForeground(Color.RED);
					return;
				}
				
				boolean low_sugar = checkbox_lowsugar.isSelected();
				boolean low_sodium  = checkbox_lowsodium.isSelected();
				boolean low_cholesterol = checkbox_Lowcholesterol.isSelected();
				
				CheckUpdateProfile.updateExpenseProfile(user, fund);
				CheckUpdateProfile.updateDietaryProfile(user, calorie, low_sugar, low_sodium, low_cholesterol);
				
				label_result.setText("update correctly");
				label_result.setForeground(Color.GREEN);
			}
			
		});
		panel_3_button.add(button_save);
		
	}


}
