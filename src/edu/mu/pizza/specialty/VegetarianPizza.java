package edu.mu.pizza.specialty;
import java.util.List;

import edu.mu.pizza.*;
import edu.mu.pizza.cooking.ICookingStrategy;

public class VegetarianPizza extends AbstractPizza {
	
	public VegetarianPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
			ICookingStrategy cookingStrategy, double cookingPrice) {
		super(toppingList, priceWithoutToppings, totalPrice, pizzaOrderID, cookingStrategy, cookingPrice);
		// TODO Auto-generated constructor stub
	}
	
	public VegetarianPizza(VegetarianPizza copy) {
		super(copy);
	}
	
}