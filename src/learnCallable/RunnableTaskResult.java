/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnCallable;

/**
 * @author LouHF
 *
 */
public class RunnableTaskResult {
  
  private int result;
  /**
   * 
   */
  public RunnableTaskResult() {
    result = 0;
  }
  
  synchronized public int getResult() {
    return result;
  }
  
  synchronized public void setResult(int result) {
    this.result = result;
  }
  

}
