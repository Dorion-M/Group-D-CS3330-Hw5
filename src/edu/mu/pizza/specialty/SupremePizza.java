package edu.mu.pizza.specialty;
import java.util.ArrayList;
import java.util.List;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.Toppings;

public class SupremePizza extends AbstractPizza {

	public SupremePizza() {
        super();
        addDefaultToppings(List.of(Toppings.TOMATO, Toppings.CHEESE, Toppings.BELL_PEPPER, Toppings.ITALIAN_SAUSAGE, Toppings.PEPPERONI, Toppings.BLACK_OLIVE, Toppings.MUSHROOM));
        priceWithoutToppings = 3.50;
        totalPrice = updatePizzaPrice();
    }

	public SupremePizza(SupremePizza otherPizza) 
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
    	return "SupremePizza [toppingList=" + toppingList + ", priceWithoutToppings=" + priceWithoutToppings
    			+ ", totalPrice=" + totalPrice + ", pizzaOrderID=" + pizzaOrderID + ", cookingStrategy="
    			+ cookingStrategy + ", cookingPrice=" + cookingPrice + ", updatePizzaPrice()=" + updatePizzaPrice()
    			+ ", getToppingList()=" + getToppingList() + ", getPriceWithoutToppings()=" + getPriceWithoutToppings()
    			+ ", getTotalPrice()=" + getTotalPrice() + ", getPizzaOrderID()=" + getPizzaOrderID()
    			+ ", getCookingStrategy()=" + getCookingStrategy() + ", getCookingPrice()=" + getCookingPrice()
    			+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
    			+ "]";
    }
}
