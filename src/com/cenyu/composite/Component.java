package com.cenyu.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {

    String name;

    public Component(String name) {
        this.name = name;
    }

    // Only the leaf nodes implement this method
    public abstract void show();

    // Only non-leaf nodes implement this method
    public abstract void add(Component component);

    // Only non-leaf nodes implement this method
    public abstract void delete(Component component);

    // Only non-leaf nodes implement this method
    public abstract List<Component> getChildren();
}

class NonLeaf extends Component {

    List<Component> components = new ArrayList<>();

    public NonLeaf(String name) {
        super(name);
    }

    @Override
    public void show() {
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void delete(Component component) {
        components.remove(component);
    }

    @Override
    public List<Component> getChildren() {
        return components;
    }
}

class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println("leaf node's name = " + name);
    }

    @Override
    public void add(Component component) {
    }

    @Override
    public void delete(Component component) {
    }

    @Override
    public List<Component> getChildren() {
        return null;
    }
}

class Demo {

    public static void main(String[] args) {
        NonLeaf root = new NonLeaf("root");
        Leaf leaf1 = new Leaf("leaf1");
        Leaf leaf2 = new Leaf("leaf2");
        root.add(leaf1);
        root.add(leaf2);
        List<Component> children = root.getChildren();
        for (Component child : children) {
            System.out.println(child.name);
        }
        System.out.println("============");
        leaf1.show();
        leaf2.show();
        System.out.println("============");
        root.delete(leaf1);
        children = root.getChildren();
        for (Component child : children) {
            System.out.println(child.name);
        }
        System.out.println("============");
        root.delete(leaf2);
        children = root.getChildren();
        for (Component child : children) {
            System.out.println(child.name);
        }
    }
}
