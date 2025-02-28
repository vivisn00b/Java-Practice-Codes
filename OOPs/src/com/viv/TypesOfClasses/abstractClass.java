// An abstract class in Java is a class that cannot be instantiated directly
//  It is meant to be subclassed by other classes, which provide implementations for the abstract methods

package OOPs.src.com.viv.TypesOfClasses;

abstract class Animal {
    // Abstract method (no implementation)
    abstract void sound();

    // Regular method (with implementation)
    void sleep() {
        System.out.println("The animal is sleeping");
    }
}

// Subclass (inheriting from Animal)
class Dog extends Animal {
    // Providing implementation of the abstract method
    void sound() {
        System.out.println("The dog barks");
    }
}

class abstractClass {
    public static void main(String[] args) {
        // Cannot instantiate the abstract class directly
        // Animal animal = new Animal(); // This would cause a compile-time error

        // Creating an object of Dog (which is a subclass of Animal)
        Animal myDog = new Dog();

        // Calling the implemented method
        myDog.sound();

        // Calling the concrete method from the abstract class
        myDog.sleep();
    }

}
