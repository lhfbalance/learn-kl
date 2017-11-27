/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnConcurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LouHF
 *
 */
public class LearnBlockingQueue {
  
  private static final BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(50);
  
  
  public void startProduce(int count) {
    ExecutorService ex = Executors.newCachedThreadPool();
    for(int i = 0; i < count; i++)
      ex.submit(new ProduceTask());
    ex.shutdown();
    
  }
  
  public void startConsume(int count) {
    ExecutorService ex = Executors.newCachedThreadPool();
    for(int i = 0; i < count; i++)
      ex.submit(new ConsumeTask());
    ex.shutdown();
  }
  
  private static class ProduceTask implements Callable<Integer> {
    
    volatile static AtomicInteger id = new AtomicInteger(0);

    @Override
    public Integer call() throws Exception{
      int i = id.getAndIncrement();
      System.out.println("wait to prodece");
      LearnBlockingQueue.queue.put(i);
      System.out.println("produce " + i);
      return i;
    }
    
  }
  
  private static class ConsumeTask implements Callable<Integer> {
    
    @Override
    public Integer call() throws Exception{
     
      System.out.println("wait to consume");
      int r = LearnBlockingQueue.queue.take();
      System.out.println("consumeTask " + r);
      return r;
    }
  }
  
  public static void main(String[] args) {
    
    LearnBlockingQueue qtest = new LearnBlockingQueue();
    qtest.startProduce(5);
    qtest.startConsume(5);
    
  }

}
