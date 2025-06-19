package OOPs.src.com.viv.Enums;

public class DayTest2 {
    public static void main(String[] args) {
        Day2 tues = Day2.TUESDAY;
        Day2 wed = Day2.WEDNESDAY;
        Day2 day = Day2.SUNDAY;
        tues.display();
        System.out.println(wed.lower);
//        switch (day){
//            case SUNDAY -> System.out.println("HOLIDAY!!");
//            case MONDAY -> System.out.println("Work Day :(");
//            default -> throw new IllegalStateException("Unexpected value: " + day);
//        }
        String res = switch (day) {
            case SUNDAY -> "S";
            case MONDAY -> "M";
            case TUESDAY -> "T";
            case WEDNESDAY -> "W";
            case THURSDAY -> null;
            case FRIDAY -> null;
            case SATURDAY -> null;
        };
    }
}
