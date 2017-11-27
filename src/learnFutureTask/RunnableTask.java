/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureTask;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class RunnableTask implements Runnable {

  private String id;


  /**
   * 
   */
  public RunnableTask(String id) {
    this.id = id;
  }

  @Override
  public void run() {
    System.out.println("task " + id + " is starting to run");
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      System.out.println(Thread.interrupted());
      System.out.println(Thread.interrupted());
      e.printStackTrace();
    }
    System.out.println("task " + id + " is running");

    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      System.out.println(Thread.interrupted());
      System.out.println(Thread.interrupted());
      e.printStackTrace();
    }
    
    System.out.println("task " + id + " is over");

  }

}
