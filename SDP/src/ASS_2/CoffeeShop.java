package ASS_2;

import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {

        System.out.println("Available coffees:");
        System.out.println("1. Espresso");
        System.out.println("2. Latte");
        System.out.println("Available supplements:");
        System.out.println("3. Milk");
        System.out.println("4. Sugar");


        Scanner scanner = new Scanner(System.in);
        Coffee coffee = null;


        while (coffee == null) {
            System.out.print("Select the type of coffee (1/2): ");
            int coffeeChoice = scanner.nextInt();
            switch (coffeeChoice) {
                case 1:
                    coffee = new Espresso();
                    break;
                case 2:
                    coffee = new Latte();
                    break;
                default:
                    System.out.println("Wrong choice. Please try again.");
            }
        }

        while (true) {
            System.out.print("Would you like to add milk? (yes/no): ");
            String milkChoice = scanner.next();
            if (milkChoice.equalsIgnoreCase("yes")) {
                coffee = new MilkDecorator(coffee);
            } else if (milkChoice.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Wrong choice. Please try again.");
            }
        }

        while (true) {
            System.out.print("Do you wish to add sugar? (yes/no): ");
            String sugarChoice = scanner.next();
            if (sugarChoice.equalsIgnoreCase("yes")) {
                coffee = new SugarDecorator(coffee);
            } else if (sugarChoice.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.println("Wrong choice. Please try again.");
            }
        }

        scanner.close();

        System.out.println("Your order: " + coffee.getDescription());
        System.out.println("Bill: $" + coffee.cost());
    }
}
