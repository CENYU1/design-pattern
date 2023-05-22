package com.cenyu.singleton.eager;

/**
 * Singleton pattern with eager initialization
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}
