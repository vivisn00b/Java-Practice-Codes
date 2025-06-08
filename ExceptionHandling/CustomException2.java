// Extend the RuntimeException class (for unchecked exceptions).

package ExceptionHandling;

class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String msg) {
        super(msg);
    }
}

//class Bank {
//    public static void deposit(int amount) {
//        if (amount < 0)
//            throw new NegativeAmountException("Amount cannot be negative!");
//        else
//            System.out.println("Deposited: ₹"+amount);
//    }
//}

class Bank { //Using throws keyword
    public static void deposit(int amount) throws NegativeAmountException {
        if (amount < 0)
            throw new NegativeAmountException("Amount cannot be negative!");
        else
            System.out.println("Deposited: ₹"+amount);
    }
}

public class CustomException2 {
    public static void main(String[] args) {
        Bank.deposit(100);
        Bank.deposit(-100);
    }
}
