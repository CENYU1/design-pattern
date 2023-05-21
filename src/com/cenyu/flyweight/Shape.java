package com.cenyu.flyweight;

import java.util.HashMap;
import java.util.Map;

public interface Shape {

    void show();
}

class ConcreteShape implements Shape {

    private String key;

    public ConcreteShape(String key) {
        System.out.println(key + " is created");
        this.key = key;
    }

    @Override
    public void show() {
        System.out.println("key: " + key + "'s method of show is called");
    }
}

class FlyWeightFactory {

    private Map<String, ConcreteShape> map = new HashMap<>();

    public Shape getObject(String key) {
        ConcreteShape concreteShape = map.get(key);
        if(concreteShape == null) {
            concreteShape = new ConcreteShape(key);
            map.put(key, concreteShape);
        } else {
            System.out.println("key: " + key + " is found in flyweight factory, no need to create");
        }
        return concreteShape;
    }
}

class Demo {

    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        factory.getObject("circle");
        factory.getObject("circle");
        factory.getObject("square");
        factory.getObject("square");
    }
}
