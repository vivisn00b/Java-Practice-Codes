package com.viv.Packages;

// import static com.viv.javaPackages.greetings.*;
import static com.viv.javaPackages.greetings.Greetings;  // static import
import com.viv.javaPackages.name;

public class packageEx {
    public static void main(String[] args) {
        Greetings();

        String s = "Viv";
        name obj = new name();
        obj.greet(s);
    }
}
