package edu.mu.pizza;

import java.util.ArrayList;
import java.util.List;

import edu.mu.pizza.cooking.ICookingStrategy;

public abstract class AbstractPizza {
	
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCounter;
	protected ICookingStrategy cookingStrategy;
	protected double cookingPrice;

	
	public AbstractPizza() {
		toppingList = new ArrayList<>();
        priceWithoutToppings = 0.0;
        totalPrice = 0.0;
        pizzaOrderID = 1+ orderIDCounter++;
	}
	


	public AbstractPizza(List<Toppings> toppingList, double priceWithoutToppings, double totalPrice, int pizzaOrderID,
			ICookingStrategy cookingStrategy, double cookingPrice) {
		super();
		this.toppingList = toppingList;
		this.priceWithoutToppings = priceWithoutToppings;
		this.totalPrice = totalPrice;
		this.pizzaOrderID = pizzaOrderID;
		this.cookingStrategy = cookingStrategy;
		this.cookingPrice = cookingPrice;
	}
	
	
	public AbstractPizza(AbstractPizza copy) {
		this.toppingList = copy.toppingList;
		this.priceWithoutToppings = copy.priceWithoutToppings;
		this.totalPrice = copy.totalPrice;
		this.pizzaOrderID = copy.pizzaOrderID;
		this.cookingStrategy = copy.cookingStrategy;
		this.cookingPrice = copy.cookingPrice;
		
	}



	public List<Toppings> getToppingList() {
		return toppingList;
	}



	public void setToppingList(List<Toppings> toppingList) {
		this.toppingList = toppingList;
	}



	public double getPriceWithoutToppings() {
		return priceWithoutToppings;
	}



	public void setPriceWithoutToppings(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
	}



	public double getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	public int getPizzaOrderID() {
		return pizzaOrderID;
	}



	public void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}



	public static int getOrderIDCounter() {
		return orderIDCounter;
	}



	public static void setOrderIDCounter(int orderIDCounter) {
		AbstractPizza.orderIDCounter = orderIDCounter;
	}



	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}



	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}



	public double getCookingPrice() {
		return cookingPrice;
	}

	
	
	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}

    public abstract double updatePizzaPrice();
    
    public void addDefaultToppings(List<Toppings> toppings) {
        // Adding default toppings
        for (Toppings topping : toppings) {
            toppingList.add(topping);
        }
    }
    
    protected abstract double addToppingsToPrice(double priceWithoutToppings);

	@Override
	public String toString() {
        return "Pizza Order ID: " + pizzaOrderID + "\n" +
               "Topping List: " + toppingList + "\n" +
               "Cooking Strategy: " + cookingStrategy + "\n" +
               "Price without Toppings: $" + priceWithoutToppings + "\n" +
               "Cooking Price: $" + cookingPrice +  "\n" +
               "Total Price: $" + (totalPrice) + "\n";   
	}
	
	 
	
	
	
	
	
	
	
	
}
