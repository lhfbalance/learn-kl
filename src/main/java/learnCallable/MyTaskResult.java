package learnCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;


public class MyTaskResult implements Future<MyTask> {
  
  
  AtomicBoolean cancellFlag;
  AtomicBoolean doneFlag;
  
  MyTask mytask;
  
  public MyTaskResult() {
    this.cancellFlag = new AtomicBoolean(false);
    this.doneFlag = new AtomicBoolean(false);
  }

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    return false;
  }

  @Override
  public boolean isCancelled() {
    return this.cancellFlag.get();
  }

  @Override
  public boolean isDone() {
    return this.doneFlag.get();
  }

  @Override
  public MyTask get() throws InterruptedException, ExecutionException {
    return mytask;
  }

  @Override
  public MyTask get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return mytask;
  }

  public void setMytask(MyTask mytask) {
    this.mytask = mytask;
  }
  
  public void setDone() {
    this.doneFlag.set(true);
  }
  
  public void setCancell() {
    this.cancellFlag.set(true);
  }

}
