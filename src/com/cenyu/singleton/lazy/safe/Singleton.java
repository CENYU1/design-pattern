package com.cenyu.singleton.lazy.safe;

/**
 * Singleton pattern with lazy initialization (thread-safe)
 * synchronized
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
