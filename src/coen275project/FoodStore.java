package coen275project;

import java.util.*;

public class FoodStore {
    private String name;
    private int id;
    private String location;
    private HashMap<String, Food> foodList = new HashMap<String, Food>();
    //private ArrayList<Food> foodList = new ArrayList<Food>();
    
    public FoodStore(String name, int id, String location) {
    	this.name = name;
    	this.id = id;
    	this.location = location;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}
    
    public void addFoodToList(String foodName, Food food) {
    	foodList.put(foodName, food);
    }
    public HashMap<String, Food> getFoodList(){
    	return foodList;
    }
}
