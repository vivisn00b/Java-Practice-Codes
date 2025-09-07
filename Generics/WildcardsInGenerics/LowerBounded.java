//  Lower-bounded wildcards are useful when you want to add objects to a collection. You can add objects of the specified type or any of its subclasses.

package Generics.WildcardsInGenerics;

import java.util.ArrayList;
import java.util.List;

public class LowerBounded {
    public static void addObject(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++)
            list.add(i);

        // But when we read, we only know it's at least Object
        Object obj = list.get(0); // Allowed
        // Integer num = list.get(0); // Compile error
        System.out.println("First element (as Object): " + obj);
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        // Works with an Integer list
        addObject(intList);
        System.out.println("intList: " + intList);

        // Works with a Number list
        addObject(numList);
        System.out.println("numList: " + numList);

        // Works with an Object list
        addObject(objList);
        System.out.println("objList: " + objList);

        //addObject((new ArrayList<Double>()));  // Doesn't work as Double is not a supertype of Integer
    }
}
