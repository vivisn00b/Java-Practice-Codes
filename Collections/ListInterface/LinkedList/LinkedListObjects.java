package Collections.ListInterface.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class LinkedListObjects {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 22));
        students.add(new Student("Charlie", 21));

        students.forEach(System.out::println);

        // Using iterator
        Iterator<Student> it = students.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
}
