// One class serves as a superclass (base class) for more than one subclass.

package OOPs.src.com.viv.INHERITANCE;

class hierarchicalInherit {
    String message = "Hello from Parent class!";

    // Method in the parent class
    public void showMessage() {
        System.out.println(message);
    }
}

// Child class 1 inheriting from hierarchicalInherit
class childClass1 extends hierarchicalInherit {
    String child1Message = "Hello from Child Class 1!";

    // Method in the first child class
    public void showChild1Message() {
        System.out.println(child1Message);
    }
}

// Child class 2 inheriting from hierarchicalInherit
class childClass2 extends hierarchicalInherit {
    String child2Message = "Hello from Child Class 2!";

    // Method in the second child class
    public void showChild2Message() {
        System.out.println(child2Message);
    }
}

// Main class to test hierarchical inheritance
class TestClass {
    public static void main(String[] args) {
        childClass1 obj1 = new childClass1(); // Creating object of first child class
        childClass2 obj2 = new childClass2(); // Creating object of second child class

        // Calling parent class method from both child objects
        obj1.showMessage();
        obj1.showChild1Message();

        obj2.showMessage();
        obj2.showChild2Message();
    }
}