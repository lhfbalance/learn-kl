/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package testString;

import java.nio.charset.Charset;

/**
 * @author LouHF
 *
 */
public class TestStr {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // byte[] bs = {0,1,2,3,4,5,6,7,8,9};
    //
    // for (int i = 0; i < bs.length; i++) {
    // System.out.println(bs[i]);
    // }
    // String string = new String(bs);
    // System.out.println(string);
    // System.out.println(string.length());
    // String ss = string.substring(4, 6);
    // System.out.println(ss);
    // byte[] bb = ss.getBytes();
    // for (int i = 0; i < bb.length; i++) {
    // System.out.println(bb[i]);
    // //System.out.println();
    // }
    byte[] en = {0, 0, 74, -64, 'a', 'b', 'c', 'd', 'e', 0, 0, 0, 3, 'i', 'o', 'u',};
    for (int i = 0; i < en.length; i++) {
      System.out.println(en[i]);
    }
    String ens = new String(en);
    StringBuffer length = new StringBuffer(ens.substring(0, 4));
    byte[] ll = length.reverse().toString().getBytes();
    int firstLength = byte2int(length.reverse().toString().getBytes());
//    for (int i = 0; i < ens.substring(0, 4).getBytes().length; i++) {
//      System.out.println(ens.substring(0, 4).getBytes()[i]);
//    }
//    System.out.println(firstLength);
    System.out.println("firstLength: " + firstLength);
    String first = ens.substring(4, 4 + firstLength);
    System.out.println(first + "  firstString: ");
    byte[] firstByte = first.getBytes();
    for (int i = 0; i < firstByte.length; i++) {
      System.out.print(firstByte[i]);
    }
    System.out.println();
    
    
    length = new StringBuffer(ens.substring(4 + firstLength, 8 + firstLength));
    int secondLength = byte2int(length.reverse().toString().getBytes());
    System.out.println("secondLength: " + secondLength);
    String Second = ens.substring(8 + firstLength);
    System.out.println(Second + "  secondString: ");
    byte[] secondByte = Second.getBytes();
    for (int i = 0; i < secondByte.length; i++) {
      System.out.print(secondByte[i]);
    }
  }

  public static int byte2int(byte[] res) {
     // 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
    //byte[] res 是网络字节序（大端）
    int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | 按位或
        | ((res[2] << 24) >>> 8) | (res[3] << 24);
    return targets;
  }

}
