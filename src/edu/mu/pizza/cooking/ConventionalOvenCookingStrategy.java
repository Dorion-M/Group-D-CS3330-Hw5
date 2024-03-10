package edu.mu.pizza.cooking;

import edu.mu.pizza.AbstractPizza;

public class ConventionalOvenCookingStrategy implements ICookingStrategy{

	@Override
	public boolean cook(AbstractPizza pizza) {
		// TODO Auto-generated method stub
		pizza.setCookingPrice(8.0);
		pizza.setCookingStrategy(this);
		pizza.updatePizzaPrice();
		return true;
	}

}
