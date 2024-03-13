package edu.mu;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.PizzaType;
import edu.mu.pizza.Toppings;
import edu.mu.pizza.cooking.CookingStyleType;
import edu.mu.pizza.cooking.PizzaCookingFactory;
import edu.mu.pizza.order.PizzaOrder;

public class Main {

	public static void main(String[] args) {
		
       //Create a PizzaFactory and create pizzas.
		PizzaCookingFactory pizzaFactory = new PizzaCookingFactory();
	

      try {
            	
		  	PizzaOrder order = new PizzaOrder();
           
            // Adding pizzas to the cart
            System.out.println("Adding pizzas to the cart:");         
            order.addPizzaToCart(PizzaType.HAWAIIAN);
            order.addPizzaToCart(PizzaType.MARGHERITA);
            order.addPizzaToCart(PizzaType.HAWAIIAN);
            order.addPizzaToCart(PizzaType.VEGETARIAN); 
            order.addPizzaToCart(PizzaType.SUPREME);
            
            //Adds cooking strategies to the pizzas.
            System.out.println("\nAdding Cooking Strategies to Pizzas in Cart:");
            boolean cook = order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.MICROWAVE);
            System.out.println("Cooking strategy was set: "+ cook);
            order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.MICROWAVE);
            order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.MICROWAVE);
            order.selectCookingStrategyByPizzaOrderID(4, CookingStyleType.MICROWAVE);
            order.selectCookingStrategyByPizzaOrderID(5, CookingStyleType.MICROWAVE);
            
           //Adds selected toppings to the pizzas.
            System.out.println("\nAdding Toppings to Pizzas:");
            order.addNewToppingToPizza(1, Toppings.BLACK_OLIVE);
            order.addNewToppingToPizza(2, Toppings.CANADIAN_BACON); 
            order.addNewToppingToPizza(3, Toppings.BLACK_OLIVE); 
            order.addNewToppingToPizza(4, Toppings.BLACK_OLIVE); 
            order.addNewToppingToPizza(5, Toppings.BLACK_OLIVE); 
            
            //Removes selected toppings from the pizzas
            System.out.println("\nRemoving Toppings from Pizzas");
            order.removeToppingFromPizza(1, Toppings.CHEESE);
            order.removeToppingFromPizza(2, Toppings.CHEESE);
            order.removeToppingFromPizza(3, Toppings.CHEESE);
            order.removeToppingFromPizza(4, Toppings.CHEESE);
            order.removeToppingFromPizza(5, Toppings.CHEESE);
            
            //Tests the isThereAnyUncoockedPizza method.
            System.out.println("\nTesting the method isThereAnyUncoockedPizza");
            boolean uncoocked = order.isThereAnyUncoockedPizza();
            System.out.println("There is an uncoocked pizza in the order: " + uncoocked);
            
          //Tests the printListOfToppingsByPizzaOrderID method.
            System.out.println("\nTesting the method printListOfToppingsByPizzaOrderID");
            order.printListOfToppingsByPizzaOrderID(2);
            
          //Tests the printPizzaOrderCart method.
            System.out.println("\nTesting the method printPizzaOrderCart");
            order.printPizzaOrderCart(4);
            
            //Tests the getPizzaByOrderID method.
            System.out.println("\nTesting the method  getPizzaByOrderID");
            System.out.println(order.getPizzaByOrderID(2));
            
            
           // Checks out the cart and displays the price and an error if one has occured.
            System.out.println("\nChecking out the cart");
            System.out.println("\nAttempting to checkout:");
            double total = order.checkout();
            System.out.printf("Total cost of the order: $%.2f\n", total);
	} catch(Exception e) {
    	  System.out.println("An error occurred: " + e.getMessage());
          e.printStackTrace();
      }
            
      
	}
}


       
