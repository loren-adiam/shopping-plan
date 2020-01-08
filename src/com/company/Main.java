package com.company;

public class Main {

    // TODO: NEXT LINE FOR ADDING ITEMS, EXPLANATION FOR FUNCTIONS

    public static void main(String[] args) {
        shoppingListTittle();

        do {
            displayOptionsMenu();
            try {
                int userInput = ShoppingList.scanner.nextInt();
                if (userInput == 1){
                    ShoppingList.addItem();
                } else if (userInput == 2){
                    ShoppingList.removeItem();
                } else if (userInput == 3){
                    ShoppingList.printItems();
                } else if (userInput == 4){
                    ShoppingList.sortItems();
                } else if (userInput == 5){
                    System.out.println("Exiting...");
                    System.exit(0);
                }
            } catch (Exception e){
                System.out.println("Wrong Entry, try again.");
                ShoppingList.scanner.nextLine();
            }
        } while (true);
    }

    private static void shoppingListTittle() {
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>");
        System.out.println("<<>>                     FRUIT SALAD SHOPPING PLAN                      <<>>");
        System.out.println("<<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>><<>>");
    }

    public static void displayOptionsMenu() {
        System.out.println("\nOptions menu: ");
        System.out.println("______________________________________________________________________________");
        System.out.println("1: Add item | 2: Remove item | 3: Display items | 4: Sort & Display | 5: Exit\n");
        System.out.print("Choose the option number: ");
    }
}
