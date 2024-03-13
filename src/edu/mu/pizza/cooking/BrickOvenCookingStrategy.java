package edu.mu.pizza.cooking;

import edu.mu.pizza.AbstractPizza;

public class BrickOvenCookingStrategy implements ICookingStrategy {

	//Cooks the pizza and updates the price of the pizza.
	@Override
	public boolean cook(AbstractPizza pizza) {
		// TODO Auto-generated method stub
		pizza.setCookingPrice(10.0);
		pizza.setCookingStrategy(this);
		pizza.updatePizzaPrice();
		return true;
	}

	@Override
	public String toString() {
		return "Brick Oven Strategy";
	}

	
}
