package people;

import java.util.ArrayList;

import main.Food;
import restaurant.Restaurant;

public class Visitor {
	private String name;
	private int totalPrice=0;
	private ArrayList<String>orders=new ArrayList<String>();

	public Visitor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addOrder(Food food, int quantity, int cost) {
        orders.add(quantity + "x " + food.getName() + " - " + Restaurant.formatIDR(cost));
        totalPrice += cost;
    }

    public void showTotalPrice() {
    	System.out.println("---------------------------------------------------");
        System.out.println(name + "'s order details:");
        for (String order : orders) {
            System.out.println("  - " + order);
        }
        System.out.println("Total spending: " + Restaurant.formatIDR(totalPrice));
       
    }
	
	
}
