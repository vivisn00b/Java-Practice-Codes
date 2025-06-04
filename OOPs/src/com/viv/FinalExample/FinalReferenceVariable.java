class Car {
    String model;

    Car(String model) {
        this.model = model;
    }

    void setModel(String model) {
        this.model = model;
    }

    void display() {
        System.out.println("Car model: " + model);
    }
}

public class FinalReferenceVariable {
    public static void main(String[] args) {
        final Car car1 = new Car("Honda");

        car1.display();
      
        // Allowed: modifying the object that car1 refers to
        car1.setModel("Toyota");

        car1.display();

        // Not allowed: reassigning the reference
        // car1 = new Car("BMW");  // will give Compilation error
    }
}
