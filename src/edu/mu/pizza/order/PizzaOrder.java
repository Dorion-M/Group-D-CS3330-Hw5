package edu.mu.pizza.order;

import edu.mu.pizza.cooking.BrickOvenCookingStrategy;
import edu.mu.pizza.cooking.ConventionalOvenCookingStrategy;
import edu.mu.pizza.cooking.CookingStyleType;
import edu.mu.pizza.cooking.ICookingStrategy;
import edu.mu.pizza.cooking.MicrowaveCookingStrategy;
import edu.mu.pizza.cooking.PizzaCookingFactory;
import edu.mu.pizza.specialty.HawaiianPizza;
import edu.mu.pizza.specialty.MargheritaPizza;
import edu.mu.pizza.specialty.VegetarianPizza;

import java.util.ArrayList;
import java.util.List;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.PizzaType;
import edu.mu.pizza.Toppings;

public class PizzaOrder 
{

	private PizzaCookingFactory pizzaFactory;
	private ICookingStrategy cookingStrategy;
	private List<AbstractPizza> pizzaOrderList;
	
	public PizzaOrder() 
	{
		this.pizzaFactory = new PizzaCookingFactory();
		this.pizzaOrderList = new ArrayList<>();
	}
	
	
	// Prints the pizza toppings included on the pizza which corresponds to the orderID.
	public void printListOfToppingsByPizzaOrderID(int orderID) 
	{

	    for (AbstractPizza pizza : pizzaOrderList) 
	    {
	        if (pizza.getPizzaOrderID() == orderID) 
	        {
	            
	            System.out.println("Toppings for Pizza Order ID " + orderID + ":");
	            for (Toppings topping : pizza.getToppingList()) 
	            {
	                System.out.println(topping);
	            }
	            return; 
	        }
	    }
	    System.out.println("No pizza found with Order ID: " + orderID);
	}
	
	
	
	// Prints the pizza in the cart which corresponds to the orderID.
	public void printPizzaOrderCart() {
	    if (pizzaOrderList.isEmpty()) {
	        System.out.println("Cart is empty.");
	    } else {
	        System.out.println("Details of all pizzas in the cart:");
	        for (AbstractPizza pizza : pizzaOrderList) {
	            System.out.println(pizza); // This will use the overridden toString() method of AbstractPizza
	            System.out.println(); // Add a blank line for readability
	        }
	    }
	}
	
	//Retrieves the pizza which corresponds to the orderID.
	public AbstractPizza getPizzaByOrderID(int orderID) 
	{
	    for (AbstractPizza order : pizzaOrderList) 
	    {
	        if (order.getPizzaOrderID() == orderID) 
	        {
	            return order;
	        }
	        else
	        {
	        	
	        }
	    }
	    System.out.println(orderID + "'s order wasn't found.");
	    return null;
	}
	
	//Adds the passed pizza to the cart list.
	public boolean addPizzaToCart(PizzaType pizzaType) 
	{
		AbstractPizza newPizza = pizzaFactory.createPizza(pizzaType);
		if(pizzaType == null) return false;
		pizzaOrderList.add(newPizza);
		System.out.println(pizzaType + " pizza added to cart with Order ID: " + newPizza.getPizzaOrderID());
		int size;
		size = pizzaOrderList.size();
		System.out.println("The size of the cart is now: " + size);
		return true;
	}
	
	//Takes the pizza corresponding to the orderID and adds the included topping to the toppings list 
	//of the pizza.
	public boolean addNewToppingToPizza(int orderID, Toppings topping) 
	{
	    for (AbstractPizza order : pizzaOrderList) 
	    {
	        if (order.getPizzaOrderID() == orderID) 
	        {
	            
	            if (order.getToppingList().contains(topping)) 
	            {
	                System.out.println("Topping: " + topping + " already exists on pizza with Order ID: " + orderID);
	                return false; 
	            } 
	            else 
	            {
	                
	                order.getToppingList().add(topping);
	                
	                order.updatePizzaPrice();
	                System.out.println("Added new topping " + topping + " to pizza with Order ID: " + orderID);
	                return true; 
	            }
	        }
	    }
	    System.out.println("The pizza with the OrderID " + orderID + " was not found.");
	    return false; 
	}
	
	
	//Removes the given topping from the pizza corresponding to the orderID.
	public boolean removeToppingFromPizza(int orderID, Toppings topping) 
	{
	    for (AbstractPizza order : pizzaOrderList) 
	    {
	        if (order.getPizzaOrderID() == orderID) 
	        {
	            if (order.getToppingList().contains(topping)) 
	            {
	                order.getToppingList().remove(topping);
	                order.updatePizzaPrice();
	                System.out.println("Removed topping: " + topping + " from pizza with Order ID: " + orderID);
	                return true;
	            } 
	            else 
	            {
	                System.out.println("The topping: " + topping + " was not found on pizza with Order ID: " + orderID);
	                return false; 
	            }
	        }
	    }
	    System.out.println("The pizza with Order ID " + orderID + " was not found.");
	    return false; 
	}
	
	//Checks if there are any uncooked pizzas in the cart.
	public boolean isThereAnyUncoockedPizza() 
	{
		for(AbstractPizza pizza : pizzaOrderList) 
		{
			if(pizza.getCookingStrategy() == null) 
			{
				return true;
			}
		}
		return false;
	}
	
	//Checks out the order and returns the total and throws an exception if one occurs.
	public double checkout() throws Exception {
	    if (isThereAnyUncoockedPizza()) {
	        throw new Exception("There is an uncooked pizza.");
	    }        

	    double total = 0.0;
	    for (AbstractPizza order : pizzaOrderList) {
	        total += order.getTotalPrice() + order.getCookingPrice();
	    }

	    return total;
	}
	
	//Chooses the given cooking strategy for the given pizza.
	public boolean selectCookingStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) 
	{
		for(AbstractPizza pizza : pizzaOrderList) 
		{
			if(pizza.getPizzaOrderID() == orderID) 
			{
				switch(cookingStrategyType) 
				{
					case BRICK_OVEN:
						cookingStrategy = new BrickOvenCookingStrategy();
						break;
						
					case CONVENTIONAL_OVEN:
						cookingStrategy = new ConventionalOvenCookingStrategy();
						break;
						
					case MICROWAVE:
						cookingStrategy = new MicrowaveCookingStrategy();
						break;
						
					default:
						return false;
							
				}
				if(cookingStrategy != null)
				{
					pizza.setCookingStrategy(cookingStrategy);
					cookingStrategy.cook(pizza);
					System.out.println("Cooking strategy " + cookingStrategyType + " applied to Pizza Order ID: " + orderID);
	                return true;
				}
				return true;
				
			}
			
		}
		
		return true;
	}
	
}
