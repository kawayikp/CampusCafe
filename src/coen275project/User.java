package coen275project;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String cardNumber;
    private ExpenseProfile expenseProfile = new ExpenseProfile();
    private DietaryProfile dietaryProfile = new DietaryProfile();
    private static final long serialVersionUID = 2L;
    
    private int extensionNumber = 0;     // the initial extensionNumber is 0 for parents. It could be set to 1-9 for children
   
    // constructor
    public User(String name, String cardNumber) {
    	this.name = name;
    	this.cardNumber = cardNumber;
    }
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public ExpenseProfile getExpenseProfile() {
		return expenseProfile;
	}
	public void setExpenseProfile(ExpenseProfile expenseProfile) {
		this.expenseProfile = expenseProfile;
	}
	public DietaryProfile getDietaryProfile() {
		return dietaryProfile;
	}
	public void setDietaryProfile(DietaryProfile dietaryProfile) {
		this.dietaryProfile = dietaryProfile;
	}
	public void setExtensionNumber(int extensionNumber)  {
		this.extensionNumber = extensionNumber;
	}
	public int getExtensionNumber() {
		return extensionNumber;
	}
	
	@Override
    public String toString(){
    	String s = "User:" + "\n";
    	s += "user name: " + name + "\n";
    	s += "extension: " + extensionNumber + "\n";
    	s += cardNumber; 
    	s += expenseProfile;
    	s += dietaryProfile + "\n";
    	return s;
    }
    
}
