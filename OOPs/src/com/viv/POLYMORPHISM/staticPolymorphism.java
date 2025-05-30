// Compile-Time Polymorphism in Java is also known as static polymorphism and also known as method overloading.
// This happens when multiple methods in the same class have the same name but different parameters.

package OOPs.src.com.viv.POLYMORPHISM;

class Helper {
    static int Multiply(int a, int b)
    {
        return a*b;
    }
    static double Multiply(double a, double b)
    {
        return a * b;
    }
}
public class staticPolymorphism {
    public static void main(String[] args) {
        System.out.println(Helper.Multiply(2, 4));
        System.out.println(Helper.Multiply(5.5, 6.3));
    }
}
