package Generics;

enum Operation {
    ADD, SUBSTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        switch (this) {
            case ADD -> {
                return a.doubleValue() + b.doubleValue();
            }
            case SUBSTRACT -> {
                return a.doubleValue() - b.doubleValue();
            }
            case MULTIPLY -> {
                return a.doubleValue() * b.doubleValue();
            }
            case DIVIDE -> {
                return a.doubleValue() / b.doubleValue();
            }
            default -> throw new AssertionError("Unknown operation: " + this);
        }
    }
}

public class EnumGenerics {
    public static void main(String[] args) {
        double result1 = Operation.ADD.apply(10, 20);
        double result2 = Operation.MULTIPLY.apply(5, 4);
        System.out.println(result1);  // Output: 30.0
        System.out.println(result2);  // Output: 20.0
    }
}
