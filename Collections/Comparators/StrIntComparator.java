package Collections.Comparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class CompareStrings implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();  // ascending order of string length
        //return (int) o1.charAt(0) - (int) o2.charAt(0);  // ascending order of alphabetical order
    }
}

class CompareIntegers implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;  // ascending order
        //return o2 - o1;  // descending order
    }
}

public class StrIntComparator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(6);
        //list.sort(null);
        list.sort(new CompareIntegers());
        System.out.println(list);

        List<String> words = Arrays.asList("banana", "apple", "date");
        words.sort(new CompareStrings());
        System.out.println(words);
    }
}