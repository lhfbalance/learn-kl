/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnObject;

/**
 * @author LouHF
 *
 */
public class TestClone2 {

    public void changeA(A a){
        a.name="b";
    }
    public void changInt(int i){
        i=i*2+100;
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TestClone2 test=new TestClone2();
        A a=new A();
        a.name="a";
        System.out.println("before change : a.name="+a.name);
        test.changeA(a);
        System.out.println("after  change : a.name="+a.name);
        int i=1;
        System.out.println("before change : i="+i);
        test.changInt(i);
        System.out.println("after  change : i="+i);
    }
 
}

 class A {
  public String name;
}
