/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnReflection;


/**
 * @author LouHF
 *
 */
public class Example {

  private String privateProperty;
  
  public String publicProperty;
  
  public void setProperty(String str) {
    publicProperty = str;
  }
  
  public static String staticProperty;
  
  static public boolean SMethod(String str) {
    staticProperty = str;
    return true;
  }
  
  
}
