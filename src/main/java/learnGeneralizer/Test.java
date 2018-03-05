package learnGeneralizer;

import java.util.ArrayList;
import java.util.List;

public class Test {
  
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    Test test = new Test();
    test.print(list);
//    test.print1(list);
  }
  
  void print1(List<Object> ls) {
    for(Object l : ls)
      System.out.println(l);
  }
  
  void print(List<?> ls) {
    for(Object l : ls)
    System.out.println(l);
  }

}
