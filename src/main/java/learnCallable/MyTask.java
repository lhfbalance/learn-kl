package learnCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyTask implements Callable<MyTaskResult> {
  
  MyTaskResult result;
  
  public MyTask(MyTaskResult result) {
    this.result = result;
    result.setMytask(this);
  }

  @Override
  public MyTaskResult call() throws Exception {
    TimeUnit.SECONDS.sleep(1);
    result.setDone();
    return result;
  }

}
