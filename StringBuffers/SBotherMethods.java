package StringBuffers;

import java.util.*;

public class SBotherMethods {
    public static void main(String[] args){
        StringBuffer str = new StringBuffer("GitHub");
        str.append("Contribute");
        System.out.println("Capacity before applying trimToSize() = " + str.capacity());
        str.trimToSize();
        System.out.println("String = " + str.toString());
        System.out.println("Capacity after" + " applying trimToSize() = " + str.capacity());

        str.ensureCapacity(100);
        System.out.println("After ensureCapacity" + " method capacity = " + str.capacity());

        // appendCodePoint() method of StringBuffer class appends the string representation of the argument
        str.appendCodePoint(65);
        System.out.println("After appending CodePoint is = " + str);

        int unicode = str.codePointAt(10);
        System.out.println("Unicode of Character " + "at Position 10 " + "in StringBuffer = " + unicode);

        int unicode2 = str.codePointBefore(14);
        System.out.println("Unicode of character at position 13= " + unicode2);

        int codepoints = str.codePointCount(4, 10);
        System.out.println("No of Unicode code points between index 4 and index 10 = " + codepoints);

        char[] array = new char[25];
        // initialize all character to .(dot).
        Arrays.fill(array, '.');
        // get char from index 0 to 9
        // and store in array start index 5
        str.getChars(0, 9, array, 5);
        System.out.print("char array contains : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
        // get subSequence between index 0 to 7
        System.out.println("SubSequence = " + str.subSequence(0, 7));

        System.out.println("String length = " + str.length() + " and contains = " + str);
        // set length equal to 10
        str.setLength(10);
        System.out.println("After setLength() String = " + str.toString());
    }
}
