package com.cenyu.proxy;

public interface Money {

    void borrowMoney();
}

class MoneyImpl implements Money {

    @Override
    public void borrowMoney() {
        System.out.println("go to the vault and get the money out");
    }
}

class MoneyProxy implements Money {

    private MoneyImpl moneyImpl;

    public MoneyProxy(MoneyImpl moneyImpl) {
        this.moneyImpl = moneyImpl;
    }

    @Override
    public void borrowMoney() {
        preHandle();
        moneyImpl.borrowMoney();
        postHandle();
    }

    public void preHandle() {
        System.out.println("ask how much you wanna borrow");
    }

    public void postHandle() {
        System.out.println("give you money");
    }
}

class Demo {

    public static void main(String[] args) {
        MoneyProxy proxy = new MoneyProxy(new MoneyImpl());
        proxy.borrowMoney();
    }
}
