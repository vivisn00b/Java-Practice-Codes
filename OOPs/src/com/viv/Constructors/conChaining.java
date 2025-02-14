// Constructor chaining happens when one constructor calls another constructor in the same class or superclass.
//
package com.viv.Constructors;

public class conChaining {
    public static void main(String[] args) {

    }
}

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal Constructor: " + name);
    }
}

class Dog extends Animal {
    Dog(String name) {
        // Call the constructor of the parent class
        super(name);
        System.out.println("Dog Constructor: " + name);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Bulldog");
    }
}