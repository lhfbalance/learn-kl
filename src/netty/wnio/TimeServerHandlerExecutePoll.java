/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package netty.wnio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class TimeServerHandlerExecutePoll {
  
  private ExecutorService executor;

  /**
   * 
   */
  public TimeServerHandlerExecutePoll(int maxPoolSize, int queueSize) {
    
    executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<java.lang.Runnable>(queueSize));
  }
  
  public void execute(Runnable task) {
    executor.execute(task);
  }


}
