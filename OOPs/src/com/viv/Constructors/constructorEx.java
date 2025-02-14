package com.viv.Constructors;

import java.io.*;

public class constructorEx {
    // Constructor
    private constructorEx()
    {
        //super();
        System.out.println("Constructor Called");
    }

    // main function
    public static void main(String[] args)
    {
        constructorEx con = new constructorEx();
    }
}