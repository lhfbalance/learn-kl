/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnCallable;

import java.util.concurrent.Callable;

/**
 * @author LouHF
 * @param <V>
 *
 */
public class MyCallable implements Callable<String> {

  private int flag = 0;

  public MyCallable(int flag) {

    this.flag = flag;

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.concurrent.Callable#call()
   */
  @Override
  public String call() throws Exception {
    
    if (this.flag == 0) {

      return "flag = 0";

    }

    if (this.flag == 1) {

      try {

        while (true) {

          System.out.println("looping.");

          Thread.sleep(2000);

        }

      } catch (InterruptedException e) {

        System.out.println("Interrupted");

      }

      return "false";

    } else {

      throw new Exception("Bad flag value!");

    }
  }

}
