// It represents the instances of functional interfaces (interfaces with a single abstract method).
// https://devcookies.medium.com/a-complete-guide-to-lambda-expressions-in-java-0aea2e1cea42

package LambdaExpressions;

interface FunInterface {
    //void abstractFun(int x);
    //void abstractFun(int x, int y);
    void abstractFun(String st);

    default void normalFun() {
        System.out.println("Inside functional interface");
    }
}

public class LambdaExpEx {
    public static void main(String[] args) {
//        FunInterface obj = (int x) -> System.out.println(2*x);
//        obj.abstractFun(5);
//        FunInterface obj = (int x, int y) -> System.out.println(x*y);
//        obj.abstractFun(5, 6);

        FunInterface obj = st -> {
            String message = "Hello, " + st + "!";
            System.out.println(message);
        };
        obj.abstractFun("Viv");
    }
}