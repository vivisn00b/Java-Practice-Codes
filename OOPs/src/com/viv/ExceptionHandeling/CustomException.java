// User-Defined Custom Exception or custom exception is creating our own exception class
// and throwing that exception using the "throw" keyword.

// Extend the Exception class (for checked exceptions)

package OOPs.src.com.viv.ExceptionHandeling;

class AgeTooSmallException extends Exception {
    public AgeTooSmallException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void checkAge(int age) throws AgeTooSmallException {
        if (age<18) {
            throw new AgeTooSmallException("Age must be 18 or above");
        } else
            System.out.println("You're eligible!");
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (AgeTooSmallException e) {
            System.out.println(e.getMessage());
        }
    }
}
