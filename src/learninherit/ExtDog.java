/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learninherit;

/**
 * @author LouHF
 *
 */
public abstract class ExtDog extends Dog implements ExtAnimal {

  /*
   * (non-Javadoc)
   * 
   * @see learninherit.ExtAnimal#ext()
   */
  @Override
  public void ext() {
    System.out.println("a ext Dog");

  }

  /*
   * (non-Javadoc)
   * 
   * @see learninherit.Dog#bark()
   */
  @Override
  void bark() {
    System.out.println("wang wang wang!");

  }
  
  /* (non-Javadoc)
   * @see learninherit.Dog#eat()
   */
//  @Override
//  public void eat() {
//    System.out.println("i'm ext dog , and eat ext dog food");
//  }

  abstract void extdogSkill();

}
