package Collections.Comparable;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

// implement the Comparable<Student> interface and override the compareTo method, defining natural ordering based on one or more fields
class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa  = gpa;
    }

    public String getName() { return name; }
    public double getGpa()  { return gpa; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(gpa, student.gpa) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(o.getGpa(), this.getGpa());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Charlie", 3.5));
        list.add(new Student("Bob", 3.7));
        list.add(new Student("Alice", 3.5));
        list.add(new Student("Akshit", 3.9));
        list.sort(null);
        System.out.println(list);
        for (Student s : list)
            System.out.println(s.getName() + " : " + s.getGpa());
    }
}

// Comparable: Used when a class has a single, natural ordering (for example, Integer, String). Implementing Comparable makes objects of the class comparable to each other by default.
//             Placed inside the class that needs ordering.
//
// Comparator: Used to define alternative or multiple orderings without changing the class; supplied externally when sorting or comparing.
//             Implemented in a separate class, as an anonymous class, or as a lambda.