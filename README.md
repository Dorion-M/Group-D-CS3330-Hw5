# Group-D-CS3330-Hw5

# Pizza Store System

##Project Overview
This Java project is designed to automate the operations of a fictional pizza store named FakeSpeare. It utilizes Factory and Strategy design patterns, Enum classes with methods, and assigning values to Enums. The project simulates the process of ordering different types of pizzas, applying cooking strategies, and managing pizza orders with dynamic toppings and pricing.

##Project Structure
The project consists of the following files:

1. `Main.java`: The entry point of the program that handles instantiation and operations on pizza orders.
2. `AbstractPizza.java`, `MargheritaPizza.java`, `VegetarianPizza.java`, `HawaiianPizza.java`, `SupremePizza.java`: These files define the pizza classes and their properties, including an abstract class and its subclasses for different pizza types which are used in the system.
3. `ICookingStrategy.java`: This interface defines the cooking strategy with a method to cook pizzas.
4. `BrickOvenCookingStrategy.java`, `ConventionalOvenCookingStrategy.java`, `MicrowaveCookingStrategy.java`: Implementation of different cooking strategies.
5. `PizzaOrder.java`: Manages the pizza orders, including adding pizzas to the cart, selecting cooking strategies, and checking out.
6. `PizzaCookingFactory.java`: A factory class for creating pizza objects based on the specified type.
7. `PizzaType.java`, `Toppings.java`, `CookingStyleType.java`: Enum classes that define the types of pizzas, available toppings, and cooking styles.

## Pizza Classes
The project includes subclasses of the `AbstractPizza` class, each representing a specific type of pizza with default toppings and prices:

- `MargheritaPizza.java`: Includes the toppings of TOMATO and CHEESE.
- `VegetarianPizza.java`: Includes the toppings of TOMATO, CHEESE, BELL_PEPPER, BLACK_OLIVE, and MUSHROOM.
- `HawaiianPizza.java`: Includes the toppings of CANADIAN_BACON, CHEESE, and PINEAPPLE.
- `SupremePizza.java`: Includes the toppings of TOMATO, CHEESE, BELL_PEPPER, ITALIAN_SAUSAGE, PEPPERONI, BLACK_OLIVE, and MUSHROOM.

## Methods of the Project
The project allows users to perform various operations including:

- Creating pizzas of different types with default settings.
- Adding or removing toppings from a pizza.
- Selecting a cooking strategy for a pizza.
- Printing the pizza order cart and the list of toppings by pizza order ID.
- Checking out, which calculates the total price of all pizzas in the cart.

## How to Run the Project
To run the project:

1. Clone the GitHub repository containing the project files.
2. Open the project in your preferred IDE.
3. Make sure you have JDK installed on your machine.
4. Compile and run the `Main.java` file to start the pizza ordering process.

## Dependencies
The project requires the following dependencies:

- Java Development Kit (JDK) to compile and run the program.

## Contributors
- Seth Keenan 
- Paul Maschhoff 
- Dorion Massengill 

