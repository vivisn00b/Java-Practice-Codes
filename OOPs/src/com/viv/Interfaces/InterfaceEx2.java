// Interface
interface Animal {
    void makeSound();
    void eat();
}

// Abstract class that implements the interface
abstract class Dog implements Animal {
    // Provide implementation for one method
    public void eat() {
        System.out.println("Dog eats bones.");
    }

    // makeSound() is left abstract for subclass
}

// Concrete class that extends abstract class
class Puppy extends Dog {
    // Implement the remaining method
    public void makeSound() {
        System.out.println("Puppy barks!");
    }
}

// Main class
public class InterfaceEx2 {
    public static void main(String[] args) {
        // Reference using interface type
        Animal myPet = new Puppy();
        
        // Method calls
        myPet.eat();         // Output: Dog eats bones.
        myPet.makeSound();   // Output: Puppy barks!
    }
}
