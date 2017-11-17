/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnTimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class TestTimer {

  public static void main(String[] args) {
    Timer t = new Timer(false);

    MyTimerTask1 task1 = new MyTimerTask1(1);
    MyTimerTask1 task2 = new MyTimerTask1(2);
    System.out.println(task1.scheduledExecutionTime());
    t.schedule(task1, 100, 100000);
    t.schedule(task2, 200, 100000);
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      System.out.println("interrupted, break while(true)");
    }
    System.out.println(new Date(task1.scheduledExecutionTime()));
  }


}


class MyTimerTask1 extends TimerTask {

  private final int id;

  /**
   * 
   */
  public MyTimerTask1(int identified) {
    this.id = identified;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.TimerTask#run()
   */
  @Override
  public void run() {
    // while (true) {
    System.out.println("#" + id + " running");
    // try {
    // TimeUnit.SECONDS.sleep(1);
    // } catch (InterruptedException e) {
    // System.out.println("interrupted, break while(true)");
    // break;
    // }
    // }


  }
}
