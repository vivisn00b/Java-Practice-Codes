package OOPs.src.com.viv.WrapperClasses;

public class WrapperClassEx {
    public static void main(String[] args)
    {
        byte a = 1;
        // wrapping around Byte object (use valueOf or autoboxing)
        Byte byteobj = Byte.valueOf(a);

        int b = 10;
        // wrapping around Integer object (use valueOf or autoboxing)
        Integer intobj = Integer.valueOf(b);

        float c = 18.6f;
        // wrapping around Float object (use valueOf or autoboxing)
        Float floatobj = Float.valueOf(c);

        double d = 250.5;
        // Wrapping around Double object (use valueOf or autoboxing)
        Double doubleobj = Double.valueOf(d);

        char e = 'a';
        // wrapping around Character object (autoboxing)
        Character charobj = e;

        System.out.println("Values of Wrapper objects (printing as objects)");
        System.out.println("\nByte object byteobj: " + byteobj);
        System.out.println("\nInteger object intobj: " + intobj);
        System.out.println("\nFloat object floatobj: " + floatobj);
        System.out.println("\nDouble object doubleobj: " + doubleobj);
        System.out.println("\nCharacter object charobj: " + charobj);

        // objects to data types (retrieving data types from objects)
        // unwrapping objects to primitive data types
        byte bv = byteobj;
        int iv = intobj;
        float fv = floatobj;
        double dv = doubleobj;
        char cv = charobj;

        System.out.println("\nUnwrapped values (printing as data types)");
        System.out.println("\nbyte value, bv: " + bv);
        System.out.println("\nint value, iv: " + iv);
        System.out.println("\nfloat value, fv: " + fv);
        System.out.println("\ndouble value, dv: " + dv);
        System.out.println("\nchar value, cv: " + cv);
    }
}
