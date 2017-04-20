/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnObject;

import java.util.Vector;

/**
 * @author LouHF
 *
 */
public class TestClone {
  
  private String name;
  
  /**
   * 
   */
  public TestClone(String name) {
    this.name = name;
  }
  
  /**
   * @param args
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static void main(String[] args) {
 // create an empty Vector vec with an initial capacity of 4      
    Vector<TestClone> vec = new Vector<TestClone>(4);
    Vector<TestClone> vecclone = new Vector<TestClone>(4);

    // use add() method to add elements in the vector
    vec.add(new TestClone("4"));
    vec.add(new TestClone("3"));
    vec.add(new TestClone("2"));
    vec.add(new TestClone("1"));

    // let us clone the vector vec
    vecclone=(Vector)vec.clone();
    if (vecclone == vec) {
      System.out.println("oh my god");
    }
    
    vecclone.remove(2);
    
 // let us print all the elements available in vec
    System.out.println("Added numbers in vec vector are :- "); 
    for (TestClone testClone : vec) {         
       System.out.println("Number = " + testClone.name);
    }
    
     // let us print all the elements available in vecclone
    System.out.println("Added numbers in vecclone vector are :-");       
    for (TestClone testClone : vecclone) {         
       System.out.println("Number = " + testClone.name);
    }

  }

}
