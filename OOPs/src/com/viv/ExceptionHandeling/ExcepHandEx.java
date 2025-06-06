package OOPs.src.com.viv.ExceptionHandeling;

import java.util.Scanner;

public class ExcepHandEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter numerator: ");
            int numerator = sc.nextInt();
            System.out.println("Enter denominator: ");
            int denominator = sc.nextInt();
            int result = numerator/denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("ERROR: Division by 0 is not allowed!");
            System.out.println(e);
        } catch (Exception e) { // Cannot use this block at first as ArithmeticException is a subclass of Exception, and catch blocks work from top to bottom.
            System.out.println(" Error: Invalid input.");
            System.out.println(e);
        } finally {
            System.out.println("✅ Program ended. Closing resources...");
            sc.close();  // Clean up
        }
    }
}
