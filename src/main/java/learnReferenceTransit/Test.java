/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnReferenceTransit;

/**
 * @author LouHF
 *
 */
public class Test {
  
  public static void writeByteArray(byte[] b) {
    byte[] c = {1,2,3};
    b = c;//这里b这个引用在这个函数结束之后就没有用了，主函数中的引用bb并没有被改变
  }
  public static void writeByteArray1(byte[] b) {
    b[1] = 2;
    b[0] = 1;
    b[2] = 3;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    //Test test = new Test();
    byte[] bb = new byte[3];
    for (int i = 0; i < bb.length; i++) {
      System.out.print(bb[i]);
    }
    
    System.out.println("");
    writeByteArray(bb);
    for (int i = 0; i < bb.length; i++) {
      System.out.print(bb[i]);
    }
    
    System.out.println("");
    writeByteArray1(bb);
    for (int i = 0; i < bb.length; i++) {
      System.out.print(bb[i]);
    }

  }

}
