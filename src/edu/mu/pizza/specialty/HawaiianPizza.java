package edu.mu.pizza.specialty;
import java.util.ArrayList;
import java.util.List;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.Toppings;

public class HawaiianPizza extends AbstractPizza {
    public HawaiianPizza() {
        super();
        addDefaultToppings(List.of(Toppings.CANADIAN_BACON, Toppings.CHEESE, Toppings.PINEAPPLE));
        priceWithoutToppings = 3.00;
        totalPrice = updatePizzaPrice();
    }

	public HawaiianPizza(HawaiianPizza otherPizza) 
	{
		this.toppingList = new ArrayList<>(otherPizza.toppingList);
		this.priceWithoutToppings = otherPizza.priceWithoutToppings;
		this.totalPrice = otherPizza.totalPrice;
	}
    
    @Override
    protected double addToppingsToPrice(double priceWithoutToppings) {
        double totalToppingPrice = 0.0;
        for (Toppings topping : toppingList) {
            totalToppingPrice += topping.getPrice();
        }
        totalPrice = priceWithoutToppings + totalToppingPrice;
        return totalPrice;
    }

    @Override
    public double updatePizzaPrice() {
        return addToppingsToPrice(priceWithoutToppings);
    }

	
		@Override
		public String toString() {
			 return "Pizza Order ID: " + pizzaOrderID + "\n" +
		               "Topping List: " + toppingList + "\n" +
		               "Cooking Strategy: " + cookingStrategy + "\n" +
		               "Price without Toppings: $" + priceWithoutToppings + "\n" +
		               "Cooking Price: $" + cookingPrice +  "\n" +
		               "Total Price: $" + (totalPrice+cookingPrice) + "\n"; 
	        
		}

	
}

	