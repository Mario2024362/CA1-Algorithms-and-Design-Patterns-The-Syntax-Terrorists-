/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fast.food;

import java.time.LocalDate;

/**
 *
 * @author Mario Cornejo
 */
public class StorageTest {
    //to test everything is running perfectly
    static int passed = 0;
    static int total = 0;

    // Print the fail or success for everytime that is check =
    static void check(String description, boolean condition) {
        total++;
        if (condition) {
            passed++;
            System.out.println("Pass: " + description);
        } else {
            System.out.println("fail: " + description);
        }
    }

     static FoodItem item(String name) {
        return new FoodItem(name, 100, LocalDate.now().plusDays(3));
    }

    public static void main(String[] args) {

        System.out.println("--- Storage: empty storage ---");
        Storage s = new Storage();
        check("new storage is empty", s.isEmpty());
        check("peek on empty returns null", s.peek() == null);
        check("removeFront on empty returns null", s.removeFront() == null);
        check("removeBack on empty returns null", s.removeBack() == null);
        check("search on empty returns null", s.search("Pizza") == null);

        System.out.println("--- Storage: add and remove ---");
        s.addFront(item("Pizza"));
        s.addFront(item("Burger"));
        check("size is 2", s.size() == 2);
        check("peek shows the last added (Burger)", s.peek().getName().equals("Burger"));
        check("removeBack gives the first added (Pizza)", s.removeBack().getName().equals("Pizza"));
        check("removeFront gives Burger", s.removeFront().getName().equals("Burger"));
        check("storage is empty again", s.isEmpty());

         System.out.println("--- Storage: full (max 8) ---");
        s = new Storage();
        for (int i = 1; i <= 8; i++) {
            s.addFront(item("A" + i));
        }
        check("storage is full after 8 items", s.isFull());
        check("adding a 9th item returns false", s.addFront(item("A9")) == false);
        check("size stays 8", s.size() == 8);

        //storage data in a circular array, with a size of 8
        System.out.println("--- Storage: circular array ---");
        s.removeFront(); // removes A8
        s.removeFront(); // removes A7
        s.removeFront(); // removes A6
        s.addFront(item("B1"));
        s.addFront(item("B2"));
        s.addFront(item("B3"));
        check("size is 8 again", s.size() == 8);
        check("peek is B3", s.peek().getName().equals("B3"));
        check("removeBack is still the oldest (A1)", s.removeBack().getName().equals("A1"));

        //storage products by name 
        System.out.println("--- Storage: search ---");
        check("search finds B2", s.search("B2") != null);
        check("search ignores upper/lower case", s.search("b2") != null);
        check("search returns null if not found", s.search("Cake") == null);

        //valid products
        System.out.println("--- Input validation ---");
        check("'pizza' is a valid name", FastFood.validName("pizza").equals("Pizza"));
        check("'Cake' is not a valid name", FastFood.validName("Cake") == null);
        check("weight 300 is valid", FastFood.validWeight("300") == 300);
        check("weight -5 is not valid", FastFood.validWeight("-5") == -1);
        check("weight 0 is not valid", FastFood.validWeight("0") == -1);
        check("weight 'abc' is not valid", FastFood.validWeight("abc") == -1);
        check("date in 3 days is valid", FastFood.validDate(LocalDate.now().plusDays(3).toString()) != null);
        check("date in 30 days is not valid", FastFood.validDate(LocalDate.now().plusDays(30).toString()) == null);
        check("date in the past is not valid", FastFood.validDate(LocalDate.now().minusDays(1).toString()) == null);
        check("wrong date format is not valid", FastFood.validDate("2026-13-45") == null);

        
        System.out.println("--- Inheritance ---");
        check("FoodItem is a Food", item("Pizza") instanceof Food);
        check("FoodItem is a FoodItem", item("Pizza") instanceof FoodItem);
        check("Storage implements StorageOperations", new Storage() instanceof StorageOperations);

        System.out.println("\nResult: " + passed + " / " + total + " tests passed");
    }
}
