/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fast.food;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Mario Cornejo
 */
//the food that will be storage with the detailes
class Food {
    private String name;
    private double weight; //is in grams

    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " | " + weight + "g";
    }
}
public class foodType {
     private String name;
    private double weight;            // in grams
    private LocalDate bestBefore;     // max 2 weeks from today
    private LocalDateTime timePlaced; // set automatically when created


     public foodType(String name, double weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timePlaced = LocalDateTime.now();
    }


    public String getName() {
        return name;
    }


     @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return name + " | " + weight + "g | Best before: " + bestBefore
                + " | Placed: " + timePlaced.format(f);
    }

}
