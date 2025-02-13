// StringBuilder in Java represents a mutable sequence of characters.
// StringBuilder is not thread-safe and should not be used in multi-threaded environments.
// If thread safety is required, it is recommended to use StringBuffer instead.

package StringBuilders;

public class stringBuilderEx {
    public static void main(String[] args) {
        // Creating a new StringBuilder object
        StringBuilder sb = new StringBuilder();
        // Appending strings
        sb.append("Hello");
        sb.append(" ");
        sb.append("World!");
        // Converting StringBuilder to String
        String result = sb.toString();
        System.out.println(result);  // Output: Hello World!
    }
}
