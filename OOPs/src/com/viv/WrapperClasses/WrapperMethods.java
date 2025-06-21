package OOPs.src.com.viv.WrapperClasses;

public class WrapperMethods {
    public static void main(String[] args) {
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println("Parsed int: " + num);

        System.out.println("Max of 10 and 20: " + Integer.max(10, 20));
        System.out.println("Binary of 5: " + Integer.toBinaryString(5));
        System.out.println("compare: " + Integer.compare(10, 20)); // -1

        System.out.println("Is 'A' a letter? " + Character.isLetter('A'));
        System.out.println("isDigit: " + Character.isDigit('9')); // true
        System.out.println("isWhitespace: " + Character.isWhitespace(' ')); // true
        System.out.println("Lowercase of 'Z': " + Character.toLowerCase('Z'));

        Integer a = 100;
        Integer b = 100;
        System.out.println("a == b? " + (a == b));         // true (cached)
        System.out.println("a.equals(b)? " + a.equals(b)); // true
        Integer x = 200;
        Integer y = 200;
        // Works incorrectly outside -128 to 127 range
        System.out.println("x == y? " + (x == y));         // false
        System.out.println("x.equals(y)? " + x.equals(y)); // true

    }
}
