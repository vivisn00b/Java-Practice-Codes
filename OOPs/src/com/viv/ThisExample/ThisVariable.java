// 1. Using ‘this’ keyword to refer to current class instance variables

package OOPs.src.com.viv.ThisExample;



public class ThisVariable {
    int a;
    int b;

    // Parameterized constructor
    ThisVariable(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    void display()
    {
        // Displaying value of variables a and b
        System.out.println("a = " + a + "  b = " + b);
    }

    public static void main(String[] args)
    {
        ThisVariable object = new ThisVariable(10, 20);
        object.display();
    }
}
