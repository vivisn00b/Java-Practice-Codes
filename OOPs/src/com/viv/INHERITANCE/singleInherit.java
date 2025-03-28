// In single inheritance, a sub-class is derived from only one super class.
// It inherits the properties and behavior of a single-parent class.

package OOPs.src.com.viv.INHERITANCE;

public class singleInherit {
    String message = "Hello from Parent class!";

    // Method in the parent class
    public void showMessage() {
        System.out.println(message);
    }
}

class childClass extends singleInherit {
    String childMessage = "Hello from Child class!";

    // Method in the child class
    public void showChildMessage() {
        System.out.println(childMessage);
    }
}

class Test {
    public static void main(String[] args) {
        childClass obj = new childClass(); // Creating an object of childClass

        obj.showMessage();      // Calling parent class method
        obj.showChildMessage(); // Calling child class method
    }
}