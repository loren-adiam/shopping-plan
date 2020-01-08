package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoppingList {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Item> items = new ArrayList<>();
    public static boolean sortChoice = true;

    public ShoppingList() {
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

                ArrayList<Item> sortItems = new ArrayList<>(items);
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
}
