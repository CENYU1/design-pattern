package com.cenyu.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject  {

    private List<Observer> userList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : userList) {
            observer.receiveNewMessage(message);
        }
    }
}
