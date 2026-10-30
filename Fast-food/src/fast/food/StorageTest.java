/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fast.food;

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
}
