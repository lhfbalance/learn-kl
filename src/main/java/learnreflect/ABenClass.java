/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnreflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author LouHF
 *
 */
public abstract class ABenClass {
  
  /**
   * 
   */
  public ABenClass() {
    initByMethodSet(this);
  }
  
  /*
   * 只能初始化public类型的feild
   */
  private void initByFeildSet(ABenClass obj) {
    Field[] fields = obj.getClass().getDeclaredFields();
    System.out.println("-----" + fields.length);
    for (Field field : fields) {
      System.out.println(field.getName());
      System.out.println(field.getModifiers());
      System.out.println();
      System.out.println(field.getType());
      System.out.println();
      
      if (Modifier.isPublic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
        
        try {
          field.set(obj, "haha");
        } catch (IllegalArgumentException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      
    }
  }
  
  
  /*
   *  使用Set方法初始化field，不受field本身的装饰符限制（public，private）
   */
  private void initByMethodSet(ABenClass obj) { 
    Field[] fields = obj.getClass().getDeclaredFields();
    System.out.println("-----" + fields.length);
    for (Field field : fields) {
      Method fieldSetMet;
      try {
        fieldSetMet = obj.getClass().getMethod(parSetName(field.getName()), field.getType());
        fieldSetMet.invoke(obj, "haha");
      } catch (NoSuchMethodException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } 
    }
  } 
  
  private static String parSetName(String fieldName) {
    if (null == fieldName || "".equals(fieldName)) {
      return null;
    }
    int startIndex = 0;
    if (fieldName.charAt(0) == '_') startIndex = 1;
    return "set" + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
        + fieldName.substring(startIndex + 1);
  }

}
