package Collections.ListInterface.Stack;

import java.util.Stack;

class Book {
    String title;
    Book(String title) { this.title = title; }
    public String toString() { return title; }
}

public class StackObjects {
    public static void main(String[] args) {
        Stack<Book> books = new Stack<>();
        books.push(new Book("Java"));
        books.push(new Book("Python"));
        books.push(new Book("C++"));

        while (!books.empty()) {
            System.out.println("Reading: " + books.pop());
        }
    }
}
