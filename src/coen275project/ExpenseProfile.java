package coen275project;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;


public class ExpenseProfile extends Observable implements Serializable{    //****
	private static final long serialVersionUID = 2L;
	
	private static final String TYPE = "Expense Profile";
	
	private String cardNumber; 		// need a cardnumber to serialization
	private String userName;
	private float currentFund;		// expense limitation this month
	private float nextFund;			// expense limitation next month
	private float expense;			// total expense in the period
	private String period;			// year and month

	private List<ExpenseRecord> expenseRecordList = new ArrayList<>();	//expenseList of this month

    public ExpenseProfile() {
    	this.cardNumber = "0";
    	this.currentFund = 0;
    	this.nextFund = 0;
    	this.expense = 0;
    	period = null;
    	expenseRecordList = null;
    }
    
    // for program initialization
    public ExpenseProfile(String cardNumber, String userName, float currentFund, float nextFund, float expense, String period, List<ExpenseRecord> expenseRecordList ) {
    	this.cardNumber = cardNumber;
    	this.userName = userName;
    	this.currentFund = currentFund;
    	this.nextFund = nextFund;
    	this.expense = expense;
    	this.period = period;
    	this.expenseRecordList = expenseRecordList;
    }
    
    // when second period begin
    public void reset () {
    	currentFund = nextFund;
    	nextFund = 0;
    	expense = 0;
    	period = new SimpleDateFormat("YYYY-MM").format(new Date());
    	expenseRecordList = new ArrayList<>();
    }
    
    // modify fund of next month
    public void setNextFund(float fund) {
    	this.nextFund = fund;	
    	setChanged();       //****
		notifyObservers();       //****
    }
    
	// user buy item
    public void addExpenseRecord(ExpenseRecord er) {
    	expenseRecordList.add(er);
    	//System.out.println("MVC test step 1");
    	setChanged();       //****
		notifyObservers();       //****
    }
    
    public String getCardNumber() {
    	return cardNumber;
    }
    
    public float getCurrentFund() {
    	return currentFund;
    }
    
    public float getExpense() {
    	return expense;
    }
    
    public float getNextFund() {
    	return nextFund;
    }
    
    public List<ExpenseRecord> getList() {
    	return expenseRecordList;
    }
    
    
    public String getUserName() {
		return userName;
	}
    
    public void setCurrentFund(float fund) {
    	this.currentFund = fund;
    }
    

    
    public void setExpense(float expense) {
    	this.expense = expense;
    }
    
    
    public void setList(List<ExpenseRecord> list) {
    	this.expenseRecordList = list;
    }
    

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
    public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
    
    @Override
    public String toString() {
    	String s = "Profile type: " + TYPE + "\n";
    	s += "Card number: " + cardNumber + "\n";
    	s += "Period: " + getPeriod() + "\n";
    	
    	s += "Limitation of this month: " + currentFund + "\n";
    	s += "Limitation of next month: " + nextFund + "\n";
    	s += "Expense of this month: " + expense + "\n";
    	s += expenseRecordList+ "\n";
    	return s;
    }
}
