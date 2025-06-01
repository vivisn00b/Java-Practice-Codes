package OOPs.src.com.viv.POLYMORPHISM;

// Base class
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Derived class 1
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Derived class 2
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Main class demonstrating polymorphism
public class polymorphismEx {
    public static void main(String[] args) {
        Animal myAnimal;  // Reference of type Animal

        myAnimal = new Dog();  // Dog object
        myAnimal.sound();      // Outputs: Dog barks

        myAnimal = new Cat();  // Cat object
        myAnimal.sound();      // Outputs: Cat meows
    }
}