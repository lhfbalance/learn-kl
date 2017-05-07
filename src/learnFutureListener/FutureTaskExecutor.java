/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class FutureTaskExecutor {

  private ExecutorService executor;

  /**
   * 
   */
  public FutureTaskExecutor() {
    executor = Executors.newFixedThreadPool(5);
  }

  public ComposeFutureTask execute(ComposeFutureTask task) {
    executor.execute(task);
    return task;
  }


  /**
   * @param args
   */
  public static void main(String[] args) {
    FutureTaskExecutor futureTaskExecutor = new FutureTaskExecutor();

    futureTaskExecutor.execute(new ComposeFutureTask("111", 1, 1))
        .addListener(new IFutureListener<ComposeResult>() {

          @Override
          public void operationCompleted(IFuture<ComposeResult> future) throws Exception {
            System.out.println(future.get().getName());
            System.out.println(future.get().getResult());
          }
        });

    futureTaskExecutor.execute(new ComposeFutureTask("222", 2, 2))
        .addListener(new IFutureListener<ComposeResult>() {

          @Override
          public void operationCompleted(IFuture<ComposeResult> future) throws Exception {
            System.out.println(future.get().getName());
            System.out.println(future.get().getResult());
          }
        });
    futureTaskExecutor.execute(new ComposeFutureTask("333", 3, 3))
    .addListener(new IFutureListener<ComposeResult>() {

      @Override
      public void operationCompleted(IFuture<ComposeResult> future) throws Exception {
        System.out.println(future.get().getName());
        System.out.println(future.get().getResult());
      }
    });

    while (true) {
      try {
        TimeUnit.MILLISECONDS.sleep(800);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("I'm not blocked.");
    }


  }

}
