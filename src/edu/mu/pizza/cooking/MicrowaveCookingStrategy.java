package edu.mu.pizza.cooking;

import edu.mu.pizza.AbstractPizza;

public class MicrowaveCookingStrategy implements ICookingStrategy{

	//Cooks the pizza and updates the price of the pizza.
	@Override
	public boolean cook(AbstractPizza pizza) {
		// TODO Auto-generated method stub
		pizza.setCookingPrice(1.0);
		pizza.setCookingStrategy(this);
		pizza.updatePizzaPrice();
		return true;
	}

	@Override
	public String toString() {
		return "Microwave Cooking Strategy";
	}
	
	

}
