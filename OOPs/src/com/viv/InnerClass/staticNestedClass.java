// Static nested classes are not technically inner classes.
// They are like a static member of outer class.

package OOPs.src.com.viv.InnerClass;

import java.time.LocalDateTime;

// Outer class
class Outer {
    private static void outerMethod()
    {
        System.out.println("inside outerMethod");
    }

    // Static inner class
    static class Inner {
        public static void display()
        {
            System.out.println("inside inner class Method");
            outerMethod();
        }

        void timeDate()
        {
            LocalDateTime currentDateTime = LocalDateTime.now();
            System.out.println("Current Date and Time: " + currentDateTime);
        }
    }
}

public class staticNestedClass {
    public static void main(String[] args)
    {
        Outer.Inner.display(); // to call static nested class's static method

        Outer.Inner nestedClass = new Outer.Inner();
        nestedClass.timeDate(); // to call non-static method
    }
}