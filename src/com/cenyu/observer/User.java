package com.cenyu.observer;

public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subject subject) {
        subject.attach(this);
    }

    @Override
    public void unsubscribe(Subject subject) {
        subject.detach(this);
    }

    @Override
    public void receiveNewMessage(String message) {
        System.out.println("user: " + name + " receives, message: " + message);
    }
}
