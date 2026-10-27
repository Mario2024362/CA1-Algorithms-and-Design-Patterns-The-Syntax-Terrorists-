/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fast.food;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Mario Cornejo
 */
public class foodType {
     private String name;
    private double weight;            // in grams
    private LocalDate bestBefore;     // max 2 weeks from today
    private LocalDateTime timePlaced; // set automatically when created


     public FoodItem(String name, double weight, LocalDate bestBefore) {
        this.name = name;
        this.weight = weight;
        this.bestBefore = bestBefore;
        this.timePlaced = LocalDateTime.now();
    }
}
