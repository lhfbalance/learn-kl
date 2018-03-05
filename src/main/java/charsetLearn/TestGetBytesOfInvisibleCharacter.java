/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package charsetLearn;

/**
 * @author LouHF
 *
 */
public class TestGetBytesOfInvisibleCharacter {

  public static void main(String[] args) {
    String test1 = "abcdefghigklmnopqrstuvwxyz";
    byte[] a1 = test1.getBytes();
    for(byte a : a1) {
      System.out.print(a + " ");
    }
    System.out.println();
    String test2 = "abcdefghigk\n" + "lmnopqrstuvwxyz";
    byte[] a2 = test2.getBytes();
    for(byte a : a2) {
      System.out.print(a + " ");
    }
  }
  
}
