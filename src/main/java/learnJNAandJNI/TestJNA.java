/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnJNAandJNI;

import java.util.concurrent.Future;

/**
 * @author LouHF
 *
 */
public class TestJNA {

  /**
   * @param args
   */
  public static void main(String[] args) {
    long beginTime = System.currentTimeMillis();
    int i = 0;
    int j = 0;
    //System.out.println(System.getProperty("java.library.path"));
    for (i = 0; i < 1000; i++) {
      for (j = 0; j < 1000; j++) {
        JNATest.INSTANCE.set(i * j);
        JNATest.INSTANCE.get();
      }
    }
    long totalTime = System.currentTimeMillis() - beginTime;
    System.out.println("JNI消耗的总时间（ms）：" + totalTime);

  }

}
