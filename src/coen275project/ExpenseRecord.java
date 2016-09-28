package coen275project;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;



public class ExpenseRecord implements Serializable{

	private String date;
	private float expense;
	private String userName;				// record user name
	private String storeName;				// record store name

	
	public ExpenseRecord(float expense, String userName, String storeName) {
		this.expense = expense;
		this.userName = userName;
		this.storeName = storeName;
		SimpleDateFormat dt = new SimpleDateFormat("YYYY-MM-dd"); 
		date = dt.format(new Date());
		//date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	// for programe initialization
	public ExpenseRecord(String date, float expense, String userName, String storeName) {
		this.date = date;
		this.expense = expense;
		this.userName = userName;
		this.storeName = storeName;
	}
	
	
	
	public String getDate() {
		return date;
	}
	
	public float getExpense() {
		return expense;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getStoreName() {
		return storeName;
	}

	
	public void setExpense(float expense) {
		this.expense = expense;
	}
	
	public String toString() {
		return "\n" + "date=" + date + ", expense=" + expense +  " , location = " + storeName + ", userName=" + userName;
	}
	
}

