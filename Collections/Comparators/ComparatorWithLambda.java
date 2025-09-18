package Collections.Comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() { return name; }

    public double getGpa() {
        return gpa;
    }
}

public class ComparatorWithLambda {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("pineapple");
        fruits.add("mango");
        fruits.sort((a, b) -> {
            return a.length() - b.length();
        });
        System.out.println(fruits);

        List<Integer> numbers = Arrays.asList(3, 2, 5, 1, 4);
        //numbers.sort(null);
        numbers.sort((x, y) -> y - x);  // descending order
        System.out.println(numbers);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie", 3.5));
        students.add(new Student("Bob", 3.7));
        students.add(new Student("Alice", 3.4));
        students.add(new Student("Viv", 3.9));
        students.add(new Student("Akitoshi", 3.9));
        //students.sort((s1, s2) -> (int) (s1.getGpa() - s2.getGpa()));  // The compare() method within the `java.util.Comparator` interface in Java returns an int so needs to be type cast to int.
        // Casting it to int loses precision
//        students.sort((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()));  // properly handles doubles
        // OR
//        students.sort((o1, o2) -> {
//            if (o2.getGpa() - o1.getGpa() > 0)
//                return 1;
//            else if (o2.getGpa() - o1.getGpa() < 0)
//                return -1;
//            else {
//                //return 0;
//                  return o1.getName().compareTo(o1.getName());  // for getting ascending order of names if they've similar gpa
//            }
//        });  // descending order but this won't compare names if someone got similar gpa like Viv and Akitoshi

        //Comparator<Student> compare = Comparator.comparing(Student::getGpa); //ascending order
        //Comparator<Student> compare = Comparator.comparing(Student::getGpa).reversed(); //descending order
        Comparator<Student> compare = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName); // descending order of gpa then ascending order of names
        students.sort(compare);
//        for (Student s : students) {
//            System.out.println(s.getName() + " : " + s.getGpa());
//        }
        students.forEach(s -> System.out.println(s.getName() + ": " + s.getGpa()));
    }
}
