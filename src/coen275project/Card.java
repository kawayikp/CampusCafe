package coen275project;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Card implements Serializable {
    private String cardNumber;
    private String password;
    private float totalBalance = 5000.0F; 
    private static final long serialVersionUID = 1L;
    
    public Card(String cardNumber, String password) {
    	this.cardNumber = cardNumber;
    	this.password = password;
    }
    
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	synchronized public static void deductMoney(String cardNumber, float expense){   //
		Card thisCard = Serialization.deSerialize("database/card_"+ cardNumber +".ser");
		System.out.println("card: " + cardNumber);
		System.out.print("( before deduct is " + thisCard.totalBalance);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thisCard.totalBalance -= expense;    // this is not atomic step
		System.out.println(", after deduct is " + thisCard.totalBalance + ")");
		
	    Serialization.serialize(thisCard,"database/card_"+ cardNumber +".ser");	
	}
	
	public static float getTotalBalance(String cardNumber) {
		Card temCard = Serialization.deSerialize("database/card_"+ cardNumber +".ser");
		return temCard.totalBalance;
	}
	
	public void setTotalBalance() {}
	
	@Override
	public String toString() {
		String s = "cardNumber: " + cardNumber + "\n";
		s += "password: " + password + "\n";
		s += "totalBalance: " + totalBalance + "\n";
		return s;
	}
}
