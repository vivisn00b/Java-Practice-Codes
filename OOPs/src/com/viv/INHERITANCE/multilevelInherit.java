// A derived class will be inheriting a base class.
// The derived class also acts as the base class for other classes.

package OOPs.src.com.viv.INHERITANCE;

// Parent class (Base Class)
class parent {
    String message = "Hello from Grandparent class!";
    public void showMessage() {
        System.out.println(message);
    }
}

// Child class (Intermediate Class) inheriting from multilevelInherit
class child extends parent {
    String childMessage = "Hello from Parent class!";
    public void showChildMessage() {
        System.out.println(childMessage);
    }
}

// Grandchild class (Derived Class) inheriting from childClass
class grandChild extends child {
    String grandChildMessage = "Hello from Child class!";
    public void showGrandChildMessage() {
        System.out.println(grandChildMessage);
    }
}

// Main class to test multilevel inheritance
public class multilevelInherit {
    public static void main(String[] args) {
        grandChild obj = new grandChild(); // Creating an object of grandChildClass
        obj.showMessage();           // Calling grandparent class method
        obj.showChildMessage();      // Calling parent class method
        obj.showGrandChildMessage(); // Calling grandchild class method
    }
}
