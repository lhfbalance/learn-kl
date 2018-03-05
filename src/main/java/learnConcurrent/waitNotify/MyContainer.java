package learnConcurrent.waitNotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyContainer {

  volatile List<Integer> l = new ArrayList<>();

  public void add(int i) {
    l.add(i);
  }

  public int size() {
    return l.size();
  }

  public static void main(String[] args) {

    final MyContainer myContainer = new MyContainer();
    final Object lock = new Object();

    new Thread(new Runnable() {

      @Override
      public void run() {
        synchronized (lock) {
            if (myContainer.size() != 5) {
              
              try {
                lock.wait();
              } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
          }
            System.out.println("t2 start");
            lock.notify();
        }

      }
    }, "t2").start();
    
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    new Thread(new Runnable() {

      @Override
      public void run() {
        synchronized (lock) {
          for (int i = 0; i < 10; i++) {
            System.out.println("add " + i);
            myContainer.add(i);
            if (myContainer.size() == 5) {
              lock.notify();
              try {
                lock.wait();
              } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            }
          }
          
        }

      }
    }, "t1").start();
  }

}
