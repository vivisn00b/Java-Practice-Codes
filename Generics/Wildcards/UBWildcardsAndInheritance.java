package Generics.Wildcards;

import java.util.List;

class Animal {
    public void sound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("bark");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("meow");
    }
}

public class UBWildcardsAndInheritance {
    public static void makeSound(List<? extends Animal> animals) {
        // The upper-bounded wildcard <? extends Animal> ensures that we can pass in lists of Dog, Cat, or any other subclass of Animal
        for (Animal animal : animals)
            animal.sound();
    }
    public static void main(String[] args) {
        List<Dog> dogs = List.of(new Dog(), new Dog());
        List<Cat> cats = List.of(new Cat(), new Cat());
        makeSound(dogs);
        makeSound(cats);
    }
}
