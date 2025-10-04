package Collections.MapInterface.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeAndEqualsMethod {
    public static void main(String[] args) {
        HashMap<Person, String> jobMap = new HashMap<>();
        Person p1 = new Person("Viv", 1);
        Person p2 = new Person("Alice", 2);
        Person p3 = new Person("Viv", 1);
        //System.out.println("p1 hashcode: " + p1.hashCode() + ", " + "p3 hashcode: " + p3.hashCode());
        //System.out.println("Same type? " + (p1.getClass() == p3.getClass()));  //true
        //System.out.println("Same memory address? " + (p1 == p3));  //false
        //System.out.println("p1 == p3? " + p1.equals(p3)); //true
        jobMap.put(p1, "Engineer");
        jobMap.put(p2, "Manager");
        jobMap.put(p3, "Consultant");
        System.out.println("HashMap Size: " + jobMap.size());
        System.out.println("p1 info: " + p1.getName() +", "+ "value for p1: " + jobMap.get(p1));
        System.out.println("p3 info: " + p3.getName() +", "+ "value for p3: " + jobMap.get(p3));

        Map<String, Integer> marksMap = new HashMap<>();
        marksMap.put("Shubham", 90); // hashcode1 --> index1
        marksMap.put("Neha", 92); // hashcode2 --> index2
        marksMap.put("Shubham", 99); // hashcode1 --> index1 --> equals() --> replace
    }
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    // To override it correctly, we must keep the same signature
    @Override
    public boolean equals(Object obj) {
        if (this == obj)  //Checks reference equality, if both references point to the exact same object in memory, no need to compare fields
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())  // Ensures both objects are of the exact same type
            return false;
        Person people = (Person) obj;  // To compare the fields of Person (like id and name) but since the compiler only knows obj is of type Object, we can’t directly call 'obj.getId()'
        return (id == people.getId()) && (Objects.equals(name, people.getName()));  // If both id and name match → return true
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name;
    }
}
