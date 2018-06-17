/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnCallable;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class RunnableTask implements Runnable {

  
  /**
   * 
   */
  private RunnableTaskResult result;
  
  public RunnableTask(RunnableTaskResult restult) {
    this.result = restult;
  }
  @Override
  public void run() {
    System.out.println("I'm starting on " + Thread.currentThread().getId());
    
    this.result.setResult(1);
    
    System.out.println("I'm running");
    
    try {
      TimeUnit.SECONDS.sleep(1);
      
      this.result.setResult(2);
      
      System.out.println("I'm run over, but I can't return");

    } catch (InterruptedException e) {
      this.result.setResult(3);
    }
    
  }

}
