// 5. Using ‘this’ keyword to invoke the current class method

package OOPs.src.com.viv.ThisExample;

public class ThisClassMethod {
    void display()
    {
        // calling function show()
        this.show();

        System.out.println("Inside display function");
    }

    void show()
    {
        System.out.println("Inside show function");
    }

    public static void main(String args[])
    {
        ThisClassMethod t1 = new ThisClassMethod();
        t1.display();
    }
}
