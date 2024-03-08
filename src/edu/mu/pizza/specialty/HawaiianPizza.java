package edu.mu.pizza.specialty;
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

	