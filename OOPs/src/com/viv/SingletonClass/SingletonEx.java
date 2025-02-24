// A singleton class is one that has just one object at any one moment.
// when new instance is created, it refers to the previous one

package OOPs.src.com.viv.SingletonClass;

import java.lang.*;

public class SingletonEx {
    private static SingletonEx single_instance = null;

    public String s;
    public int count=0;

    private SingletonEx()
    {
        s = "Object is created: ";
        count++;
    }

    // Creating a static function that returns the singleton class’s object (using lazy initialization).
    public static SingletonEx SingletonEx()
    {
        if (single_instance == null) {
            single_instance = new SingletonEx();
        }
        return single_instance;
    }
}

class SingletonTest {
    public static void main(String args[])
    {
        SingletonEx x = SingletonEx.SingletonEx();
        SingletonEx y = SingletonEx.SingletonEx();

        // change var of x
        x.s = (x.s).toUpperCase();

        System.out.println("String from x is -->" + x.s + x.count);
        System.out.println("String from y is -->" + y.s + y.count);
        System.out.println("\n");

        y.s = (y.s).toLowerCase();

        System.out.println("String from x is -->" + x.s + x.count);
        System.out.println("String from y is -->" + y.s + y.count);
    }
}
