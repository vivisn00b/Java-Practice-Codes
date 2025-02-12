package Strings;
import java.util.*;

public class StringMethods {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = "Java Programming";

        // 1. length()
        System.out.println("Length of str1: " + str1.length());

        // 2. charAt()
        System.out.println("Character at index 4 of str1: " + str1.charAt(4));

        // 3. compareTo()
        System.out.println("Compare str1 and str2: " + str1.compareTo(str2));

        // 4. compareToIgnoreCase()
        System.out.println("Compare str1 and str2 ignoring case: " + str1.compareToIgnoreCase("HELLO, WORLD!"));

        // 5. contains()
        System.out.println("Does str1 contain 'World': " + str1.contains("World"));

        // 6. endsWith()
        System.out.println("Does str1 end with 'World!': " + str1.endsWith("World!"));

        // 7. startsWith()
        System.out.println("Does str1 start with 'Hello': " + str1.startsWith("Hello"));

        // 8. equals()
        System.out.println("Does str1 equal str2: " + str1.equals(str2));

        // 9. equalsIgnoreCase()
        System.out.println("Does str1 equal 'hello, world!' ignoring case: " + str1.equalsIgnoreCase("hello, world!"));

        // 10. indexOf()
        System.out.println("Index of 'o' in str1: " + str1.indexOf('o'));

        // 11. lastIndexOf()
        System.out.println("Last index of 'o' in str1: " + str1.lastIndexOf('o'));

        // 12. isEmpty()
        System.out.println("Is str1 empty: " + str1.isEmpty());

        // 13. replace()
        System.out.println("Replace 'World' with 'Java' in str1: " + str1.replace("World", "Java"));

        // 14. substring()
        System.out.println("Substring of str1 from index 7: " + str1.substring(7));

        // 15. toLowerCase()
        System.out.println("str1 in lowercase: " + str1.toLowerCase());

        // 16. toUpperCase()
        System.out.println("str1 in uppercase: " + str1.toUpperCase());

        // 17. trim()
        String str3 = "   Hello, Java!   ";
        System.out.println("Trimmed str3: '" + str3.trim() + "'");

        // 18. split()
        String[] words = str1.split(" ");
        System.out.println("Split str1 into words: ");
        for (String word : words) {
            System.out.println(word);
        }

        // 19. valueOf()
        int num = 123;
        System.out.println("Integer as string: " + String.valueOf(num));

        // 20. concat()
        String str4 = " Welcome to ";
        System.out.println("Concatenated string: " + str4.concat("Java Programming"));
    }
}
