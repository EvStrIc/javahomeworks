package com.company;

import com.company.tasks.Calculator;
import com.company.tasks.HelloWorld;
import com.company.tasks.Squares;
import com.company.tasks.XOXO;

public class Main {

    public static void main(String[] args) {
        //HelloWorld write = new HelloWorld();
        //System.out.println(write.getHello());

        //Calculator operation = new Calculator();
        //System.out.println(operation.Calc());

        //Squares figureSqr = new Squares();
        //System.out.println(figureSqr.Sqr());

        new XOXO().game();
    }
}
