package com.cenyu.observer;

public interface Observer {

    void subscribe(Subject subject);
    void unsubscribe(Subject subject);
    void receiveNewMessage(String message);
}
