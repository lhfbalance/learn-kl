/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class TestRunnableAdapter {
  
  public static void main(String[] args) throws Exception {
    
    System.out.println("run on thread: " + Thread.currentThread().getId());
    
    RunnableTaskResult result = new RunnableTaskResult();
    RunnableTask task = new RunnableTask(result);
    ExecutorService ex = Executors.newSingleThreadScheduledExecutor();
    
    //use FutureTask
//    FutureTask<RunnableTaskResult> futureTask = new FutureTask<RunnableTaskResult>(task, result);
//    ex.submit(futureTask, result);
//    System.out.println("futuretask result : " + futureTask.get().getResult());
    
    //run task, but can't know what time the task is done
//    ex.execute(task);
    new Thread(task).start();
    TimeUnit.MILLISECONDS.sleep(1000);
    System.out.println(result.getResult());
    ex.shutdown();
    
  }

}
