/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnStaticInnerClass;

/**
 * @author LouHF
 *
 */
public class OuterClassTest {
  
  public static void main(String[] args) {
    Cert cert1 = new Cert("first", "1111", "f,f,f,f", "s1s1s1s1");
    Cert cert2 = new Cert("second", "2222", "s,s,s,s", "s2s2s2s2");
    
    OuterClass class1 = new OuterClass(cert1);
    OuterClass class2 = new OuterClass(cert2);
    
    System.out.println(class1.getId());
    System.out.println(class2.getId());
    
    OuterClass class3 = OuterClass.creatOuterWithoutCert("33", 33);
    
    System.out.println(class3.getId());
    
  }

}
