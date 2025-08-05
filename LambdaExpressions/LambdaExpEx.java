// It represents the instances of functional interfaces (interfaces with a single abstract method).

package LambdaExpressions;

interface FunInterface {
    void asbstractFun(int x);

    default void normalFun() {
        System.out.println("Inside functional interface");
    }
}

public class LambdaExpEx {
    public static void main(String[] args) {
        FunInterface obj = (int x) -> System.out.println(2*x);
        obj.asbstractFun(5);
    }
}
