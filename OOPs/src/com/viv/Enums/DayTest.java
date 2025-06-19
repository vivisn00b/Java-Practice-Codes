package OOPs.src.com.viv.Enums;

public class DayTest {
    public static void main(String[] args) {
        Day monday = Day.MONDAY;
        //String string = monday.toString();
        int ordinal = monday.ordinal();
        System.out.println(ordinal);
        System.out.println(monday.name());
        Day enumDay = Day.valueOf("TUESDAY");
        System.out.println(enumDay);
        Day[] values = Day.values();
        //System.out.println(Day.values());
        for(Day i : values){
            System.out.println(i);
        }
    }
}
