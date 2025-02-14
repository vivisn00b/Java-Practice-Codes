package com.viv.Constructors;

public class conOverloading {
    // Constructor with no arguments
    public conOverloading() {
        System.out.println("Constructor with no arguments");
    }

    // Constructor with one argument
    public conOverloading(int x) {
        System.out.println("Constructor with one argument: x = " + x);
    }

    // Constructor with two arguments
    public conOverloading(int x, int y) {
        System.out.println("Constructor with two arguments: x = " + x + ", y = " + y);
    }
}

class Main {
    public static void main(String[] args) {
        // Creating objects with different constructors
        conOverloading obj1 = new conOverloading();       // Calls constructor with no arguments
        conOverloading obj2 = new conOverloading(10);     // Calls constructor with one argument
        conOverloading obj3 = new conOverloading(10, 20); // Calls constructor with two arguments
    }
}
