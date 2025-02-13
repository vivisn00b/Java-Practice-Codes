// StringBuffer is a class in Java that represents a mutable sequence of characters.
// It provides an alternative to the immutable String class.
// It is Synchronized or thread-safe.

package StringBuffers;

public class StrBufferEx {
    public static void main(String[] args){
        StringBuffer s = new StringBuffer();
        s.append("Hello");
        s.append(" ");
        s.append("world");
        String str = s.toString();
        System.out.println(str);
    }
}
