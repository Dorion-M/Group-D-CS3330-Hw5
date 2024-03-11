package edu.mu.pizza.order;

import edu.mu.pizza.cooking.BrickOvenCookingStrategy;
import edu.mu.pizza.cooking.ConventionalOvenCookingStrategy;
import edu.mu.pizza.cooking.CookingStyleType;
import edu.mu.pizza.cooking.ICookingStrategy;
import edu.mu.pizza.cooking.MicrowaveCookingStrategy;
import edu.mu.pizza.cooking.PizzaCookingFactory;

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
			else 
			{
				System.out.println(order + "'s order wasn't found.");
				return;
			}
		}
	}
	
	public void printPizzaOrderCart(int orderID) 
	{
		for(AbstractPizza order : pizzaOrderList) 
		{
			if(order.getPizzaOrderID() == orderID) 
			{
				System.out.println(orderID + "'s pizza: ");
				System.out.println("Pizza: " + order.getClass());
				for(Toppings topping : order.getToppingList()) 
				{
					System.out.println(topping);
				}
				return;
			}
			else 
			{
				System.out.println(order + "'s order wasn't found.");
				return;
			}
		}
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
				return false;
			}
		}
		return true;
	}
	
	public double checkout() throws Exception
	{
		if(isThereAnyUncoockedPizza()) 
		{
			throw new Exception("There is a cooked pizza.");
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
				
				return cookingStrategy.cook(pizza);
				
			}
			
		}
		
		return true;
	}
	
}
