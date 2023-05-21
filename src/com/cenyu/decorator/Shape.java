package com.cenyu.decorator;

public interface Shape {

    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("the draw method of the rectangle is called");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("the draw method of the circle is called");
    }
}

class RedColorDecorator extends ShapeDecorator {

    public RedColorDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        this.setColor("red");
    }

    public void setColor(String color) {
        System.out.println(color + " color is set");
    }
}

class BlueColorDecorator extends ShapeDecorator {

    public BlueColorDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        this.setColor("blue");
    }

    public void setColor(String color) {
        System.out.println(color + " color is set");
    }
}

class Demo {

    public static void main(String[] args) {
        RedColorDecorator redColorDecorator = new RedColorDecorator(new Rectangle());
        redColorDecorator.draw();
    }
}
