class Animal {
    // final method cannot be overridden
    public final void eat() {
        System.out.println("Animal is eating.");
    }

    public void sleep() {
        System.out.println("Animal is sleeping.");
    }
}

class Dog extends Animal {
    // This would cause a compilation error:
    /*
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
    */

    // You can still override other non-final methods
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}

public class FinalMethod {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // Output: Animal is eating.
        d.sleep(); // Output: Dog is sleeping.
    }
}
