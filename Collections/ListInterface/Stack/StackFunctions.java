package Collections.ListInterface.Stack;

import java.util.Stack;

class StackedBook {
    String title;
    StackedBook(String title) { this.title = title; }
    @Override
    public String toString() {
        return "StackedBook{" + title + "}";
    }
}

public class StackFunctions {
    public static void main(String[] args) {
        // 1. Create a Stack of Integers
        Stack<Integer> stack = new Stack<>();

        // 2. Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Stack after pushes: " + stack);

        // 3. Peek at the top
        System.out.println("Top element (peek): " + stack.peek());

        // 4. Pop elements
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // 5. Search elements (position from TOP, 1-based)
        System.out.println("Search 20: " + stack.search(20)); // should return 2
        System.out.println("Search 100: " + stack.search(100)); // not found (-1)

        // 6. Check if stack is empty
        System.out.println("Is stack empty? " + stack.empty());

        // 7. Iterate using for-each
        System.out.print("Iterating using for-each: ");
        for (Integer num : stack) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 8. Iterate by popping (LIFO)
        System.out.print("Iterating using pop: ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        // 9. Stack with objects (Book class)
        Stack<Book> bookStack = new Stack<>();
        bookStack.push(new Book("Java"));
        bookStack.push(new Book("Python"));
        bookStack.push(new Book("C++"));

        System.out.println("Book stack: " + bookStack);

        // Popping books one by one
        while (!bookStack.empty()) {
            System.out.println("Reading and removing: " + bookStack.pop());
        }

        // 10. Check empty again
        System.out.println("Book stack empty? " + bookStack.empty());
    }
}
