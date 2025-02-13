package StringBuffers;

public class StrBufferMethods {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" guys!!");
        System.out.println(sb);

        sb.insert(0, "Java ");
        System.out.println(sb);

        sb.replace(1, 3, "Java");
        System.out.println(sb);

        sb.delete(0, 7);
        System.out.println(sb);

        sb.deleteCharAt(7);
        System.out.println(sb);

        System.out.println("charAt method return:" + sb.charAt(0));

        sb.reverse();
        System.out.println(sb);

        int len = sb.length();
        System.out.println("Length of string: " + len);

        StringBuffer str = new StringBuffer();
        // default 16
        System.out.println(str.capacity());
        sb.append("Hello");
        // now 16
        System.out.println(str.capacity());
        sb.append("java is my favourite language");
        // (oldcapacity*2)+2
        System.out.println(str.capacity());

        System.out.println("Index of 'java': " + sb.indexOf("java"));
        System.out.println("Last index of 'a': " + sb.lastIndexOf("a"));

        System.out.println("SubSequence = " + sb.substring(5));

        sb.setCharAt(7, '0');
        System.out.println("After setCharAt() String = " + sb.toString());

        System.out.println("Variable type:" + sb.getClass().getName());
        System.out.println("Variable type after toString():" + sb.toString().getClass().getName());
    }
}
