package people;

import java.util.ArrayList;

import main.Food;

public class Chef {
	private String name;
	private ArrayList<String>history= new ArrayList<String>();

	public Chef(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void cookFood(Food food, int quantity) {
        history.add("Cooked " + quantity + " of " + food.getName());
    }
	
	public void showCookHistory() {
		System.out.println("---------------------------------------------------");
	     System.out.println("Cook history of Chef " + name + ":");
	     for (String his : history) {
	    	 System.out.println(" - " + his);
	     }
	}
	
	
	
	
}
