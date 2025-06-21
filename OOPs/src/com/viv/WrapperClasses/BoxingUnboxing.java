package OOPs.src.com.viv.WrapperClasses;

public class BoxingUnboxing {
    public static void main(String[] args) {
        // byte
        byte b = 10;
        Byte bObj = Byte.valueOf(b);         // Boxing
        byte bVal = bObj.byteValue();        // Unboxing
        System.out.println("byte: " + bVal);

        // short
        short s = 20;
        Short sObj = Short.valueOf(s);
        short sVal = sObj.shortValue();
        System.out.println("short: " + sVal);

        // int
        int i = 30;
        Integer iObj = Integer.valueOf(i);
        //Integer iObj = new Integer(i); // This is deprecated
        int iVal = iObj.intValue();
        System.out.println("int: " + iVal);

        // long
        long l = 100L;
        Long lObj = Long.valueOf(l);
        long lVal = lObj.longValue();
        System.out.println("long: " + lVal);

        // float
        float f = 10.5f;
        Float fObj = Float.valueOf(f);
        float fVal = fObj.floatValue();
        System.out.println("float: " + fVal);

        // double
        double d = 99.99;
        Double dObj = Double.valueOf(d);
        double dVal = dObj.doubleValue();
        System.out.println("double: " + dVal);

        // char
        char c = 'A';
        Character cObj = Character.valueOf(c);
        char cVal = cObj.charValue();
        System.out.println("char: " + cVal);

        // boolean
        boolean bool = true;
        Boolean boolObj = Boolean.valueOf(bool);
        boolean boolVal = boolObj.booleanValue();
        System.out.println("boolean: " + boolVal);
    }
}
