/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

/**
 * @author LouHF
 *
 */
public interface IFutureListener<T> {
  
  public void operationCompleted(IFuture<T> future) throws Exception;

}
