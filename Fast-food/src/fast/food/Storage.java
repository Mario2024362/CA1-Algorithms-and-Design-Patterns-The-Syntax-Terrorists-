/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fast.food;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Mario Cornejo
 */
public class Storage {
    private static final int MAX_CAPACITY = 8;
    private Deque<FoodItem> storage = new ArrayDeque<>();

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
    // Remove from the FRONT (same side as adding) - O(1)
    public void removeFront() {
        if (storage.isEmpty()) {
            System.out.println("Error: storage is empty.");
            return;
        }
        System.out.println("Removed from front: " + storage.removeFirst());
    }

    // Remove from the BACK (opposite side) - O(1)
    public void removeBack() {
        if (storage.isEmpty()) {
            System.out.println("Error: storage is empty.");
            return;
        }
        System.out.println("Removed from back: " + storage.removeLast());
    }
    // Show the item at the top (front) without removing it - O(1)
    public void peek() {
        if (storage.isEmpty()) {
            System.out.println("Error: storage is empty.");
            return;
        }
        System.out.println("Top item: " + storage.peekFirst().getName());
    }

    // Show all items - O(n)
    public void display() {
        if (storage.isEmpty()) {
            System.out.println("Error: storage is empty.");
            return;
        }
        int i = 1;
        for (FoodItem item : storage) {
            System.out.println(i++ + ". " + item);
        }
    }
    // Search by name - O(n)
    public void search(String name) {
        if (storage.isEmpty()) {
            System.out.println("Error: storage is empty.");
            return;
        }
        boolean found = false;
        for (FoodItem item : storage) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + item);
                found = true;
            }
        }
        if (!found) {
            System.out.println(name + " not found.");
        }
    }
}
