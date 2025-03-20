package restaurant;

import java.util.ArrayList;

import main.Food;

public class Menu {
	private String name;
	private ArrayList<Food>foods=new ArrayList<Food>();
	
	public Menu(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public void add(Food food) {
		foods.add(food);
		
	}
	
	public ArrayList<Food> getFood() {
		return foods;
	}
	
	public Food getFoodName(String name) {
        for (Food food : foods) {
            if (food.getName().equalsIgnoreCase(name)) {
                return food;
            }
        }
        return null;
    }
	
	
}
