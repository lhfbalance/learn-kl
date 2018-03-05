/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnJNAandJNI;

/**
 * @author LouHF
 *
 */
public class JNITest {
//  public native void test();
  public native static void set(int i);
  public native static int get();
  
  static{
    System.loadLibrary("JNITest");
  }

}
