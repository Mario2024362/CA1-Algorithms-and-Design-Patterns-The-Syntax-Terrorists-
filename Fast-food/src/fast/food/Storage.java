/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fast.food;

/**
 *
 * @author Mario Cornejo
 */
public class Storage {
    private static final int MAX_CAPACITY = 8;

     // Add at the FRONT - O(1)
    public boolean add(FoodItem item) {
        if (storage.size() >= MAX_CAPACITY) {
            System.out.println("Error: storage is full (max " + MAX_CAPACITY + ").");
            return false;
        }
        storage.addFirst(item);
        System.out.println("Added: " + item);
        return true;
    }
}
