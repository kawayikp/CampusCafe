package coen275project;

public class Food {
    private String foodName;
    private float foodPrice;
    private int foodCalorie;
    private boolean lowSugar;
    private boolean lowSodium;
    private boolean lowCholesterol;
    
    public Food(String n, float p, int c, boolean sugar, boolean sodium, boolean cholesterol){
		this.foodName = n;
		this.foodPrice = p;
		this.foodCalorie = c;
		this.lowSugar = sugar;
		this.lowSodium = sodium;
		this.lowCholesterol = cholesterol;
	}
	
	public String getName(){
		return foodName;
	}
	public float getPrice(){
		return foodPrice;
	}
	public int getCalories(){
		return foodCalorie;
	}
    public boolean getSugar(){
    	return lowSugar;
    }
    public boolean getSodium(){
    	return lowSodium;
    }
    public boolean getCholesterol(){
    	return lowCholesterol;
    }
    public String toString(){
    	return foodName;
    }
}
