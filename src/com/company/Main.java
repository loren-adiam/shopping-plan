package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String itemName;
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        int userInput;
        System.out.println("____________________________________________________________________________");
        System.out.println("FRUIT SALAD SHOPPING PLAN");

        do {
            System.out.println("\nOptions menu: ");
            System.out.println("____________________________________________________________________________");
            System.out.print("1: Add item | 2: Remove item |");
            System.out.println(" 3: Print items | 4: Sort by price | 5: Exit\n");
            System.out.print("Choose the option number: ");

            try {
                userInput = scanner.nextInt();
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

    public static void addItem(){
        do {
            System.out.print("\nEnter item name or \"e\" to exit: ");
            itemName = scanner.next();
            if (itemName.equals("e")) break;
            else {
                System.out.print("Enter item price: ");
                try {
                    float itemPrice = scanner.nextFloat();
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
                System.out.print("\nEnter name of the item you want to delete (");
                for (int i = 0; i < items.size(); i++) {
                    System.out.print((i < items.size() - 1) ? items.get(i).getName() + ", " : items.get(i).getName());
                }
                System.out.print("): ");
                String input = scanner.next();

                for (int i = 0; i < items.size(); i++) {
                    String name = items.get(i).getName();
                    String name2 = name.toLowerCase();
                    if (input.equals(name) || input.equals(name2)) {
                        System.out.println(items.get(i).getName() + " deleted.");
                        items.remove(items.get(i));
                        flag = false;
                    }
                }
                if (flag) System.out.println("Wrong entry, try again.");
            } while (flag);
        }
    }

    public static void printItems(){
        if (items.isEmpty()) System.out.println("No added items yet.");
        else {
            float sum = 0;
            System.out.println();
            for (Item item : items) {
                String priceFormatted = NumberFormat.getCurrencyInstance().format(item.getPrice());
                System.out.println(item.getName() + ": " + priceFormatted);
                sum = sum + (item.getPrice());
            }
            System.out.println("\n***** Total: " + NumberFormat.getCurrencyInstance().format(sum) + " *****");
            // make it like list, frame list, make total,
        }
    }

    public static void sortItems(){
        if (items.isEmpty()) System.out.println("No added items yet.");
        else {

        }
    }
}
    /*System.out.println("_________________________________________________________");
      System.out.println("Fruit Salad shopping plan");
      System.out.println("\nOptions menu: ");
      System.out.println("\n1: Add item");
      System.out.println("2: Remove item");
      System.out.println("3: Print items");
      System.out.println("4: Sort and print");
      System.out.println("5: Exit\n");
      System.out.println("Choose the number: ");*/

