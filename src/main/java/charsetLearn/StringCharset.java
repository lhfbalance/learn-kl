/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package charsetLearn;

import java.io.UnsupportedEncodingException;

/**
 * @author LouHF
 *
 */
public class StringCharset {

  /**
   * @param args
   * @throws UnsupportedEncodingException
   */
  public static void main(String[] args) throws UnsupportedEncodingException {
    String string = "中华人民共和国";
    byte[] b1 = string.getBytes("UTF-8");
    System.out.println(b1.length);
    System.out.println("你好的UTF-8编码：");
    for (int i = 0; i < b1.length; i++) {
      System.out.print(b1[i] + ",");
    }

    System.out.println("");

    byte[] b2 = string.getBytes("GBK");
    System.out.println(b2.length);
    System.out.println("你好的GBK编码：");
    for (int i = 0; i < b2.length; i++) {
      System.out.print(b2[i] + ",");
    }
    
    System.out.println("");

    byte[] bd = string.getBytes();//default
    System.out.println(bd.length);
    System.out.println("你好的default编码：");
    for (int i = 0; i < bd.length; i++) {
      System.out.print(bd[i] + ",");
    }

    System.out.println("");
    System.out.println("");
    System.out.println("1.GBK 2.default 3.UTF-8");
    byte[] b3 = {-42, -48, -69, -86, -56, -53, -61, -15, -71, -78, -70, -51, -71, -6};//GBK
    
    string = new String(b3, "GBK");
    System.out.println("1." + string);
    string = new String(b3);
    System.out.println("2." + string);
    string = new String(b3, "UTF-8");
    System.out.println("3." + string);

    System.out.println("");
    System.out.println("1.GBK 2.default 3.UTF-8");// default
    byte[] b4 = {-28, -72, -83, -27, -115, -114, -28, -70, -70, -26, -80, -111, -27, -123, -79, -27,
        -110, -116, -27, -101, -67};
    string = new String(b4, "GBK");
    System.out.println("1." + string);
    string = new String(b4);
    System.out.println("2." + string);
    string = new String(b4, "UTF-8");
    System.out.println("3." + string);

  }

}
