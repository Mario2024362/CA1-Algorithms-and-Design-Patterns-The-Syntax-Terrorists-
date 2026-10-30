/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fast.food;

import java.util.Scanner;

/**
 *
 * @author Mario Cornejo
 */
public class FastFood {
  
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in); //to make the input of data
        Storage storage = new Storage(); //variable to input
        boolean running = true;
   
while (running) {  //while for the chossing of the message depeding in the case
            System.out.println("\n--- FOOD STORAGE MENU ---");
            System.out.println("1. Add food item");
            System.out.println("2. Remove from front");
            System.out.println("3. Remove from back");
            System.out.println("4. Show");
            System.out.println("5. Display all");
            System.out.println("6. Search by name");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            
            String choice = scanner.nextLine().trim(); // read the choice that was made
    }
   switch (choice) {
                case "1":
                    addFood(scanner, storage);
                    break;
                case "2":
                    showRemoved(storage.removeFront(), "front");
                    break;
                case "3":
                    showRemoved(storage.removeBack(), "back");
                    break;
                case "4":
                    FoodItem top = storage.peek();
                    if (top == null) {
                        System.out.println("Empty");
                    } else {
                        System.out.println("Top " + top);
                    }
                    break;
                case "5":
                    storage.display();
                    break;
                case "6":
                    System.out.print("Name to search: ");
                    String name = scanner.nextLine().trim();
                    FoodItem found = storage.search(name);
                    if (found == null) {
                        System.out.println(name + " not found.");
                    } else {
                        System.out.println("Found: " + found);
                    }
                    break;
                case "7":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
       
}
// Asking for the details for the check and then add
    static void addFood(Scanner scanner, Storage storage) {
        if (storage.isFull()) {
            System.out.println("Storage is full!");
            return;
        }

        System.out.print("Name (Burger, Pizza, Fries, Sandwich, Hotdog): ");
        String name = validName(scanner.nextLine().trim());
        if (name == null) {
            System.out.println("Invalid food name!");
            return;
        }

        System.out.print("Weight (grams): ");
        double weight = validWeight(scanner.nextLine().trim());
        if (weight == -1) {
            System.out.println("Weight must be a number above 0!");
            return;
        }

        System.out.print("Best-before (YYYY-MM-DD, max 2 weeks): ");
        LocalDate date = validDate(scanner.nextLine().trim());
        if (date == null) {
            System.out.println("Invalid date! Use YYYY-MM-DD, within 2 weeks from today.");
            return;
        }

        storage.addFront(new FoodItem(name, weight, date));
        System.out.println(name + " added.");
}
}
