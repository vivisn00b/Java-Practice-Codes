package Collections.ListInterface.Arraylists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayLists {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.getClass().getName());

        List<String> list1 = Arrays.asList("Sunday", "Tuesday");
        System.out.println(list1.getClass().getName());
        list1.set(0, "Monday");
        System.out.println(list1.getFirst());

        String[] array = {"Apple", "Banana", "Mango"};
        List<String> list2 = Arrays.asList(array);     //creates fixed size list
        System.out.println(list2.getClass().getName());
        //list2.add("Cherry");     //does not support add() and remove()
        //list2.set(1, "Cherry");    //allows modification of existing element using set()

        // to make a modifiable list
        List<String> list3 = new ArrayList<>(list2);

        List<String> list4 = List.of("1", "2", "2", "3"); //unmodifiable list
        list.addAll(list4);
        //list4.addAll(list1);    //can't do it as list 4 is an unmodifiable list

        List<Integer> list5 = new ArrayList<>();
        list5.add(1);
        list5.add(20);
        list5.add(5);
        list5.remove(Integer.valueOf(20));     //to remove by object
                                                //paid courses won't tell u this lol

        Integer[] array5 = list5.toArray(new Integer[0]);   //converts a list to an array
        //System.out.println(array5);
        System.out.println(Arrays.toString(array5));
        // Print in int form
        for (int num : array5) {
            System.out.println(num);
        }
    }
}
