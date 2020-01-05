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
        System.out.println("Fruit Salad shopping plan");

        do {
            System.out.println("\nOptions menu: ");
            System.out.println("____________________________________________________________________________");
            System.out.print("1: Add item | 2: Remove item |");
            System.out.println(" 3: Print items | 4: Sort by price | 5: Exit\n");
            System.out.print("Choose the number: ");

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
        boolean flag1 = true;
        boolean flag2 = true;
        do {
            if (flag2) {
                System.out.print("\nEnter item: ");
                itemName = scanner.next();
                System.out.print("Enter item price: ");
                try {
                    float itemPrice = scanner.nextFloat();
                    items.add(new Item(itemName, itemPrice));
                } catch (Exception e) {
                    System.out.println("Wrong Entry, try again.");
                    scanner.nextLine();
                    continue;
                }
            }
            System.out.print("\nContinue adding: Y/N: ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'y':
                case 'Y':
                    flag2 = true;
                    continue;
                case 'n':
                case 'N':
                    scanner.nextLine();
                    flag1 = false;
                    break;
                default:
                    System.out.println("Wrong entry, try again.");
                    flag2 = false;
            }
        } while (flag1);
    }

    public static void removeItem(){
        boolean flag = true;
        do {
            System.out.print("\nEnter name of the item you want to delete (");
            for (int i = 0; i < items.size(); i++) {
                System.out.print((i < items.size() - 1) ? items.get(i).getName() + ", " : items.get(i).getName());
            }
            System.out.print("): ");
            String input = scanner.next();

            for (int i = 0; i < items.size(); i++) {
                if (input.equals(items.get(i).getName())) {
                    System.out.println(items.get(i).getName() + " deleted.");
                    items.remove(items.get(i));
                    flag = false;
                }
            }
            if (flag) System.out.println("Wrong entry, try again.");
        } while (flag);
    }

    public static void printItems(){
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

    public static void sortItems(){

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

