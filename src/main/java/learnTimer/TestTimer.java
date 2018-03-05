/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnTimer;

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
    t.schedule(new MyTimerTask(1), 100, 1000);
    t.schedule(new MyTimerTask(2), 200, 1000);
  }
  

}

class MyTimerTask extends TimerTask {
  
  private final int id;
  
  /**
   * 
   */
  public MyTimerTask(int identified) {
    this.id = identified;
  }
  /* (non-Javadoc)
   * @see java.util.TimerTask#run()
   */
  @Override
  public void run() {
    while (true) {
      System.out.println("#" + id + " running");
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        System.out.println("interrupted, break while(true)");
        break;
      }
    }
    
    
  }
}
