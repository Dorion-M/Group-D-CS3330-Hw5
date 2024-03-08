package edu.mu;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.PizzaType;
import edu.mu.pizza.cooking.PizzaCookingFactory;

public class Main {

	public static void main(String[] args) {
		
        PizzaCookingFactory pizzaFactory = new PizzaCookingFactory();
        
        AbstractPizza p1 = pizzaFactory.createPizza(PizzaType.SUPREME);
        AbstractPizza p2 = pizzaFactory.createPizza(PizzaType.MARGHERITA);
        AbstractPizza p3 = pizzaFactory.createPizza(PizzaType.VEGETARIAN);
        AbstractPizza p4 = pizzaFactory.createPizza(PizzaType.HAWAIIAN);
        
        System.out.println(p1+"\n");
        System.out.println(p2+"\n");
        System.out.println(p3+"\n");
        System.out.println(p4+"\n");
        



	}

}
