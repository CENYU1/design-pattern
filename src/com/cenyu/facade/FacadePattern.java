package com.cenyu.facade;

public class FacadePattern {

    public void autoCooking() {
        new FirstProcedure().boilWater();
        new SecondProcedure().washing();
        new ThirdProcedure().cutting();
        new FourthProcedure().cooking();
    }
}

class FirstProcedure {

    public void boilWater() {
        System.out.println("No1: boiling water");
    }
}

class SecondProcedure {

    public void washing() {
        System.out.println("No2: washing");
    }
}

class ThirdProcedure {

    public void cutting() {
        System.out.println("No3: cutting");
    }
}

class FourthProcedure {

    public void cooking() {
        System.out.println("No4: cooking");
    }
}

class Demo {

    public static void main(String[] args) {
        // before using facade pattern
        new FirstProcedure().boilWater();
        new SecondProcedure().washing();
        new ThirdProcedure().cutting();
        new FourthProcedure().cooking();

        System.out.println("==============");

        // after using facade pattern
        new FacadePattern().autoCooking();
    }
}
