/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnConcurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class SynchronizedOnMethod {

  public synchronized void method1() {

    System.out.println("enter method1, thread id " + Thread.currentThread().getId());
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("exit method1");
  }

  public synchronized void method2() {
    System.out.println("enter method2, thread id " + Thread.currentThread().getId());
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("exit method2");
  }

  public static void main(String[] args) {
    final SynchronizedOnMethod c = new SynchronizedOnMethod();
    new Thread(new Runnable() {

      @Override
      public void run() {
        c.method1();

      }
    }).start();

    new Thread(new Runnable() {

      @Override
      public void run() {
        c.method2();

      }
    }).start();
  }

}
