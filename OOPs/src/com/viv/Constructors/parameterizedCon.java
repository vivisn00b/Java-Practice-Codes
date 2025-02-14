package com.viv.Constructors;

public class parameterizedCon {
    String name;
    int age;

    parameterizedCon(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class person {
    public static void main(String[] args) {
        parameterizedCon con = new parameterizedCon("Viv", 21);
        System.out.println("Name: " + con.name);
        System.out.println("Age: " + con.age);
    }
}