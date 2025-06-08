package ExceptionHandling;

import java.util.Scanner;
public class ThrowEx {
    public static void checkAge(int age) {
        if (age<18)
            throw new ArithmeticException("NOT ELIGIBLE to vote!");
        else
            System.out.println("ELIGIBLE to vote!");
    }

    public static void checkSeniorCitizen(int age) {
        try {
            if (age>=60)
                System.out.println("SENIOR CITIZEN!");
            else
                throw new RuntimeException("NOT senior citizen!");
                //System.out.println("NOT a senior citizen!");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age: ");

        try {
            int age = sc.nextInt();
            checkSeniorCitizen(age);
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
            //System.out.println("Exception caught: " + e);
        }

        try {
            checkAge(16);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
            //System.out.println("Exception caught: " + e);
        }
    }
}
