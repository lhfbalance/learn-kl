/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnBreakCycle;

import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class BreakCycleTest {
  
  int returnBreakForCycle() throws InterruptedException {
    int loop = 0;
    for(;;) {
      System.out.println("for cycle start at " + ++loop);
      TimeUnit.MICROSECONDS.sleep(100);
      if (loop == 5) {
        return loop;
      }
    }
  }
  
  public static void main(String[] args) throws InterruptedException {
    new BreakCycleTest().returnBreakForCycle();
  }

}
