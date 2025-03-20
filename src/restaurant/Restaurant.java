package restaurant;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import main.Food;
import people.Chef;
import people.Visitor;

public class Restaurant {
	private String name;
	private ArrayList<Menu>menus=new ArrayList<Menu>();
	private ArrayList<Chef>chefs=new ArrayList<Chef>();
	private int totalIncome=0;
	
	public Restaurant(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
	
	
	public ArrayList<Menu> getMenus() {
		return menus;
	}


	public void addMenu(Menu menu) {
		menus.add(menu);
	}
	
	public void addChef(Chef chef) {
		chefs.add(chef);
	}


	public void order(Chef chef, Visitor visitor, String foodName, int quantity) {
        Food food = null;
        for (Menu menu : menus) {
            food = menu.getFoodName(foodName);
            if (food != null) break;
        }
        if (food != null) {
            int cost = food.getPrice() * quantity;
            visitor.addOrder(food, quantity, cost);
            chef.cookFood(food, quantity);
            totalIncome += cost;
        } else {
            System.out.println("Food not found: " + foodName);
        }
    }

    
	



	public void showChef() {
		System.out.println("Restaurant "+ name +"'s Chefs: ");
		for(Chef chef : chefs) {
			System.out.println(" - "+chef.getName());
		}
		
	}


	public void showMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("  Restaurant "+ name +"'s Menus: ");
		for(Menu menu : menus) {
			System.out.println(" ========== " + menu.getName()+ " ===========");
			for(Food fud : menu.getFood()) {
				System.out.println("   - " + fud.getName()+ "    " + formatIDR(fud.getPrice())+"");
			}
		}
		System.out.println("---------------------------------------------------");
		
	}
	
	@SuppressWarnings("deprecation")
	public static String formatIDR(int amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return formatter.format(amount);
    }
	
	public void showTotalIncome() {
		System.out.println("---------------------------------------------------");
        System.out.println("Total Restaurant Income: " + formatIDR(totalIncome));
        System.out.println("---------------------------------------------------");
        System.out.println("  _______ _                 _      ");
        System.out.println(" |__   __| |               | |   __ ");
        System.out.println("    | |  | |__   __ _ _ __ | |__/ / ");
        System.out.println("    | |  | '_ \\ / _` | '_ \\|  _  / ");
        System.out.println("    | |  | | | | (_| | | | | | | |  ");
        System.out.println("    |_|  |_| |_|\\__,_|_| |_|_| |_| ");
        System.out.println("                                     ");
        System.out.println("  __     __                   ");
        System.out.println("  \\ \\   / /                   ");
        System.out.println("   \\ \\_/ /__  _   _   ");
        System.out.println("    \\   / _ \\| | | |");
        System.out.println("     | | (_) | |_| |  ");
        System.out.println("     |_|\\___/ \\__,_|   ");
    }
	
}
