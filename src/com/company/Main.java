package com.company;

public class Main {

    // TODO EXPLANATION FOR FUNCTIONS

    public static void main(String[] args) {
        shoppingListTittle();

        do {
            displayOptionsMenu();
            try {
                int userInput = ShoppingList.scanner.nextInt();
                ShoppingList.scanner.nextLine();
                switch (userInput){
                    case 1:
                        ShoppingList.addItem();
                        break;
                    case 2:
                        ShoppingList.removeItem();
                        break;
                    case 3:
                        ShoppingList.printItems();
                        break;
                    case 4:
                        ShoppingList.sortItems();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
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
