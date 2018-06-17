/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author LouHF
 *
 */
public class Test {
  
  public static void main(String[] args) {
    ExecutorService ex = Executors.newSingleThreadExecutor();
    
    Future<Integer> future2 = ex.submit(new RunnableTask("2"), 2);
    Future<?> future1 = ex.submit(new RunnableTask("1"));
    
    try {
      System.out.println(future2.get().intValue());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      System.out.println(future1.isDone());
      System.out.println(future1.get());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    ex.shutdown();
    
  }

}
