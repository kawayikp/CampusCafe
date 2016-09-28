package initialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import coen275project.*;

public class Initialization {
	public static void main(String[] args) {

		/**************************************
		 * create user_1000_0   used for testing buy item
		 **********************************************************/

		// card
		Card card_1000 = new Card("1000", "0000");
		// expense profile

		List<ExpenseRecord> expenseList_1000_0 = new ArrayList<>();
		ExpenseRecord er = new ExpenseRecord("2016-06-01", 20, "user_1000_0", "Drink Vending Machine");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-01", 80, "user_1000_0", "Snack Vending Machine");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-01", 30, "user_1000_0", "Drink Vending Machine");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-01", 40, "user_1000_0", "Tago Restaurant");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-02", 20, "user_1000_0", "Drink Vending Machine");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-02", 10, "user_1000_0", "Snack Vending Machine");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-03", 20, "user_1000_0", "Drink Vending Machine");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-03", 10, "user_1000_0", "Mission Cafe");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-03", 20, "user_1000_0", "Drink Vending Machine");
		expenseList_1000_0.add(er);
		er = new ExpenseRecord("2016-06-04", 20, "user_1000_0", "Snack Vending Machine");
		expenseList_1000_0.add(er);
		ExpenseProfile expenseProfile_1000_0 = new ExpenseProfile("1000", "user_1000_0", 1000, 800, 250, "2016-06",
				expenseList_1000_0);
		// dietary profile

		List<DietaryRecord> dietaryList_1000_0 = new ArrayList<>();
		DietaryRecord dr = new DietaryRecord("2016-06-01", 50, "user_1000_0", "Mission Cafe");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-01", 160, "user_1000_0", "Snack Vending Machine");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-01", 80, "user_1000_0", "Snack Vending Machine");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-01", 40, "user_1000_0", "Drink Vending Machine");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-02", 20, "user_1000_0", "Drink Vending Machine");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-02", 20, "user_1000_0", "Drink Vending Machine");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-03", 30, "user_1000_0", "Mission Cafe");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-03", 80, "user_1000_0", "Mission Cafe");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 200, "user_1000_0", "Tago Restaurant");
		dietaryList_1000_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 10, "user_1000_0", "Tago Restaurant");
		dietaryList_1000_0.add(dr);
		DietaryProfile dietaryProfile_1000_0 = new DietaryProfile("1000", "user_1000_0", 2000, 1600, 0, "2016-06",
				"2016-06-04", dietaryList_1000_0, true, false, false);
		// user
		User user_1000_0 = new User("user_1000_0", "1000");
		user_1000_0.setExtensionNumber(0);
		user_1000_0.setExpenseProfile(expenseProfile_1000_0);
		user_1000_0.setDietaryProfile(dietaryProfile_1000_0);



		/**************************************
		 * create user_1001_0      used fot testing exceed limitation
		 **********************************************************/

		// card
		Card card_1001 = new Card("1001", "0000");
		// expense profile
		List<ExpenseRecord> expenseList_1001_0 = new ArrayList<>();
		er = new ExpenseRecord("2016-06-01", 10, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-01", 20, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-01", 30, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-01", 20, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-01", 50, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-01", 10, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 10, "user_1001_0", "Tago Restaurant");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 10, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 20, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 10, "user_1001_0", "Tago Restaurant");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 10, "user_1001_0", "Tago Restaurant");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 10, "user_1001_0", "Snack Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 200, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 10, "user_1001_0", "Snack Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 30, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-02", 100, "user_1001_0", "Snack Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-03", 20, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-03", 20, "user_1001_0", "Snack Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-04", 20, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-04", 200, "user_1001_0", "Snack Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-04", 100, "user_1001_0", "Drink Vending Machine");
		expenseList_1001_0.add(er);
		er = new ExpenseRecord("2016-06-04", 80, "user_1001_0", "Tago Restaurant");
		expenseList_1001_0.add(er);
		ExpenseProfile expenseProfile_1001_0 = new ExpenseProfile("1001", "user_1001_0", 1000, 1200, 980, "2016-06",
				expenseList_1001_0);
		
		// dietary profile
		List<DietaryRecord> dietaryList_1001_0 = new ArrayList<>();
		dr = new DietaryRecord("2016-06-01", 20, "user_1001_0", "Drink Vending Machine");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-01", 200, "user_1001_0", "Tago Restaurant");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-02", 20, "user_1001_0", "Mission Cafe");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-02", 150, "user_1001_0", "Tago Restaurant");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-03", 20, "user_1001_0", "Drink Vending Machine");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-03", 30, "user_1001_0", "Snack Vending Machine");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 30, "user_1001_0", "Tago Restaurant");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 100, "user_1001_0", "Snack Vending Machine");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 20, "user_1001_0", "Mission Cafe");
		dietaryList_1001_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 10, "user_1001_0", "Snack Vending Machine");
		dietaryList_1001_0.add(dr);
		DietaryProfile dietaryProfile_1001_0 = new DietaryProfile("1001", "user_1001_0", 2000, 2200, 0, "2016-06",
				"2016-06-04", dietaryList_1001_0, true, false, true);
		// user
		User user_1001_0 = new User("user_1001_0", "1001");
		user_1001_0.setExtensionNumber(0);
		user_1001_0.setExpenseProfile(expenseProfile_1001_0);
		user_1001_0.setDietaryProfile(dietaryProfile_1001_0);

		
		/**************************************
		 * create user_1002_0
		 **********************************************************/

		// card
		Card card_1002 = new Card("1002", "0000");
		// expense profile
		List<ExpenseRecord> expenseList_1002_0 = new ArrayList<>();
		er = new ExpenseRecord("2016-06-01", 20, "user_1002_0", "Drink Vending Machine");
		expenseList_1002_0.add(er);
		er = new ExpenseRecord("2016-06-01", 10, "user_1002_0", "Snack Vending Machine");
		expenseList_1002_0.add(er);
		er = new ExpenseRecord("2016-06-02", 30, "user_1002_0", "Mission Cafe");
		expenseList_1002_0.add(er);
		er = new ExpenseRecord("2016-06-02", 40, "user_1002_0", "Snack Vending Machine");
		expenseList_1002_0.add(er);
		er = new ExpenseRecord("2016-06-03", 20, "user_1002_0", "Mission Cafe");
		expenseList_1002_0.add(er);
		er = new ExpenseRecord("2016-06-04", 20, "user_1002_0", "Snack Vending Machine");
		expenseList_1002_0.add(er);
		ExpenseProfile expenseProfile_1002_0 = new ExpenseProfile("1002", "user_1002_0", 1000, 800, 140, "2016-06",
				expenseList_1002_0);
		
		// dietary profile
		List<DietaryRecord> dietaryList_1002_0 = new ArrayList<>();
		dr = new DietaryRecord("2016-06-01", 60, "user_1002_0", "Mission Cafe");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-02", 20, "user_1002_0", "Snack Vending Machine");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-02", 80, "user_1002_0", "Drink Vending Machine");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-02", 20, "user_1002_0", "Snack Vending Machine");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-03", 200, "user_1002_0", "Mission Cafe");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-03", 20, "user_1002_0", "Drink Vending Machine");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-03", 30, "user_1002_0", "Snack Vending Machine");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 30, "user_1002_0", "Mission Cafe");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 20, "user_1002_0", "Drink Vending Machine");
		dietaryList_1002_0.add(dr);
		dr = new DietaryRecord("2016-06-04", 10, "user_1002_0", "Mission Cafe");
		dietaryList_1002_0.add(dr);
		DietaryProfile dietaryProfile_1002_0 = new DietaryProfile("1002", "user_1002_0", 2000, 1600, 0, "2016-06",
				"2016-06-04", dietaryList_1002_0, true, false, true);
		// user
		User user_1002_0 = new User("user_1002_0", "1002");
		user_1002_0.setExtensionNumber(0);
		user_1002_0.setExpenseProfile(expenseProfile_1002_0);
		user_1002_0.setDietaryProfile(dietaryProfile_1002_0);

		
		
		/**************************************
		 * create user_1002_1
		 **********************************************************/

		// card
		
		// expense profile
		List<ExpenseRecord> expenseList_1002_1 = new ArrayList<>();
		er = new ExpenseRecord("2016-06-01", 20, "user_1002_1", "Drink Vending Machine");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-06-01", 100, "user_1002_1", "Snack Vending Machine");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-06-02", 80, "user_1002_1", "Drink Vending Machine");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-06-02", 40, "user_1002_1", "Snack Vending Machine");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-06-02", 20, "user_1002_1", "Drink Vending Machine");
		expenseList_1002_1.add(er);
		er = new ExpenseRecord("2016-06-03", 20, "user_1002_1", "Snack Vending Machine");
		expenseList_1002_1.add(er);
		ExpenseProfile expenseProfile_1002_1 = new ExpenseProfile("1002", "user_1002_1", 1000, 800, 340, "2016-06",
				expenseList_1002_1);
		// dietary profile
		List<DietaryRecord> dietaryList_1002_1 = new ArrayList<>();
		dr = new DietaryRecord("2016-06-01", 80, "user_1002_1", "Drink Vending Machine");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-01", 20, "user_1002_1", "Snack Vending Machine");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-02", 20, "user_1002_1", "Mission Cafe");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-02", 200, "user_1002_1", "Drink Vending Machine");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-03", 20, "user_1002_1", "Mission Cafe");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-04", 20, "user_1002_1", "Snack Vending Machine");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-04", 100, "user_1002_1", "Drink Vending Machine");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-04", 30, "user_1002_1", "Mission Cafe");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-04", 20, "user_1002_1", "Snack Vending Machine");
		dietaryList_1002_1.add(dr);
		dr = new DietaryRecord("2016-06-04", 10, "user_1002_1", "Mission Cafe");
		dietaryList_1002_1.add(dr);
		DietaryProfile dietaryProfile_1002_1 = new DietaryProfile("1002", "user_1002_1", 2000, 1600, 0, "2016-06",
				"2016-06-04", dietaryList_1002_1, true, false, true);
		// user
		User user_1002_1 = new User("user_1002_1", "1002");
		user_1002_1.setExtensionNumber(1);
		user_1002_1.setExpenseProfile(expenseProfile_1002_1);
		user_1002_1.setDietaryProfile(dietaryProfile_1002_1);

		
		
		/***************************
		 * check users
		 **********************************************************/
		
		// succeed
//		System.out.println(user_1000_0);
//		System.out.println(user_1001_0);
//		System.out.println(user_1002_0);
//		System.out.println(user_1002_1);
//		
		
		
		/***************************
		 * serialization
		 **********************************************************/
		
//		// individual card
		Serialization.serialize(card_1000, "database/card_1000.ser");
		Serialization.serialize(card_1001, "database/card_1001.ser");
		Serialization.serialize(card_1002, "database/card_1002.ser");
		
		// user
		Serialization.serialize(user_1000_0, "database/user_1000_0.ser");
		Serialization.serialize(user_1001_0, "database/user_1001_0.ser");
		Serialization.serialize(user_1002_0, "database/user_1002_0.ser");
		Serialization.serialize(user_1002_1, "database/user_1002_1.ser");
		System.out.println("finish.");
		
		
		/***************************
		 * deserialization
		 **********************************************************/
		
		card_1000 = null;
		card_1001 = null;
		card_1002 = null;
		user_1000_0 = null;
		user_1001_0 = null;
		user_1002_0 = null;
		user_1002_1 = null;
		card_1000 = Serialization.deSerialize("database/card_1000.ser");
		card_1001 = Serialization.deSerialize("database/card_1001.ser");
		card_1002 = Serialization.deSerialize("database/card_1002.ser");
		user_1000_0 = Serialization.deSerialize("database/user_1000_0.ser");
		user_1001_0 = Serialization.deSerialize("database/user_1001_0.ser");
		user_1002_0 = Serialization.deSerialize("database/user_1002_0.ser");
		user_1002_1 = Serialization.deSerialize("database/user_1002_1.ser");
//		
//		// succeed
//		System.out.println("card_1000" + "\n" + card_1000 + "\n");
//		System.out.println("card_1001" + "\n" + card_1001 + "\n");
//		System.out.println("card_1002" + "\n" + card_1002 + "\n");
//		System.out.println("user_1000_0" + "\n" + user_1000_0 + "\n");
//		System.out.println("user_1001_0" + "\n" + user_1001_0 + "\n");
		System.out.println("user_1002_0" + "\n" + user_1002_0 + "\n");
//		System.out.println("user_1002_1" + "\n" + user_1002_1 + "\n");
		
		
	}

}
