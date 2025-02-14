// Copy constructor is passed with another object which copies the data available from the passed object to the newly created object.
//
package com.viv.Constructors;

class copyCon {
    String name;
    int id;

    // Parameterized Constructor
    copyCon(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    // Copy Constructor
    copyCon(copyCon obj2)
    {
        this.name = obj2.name;
        this.id = obj2.id;
    }
}

class Owner {
    public static void main(String[] args) {
        // This would invoke the parameterized constructor.
        copyCon con = new copyCon("Vivy", 2568974);
        System.out.println("Owner name: " + con.name + "\n" + "Owner id: " + con.id);

        // This would invoke the copy constructor.
        copyCon cons = new copyCon(con);
        System.out.println("Owner name: " + cons.name + "\n" + "Owner id: " + cons.id);
    }
}

class Car {
    String model;
    int year;

    // Regular constructor
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // Copy constructor
    public Car(Car other) {
        this.model = other.model;
        this.year = other.year;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Model: " + model + ", Year: " + year);
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", 2022);
        Car car2 = new Car(car1);  // Copy constructor is used here

        car1.displayDetails();
        car2.displayDetails();
    }
}
