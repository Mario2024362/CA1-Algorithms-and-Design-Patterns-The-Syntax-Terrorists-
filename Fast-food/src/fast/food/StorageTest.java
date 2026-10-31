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
}
