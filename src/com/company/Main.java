package com.company;

import com.company.tasks.HelloWorld;

public class Main {

    public static void main(String[] args) {
        HelloWorld write = new HelloWorld();
        System.out.println(write.getHello());
    }
}
