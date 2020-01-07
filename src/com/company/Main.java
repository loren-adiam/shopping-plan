package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Item> items = new ArrayList<>();
    public static boolean sortChoice = true;

    // TODO: NEXT LINE FOR ADDING ITEMS, EXPLANATION FOR FUNCTIONS

    public static void main(String[] args) {
        System.out.println("______________________________________________________________________________");
        System.out.println("FRUIT SALAD SHOPPING PLAN");

        //placeholder data
        items.add(new Item("Chicken",  7.4555));
        items.add(new Item("Meat", 11));
        items.add(new Item("Bread", 2));
        items.add(new Item("Cola",  2.53));
        items.add(new Item("Eggs", 3));
        items.add(new Item("Juice",  5.5));
        items.add(new Item("Ketchup", 1));

        do {
            displayOptionsMenu();
            try {
                int userInput = scanner.nextInt();
                if (userInput == 1){
                    addItem();
                } else if (userInput == 2){
                    removeItem();
                } else if (userInput == 3){
                    printItems();
                } else if (userInput == 4){
                    sortItems();
                } else if (userInput == 5){
                    System.out.println("Exiting...");
                    System.exit(0);
                }
            } catch (Exception e){
                System.out.println("Wrong Entry, try again.");
                scanner.nextLine();
            }
        } while (true);
    }

    private static void displayOptionsMenu() {
        System.out.println("\nOptions menu: ");
        System.out.println("______________________________________________________________________________");
        System.out.print("1: Add item | 2: Remove item |");
        System.out.println(" 3: Display items | 4: Sort & Display | 5: Exit\n");
        System.out.print("Choose the option number: ");
    }

    public static void addItem(){
        do {
            System.out.print("\nEnter item name or \"e\" to exit to menu: ");
            String itemName = scanner.next();
            if (itemName.equals("e") || itemName.equals("E")) break;
            else {
                System.out.print("Enter item price: ");
                try {
                    double itemPrice = scanner.nextDouble();
                    items.add(new Item(itemName, itemPrice));
                } catch (Exception e) {
                    System.out.println("Wrong Entry, try again.");
                    scanner.nextLine();
                }
            }
        } while (true);
    }

    public static void removeItem(){
        if (items.isEmpty()) System.out.println("No added items yet.");
        else {
            boolean flag = true;
            do {
                System.out.print("\nCurrent list: (");
                for (int i = 0; i < items.size(); i++) {
                    System.out.print((i < items.size() - 1) ? items.get(i).getName() + ", " : items.get(i).getName());
                }
                System.out.println(")");
                System.out.print("Enter item name to remove it or \"e\" to exit to menu: ");
                String input = scanner.next();

                if (input.equals("e") || input.equals("E")) flag = false;
                else {
                    for (int i = 0; i < items.size(); i++) {
                        String name = items.get(i).getName();
                        String name2 = name.toLowerCase();
                        if (input.equals(name) || input.equals(name2)) {
                            System.out.println(items.get(i).getName() + " deleted from the list.");
                            items.remove(items.get(i));
                            flag = false;
                        }
                    }
                    if (flag) System.out.println("There is no item with that name, try again.");
                }
            } while (flag);
        }
    }

    public static void printItems(){
        if (items.isEmpty()) System.out.println("No added items yet.");
        else {
            double sum = 0;
            System.out.println();
            System.out.println("------SHOPPING LIST IN ADDING ORDER------\n");
            for (int i = 0; i < items.size(); i++) {
                String priceFormatted = NumberFormat.getCurrencyInstance().format(items.get(i).getPrice());
                System.out.println(i + 1 + ". " + items.get(i).getName() + ": " + priceFormatted);
                sum = sum + (items.get(i).getPrice());
            }
            String sumFormatted = NumberFormat.getCurrencyInstance().format(sum);
            System.out.println("\n-------------TOTAL: " + sumFormatted + "-------------");
        }
    }

    public static void sortItems(){
        if (items.isEmpty()) System.out.println("No added items yet.");
        else {
            while (true) {
                System.out.print("Enter 1 for Ascending, 2 for Descending: ");
                try {
                    int input = scanner.nextInt();
                    if (input == 2) sortChoice = false;
                    else if (input == 1) sortChoice = true;
                    else continue;
                } catch (Exception e) {
                    System.out.println("Try again.");
                    scanner.nextLine();
                    continue;
                }
                double maxItemPrice = items.get(0).getPrice();
                double minItemPrice = items.get(0).getPrice();
                String maxItemName = items.get(0).getName();
                String minItemName = items.get(0).getName();

                System.out.println();
                System.out.println("----------SORTED LIST BY PRICE----------\n");

                ArrayList<Item> sortItems = new ArrayList<>();

                for (Item value : items) {
                    sortItems.add(new Item(value.getName(), value.getPrice()));
                }
                Collections.sort(sortItems);

                for (Item sortItem : sortItems) {
                    String priceFormatted = NumberFormat.getCurrencyInstance().format(sortItem.getPrice());
                    System.out.println("- " + priceFormatted + "  " + sortItem.getName());
                    if (sortItem.getPrice() > maxItemPrice) {
                        maxItemPrice = sortItem.getPrice();
                        maxItemName = sortItem.getName();
                    } else if (sortItem.getPrice() < minItemPrice) {
                        minItemPrice = sortItem.getPrice();
                        minItemName = sortItem.getName();
                    }
                }
                String minFormatted = NumberFormat.getCurrencyInstance().format(minItemPrice);
                String maxFormatted = NumberFormat.getCurrencyInstance().format(maxItemPrice);
                System.out.println("\n- CHEAPEST ITEM -> " + minItemName + ": " + minFormatted);
                System.out.println("- MOST EXPENSIVE ITEM -> " + maxItemName + ": " + maxFormatted);
                System.out.println("----------------------------------------");
                break;
            }
        }
    }

    public static String currencySEK(double number){
        String str1 = String.valueOf(number);
        int index = str1.indexOf('.');
        String str2 = str1.replace('.',',');
        String answer = "";
        for (int i = 1; i < index + 3; i++) {
            if (index == str2.length() - 2)
                answer = str2 + "0 SEK";
            else if (index == i)
                answer = str2.substring(0, i + 3) + " SEK";
        }
        return answer;
    }
}
