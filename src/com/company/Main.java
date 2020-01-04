package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
                    deleteItem();
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
                    String priceFormatted = NumberFormat.getCurrencyInstance().format(itemPrice);
                    items.add(new Item(itemName, priceFormatted));
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

    public static void deleteItem(){

    }

    public static void printItems(){
        System.out.println();
        System.out.println(Arrays.toString(new ArrayList[]{items}));
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

