package OOPs.src.com.viv.Enums;

public enum Day2 {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday");

    public String lower;

    private Day2(String lower) {
        this.lower = lower;
    }

    public void display() {
        System.out.println("Today is " + this.name());
    }
}