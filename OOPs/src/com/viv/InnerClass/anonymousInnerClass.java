// Anonymous inner classes are declared without any name at all
// They can be created in two ways:
// 1. As a subclass of the specified type
// 2. As an implementer of the specified interface

//Example of 1
package OOPs.src.com.viv.InnerClass;

import java.util.*;

class anon {
    void show()
    {
        System.out.println("i am in show method of superclass");
    }
}

// Main class
class anonymousInnerClass {

    //  An anonymous class with "anon" as base class
    static anon a = new anon() {
        // Anonymous inner class overriding show method
        void show() {
            // Calling method show() via super keyword
            // which refers to parent class
            super.show();
            System.out.println("i am in a subclass's show method");
        }
    };

    public static void main(String[] args)
    {
        // Calling show() method inside main() method
        a.show();
    }
}