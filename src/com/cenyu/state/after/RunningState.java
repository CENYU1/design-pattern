package com.cenyu.state.after;

public class RunningState extends LiftState {

    @Override
    public void open() {
        System.out.println("lift is running, can't open ...");
    }

    @Override
    public void close() {
        System.out.println("lift is running, door has already closed ...");
    }

    @Override
    public void run() {
        System.out.println("lift is running ...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.stop();
    }
}
