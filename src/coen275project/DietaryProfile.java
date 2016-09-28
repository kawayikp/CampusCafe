package coen275project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.io.Serializable;


public class DietaryProfile extends Observable implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private static final String TYPE = "Dietary Profile";
	
	private String cardNumber; 			// need a cardnumber to serialization
	private String userName;

	private int currentCalorie;			// expense limitation within a day
	private int nextCalorie;			// expense limitation within a day
	private int expense;				// total expense within a day
	private String period;				// year and month
	private String date;				// today
    private List<DietaryRecord> dietaryRecordList = new ArrayList<>();		//Calorie expense of this month

	private boolean lowSugar;
    private boolean lowSodium;
    private boolean lowCholesterol;
    
    public DietaryProfile() {
    	
    }
   
    // for program initialization
    public DietaryProfile(String cardNumber, String userName, int currentCalorie, int nextCalorie, int expense, String period,
			String date, List<DietaryRecord> dietaryRecordList, boolean lowSugar, boolean lowSodium, boolean lowCholesterol) {
		this.cardNumber = cardNumber;
		this.userName = userName;
		this.currentCalorie = currentCalorie;
		this.nextCalorie = nextCalorie;
		this.expense = expense;
		this.period = period;
		this.date = date;
		this.dietaryRecordList = dietaryRecordList;
		this.lowSugar = lowSugar;
		this.lowSodium = lowSodium;
		this.lowCholesterol = lowCholesterol;
	}

    // modify calorie of next month		
    public void setNextCalorie(int nextCalorie) {
    	this.nextCalorie = nextCalorie;
    }
    
	// user buy item
    // TODO everyday with one record 
    public void addDietaryRecord(DietaryRecord record) {
    	dietaryRecordList.add(record);
    	//System.out.println("MVC test step 1d");
    	setChanged();       //****
		notifyObservers();       //****
    }
    
    public void reset_newmonth() {
    	expense = 0;
    	dietaryRecordList = new ArrayList<DietaryRecord>();
    	date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    	period = new SimpleDateFormat("YYYY-MM").format(new Date());
    }
    
    public void reset_newday() {
    	expense = 0;
    	date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    }
    
    public String getPeriod() {
    	return period;
    }
    
    public void setExpense(int expense) {
    	this.expense = expense;
    }
    
    public void setPeriod(String period) {
    	this.period = period;
    }
    
    public void setDate(String date) {
    	this.date = date;
    }
    
    public void setList(List<DietaryRecord> dietaryRecordList) {
    	this.dietaryRecordList = dietaryRecordList;
    }
    
    public String getCardNumber() {
    	return cardNumber;
    }
	
    public int getCurrentCalorie() {
    	return currentCalorie;
    }
    
    public int getNextCalorie() {
    	return nextCalorie;
    }
    
    public int getExpense() {
    	return expense;
    }
    
    public String getDate() {
    	return date;
    }
    
    public List<DietaryRecord> getList() {
    	return dietaryRecordList;
    }
    
    public boolean getLowSugar() {
		return lowSugar;
	}

	public void setLowSugar(boolean lowSugar) {
		this.lowSugar = lowSugar;
	}

	public boolean getLowSodium() {
		return lowSodium;
	}

	public void setLowSodium(boolean lowSodium) {
		this.lowSodium = lowSodium;
	}

	public boolean getLowCholesterol() {
		return lowCholesterol;
	}

	public void setLowCholesterol(boolean lowCholesterol) {
		this.lowCholesterol = lowCholesterol;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setCurrentCalorie(int setCurrentCalorie) {
    	this.currentCalorie = setCurrentCalorie;
    }
    
	public void editProfile(int nextCalorie, boolean lowSugar, boolean lowSodium, boolean lowCholesterol) {
		this.nextCalorie = nextCalorie;
		this.lowSugar = lowSugar;
		this.lowSodium = lowSodium;
		this.lowCholesterol = lowCholesterol;
		setChanged();       //****
		notifyObservers();       //****
	}
	
    @Override
    public String toString() {
    	String s = "Profile type: " + TYPE + "\n";
    	s += "Card number: " + cardNumber + "\n";
    	s += "User Name: " + userName + "\n";
    	s += "Period: " + getPeriod() + "\n";
    	s += "Limitation: [" + "lowSugar=" + lowSugar + ", lowSodium=" + lowSodium  + ", lowCholesterol=" + lowCholesterol+ "]" + "\n";
    	s += "Limitation calorie everyday in this month: " + currentCalorie + "\n";
    	s += "Limitation calorie everyday from next month: " + nextCalorie + "\n";
    	s += "Today: " + date + "\n";
    	s += "Expense of this today: " + expense + "\n";
    	s += dietaryRecordList + "\n";
    	return s;
    }
    
}
