package coen275project;

import java.util.*;

public class FoodStoreList {
    HashMap<String, FoodStore> foodstoreList = new HashMap<String, FoodStore>();
    
    public void addFoodStore(String name, FoodStore fs) {
    	foodstoreList.put(name, fs);
    }
    
    public FoodStore getFoodStore(String name){
    	return foodstoreList.get(name);
    }
    
    
    
}
