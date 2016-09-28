package guiBuild;

import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import coen275project.*;

public class Navigation {
	private JFrame frame;
    private User theUser;
    
	/*** Launch the application.*/
	public static void main(String[] args) {
		final String cardNumber = args[0];       // get the cardNumber
		final String extension = args[1];       // get the extension
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Navigation window = new Navigation(cardNumber, extension);    // pass the accountNumber
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*** Create the application.*/
	public Navigation(String cardNumber, String extension) {
		theUser = Serialization.deSerialize("database/user_" + cardNumber + "_" + extension + ".ser");   //Lifen: get the user
		//CheckUpdateProfile.loginUpdateExpenseProfile(theUser);    //Lifen: copy Yue's code
		//CheckUpdateProfile.loginUpdateDietaryProfile(theUser);   //Lifen: copy Yue's code
		initialize();
	}
	
	/*** Initialize the contents of the frame.*/
	private void initialize() {
		frame = new JFrame("Navigation");
		WindowExitHandler windowExitHandler = new WindowExitHandler();
		frame.addWindowListener(windowExitHandler);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	frame.setBounds(100, 100, 1250, 700);   	
    	frame.setLocationRelativeTo(null);          // center the mainFrame on screen
    	
    	
    	JTabbedPane tabbedPane = new JTabbedPane();      //**JTabbedPane
    	tabbedPane.addTab("Buy/Order food", new OrderPanel());
    	tabbedPane.addTab("Enter Preference", new PreferencePanel());
    	tabbedPane.addTab("Dietary Profile", new DietaryPanel());
    	tabbedPane.addTab("Expense Profile", new ExpensePanel());
    	tabbedPane.addTab("Family Expense Profile", new TotalExpensePanel());
    	
    	frame.getContentPane().add(tabbedPane);
    	//frame.pack();
    	frame.setVisible(true);
	}	
	
	//Lifen: below are 5 different panels
	private class TotalExpensePanel extends JPanel{
		public TotalExpensePanel(){
			TotalExpenseProfile tep = new TotalExpenseProfile(theUser);
			this.add(tep);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
	}
	
	private class OrderPanel extends JPanel {     // include SelectStore GUI
		public OrderPanel(){
			SelectStore storeList = new SelectStore(theUser);
//			Map map = new Map();
//			this.add(storeList);
//			this.add(map);
			this.add(storeList);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		}
	}
	
	private class PreferencePanel extends JPanel {
		public PreferencePanel(){
			EditProfile editprofile = new EditProfile(theUser);
			this.add(editprofile);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		
		}
	}

	private class DietaryPanel extends JPanel {
		public DietaryPanel(){
			GUIDietaryProfile e = new GUIDietaryProfile(theUser);
			this.add(e);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);	 		
		}
	}

	private class ExpensePanel extends JPanel {
		public ExpensePanel(){
			GUIExpenseProfile e = new GUIExpenseProfile(theUser);
			this.add(e);
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);		
		}
	}
	
	public class WindowExitHandler implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) {
			serialization(theUser);
			//System.out.println("Closing!");
		}
		
		private boolean serialization(User user) {
			String cardNumber = user.getCardNumber();
			String extension = user.getExtensionNumber()+"";
			Serialization.serialize(user, "database/user_" + cardNumber + "_" + extension + ".ser" );
			return true;
		}

		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}
		
	}

}

