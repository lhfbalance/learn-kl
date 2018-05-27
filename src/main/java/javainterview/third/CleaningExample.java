package javainterview.third;

import sun.misc.Cleaner;

public class CleaningExample implements AutoCloseable {
// A clearner, preferably one shared within a library
//    private static final Cleaner clearner;

    static class State implements Runnable {
        State() {

        }

        public void run() {
            //cleanup action accessing State, execute at most once
        }
    }

    private final State state;

//    private final Cleaner.Cleanable cleanable;

    public CleaningExample() {
        this.state = new State();
//        this.cleanable = cleaner.register(this, state);
    }


    @Override
    public void close() throws Exception {

//        clearnable.clean();
    }
}
