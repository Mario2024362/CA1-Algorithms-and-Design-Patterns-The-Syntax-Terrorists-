/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author Mario Cornejo
 */

// Interface: the operations the storage must have
interface StorageOperations {
    boolean isEmpty();
    boolean isFull();
    int size();
    boolean addFront(FoodItem item);  // false if full
    FoodItem removeFront();           // null if empty
    FoodItem removeBack();            // null if empty
    FoodItem peek();                  // null if empty
    FoodItem search(String name);     // null if not found
    void display();
}
// double-ended queue: this add at the front, remove from the front or the back.
// Max 8 items. The array is circular: after  7 it goes back to  0.
public class Storage implements StorageOperations {
    private static final int MAX = 8;
    private FoodItem[] items = new FoodItem[MAX];
    private int front = 0; // where the front item is
    private int count = 0; // how many items are stored

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == MAX;
    }

    public int size() {
        return count;
    }

    // add at the FRONT  - O(1)
    public boolean addFront(FoodItem item) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + MAX) % MAX;
        items[front] = item;
        count++;
        return true;
    }

    // Remove from the front - O(1)
    public FoodItem removeFront() {
        if (isEmpty()) {
            return null;
        }
        FoodItem item = items[front];
        items[front] = null;
        front = (front + 1) % MAX;
        count--;
        return item;
    }
    // remove from the back O(1)
    public FoodItem removeBack() {
        if (isEmpty()) {
            return null;
        }
        int back = (front + count - 1) % MAX;
        FoodItem item = items[back];
        items[back] = null;
        count--;
        return item;
    }

    // Look at the front item
    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }
        return items[front];
    }
    // linear search
     public FoodItem search(String name) {
        for (int i = 0; i < count; i++) {
            FoodItem item = items[(front + i) % MAX];
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
    //show all items front to back 
    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + items[(front + i) % MAX]);
        }
    }
}
