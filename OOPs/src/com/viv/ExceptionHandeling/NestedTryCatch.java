package OOPs.src.com.viv.ExceptionHandeling;

public class NestedTryCatch {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try block");
            int[] arr = new int[2];
            try {
                arr[3] = 30;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: Array index out of bounds.");
                System.out.println(e);
            }
            int num = 10/0;
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: Cannot divide by zero.");
        }
        System.out.println("program continues normally after nested try catch");
    }
}
