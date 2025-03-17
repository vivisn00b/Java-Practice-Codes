// 4. Using ‘this’ keyword as a method parameter

package OOPs.src.com.viv.ThisExample;

public class ThisMethod {
    int a;
    int b;

    // Default constructor
    ThisMethod()
    {
        a = 10;
        b = 20;
    }

    // Method that receives 'this' keyword as parameter
    void display(ThisMethod obj)
    {
        System.out.println("a = " + obj.a
                + "  b = " + obj.b);
    }

    // Method that returns current class instance
    void get() { display(this); }

    // main function
    public static void main(String[] args)
    {
        ThisMethod object = new ThisMethod();
        object.get();
    }
}
