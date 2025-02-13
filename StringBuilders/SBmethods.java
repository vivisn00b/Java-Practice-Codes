package StringBuilders;

public class SBmethods {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder("Hi! I'm Viv. It's nice to meet you.");
        // sb.ensureCapacity(200);
        System.out.println("Initial StringBuilder: " + sb);

        sb.append(" I'm a coder");
        System.out.println("After append: " + sb);

        sb.insert(3, "Hola!! ");
        System.out.println("After insert: " + sb);

        sb.replace(0, 2, "Heyyyyy!");
        System.out.println("After replace: " + sb);

        sb.delete(3, 7);
        System.out.println("After delete: " + sb);

        sb.reverse();
        System.out.println("After reverse: " + sb);

        int capacity = sb.capacity();
        System.out.println("Current capacity: " + capacity);

        int length = sb.length();
        System.out.println("Current length: " + length);

        char charAt5 = sb.charAt(5);
        System.out.println("Character at index 5: " + charAt5);

        sb.setCharAt(5, 'X');
        System.out.println("After setCharAt: " + sb);

        String substring = sb.substring(5, 10);
        System.out.println("Substring (5 to 10): " + substring);

        sb.reverse();
        int index = sb.indexOf("Viv");
        System.out.println("Index of 'Viv': " + index);

        int lastIndex = sb.lastIndexOf("y");
        System.out.println("Index of 'y': " + lastIndex);

        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt: " + sb);

        String result = sb.toString();
        System.out.println("Final String: " + result);
    }
}
