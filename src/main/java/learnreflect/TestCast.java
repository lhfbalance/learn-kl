/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnreflect;

/**
 * @author LouHF
 *
 */
public class TestCast {

  /**
   * @param args
   * @throws IllegalAccessException 
   * @throws InstantiationException 
   */
  public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    Annimal a1 = new Dog();
    Annimal a2 = new Cat();
    a1.introduceMyself();
    a2.introduceMyself();
    Annimal a3 = a1.getClass().newInstance();
    Annimal a4 = a2.getClass().newInstance();
    a3.introduceMyself();
    a4.introduceMyself();

  }

}
