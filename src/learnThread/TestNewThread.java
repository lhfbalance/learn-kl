/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnThread;

/**
 * @author LouHF
 *
 */
public class TestNewThread {
  
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int cycle = 1000;
    for(; cycle > 0; cycle--)
//      ;
      new Thread().start();
    long end = System.currentTimeMillis();
    System.out.println(end - start);
  }

}
