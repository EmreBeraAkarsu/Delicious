package com.pluralsight.view;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;
import com.pluralsight.order.Order;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Order order;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        this.order = new Order();
        homeScreen();
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

        while (true) {
        System.out.println("1) Add Sandwich\n" +
                "2) Add Drink\n" +
                "3) Add Chips\n" +
                "4) Checkout\n" +
                "0) Cancel Order\n");
        String option = scanner.nextLine().trim();


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

    public void addSandwichScreen() {

        System.out.println("Select your bread: \n- white\n" +
                "- wheat\n" +
                "- rye\n" +
                "- wrap\n");
        String bread = scanner.nextLine().trim();

        System.out.println("Select the sandwich size: \n-4''\n-8''\n12''\n");
        int size = scanner.nextInt();
        scanner.nextLine();


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

        order.addSandwiches(new Sandwich(bread, size, toppings, isToasted));

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
                    "- american\n" +
                    "- provolone\n" +
                    "- cheddar\n" +
                    "- swiss"
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

    public void addDrinkScreen() {

        System.out.println("Enter the flavor you want to pick for your drink: \n" +
                "1) Pepsi\n" +
                "2) Lemonade\n" +
                "3) Orange Juice\n" +
                "4) Turkish Tea\n" +
                "5) Turkish Coffee\n" +
                "6) Salgam\n" +
                "7) ARAK\n" +
                "8) Sahlap\n");
        String option = scanner.nextLine().trim();

        String flavor;

        switch (option){
            case "1":
                flavor = "Pepsi";
                break;
            case "2":
                flavor = "Lemonade";
                break;
            case "3":
                flavor = "Orange Juice";
                break;
            case "4":
                flavor = "Turkish Tea";
                break;
            case "5":
                flavor = "Turkish Coffee";
                break;
            case "6":
                flavor = "Salgam";
                break;
            case "7":
                flavor = "ARAK";
                break;
            case "8":
                flavor = "Sahlap";
                break;
            default:
                System.out.println("Invalid drink flavor selected!");
                return;
        }

        System.out.println("Select the size of the drink you want to select: (S/M/L)");
        String size = scanner.nextLine().trim();

        order.addDrinks(new Drink(size, flavor));


    }

    public void addChipScreen() {

        System.out.println("Select the flavor of the chip you want to add: \n" +
                "1) BBQ\n" +
                "2) Sea Salt\n" +
                "3) Cheddar");
        String option = scanner.nextLine().trim();

        String flavor;

        switch (option){
            case "1":
                flavor = "BBQ";
                break;
            case "2":
                flavor = "Sea Salt";
                break;
            case "3":
                flavor = "Cheddar";
                break;
            default:
                System.out.println("Incorrect chip flavor entered!");
                return;
        }

        order.addChip(new Chip(flavor));

    }

    public void checkoutScreen() {

        System.out.println("Order Details: ");
        System.out.println(order.toString());

        System.out.println("Do you want to confirm your order? (Y/N)");
        String option = scanner.nextLine().trim();

        if (option.equalsIgnoreCase("y")){
            order.checkout();
        }else {
            System.out.println("Do you want to continue with your order or cancel the order?\n1-) Cancel the Order\n2-)Continue with the Order");
            String cancelOrContinue = scanner.nextLine().trim();

            if (cancelOrContinue.equalsIgnoreCase("1")){
                order = null;
                homeScreen();
            }else {
                homeScreen();
            }
        }
    }
}
