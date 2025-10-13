// Stack is a linear data structure that follows the Last In First Out (LIFO) principle.
// Internally, it extends the Vector class.

package Collections.ListInterface.Stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // Add elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);
        System.out.println("Popped: " + stack.pop()); // removes and returns the top element
        System.out.println("Now stack: " + stack);
        System.out.println("Top element: " + stack.peek()); // looks at the top element without removing.
        Stack<String> searchStack = new Stack<>();
        searchStack.push("Dog");
        searchStack.push("Cat");
        searchStack.push("Tiger");
        System.out.println(searchStack.search("Cat"));   // 2 (1-based position from top)
        System.out.println(searchStack.search("Dog"));   // 3
        System.out.println(searchStack.search("Lion"));  // -1 (not found)
        System.out.println("Using for-each:");
        for (String animal : searchStack) {
            System.out.print(animal + " ");
        }
        System.out.println("\nUsing while pop:");
        while (!searchStack.empty()) {
            System.out.print(searchStack.pop() + " ");
        }
    }
}
