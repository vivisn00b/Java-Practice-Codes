package OOPs.src.com.viv.WrapperClasses;

public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        // byte
        byte b = 10;
        Byte bObj = b;            // Autoboxing
        byte bVal = bObj;         // Auto-unboxing
        System.out.println("byte: " + bVal);

        // short
        short s = 20;
        Short sObj = s;
        short sVal = sObj;
        System.out.println("short: " + sVal);

        // int
        int i = 30;
        Integer iObj = i;
        int iVal = iObj;
        System.out.println("int: " + iVal);

        // long
        long l = 100L;
        Long lObj = l;
        long lVal = lObj;
        System.out.println("long: " + lVal);

        // float
        float f = 10.5f;
        Float fObj = f;
        float fVal = fObj;
        System.out.println("float: " + fVal);

        // double
        double d = 99.99;
        Double dObj = d;
        double dVal = dObj;
        System.out.println("double: " + dVal);

        // char
        char c = 'A';
        Character cObj = c;
        char cVal = cObj;
        System.out.println("char: " + cVal);

        // boolean
        boolean bool = true;
        Boolean boolObj = bool;
        boolean boolVal = boolObj;
        System.out.println("boolean: " + boolVal);
    }
}
