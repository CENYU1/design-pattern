package com.cenyu.strategy;

public interface Strategy {

    void show();
}

class StrategyA implements Strategy {

    @Override
    public void show() {
        System.out.println("buy one get one free");
    }
}

class StrategyB implements Strategy {

    @Override
    public void show() {
        System.out.println("20% off");
    }
}

class StrategyC implements Strategy {

    @Override
    public void show() {
        System.out.println("10% off");
    }
}

class Salesman {

    private Strategy strategy;

    public Salesman(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void salesManShow() {
        strategy.show();
    }
}

class Demo {

    public static void main(String[] args) {
        Salesman salesman = new Salesman(new StrategyA());
        salesman.salesManShow();
        System.out.println("===========");
        salesman.setStrategy(new StrategyB());
        salesman.salesManShow();
        System.out.println("===========");
        salesman.setStrategy(new StrategyC());
        salesman.salesManShow();
    }
}
