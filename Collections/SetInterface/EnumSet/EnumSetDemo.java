// Extends the AbstractSet class and implements the Set Interface in Java
// It is not synchronized
// does not allow null Objects and throws NullPointerException
// It uses a fail-safe iterator, so it won’t throw ConcurrentModificationException if the collection is modified while iterating

package Collections.SetInterface.EnumSet;

import OOPs.src.com.viv.Enums.Day;

import java.util.EnumSet;

enum Days { MON, TUE, WED, THU, FRI, SAT, SUN }


public class EnumSetDemo {
    public static void main(String[] args) {
        EnumSet<Days> workDays = EnumSet.range(Days.MON, Days.FRI);
        EnumSet<Days> weekend = EnumSet.of(Days.SAT, Days.SUN);

        System.out.println("Work days: " + workDays); // [MON, TUE, WED, THU, FRI]
        System.out.println("Weekend: " + weekend);    // [SAT, SUN]

        // Complement of workDays: days not in workDays
        EnumSet<Days> notWorkDays = EnumSet.complementOf(workDays);
        System.out.println("Complement of work days: " + notWorkDays);

        // Add an element
        workDays.add(Days.SAT);
        System.out.println("After adding SAT: " + workDays);

        // Remove element
        workDays.remove(Days.MON);
        System.out.println("After removing MON: " + workDays);

        // Contains/size
        System.out.println("Contains WED? " + workDays.contains(Days.WED));
        System.out.println("Size: " + workDays.size());

        // Iteration
        for (Days d : workDays) {
            System.out.println("Day: " + d);
        }

        // allOf: Create a set with all enum values
        EnumSet<Days> allDays = EnumSet.allOf(Days.class);
        System.out.println("allOf: " + allDays);

        // noneOf: Empty EnumSet
        EnumSet<Days> emptySet = EnumSet.noneOf(Days.class);
        System.out.println("noneOf: " + emptySet);

        // of: Set with selected values
        EnumSet<Days> weeknd = EnumSet.of(Days.SAT, Days.SUN);
        System.out.println("of: " + weeknd);

        // range: Set from MON to FRI
        EnumSet<Days> workdays = EnumSet.range(Days.MON, Days.FRI);
        System.out.println("range: " + workdays);

        // complementOf: Days not in workdays
        EnumSet<Days> notWorkdays = EnumSet.complementOf(workdays);
        System.out.println("complementOf: " + notWorkdays);

        // addAll: Adding multiple elements
        emptySet.addAll(weeknd);
        System.out.println("addAll: " + emptySet);

        // removeAll: Removing multiple elements
        workdays.removeAll(EnumSet.of(Days.FRI, Days.THU));
        System.out.println("removeAll: " + workdays);

        // retainAll: Keep only elements also in weekend
        allDays.retainAll(weeknd);
        System.out.println("retainAll: " + allDays);

        // containsAll
        System.out.println("containsAll (of MON, TUE)? " + workdays.containsAll(EnumSet.of(Days.TUE, Days.MON)));
    }
}
