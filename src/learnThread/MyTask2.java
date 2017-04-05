/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnThread;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class MyTask2 implements Runnable {

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    
      System.out.println("MyThread2 running..." + Thread.currentThread().getId());
      try {
        TimeUnit.MILLISECONDS.sleep(1500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  }

}
