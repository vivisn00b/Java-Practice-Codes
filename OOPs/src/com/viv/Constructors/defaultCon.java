// If we do not create any constructor, the Java compiler automatically creates a no-arg constructor during the execution of the program.
//
package com.viv.Constructors;

public class defaultCon {
    String model;
    int year;

    // Default constructor
    defaultCon() {
        model = "Unknown";
        year = 0;
    }

    void display() {
        System.out.println("Car Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        defaultCon myCar = new defaultCon(); // Creating object using the default constructor
        myCar.display(); // Displays: Car Model: Unknown, Year: 0
    }
}

// Driver class
//class defaultCon {

    // Default Constructor
//    defaultCon() { System.out.println("Default constructor"); }

    // Driver function
//    public static void main(String[] args)
//    {
//        defaultCon hello = new defaultCon();
//    }
//}

//class Main {
//
//    int a;
//    boolean b;

//    public static void main(String[] args) {
//
        // calls default constructor
//        Main obj = new Main();
//
//        System.out.println("Default Value:");
//        System.out.println("a = " + obj.a);
//        System.out.println("b = " + obj.b);
//        }
//}