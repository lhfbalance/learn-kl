package javainterview.forth;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class learnReferenceQueue {

    public static void main(String[] args) {
        Object counter = new Object();
        System.out.println(counter);

        ReferenceQueue refQueue = new ReferenceQueue();

        PhantomReference p = new PhantomReference(counter, refQueue);

        counter = null;

        System.gc();

        try {
            Reference ref = refQueue.remove(1000L);

            if (ref != null) {
                System.out.println("ref is not null");
                System.out.println(ref.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
