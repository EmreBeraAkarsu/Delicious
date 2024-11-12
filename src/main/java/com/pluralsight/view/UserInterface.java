package com.pluralsight.view;

import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;
import com.pluralsight.order.Order;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Order order;
    private Scanner scanner;

    public void display() {


    }

    public void homeScreen() {

        while (true) {
            System.out.println("Please pick one of the following options: ");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                orderScreen();
            } else if (option == 0) {
                System.out.println("Good bye!");
                return;
            } else {
                System.out.println("Invalid Option!");
            }
        }
    }


    public void orderScreen() {

        System.out.println("1) Add Sandwich\n" +
                "2) Add Drink\n" +
                "3) Add Chips\n" +
                "4) Checkout\n" +
                "0) Cancel Order\n");
        String option = scanner.nextLine().trim();

        while (true) {
            switch (option) {
                case "1":
                    addSandwichScreen();
                    break;
                case "2":
                    addDrinkScreen();
                    break;
                case "3":
                    addChipScreen();
                    break;
                case "4":
                    checkoutScreen();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid order option!");
                    break;
            }
        }

    }

    public Sandwich addSandwichScreen() {

        System.out.println("Select your bread: \n- white\n" +
                "- wheat\n" +
                "- rye\n" +
                "- wrap\n");
        String bread = scanner.nextLine().trim();

        System.out.println("Select the sandwich size: \n-4''\n-8''\n12''\n");
        int size = scanner.nextInt();


        List<Meat> meats = addMeatsScreen();

        List<Sauce> sauces = addSaucesScreen();

        List<Cheese> cheeses = addCheesesScreen();

        List<RegularTopping> regularToppings = addRegularToppingsScreen();

        List<Topping> toppings = new ArrayList<>();

        toppings.addAll(meats);
        toppings.addAll(cheeses);
        toppings.addAll(sauces);
        toppings.addAll(regularToppings);

        System.out.println("Do you want your sandwich to be toasted? (yes/no)");
        String toastedOption = scanner.nextLine().trim();

        boolean isToasted;


        if (toastedOption.equalsIgnoreCase("yes")) {
            isToasted = true;

        } else {
            isToasted = false;
        }

        return new Sandwich(bread, size, toppings, isToasted);
        ;
    }

    public List<Meat> addMeatsScreen() {

        List<Meat> meats = new ArrayList<>();

        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("Select one of the following meats to add to your sandwich: \n" +
                    "- steak\n" +
                    "- ham\n" +
                    "- salami\n" +
                    "- roast beef\n" +
                    "- chicken\n" +
                    "- bacon\n");
            String meatSelected = scanner.nextLine().trim();

            Meat meat = new Meat(meatSelected);

            System.out.println("Do you want to add more meat? (yes/no)");
            String continueAdding = scanner.nextLine().trim();

            if (continueAdding.equalsIgnoreCase("yes")) {
                System.out.println("Adding another meat...");
            } else if (continueAdding.equalsIgnoreCase("no")) {
                continueMenu = false;
            } else {
                System.out.println("Invalid option for adding more selected!");
            }
        }

        return meats;

    }

    public List<Sauce> addSaucesScreen() {


        List<Sauce> sauces = new ArrayList<>();

        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("Select one of the following sauces to add to your sandwich: \n" +
                    "- mayo\n" +
                    "- mustard\n" +
                    "- ketchup\n" +
                    "- ranch\n" +
                    "- thousand islands\n" +
                    "- vinaigrette"
            );
            String sauceSelected = scanner.nextLine().trim();

            Sauce sauce = new Sauce(sauceSelected);

            System.out.println("Do you want to add more sauce? (yes/no)");
            String continueAdding = scanner.nextLine().trim();

            if (continueAdding.equalsIgnoreCase("yes")) {
                System.out.println("Adding another sauce...");
            } else if (continueAdding.equalsIgnoreCase("no")) {
                continueMenu = false;
            } else {
                System.out.println("Invalid option for adding more selected!");
            }
        }

        return sauces;

    }

    public List<Cheese> addCheesesScreen() {


        List<Cheese> cheeses = new ArrayList<>();

        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("Select one of the following cheese to add to your sandwich: \n" +
                    "- mayo\n" +
                    "- mustard\n" +
                    "- ketchup\n" +
                    "- ranch\n" +
                    "- thousand islands\n" +
                    "- vinaigrette\n"
            );
            String cheeseSelected = scanner.nextLine().trim();

            Cheese cheese = new Cheese(cheeseSelected);

            System.out.println("Do you want to add more cheese? (yes/no)");
            String continueAdding = scanner.nextLine().trim();

            if (continueAdding.equalsIgnoreCase("yes")) {
                System.out.println("Adding another cheese...");
            } else if (continueAdding.equalsIgnoreCase("no")) {
                continueMenu = false;
            } else {
                System.out.println("Invalid option for adding more selected!");
            }
        }

        return cheeses;
    }

    public List<RegularTopping> addRegularToppingsScreen() {

        List<RegularTopping> regularToppings = new ArrayList<>();

        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("Select one of the following Regular Toppings to add to your sandwich: \n- lettuce\n" +
                    "- peppers\n" +
                    "- onions\n" +
                    "- tomatoes\n" +
                    "- jalepenos\n" +
                    "- cucumbers\n" +
                    "- pickles\n" +
                    "- guacamole\n" +
                    "- mushrooms\n"
            );
            String regularToppingSelected = scanner.nextLine().trim();

            RegularTopping regularTopping = new RegularTopping(regularToppingSelected);

            System.out.println("Do you want to add more Regular Toppings? (yes/no)");
            String continueAdding = scanner.nextLine().trim();

            if (continueAdding.equalsIgnoreCase("yes")) {
                System.out.println("Adding another Regular Topping...");
            } else if (continueAdding.equalsIgnoreCase("no")) {
                continueMenu = false;
            } else {
                System.out.println("Invalid option for adding more selected!");
            }
        }

        return regularToppings;
    }

    public Drink addDrinkScreen() {

        System.out.println("Enter the flavor you want to pick for your drink: \n" +
                "Pepsi\n" +
                "Lemonade\n" +
                "Orange Juice\n" +
                "Turkish Tea\n" +
                "Turkish Coffee\n" +
                "Salgam\n" +
                "ARAK\n" +
                "Sahlap\n");
        String flavor = scanner.nextLine().trim();

        System.out.println("Select the size of the drink you want to select: (S/M/L)");
        String size = scanner.nextLine().trim();

        return new Drink(size, flavor);
        ;
    }

    public void addChipScreen() {


    }

    public void checkoutScreen() {


    }
}
