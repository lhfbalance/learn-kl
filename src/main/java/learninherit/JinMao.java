/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learninherit;

/**
 * @author LouHF
 *
 */
public class JinMao extends ExtDog {

  /* (non-Javadoc)
   * @see learninherit.ExtDog#extdogSkill()
   */
  @Override
  void extdogSkill() {

    System.out.println("extdogskill");
  }

  public static void main(String[] args) {
    Dog dog = new JinMao();
    dog.eat();
  }
}
