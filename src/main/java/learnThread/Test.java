/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class Test {

  /**
   * @param args
   * @throws InterruptedException 
   * @throws ExecutionException 
   */
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    /*
     * 单线程，顺序获取线程的使用权
     */
//    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
//    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
//    TimeUnit.SECONDS.sleep(10);
//    executor.shutdown();
    
    /*
     * 线程池方式，两个线程两个任务，各分配了一个线程，分别运行互不干涉
     */
//    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
//    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
//    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
//    TimeUnit.SECONDS.sleep(10);
//    executor.shutdown();
    /*
     * 线程池方式，一个线程两个任务，和单线程没什么区别
     */
//    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
//    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
//    TimeUnit.SECONDS.sleep(10);
//    executor.shutdown();
    /*
     * 线程池方式，两个线程三个任务
     */
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
    executor.scheduleAtFixedRate(new MyTask3(), 0, 1, TimeUnit.SECONDS);
    TimeUnit.SECONDS.sleep(10);
    executor.shutdown();

  }

}
