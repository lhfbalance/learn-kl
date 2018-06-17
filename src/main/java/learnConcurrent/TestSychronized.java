/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnConcurrent;

public class TestSychronized implements Runnable{

  public synchronized void get(){
      System.out.println(Thread.currentThread().getId());
      set();
  }

  public synchronized void set(){
      System.out.println(Thread.currentThread().getId());
  }

  @Override
  public void run() {
      get();
  }
  public static void main(String[] args) {
    TestSychronized ss=new TestSychronized();
      new Thread(ss).start();
      new Thread(ss).start();
      new Thread(ss).start();
  }
}


