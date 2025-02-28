package OOPs.src.com.viv.TypesOfClasses;
import java.util.*;

// A static class has only static members.
// An object cannot be created for a static class.

class staticClass {
    static int s;
    static void met(int x, int y)
    {
        System.out.print("static method to calculate sum of ");
        s = x + y;
        System.out.println(x + "+" + y);
    }
    static class NestedClass {
        static
        {
            System.out.println("static block inside a static class");
        }
        public void disp()
        {
            int x1;
            int y1;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter two numbers:");
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            met(x1, y1);
            System.out.println("Sum of the 2 numbers: " + s);
        }
    }
}

class testClass {
    public static void main(String args[]) {
        //staticClass obj = new staticClass();
        staticClass.met(10,20);
        staticClass.NestedClass nestedclass = new staticClass.NestedClass();
        nestedclass.disp();
    }
}
