/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnreflect;

/**
 * @author LouHF
 *
 */
public class BenClass extends ABenClass{
  
  private String field1;
  
  protected String field2;
  
  public String field3;
  
  /**
   * 
   */
  public BenClass() {
   
  }

  
  public String getField1() {
    return field1;
  }


  public void setField1(String field1) {
    this.field1 = field1;
  }


  public String getField2() {
    return field2;
  }


  public void setField2(String field2) {
    this.field2 = field2;
  }


  public String getField3() {
    return field3;
  }


  public void setField3(String field3) {
    this.field3 = field3;
  }
  
  public static void main(String[] args) {
    BenClass ben = new BenClass();
    System.out.println(ben.field1);
    System.out.println(ben.field2);
    System.out.println(ben.field3);
  }


}
