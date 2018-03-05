/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnJNAandJNI;

/**
 * @author LouHF
 *
 */
public class TestJNI {

  public static void main(String[] args) {
    long beginTime = System.currentTimeMillis();
    int i = 0;
    int j = 0;
    //System.out.println(System.getProperty("java.library.path"));
    for (i = 0; i < 1000; i++) {
      for (j = 0; j < 1000; j++) {
        JNITest.set(i * j);
        JNITest.get();
      }
    }
    long totalTime = System.currentTimeMillis() - beginTime;
    System.out.println("JNI消耗的总时间（ms）：" + totalTime);
  }

}
