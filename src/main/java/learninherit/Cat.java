/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learninherit;

/**
 * @author LouHF
 *
 */
public abstract class Cat implements Animal {

  /* (non-Javadoc)
   * @see learninherit.Animal#eat()
   */
  @Override
  public void eat() {
    System.out.println("I'm cat, eat cat food");

  }
  
  abstract void miao();

}
