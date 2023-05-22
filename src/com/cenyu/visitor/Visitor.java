package com.cenyu.visitor;

public interface Visitor {

    Double visitKeyboard(Keyboard keyboard);
}

class VIP implements Visitor {

    @Override
    public Double visitKeyboard(Keyboard keyboard) {
        return keyboard.price * 0.8;
    }
}

class Common implements Visitor {

    @Override
    public Double visitKeyboard(Keyboard keyboard) {
        return keyboard.price * 0.9;
    }
}

/**
 * The abstract class ComputerPort, the visited, needs to
 * provide methods to receive visitors
 */
abstract class ComputerPart {

    String name;
    Double price;

    public ComputerPart(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public abstract Double accept(Visitor visitor);
}

class Keyboard extends ComputerPart {

    public Keyboard(String name, Double price) {
        super(name, price);
    }

    @Override
    public Double accept(Visitor visitor) {
        return visitor.visitKeyboard(this);
    }
}

class Demo {

    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard("Nuphy", 100.0);
        System.out.println("VIP: " + keyboard.accept(new VIP()));
        System.out.println("Common: " + keyboard.accept(new Common()));
    }
}
