/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class ComposeFutureTask extends AbstractFuture<ComposeResult> implements Runnable{

  private String name;
  private int a;
  private int b;
  
  /**
   * 
   */
  public ComposeFutureTask(String name, int a, int b) {
    
    this.name = name;
    this.a = a;
    this.b = b;
    
  }
  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(2);
      Integer result = a + b;
      setSuccess(new ComposeResult(this.name, result));
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      setFailure(e.getCause());
    }
    
  }
  
 
}
