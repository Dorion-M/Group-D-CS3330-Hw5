package edu.mu.pizza.specialty;
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
