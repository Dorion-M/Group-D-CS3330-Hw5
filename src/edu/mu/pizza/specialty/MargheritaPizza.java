package edu.mu.pizza.specialty;
import java.util.List;

import edu.mu.pizza.AbstractPizza;
import edu.mu.pizza.Toppings;

public class MargheritaPizza extends AbstractPizza {
    public MargheritaPizza() {
        super();
        addDefaultToppings(List.of(Toppings.TOMATO, Toppings.CHEESE));
        priceWithoutToppings = 2.50;
        totalPrice = updatePizzaPrice();
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
}
