package edu.mu.pizza.cooking;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.PizzaType;
import edu.mu.pizza.specialty.*;


public class PizzaCookingFactory {
	
	public AbstractPizza createPizza(PizzaType pizzaType) {
        AbstractPizza pizza = null;
        switch (pizzaType) {
            case MARGHERITA:
                pizza = new MargheritaPizza();
                break;
            case VEGETARIAN:
                pizza = new VegetarianPizza();
                break;
            case HAWAIIAN:
            	pizza = new HawaiianPizza();
            	break;
            case SUPREME:
            	pizza = new SupremePizza();
        }
        return pizza;
    }

}
