package com.cenyu.state.after;

public class Demo {

    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.run();
        context.close();
        context.stop();
    }
}
