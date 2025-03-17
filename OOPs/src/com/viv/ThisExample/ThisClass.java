// 3. Using ‘this’ keyword to return the current class instance

package OOPs.src.com.viv.ThisExample;

class Test {
    int a;
    int b;

    // Default constructor
    Test()
    {
        a = 10;
        b = 20;
    }

    // Method that returns current class instance
    Test get() { return this; }

    // Displaying value of variables a and b
    void display()
    {
        System.out.println("a = " + a + "  b = " + b);
    }
}

public class ThisClass {
    public static void main(String[] args)
    {
        Test object = new Test();
        object.get().display();
    }
}
