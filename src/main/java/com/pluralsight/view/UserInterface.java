package com.pluralsight.view;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;
import com.pluralsight.order.Order;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//UserInterface class for displaying the options, prompting user for adding and customizing items
public class UserInterface {

    private Order order;
    private Scanner scanner;

    //Constructor initializes the order and calls the homeScreen() method to start showing the options to the customer
    public UserInterface() {
        this.order = new Order();
        this.scanner = new Scanner(System.in);
        homeScreen();
    }

    //Method to show the user the options to add a new order or exit the program
    public void homeScreen() {

        //Prompt the user if they want to add an order or exit
        while (true) {
            System.out.println("Welcome to Delicious Sandwich Shop");
            System.out.println("Please pick one of the following options: \n");
            System.out.println("-------Home Screen-------");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            //If the user selects option 1, then call the orderScreen() method to prompt the user for order options
            switch (option) {
                case 1:
                    orderScreen();
                    break;
                case 0:
                    System.out.println("Good bye!");
                    return;
                default:
                    System.out.println("Invalid navigation input entered!");
                    break;
            }
        }
    }

    //Method to display the order options and prompt the user to navigate those options
    public void orderScreen() {

        while (true) {
            //Options are listed below
            System.out.println(
                    "---------Order Menu-----------\n" +
                            "1) Add Sandwich\n" +
                            "2) Add Drink\n" +
                            "3) Add Chips\n" +
                            "4) Checkout\n" +
                            "0) Cancel Order\n");
            //Save the input into the option variable
            String option = scanner.nextLine().trim();


            //Switch case to navigate through different options
            switch (option) {
                case "1":
                    //call the addSandwichScreen() method if the input correlates to it
                    addSandwichScreen();
                    break;
                case "2":
                    //call the addDrinkScreen() method if the input correlates to it
                    addDrinkScreen();
                    break;
                case "3":
                    //call the addChipScreen() method if the input correlates to it
                    addChipScreen();
                    break;
                case "4":
                    //call the checkoutScreen() method if the input correlates to it
                    checkoutScreen();
                    break;
                case "0":
                    //return to the main screen if the user wants to cancel the order
                    return;
                default:
                    //Handle the invalid option
                    System.out.println("Invalid order option!");
                    break;
            }
        }
    }

    //Method for prompting the user to input the customizing selections of a sandwich
    public void addSandwichScreen() {

        System.out.println("Select your bread: \n" +
                "1) white\n" +
                "2) wheat\n" +
                "3) rye\n" +
                "4) wrap\n");
        String breadOption = scanner.nextLine().trim();
        String bread;

        switch (breadOption) {
            case "1":
                bread = "white";
                break;
            case "2":
                bread = "wheat";
                break;
            case "3":
                bread = "rye";
                break;
            case "4":
                bread = "wrap";
                break;
            default:
                System.out.println("Invalid bread option selected!");
                return;
        }

        System.out.println("Select the sandwich size: \n1-) 4''\n2-) 8''\n3-) 12''\n");
        int sizeOption = scanner.nextInt();
        scanner.nextLine();
        int size;

        switch (sizeOption) {
            case 1:
                size = 4;
                break;
            case 2:
                size = 8;
                break;
            case 3:
                size = 12;
                break;
            default:
                System.out.println("Invalid sandwich size selected!");
                return;
        }

        boolean isToasted = false;

        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Do you want your sandwich to be toasted? \n1) Yes\n2) No");
            String toastedOption = scanner.nextLine().trim();

            isToasted = false;

            switch (toastedOption) {
                case "1":
                    isToasted = true;
                    continueRunning = false;
                    break;
                case "2":
                    isToasted = false;
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid toasted option!");
            }
        }

        Sandwich sandwich = new Sandwich(bread, size, isToasted);


        List<Meat> meats = addMeatsScreen();

        List<Sauce> sauces = addSaucesScreen();

        List<Cheese> cheeses = addCheesesScreen();

        List<RegularTopping> regularToppings = addRegularToppingsScreen();

        List<Topping> toppings = new ArrayList<>();

        toppings.addAll(meats);
        toppings.addAll(cheeses);
        toppings.addAll(sauces);
        toppings.addAll(regularToppings);

        for (Topping topping : toppings) {
            sandwich.addToppings(topping);
        }

        order.addSandwiches(sandwich);
    }

    public List<Meat> addMeatsScreen() {

        List<Meat> meats = new ArrayList<>();

        boolean continueMenu = true;

        while (continueMenu) {
            System.out.println("Select one of the following meats to add to your sandwich: \n" +
                    "1-) steak\n" +
                    "2-) ham\n" +
                    "3-) salami\n" +
                    "4-) roast beef\n" +
                    "5-) chicken\n" +
                    "6-) bacon\n");
            String meatSelectedOption = scanner.nextLine().trim();

            String meatSelected = null;

            switch (meatSelectedOption) {
                case "1":
                    meatSelected = "steak";
                    break;
                case "2":
                    meatSelected = "ham";
                    break;
                case "3":
                    meatSelected = "salami";
                    break;
                case "4":
                    meatSelected = "roast beef";
                    break;
                case "5":
                    meatSelected = "chicken";
                    break;
                case "6":
                    meatSelected = "bacon";
                    break;
                default:
                    System.out.println("Invalid sandwich meat selected!");
                    continue;
            }

            meats.add(new Meat(meatSelected));

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
                    "1- mayo\n" +
                    "2- mustard\n" +
                    "3- ketchup\n" +
                    "4- ranch\n" +
                    "5- thousand islands\n" +
                    "6- vinaigrette\n"
            );
            String sauceSelectedOption = scanner.nextLine().trim();

            String sauceSelected;

            switch (sauceSelectedOption) {
                case "1":
                    sauceSelected = "mayo";
                    break;
                case "2":
                    sauceSelected = "mustard";
                    break;
                case "3":
                    sauceSelected = "ketchup";
                    break;
                case "4":
                    sauceSelected = "ranch";
                    break;
                case "5":
                    sauceSelected = "thousand islands";
                    break;
                case "6":
                    sauceSelected = "vinaigrette";
                    break;
                default:
                    System.out.println("Invalid sandwich sauce selected!");
                    continue;
            }

            sauces.add(new Sauce(sauceSelected));

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
                    "1- american\n" +
                    "2- provolone\n" +
                    "3- cheddar\n" +
                    "4- swiss"
            );
            String cheeseSelectedOption = scanner.nextLine().trim();

            String cheeseSelected;

            switch (cheeseSelectedOption) {
                case "1":
                    cheeseSelected = "american";
                    break;
                case "2":
                    cheeseSelected = "provolone";
                    break;
                case "3":
                    cheeseSelected = "cheddar";
                    break;
                case "4":
                    cheeseSelected = "swiss";
                    break;
                default:
                    System.out.println("Invalid sandwich cheese selected!");
                    continue;
            }

            cheeses.add(new Cheese(cheeseSelected));

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
            System.out.println("Select one of the following Regular Toppings to add to your sandwich: \n" +
                    "1- lettuce\n" +
                    "2- peppers\n" +
                    "3- onions\n" +
                    "4- tomatoes\n" +
                    "5- jalepenos\n" +
                    "6- cucumbers\n" +
                    "7- pickles\n" +
                    "8- guacamole\n" +
                    "9- mushrooms\n"
            );
            String regularToppingSelectedOption = scanner.nextLine().trim();

            String regularToppingSelected;

            switch (regularToppingSelectedOption) {
                case "1":
                    regularToppingSelected = "lettuce";
                    break;
                case "2":
                    regularToppingSelected = "peppers";
                    break;
                case "3":
                    regularToppingSelected = "onions";
                    break;
                case "4":
                    regularToppingSelected = "tomatoes";
                    break;
                case "5":
                    regularToppingSelected = "jalepenos";
                    break;
                case "6":
                    regularToppingSelected = "cucumbers";
                    break;
                case "7":
                    regularToppingSelected = "pickles";
                    break;
                case "8":
                    regularToppingSelected = "guacamole";
                    break;
                case "9":
                    regularToppingSelected = "mushrooms";
                    break;
                default:
                    System.out.println("Invalid sandwich topping selected!");
                    continue;
            }

            regularToppings.add(new RegularTopping(regularToppingSelected));

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

    //Method for prompting the user to input the customizing selections of a drink
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

        switch (option) {
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

    //Method for prompting the user to input the customizing selections of a chip
    public void addChipScreen() {

        System.out.println("Select the flavor of the chip you want to add: \n" +
                "1) BBQ\n" +
                "2) Sea Salt\n" +
                "3) Cheddar");
        String option = scanner.nextLine().trim();

        String flavor;

        switch (option) {
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

        if (option.equalsIgnoreCase("y")) {
            order.checkout();
        } else {
            System.out.println("Do you want to continue with your order or cancel the order?\n1-) Cancel the Order\n2-)Continue with the Order");
            String cancelOrContinue = scanner.nextLine().trim();

            if (cancelOrContinue.equalsIgnoreCase("1")) {
                order = null;
                homeScreen();
            } else {
                homeScreen();
            }
        }
    }
}
