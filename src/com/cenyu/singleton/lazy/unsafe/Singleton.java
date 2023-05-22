package com.cenyu.singleton.lazy.unsafe;

/**
 * Singleton pattern with lazy initialization (thread-unsafe)
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
