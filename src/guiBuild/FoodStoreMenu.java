package guiBuild;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import coen275project.Card;
import coen275project.CheckUpdateProfile;
import coen275project.Food;
import coen275project.FoodStore;
import coen275project.User;
import coen275project.VendingMachine;

public class FoodStoreMenu extends JPanel {
	FoodStore foodStore;
	JTable foodStoreMenuList;
	String[] colNames = {"Item", "Price", "Calories", "Sugar", "Sodium", "Cholesterol",  "Quantity"};
	String[][] rows = new String[5][7];
	User theUser;
	public FoodStoreMenu(User u, FoodStore fs){
		this.theUser = u;
		this.foodStore = fs;
		HashMap<String, Food> fsm = fs.getFoodList();
		Iterator<?> it = fsm.entrySet().iterator();
		int counter = 0;
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			rows[counter][0] = (String)pair.getKey();
			Food f = (Food)pair.getValue();
			rows[counter][1] = Float.toString( f.getPrice() );
			rows[counter][2] = Integer.toString( f.getCalories() );
			rows[counter][3] = (f.getSugar())? "Low":"High";
			rows[counter][4] = (f.getSodium())? "Low":"High";
			rows[counter][5] = (f.getCholesterol())? "Low":"High";
	
			counter++;
		}
		setLayout(new BorderLayout());
		foodStoreMenuList = new JTable(rows, colNames);
		JScrollPane scrollPane = new JScrollPane(foodStoreMenuList);
		add(scrollPane, BorderLayout.CENTER);
		JButton checkout = new JButton("Checkout");
		checkout.setBackground(Color.orange);
		checkout.setOpaque(true);
		checkoutHandler ch = new checkoutHandler();
		checkout.addActionListener(ch);
		add(checkout, BorderLayout.SOUTH);
		JLabel foodStoreName = new JLabel((String)fs.getName());
		foodStoreName.setFont(new Font("Serif", Font.PLAIN, 28));
		add(foodStoreName,BorderLayout.NORTH);
	}
	
	
	
	class checkoutHandler implements ActionListener{		
		public void actionPerformed(ActionEvent e){
			Thread aWorker = new Thread() {
				public void run(){ 
					checkout();
				}
			};// end of thread
			aWorker.start();
			
		}
		public void checkout(){
			int[] foodList  = foodStoreMenuList.getSelectedRows();
			float price = 0;
			int calories = 0;
			List<List<Boolean>> allNutrition = new ArrayList<>();
			
			for(int i = 0; i < foodList.length; i++) {
				//System.out.println(foodList[i]);
				List<Boolean> nutrition = new ArrayList<Boolean>();
				String foodName = (String)foodStoreMenuList.getValueAt(foodList[i],0);
				
				int quantity = Integer.parseInt( (String)foodStoreMenuList.getValueAt(foodList[i],6) );
				price += quantity * Float.parseFloat( (String)foodStoreMenuList.getValueAt(foodList[i],1) );
				calories += quantity * Integer.parseInt( (String)foodStoreMenuList.getValueAt(foodList[i],2) );
				
				nutrition.add( (foodStoreMenuList.getValueAt(foodList[i],3) == "Low" )? true:false );
				nutrition.add( (foodStoreMenuList.getValueAt(foodList[i],4) == "Low" )? true:false );
				nutrition.add( (foodStoreMenuList.getValueAt(foodList[i],5) == "Low" )? true:false );
				allNutrition.add(nutrition);
			}
			
			//System.out.println(price);
			//System.out.println(calories);
			//[food1, food2, ... calories, expense]
			List<Boolean> validation = CheckUpdateProfile.buyItem(theUser, foodStore, price, calories, allNutrition);
			String msg = "";
			Boolean succes = true;
			List<Integer> invalidItems = new ArrayList<Integer>();
			for(int i = 0; i < foodList.length + 2; i++){
				if(!validation.get(i)){
					succes = false;
					if(i == validation.size() - 2){
						msg += "Calories exceeds limitation\n";
					}else if(i == validation.size() - 1){
						msg += "Expense exceeds limitation\n";
					} else{
						invalidItems.add(i);
						msg += rows[foodList[i]][0] + " does not match your dietary preference\n";
					}
				}
						
			}
			if(succes){
				
				if(foodStore instanceof VendingMachine){
					JOptionPane.showMessageDialog(null, "Purchase completed\nItem dispensed","ok",JOptionPane.PLAIN_MESSAGE);
				} else {
					DateFormat df = new SimpleDateFormat("HH:mm");//dd/MM/yy HH:mm:ss
				    Date dateobj = new Date(System.currentTimeMillis()+15*60*1000);
					JOptionPane.showMessageDialog(null, "Purchase completed\nPlease pick up at " + df.format(dateobj),"ok",JOptionPane.PLAIN_MESSAGE);
				}
				  
			} else {
				JOptionPane.showMessageDialog(null, msg,"ok",JOptionPane.PLAIN_MESSAGE);
				
			}
		}
	}
	
	
	
}
