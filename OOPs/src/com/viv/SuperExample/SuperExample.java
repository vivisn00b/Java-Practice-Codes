// The super keyword is a reference variable that is used to refer to parent class when we’re working with objects.
//
// It is majorly used in the following contexts:
//
// 1. Use of super with Variables
// 2. Use of super with Methods
// 3. Use of super with Constructors

package OOPs.src.com.viv.SuperExample;

class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    // Constructor of the Dog class
    Dog(String name) {
        // Calling the constructor of the parent class (Animal)
        super(name);
    }

    void makeSound() {
        // Calling the makeSound method of the parent class (Animal)
        super.makeSound();
        System.out.println("Dog barks");
    }

    void printName() {
        // Accessing the name property from the parent class using super
        System.out.println("The dog's name is " + super.name);
    }
}

public class SuperExample {
    public static void main(String[] args) {
        // Creating an instance of the Dog class
        Dog dog = new Dog("Buddy");

        // Calling methods from the Dog class
        dog.makeSound();  // Output: Animal makes a sound \n Dog barks
        dog.printName();  // Output: The dog's name is Buddy
    }
}
