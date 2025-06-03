// Binding the data members and methods into a single unit is called encapsulation.
// Encapsulation is used to hide the implementation part and show the functionality for better readability and usability.

package OOPs.src.com.viv.ENCAPSULATION;

class Programmer {
    private String name;

    // Setter method to set data
    public void setName(String name)
    {
        this.name = name;
    }
    // Getter method to get data
    public String getName()
    {
        return name;
    }
}
public class EncapEx {
    public static void main(String[] args) {
        Programmer prog = new Programmer();
        prog.setName("viv");
        System.out.println("Programmer name: " + prog.getName());
    }
}
