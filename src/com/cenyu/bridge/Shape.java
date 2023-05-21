package com.cenyu.bridge;

public abstract class Shape {

    Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        this.color.showColor("circle");
    }
}

class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        this.color.showColor("square");
    }
}

interface Color {

    void showColor(String type);
}

class Red implements Color {

    @Override
    public void showColor(String type) {
        System.out.println("red " + type);
    }
}

class Blue implements Color {

    @Override
    public void showColor(String type) {
        System.out.println("blue " + type);
    }
}

class Demo {

    public static void main(String[] args) {
        Circle redCircle = new Circle(new Red());
        redCircle.draw();
        Square blueSquare = new Square(new Blue());
        blueSquare.draw();
    }
}
