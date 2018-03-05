/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class DelayAdder {

  public DelayAdditionFuture add(long delay, int a, int b) {
    DelayAdditionFuture future = new DelayAdditionFuture();
    new Thread(new DelayAdditionTask(delay, a, b, future)).start();
    return future;
  }

  /**
   * @param args
   * @throws InterruptedException 
   */
  public static void main(String[] args) throws InterruptedException {
    new DelayAdder().add(3 * 1000, 1, 2).addListener(new IFutureListener<Integer>() {

      @Override
      public void operationCompleted(IFuture<Integer> future) throws Exception {
        System.out.println(future.getNow());
      }

    });
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);
    System.out.println("I'am not blocking, I'can do anything...");
    TimeUnit.MILLISECONDS.sleep(500);

  }

  
  /**
   * ����һ���첽������
   * @author LouHF
   *
   */
  private class DelayAdditionTask implements Runnable {

    private long delay;

    private int a, b;

    private DelayAdditionFuture future;

    public DelayAdditionTask(long delay, int a, int b, DelayAdditionFuture future) {
      super();
      this.delay = delay;
      this.a = a;
      this.b = b;
      this.future = future;
    }

    @Override
    public void run() {
      try {
        Thread.sleep(delay);
        Integer i = a + b;
        // TODO ��������futureΪ���״̬(����ִ�����)
        future.setSuccess(i);
      } catch (InterruptedException e) {
        // TODO ��������futureΪ���״̬(�쳣ִ�����)
        future.setFailure(e.getCause());
      }
    }

  }

}
