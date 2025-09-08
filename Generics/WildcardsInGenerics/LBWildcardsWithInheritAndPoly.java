package Generics.WildcardsInGenerics;

import java.util.*;

class Herbivores {
    @Override
    public String toString() {
        return "Animal";
    }
}

class Cow extends Herbivores {
    @Override
    public String toString() {
        return "Cow";
    }
}

class Goat extends Herbivores {
    @Override
    public String toString() {
        return "GOAT";
    }
}

public class LBWildcardsWithInheritAndPoly {
    // Method that accepts Cow or any of its supertypes
    public static void addAnimal(List<? super Cow> list) {
        list.add(new Cow());   // always safe
        // list.add(new Cat());   // compile error
        System.out.println("Added Dog to list: " + list);
    }

    public static void main(String[] args) {
        List<Cow> cowList = new ArrayList<>();
        List<Herbivores> herbivoresList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        // Works: list is Dog
        addAnimal(cowList);
        System.out.println("dogList contents: " + cowList);

        // Works: list is Animal
        addAnimal(herbivoresList);
        System.out.println("animalList contents: " + herbivoresList);

        // Works: list is Object
        addAnimal(objectList);
        System.out.println("objectList contents: " + objectList);

        // --- Now show reading ---
        List<? super Cow> superDogList = new ArrayList<Herbivores>();
        superDogList.add(new Cow()); // allowed
        Object obj = superDogList.get(0); // only Object is safe
        // Dog d = superDogList.get(0); // compile error
        System.out.println("Read from superDogList: " + obj);
    }
}