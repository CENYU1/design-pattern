package com.cenyu.observer;

public class Client {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        User cenyu = new User("cenyu");
        User kevin = new User("kevin");
        cenyu.subscribe(subject);
        kevin.subscribe(subject);
        subject.notify("new article published");

        System.out.println("=======");

        kevin.unsubscribe(subject);
        subject.notify("another new article published");
    }
}
