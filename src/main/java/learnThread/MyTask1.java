/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnThread;


/**
 * @author LouHF
 *
 */
public class MyTask1 implements Runnable {

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    
      System.out.println("MyThread running..." + Thread.currentThread().getId());
  }

}
