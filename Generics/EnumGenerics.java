package Generics;

enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        switch (this) {
            case ADD -> {
                return a.doubleValue() + b.doubleValue();
            }
            case SUBTRACT -> {
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

// While we can’t define a generic type parameter at the enum declaration level because enums can’t be generic themselves
// We can achieve a similar effect by using an enum with a generic class or by adding a generic interface.
interface Calculator<T> {
    T calculate(T a, T b);
}

enum ArithmeticOperation implements Calculator<Integer> {
    ADD {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public Integer calculate(Integer a, Integer b) {
            return a - b;
        }
    };
}

public class EnumGenerics {
    public static void main(String[] args) {
        double result1 = Operation.ADD.apply(10, 20);
        double result2 = Operation.MULTIPLY.apply(5, 4);
        System.out.println(result1);
        System.out.println(result2);

        int resultAdd = ArithmeticOperation.ADD.calculate(10, 5);
        int resultSub = ArithmeticOperation.SUBTRACT.calculate(10, 5);
        System.out.println(resultAdd);
        System.out.println(resultSub);
    }
}
