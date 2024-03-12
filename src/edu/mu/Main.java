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
//       
//        AbstractPizza p1 = pizzaFactory.createPizza(PizzaType.SUPREME);
//        AbstractPizza p2 = pizzaFactory.createPizza(PizzaType.MARGHERITA);
//        AbstractPizza p3 = pizzaFactory.createPizza(PizzaType.VEGETARIAN);
//        AbstractPizza p4 = pizzaFactory.createPizza(PizzaType.HAWAIIAN);
//      
        
//        System.out.println(p1+"\n");
//        System.out.println(p2+"\n");
//        System.out.println(p3+"\n");
//        System.out.println(p4+"\n");
//        
        
        

            PizzaOrder order = new PizzaOrder();
            
            // Adding pizzas to the cart
            System.out.println("Adding pizzas to the cart:");
            order.addPizzaToCart(PizzaType.MARGHERITA);
            order.addPizzaToCart(PizzaType.VEGETARIAN);
            order.addPizzaToCart(PizzaType.HAWAIIAN);
            order.addPizzaToCart(PizzaType.SUPREME);
            
            //Testing printListofToppingsByPizzaOrderID method
            System.out.println("\nTesting printListofToppingsByPizzaOrderId:");
            order.printListOfToppingsByPizzaOrderID(1);
            
           //Testint printPizzaOrderCart method
            System.out.println("\nTesting printPizzaOrderCart:");
            order.printPizzaOrderCart(1);
            
            
            
//            
//            // Adding new toppings
//            System.out.println("\nAdding new toppings:");
              order.addNewToppingToPizza(1, Toppings.BLACK_OLIVE); 
              order.printListOfToppingsByPizzaOrderID(1);

//            order.addNewToppingToPizza(2, Toppings.PEPPERONI); 
//            // Removing a topping
//            System.out.println("\nRemoving a topping from Vegetarian Pizza:");
//            order.removeToppingFromPizza(2, Toppings.BELL_PEPPER);
//            
//            // Selecting cooking strategies for each pizza
//            System.out.println("\nSelecting cooking strategies:");
//            order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.BRICK_OVEN);
//            order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN);
//            order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.MICROWAVE);
//            order.selectCookingStrategyByPizzaOrderID(4, CookingStyleType.BRICK_OVEN);
//            
//            // Printing pizza orders and their toppings
//            System.out.println("\nPrinting pizza orders and toppings:");
//            order.printListOfToppingsByPizzaOrderID(1);
//            order.printListOfToppingsByPizzaOrderID(2);
//            order.printListOfToppingsByPizzaOrderID(3);
//            order.printListOfToppingsByPizzaOrderID(4);
//            
//            // Attempt to checkout
//            System.out.println("\nAttempting to checkout:");
//            double total = order.checkout();
//            System.out.printf("Total cost of the order: $%.2f\n", total);
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//            e.printStackTrace();
//        }
//		
//
//        
	}
}
       
