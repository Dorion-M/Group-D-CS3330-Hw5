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
	
	public void printListOfToppingsByPizzaOrderID(int orderID) 
	{
		for(AbstractPizza order : pizzaOrderList) 
		{
			if(order.getPizzaOrderID() == orderID) 
			{
				System.out.println(orderID + "'s toppings: ");
				for(Toppings topping : order.getToppingList()) 
				{
					System.out.println(topping);
				}
				return;
			}

			System.out.println(order + "'s order wasn't found.");
			return;

		}
	}
	
	public void printPizzaOrderCart(int orderID) 
	{
		 AbstractPizza pizzaToPrint = null;

		    // Find the pizza with the given order ID
		    for (AbstractPizza pizza : pizzaOrderList) {
		        if (pizza.getPizzaOrderID() == orderID) {
		            pizzaToPrint = pizza;
		            break;
		        }
		    }

		    // Check if the pizza was found
		    if (pizzaToPrint != null) {
		        System.out.println("Details for Pizza Order ID: " + orderID);
		        System.out.println(pizzaToPrint); // Assuming your toString() method in AbstractPizza class is well implemented.
		    } else {
		        System.out.println("No pizza found with Order ID: " + orderID);
		    }
		
		
		/*
		for(AbstractPizza order : pizzaOrderList) 
		{
			
			if(order.getPizzaOrderID() == orderID) 
			{
				System.out.println(orderID + "'s order: ");
				if (order instanceof MargheritaPizza) {
	                System.out.println("Pizza: Margherita Pizza");
	            } else if (order instanceof VegetarianPizza) {
	                System.out.println("Pizza: Pepperoni Pizza");
	            } else if (order instanceof HawaiianPizza) {
	                System.out.println("Pizza: Hawaiian Pizza");
	            } else {
	                System.out.println("Pizza: SupremePizza");
	            }
				for(Toppings topping : order.getToppingList()) 
				{
					System.out.println(topping);
				}
				return;
			}
			System.out.println(order + "'s order wasn't found.");
			return;
		}
		*/
	}
	
	public AbstractPizza getPizzaByOrderID(int orderID) 
	{
		for(AbstractPizza order: pizzaOrderList) 
		{
			if(order.getPizzaOrderID() == orderID) 
			{
				return order;
			}
			else 
			{
				System.out.println(order + "'s order wasn't found.");				
			}
		}
		return null;
	}
	
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
	
	public boolean addNewToppingToPizza(int orderID, Toppings topping) 
	{
		for(AbstractPizza order : pizzaOrderList) 
		{
			if(order.getPizzaOrderID() == orderID) 
			{
				List<Toppings> newtoppings = order.getToppingList();
				
				for(Toppings currTopping : newtoppings) 
				{
					if(currTopping == topping) 
					{
						System.out.println("Topping already on pizza, did not add.");
						return false;
					}
				}
				
				System.out.println("Added new topping: " + topping);
				newtoppings.add(topping);
				order.setToppingList(newtoppings);
				return true;
				
			}
			else 
			{
				System.out.println(order + "'s order wasn't found.");
				return false;
			}
		}
		//null statement
		return false;
	}
	
	public boolean removeToppingFromPizza(int orderID, Toppings topping) 
	{
		for(AbstractPizza order : pizzaOrderList) 
		{
			if(order.getPizzaOrderID() == orderID) 
			{
				List<Toppings> newtoppings = order.getToppingList();

				for(Toppings currTopping : newtoppings) 
				{
					if(currTopping == topping) 
					{
						System.out.println("Topping removed: " + topping);
						newtoppings.remove(topping);
						order.setToppingList(newtoppings);
						return true;	
					}
				}
				System.out.println(topping + " is not on the pizza currently");
				return false;
			}
			else 
			{
				System.out.println(order + "'s order wasn't found.");
				return false;
			}
		}
		//null statement
		return false;	
	}
	
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
	
	public double checkout() throws Exception
	{
		if(isThereAnyUncoockedPizza()) 
		{
			throw new Exception("There is an uncooked pizza.");
		}		
		
		double total = 0.0;
		for(AbstractPizza order: pizzaOrderList) 
		{
			total += order.getTotalPrice();
		}
		
		return total;
		
	}
	
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
