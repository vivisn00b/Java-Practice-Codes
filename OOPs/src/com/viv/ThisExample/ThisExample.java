// 'this’ is a reference variable that refers to the current object
//
// Methods to use ‘this’ in Java:
//
// Using the ‘this’ keyword to refer to current class instance variables.
// Using this() to invoke the current class constructor
// Using ‘this’ keyword to return the current class instance
// Using ‘this’ keyword as the method parameter
// Using ‘this’ keyword to invoke the current class method
// Using ‘this’ keyword as an argument in the constructor call

package OOPs.src.com.viv.ThisExample;

class ThisExample {
    int num;
    String name;

    // Constructor using 'this' to differentiate instance variables
    ThisExample(int num, String name) {
        this.num = num;
        this.name = name;
    }

    // Method using 'this' to call another method
    void display() {
        this.show(); // Calls show() method
        System.out.println("Number: " + this.num);
        System.out.println("Name: " + this.name);
    }

    void show() {
        System.out.println("Inside show() method.");
    }

    // Returning the current instance
    ThisExample getInstance() {
        return this;
    }

    // Passing 'this' as an argument
    void print(ThisExample obj) {
        System.out.println("Object reference passed successfully.");
    }

    void callPrint() {
        print(this);
    }

    public static void main(String[] args) {
        // Creating an object
        ThisExample obj = new ThisExample(10, "Java");

        // Calling methods
        obj.display();

        // Returning and using the current instance
        ThisExample returnedObj = obj.getInstance();
        System.out.println("Returned instance: " + returnedObj);

        // Passing 'this' as an argument
        obj.callPrint();
    }
}