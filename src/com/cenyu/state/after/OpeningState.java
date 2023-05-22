package com.cenyu.state.after;

public class OpeningState extends LiftState {

    @Override
    public void open() {
        System.out.println("opening the door ...");
    }

    @Override
    public void close() {
        // change status
        super.context.setLiftState(Context.CLOSING_STATE);
        // the action is delegated to the subclass ClosingState to execute
        super.context.close();
    }

    @Override
    public void run() {
        System.out.println("door is open, can't run ...");
    }

    @Override
    public void stop() {
        System.out.println("door is open, lift has already stopped ...");
    }
}
