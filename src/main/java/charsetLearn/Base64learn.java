/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package charsetLearn;

import java.io.UnsupportedEncodingException;

import kl.util.Base64;

/**
 * @author LouHF
 *
 */
public class Base64learn {

  /**
   * @param args
   * @throws UnsupportedEncodingException 
   */
  public static void main(String[] args) throws UnsupportedEncodingException {
    
    String string = "";
    byte[] b1 = string.getBytes("UTF-8");
    for (int i = 0; i < b1.length; i++) {
      System.out.print(b1[i] + ",");
    }
    
    System.out.println("");
    
    byte[] b11 = string.getBytes("GBK");
    for (int i = 0; i < b11.length; i++) {
      System.out.print(b11[i] + ",");
    }
    
    System.out.println("");
    
    byte[] b2 = Base64.encode(b1);
    for (int i = 0; i < b2.length; i++) {
      System.out.print(b2[i] + ",");
    }
    
    System.out.println("");
    
    String string2 = new String(b2, "GBK");
    System.out.println(string2);
    string2 = new String(b2);
    System.out.println(string2);
    string2 = new String(b2, "UTF-8");
    System.out.println(string2);

  }

}
