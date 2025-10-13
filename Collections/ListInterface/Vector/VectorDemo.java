// Vector is thread-safe, meaning only one thread can access it at a time during modification
// It is slower compared to ArrayList
// It is a legacy class

package Collections.ListInterface.Vector;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // Creating a Vector of Strings
        Vector<String> fruits = new Vector<>();

        // Adding elements using add()
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Adding an element at a specific index
        fruits.add(1, "Mango");

        System.out.println("Initial Vector: " + fruits);

        // Accessing an element
        String secondFruit = fruits.get(1);
        System.out.println("Element at index 1: " + secondFruit);

        // Removing an element by value
        fruits.remove("Banana");

        // Removing an element by index
        fruits.remove(2);

        System.out.println("Vector after removals: " + fruits);

        // Iterating using for loop
        System.out.print("Iterating using for loop: ");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.print(fruits.get(i) + " ");
        }
        System.out.println();

        System.out.print("Iterating using iterator: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }
}
