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
            System.out.println("4. Show top item (peek)");
            System.out.println("5. Display all");
            System.out.println("6. Search by name");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
    }
    
}
