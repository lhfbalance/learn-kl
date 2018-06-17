/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnConcurrent;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
class SerialExecutor implements Executor {
  final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
  final Executor executor;
  Runnable active;

  SerialExecutor(Executor executor) {
    this.executor = executor;
  }

  public synchronized void execute(final Runnable r) {
    tasks.offer(new Runnable() {
      public void run() {
        try {
          r.run();
        } finally {
          SerialExecutor.this.scheduleNext();//scheduleNext()是一个synchronized方法，所以这里可能会阻塞，1，另外的线程在调用execute，
        }
      }
    });
    if (active == null) {
      scheduleNext();
    }
  }

  protected synchronized void scheduleNext() {
    if ((active = tasks.poll()) != null) {
      executor.execute(active);
    }
  }
  
  public static void main(String[] args) {
    SerialExecutor executor = new SerialExecutor(Executors.newCachedThreadPool());
//    executor.execute(new Task(1));
//    executor.execute(new Task(2));
//    try {
//      TimeUnit.SECONDS.sleep(1);
//    } catch (InterruptedException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    executor.execute(new Task(3));
    
    for(int i = 0; i < 1000; i++) 
      executor.execute(new Task(i));
  }
}


class Task implements Runnable {

  private int id;
  public Task(int id) {
    this.id = id;
  }
  @Override
  public void run() {
    System.out.println("my id is " + id + ", Thread id is " + Thread.currentThread().getId());
    try {
      TimeUnit.MILLISECONDS.sleep(500);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
}
