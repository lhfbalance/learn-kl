/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnThread;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class MyTask3 implements Runnable {

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    
      System.out.println("MyThread3 running..." + Thread.currentThread().getId());
  }

}
