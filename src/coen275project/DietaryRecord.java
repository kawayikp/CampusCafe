package coen275project;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DietaryRecord implements Serializable{
	private String date;
	private int expense;
	private String userName;
	private String foodName;
	private String storeName;

	public DietaryRecord(int expense, String userName, String storeName) {
		this.date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		this.expense = expense;
		this.userName = userName;
//		this.foodName = foodName;
		this.storeName = storeName;
	}
	
	// for program initialization
	public DietaryRecord(String date, int expense, String userName, String storeName) {
		this.date = date;
		this.expense = expense;
		this.userName = userName;
//		this.foodName = foodName;
		this.storeName = storeName;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	@Override
	public String toString() {
		return "\n" + "date=" + date + ", expense=" + expense + ", location=" + storeName + ", user=" + userName;
	}
}
