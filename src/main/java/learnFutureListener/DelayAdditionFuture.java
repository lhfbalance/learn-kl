/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

/**
 * @author LouHF
 *
 */
public class DelayAdditionFuture extends AbstractFuture<Integer> {
  
  @Override
  protected IFuture<Integer> setFailure(Throwable cause) {
    return super.setFailure(cause);
  }
  
  @Override
  protected IFuture<Integer> setSuccess(Object result) {
    return super.setSuccess(result);
  }

}
