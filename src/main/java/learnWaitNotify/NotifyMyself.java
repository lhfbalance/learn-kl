/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnWaitNotify;

import java.util.concurrent.TimeUnit;

import org.snmp4j.util.WorkerTask;

/**
 * @author LouHF
 *
 */
public class NotifyMyself {
  public static void main(String[] args) throws InterruptedException {
    MyTask myTask = new MyTask("t1");
    TaskManager tm = new TaskManager("notifyMyself");
    tm.start();
    TimeUnit.SECONDS.sleep(1);// thread setup ,start走到run()有点慢,等等它
    tm.execute(myTask);

  }
}


class TaskManager extends Thread {
  private WorkerTask task = null;
  private volatile boolean run = true;

  public TaskManager(String name) {
    super(name);
  }

  public synchronized void run() {
    System.out.println(Thread.currentThread().getName() + ": I got lock ");
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    //while (run) {
      if (task != null) {
        task.run();
      } else {
        try {
          System.out.println(Thread.currentThread().getName() + ": no task, I'm waiting...");
          System.out.println(Thread.currentThread().getName() + ": and I release lock");
          wait();
          System.out.println(Thread.currentThread().getName() + ": yes, I'm awaked.");
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
    //}
  }

  public boolean isIdle() {
    return ((task == null) && run);
  }

  public void terminate() {
    WorkerTask t;
    if ((t = task) != null) {
      t.terminate();
    }
  }

  public synchronized void execute(WorkerTask task) {
    System.out.println(Thread.currentThread().getName() + ": I got lock ");
    System.out.println(Thread.currentThread().getName() + ": attention, there is task");
    if (this.task == null) {
      this.task = task;
      notify();
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + ": release lock!");
    } else {
      throw new IllegalStateException("TaskManager is not idle");
    }
  }
}
