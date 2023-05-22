package com.cenyu.state.before;

/**
 * Poor scalability without using state pattern
 */
public interface ILift {

    int OPENING_STATE = 1;
    int CLOSING_STATE = 2;
    int RUNNING_STATE = 3;
    int STOPPING_STATE = 4;

    void setState(int state);
    void open();
    void close();
    void stop();
    void run();
}

class Lift implements ILift {

    private int state;

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (state) {
            case OPENING_STATE:
                System.out.println("nothing to do ...");
                break;
            case CLOSING_STATE:
                System.out.println("opening ...");
                this.setState(OPENING_STATE);
                break;
            case STOPPING_STATE:
                System.out.println("opening ...");
                this.setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                System.out.println("nothing to do ...");
                break;
        }
    }

    @Override
    public void close() {
        switch (state) {
            case OPENING_STATE:
                System.out.println("closing ...");
                this.setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
                System.out.println("nothing to do ...");
                break;
            case RUNNING_STATE:
                System.out.println("nothing to do ...");
                break;
            case STOPPING_STATE:
                System.out.println("nothing to do ...");
                break;
        }
    }

    @Override
    public void stop() {
        switch (state) {
            case OPENING_STATE:
                System.out.println("nothing to do ...");
                break;
            case CLOSING_STATE:
                System.out.println("stopping ...");
                this.setState(STOPPING_STATE);
                break;
            case RUNNING_STATE:
                System.out.println("stopping ...");
                this.setState(STOPPING_STATE);
                break;
            case STOPPING_STATE:
                System.out.println("nothing to do ...");
                break;
        }
    }

    @Override
    public void run() {
        switch (state) {
            case OPENING_STATE:
                System.out.println("nothing to do ...");
                break;
            case CLOSING_STATE:
                System.out.println("running ...");
                this.setState(RUNNING_STATE);
                break;
            case RUNNING_STATE:
                System.out.println("nothing to do ...");
                break;
            case STOPPING_STATE:
                System.out.println("running ...");
                this.setState(RUNNING_STATE);
                break;
        }
    }
}

class Demo {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setState(ILift.OPENING_STATE);
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
