package testFont;

public class TestReference {

  public void switch2obj(String o1, String o2) {

    String temp = o1;
    o1 = o2;
    o2 = temp;
    System.out.println(o1);
    System.out.println(o2);
  }

  public static void main(String[] args) {

    String o1 = "123";
    String o2 = "456";
    System.out.println(o1);
    System.out.println(o2);
    TestReference t = new TestReference();
    t.switch2obj(o1, o2);
    System.out.println(o1);
    System.out.println(o2);
    
  }

}
