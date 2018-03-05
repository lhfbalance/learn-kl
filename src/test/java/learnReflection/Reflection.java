/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnReflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author LouHF
 *
 */
public class Reflection {

  public Object getProperty(Object obj, String fieldname) throws Exception {
    Object result = null;
    Class objClass = obj.getClass();
    Field field = objClass.getField(fieldname);
    result = field.get(obj);
    return result;

  }

  public Object getStaticProperty(String className, String fieldName) throws Exception {
    Class cls = Class.forName(className);
    Field field = cls.getField(fieldName);
    Object provalue = field.get(cls);
    return provalue;
  }

  public Object getPrivatePropertyValue(Object obj, String propertyName) throws Exception {
    Class cls = obj.getClass();
    Field field = cls.getDeclaredField(propertyName);
    field.setAccessible(true);
    Object retvalue = field.get(obj);
    return retvalue;
  }

  public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
    Class cls = owner.getClass();
    Class[] argclass = new Class[args.length];
    for (int i = 0, j = argclass.length; i < j; i++) {
      argclass[i] = args[i].getClass();
    }
    Method method = cls.getMethod(methodName, argclass);
    return method.invoke(owner, args);
  }

  public Object invokeStaticMethod(String className, String methodName, Object[] args)
      throws Exception {
    Class cls = Class.forName(className);
    Class[] argclass = new Class[args.length];
    for (int i = 0, j = argclass.length; i < j; i++) {
      argclass[i] = args[i].getClass();
    }
    Method method = cls.getMethod(methodName, argclass);
    return method.invoke(null, args);
  }
  
  public Object newInstance(String className, Object[] args) throws Exception {
    Class clss = Class.forName(className);

    Class[] argclass = new Class[args.length];
    for (int i = 0, j = argclass.length; i < j; i++) {
     argclass[i] = args[i].getClass();
    }
    java.lang.reflect.Constructor cons = clss.getConstructor(argclass);
    return cons.newInstance();
   }

   public static void main(String[] args) throws Exception {
   }
  
}
