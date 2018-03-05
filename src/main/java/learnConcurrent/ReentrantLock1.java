package learnConcurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {
  
  Lock lock = new ReentrantLock();
  
  public void m1() {
    try {
      lock.lock();
      for(int i = 0; i < 10; i++)
      {
        System.out.println(Thread.currentThread().getName() + " " + i);
        TimeUnit.MILLISECONDS.sleep(1000);
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      System.out.println("m1 over");
      lock.unlock();
    }
  }
  
  public void m2(){
    lock.lock();
    System.out.println(Thread.currentThread().getName() + " m2 start");
    lock.unlock();
  }
  
  public static void main(String[] args) throws InterruptedException {
    ReentrantLock1 r1 = new ReentrantLock1();
    System.out.println("sadfa");
    new Thread(r1::m1).start();
    TimeUnit.SECONDS.sleep(1);
    new Thread(() -> {r1.m2();}).start();;
  }

}
