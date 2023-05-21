package com.cenyu.builder;

public class Director {

    public void build(Builder builder) {
        builder.buildA();
        builder.buildB();
    }
}

interface Builder {

    void buildA();
    void buildB();
    Product getProduct();
}

class ConcreteBuilder1 implements Builder {

    private Product product = new Product();

    @Override
    public void buildA() {
        product.setPartA("carbon fiber");
        System.out.println("A is made of carbon fiber");
    }

    @Override
    public void buildB() {
        product.setPartB("carbon fiber");
        System.out.println("B is made of carbon fiber");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

class ConcreteBuilder2 implements Builder {

    private Product product = new Product();

    @Override
    public void buildA() {
        product.setPartA("gold");
        System.out.println("A is made of gold");
    }

    @Override
    public void buildB() {
        product.setPartB("gold");
        System.out.println("B is made of gold");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

class Product {

    private String partA;
    private String partB;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void show() {
        System.out.println("partA: " + partA + ", partB: " + partB);
    }
}

class Demo {

    public static void main(String[] args) {
        Director director = new Director();
        ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();
        director.build(concreteBuilder1);
        Product product1 = concreteBuilder1.getProduct();
        product1.show();

        System.out.println("==================");

        ConcreteBuilder2 concreteBuilder2 = new ConcreteBuilder2();
        director.build(concreteBuilder2);
        Product product2 = concreteBuilder2.getProduct();
        product2.show();
    }
}
