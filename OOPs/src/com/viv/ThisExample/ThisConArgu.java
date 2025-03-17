// 6. Using ‘this’ keyword as an argument in the constructor call

package OOPs.src.com.viv.ThisExample;

class A {
    B obj;
    String message= "hi";

    // Parameterized constructor with object of B as a parameter
    A(B obj)
    {
        this.obj = obj;

        // calling display method of class B
        obj.display(message);
    }
}

class B {
    int x = 5;

    // Default Constructor that create an object of A
    // with passing this as an argument in the constructor
    B() {
        A obj = new A(this);
    }

    // method to show value of x
    void display(String message)
    {
        System.out.println("Class A said: " + message);
        System.out.println("Value of x in Class B : " + x);
    }
}

public class ThisConArgu {
    public static void main(String[] args)
    {
        B obj = new B();
    }
}
