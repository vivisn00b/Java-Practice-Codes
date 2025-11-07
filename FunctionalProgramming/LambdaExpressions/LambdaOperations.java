package FunctionalProgramming.LambdaExpressions;

@FunctionalInterface
interface Functional {
//    int operation(int a, int b);
    void operation(int a, int b);
}

public class LambdaOperations {
    public static void main(String[] args) {
//        Functional add = (a, b) -> a+b;
//        Functional multiply = (a, b) -> (a*b);
//        System.out.println(add.operation(6, 3));
//        System.out.println(multiply.operation(5, 5));
        Functional add = (a, b) -> System.out.println("Sum: " + (a+b));
        add.operation(5, 9);
    }
}
