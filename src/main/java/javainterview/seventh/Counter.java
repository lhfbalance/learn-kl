package javainterview.seventh;

import java.util.concurrent.atomic.AtomicLong;

public class Counter {

    private final AtomicLong counter = new AtomicLong();

    public void increase() {
        counter.incrementAndGet();
    }

    public long getValue() {
        return counter.get();
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increase();
        System.out.println(counter.getValue());
    }

}
