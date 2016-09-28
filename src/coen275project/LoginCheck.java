package coen275project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginCheck {
	/**
	 * check validation of cardnumber + extension and password when login
	 * return true or false
	 */
	public static boolean loginCheckCard(String cardNumber, String extension, String password) {
		String filePath = "database/cardCollection.txt";
		
        BufferedReader br = null;
        String line = null;
        
        try {          // read file line-by-line
            br = new BufferedReader(new FileReader(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }        
        
        do {          // parse each line to check the info validation
            try {
				line = br.readLine();
				if (line != null && !line.equals("")){
	            	String[] parts = line.split("\\s+");
	            	//System.out.println(parts[0] + " + " + parts[1] + " + " + parts[2]);
	            	if (parts[0].equals(cardNumber) && parts[1].equals(password) && parts[2].equals(extension)){
	            		return true;
	            	}
	            } 
			} catch (IOException e) {
				e.printStackTrace();
			}     
        } while (line != null);
        	
		return false;
	}
}
