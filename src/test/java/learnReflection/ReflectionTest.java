/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnReflection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author LouHF
 *
 */
public class ReflectionTest {

  private Example ex;
  private Reflection reflection;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    reflection = new Reflection();
    ex = new Example();
  }

  @Test
  public void testGetPropert() throws Exception {
    assertEquals(reflection.getProperty(ex, "staticProperty"), null);
  }

  @Test
  public void testGetStaticProperty() throws Exception {
    assertEquals(reflection.getStaticProperty("learnReflection.Example", "staticProperty"), null);
  }

  @Test
  // 获取私有属性值测试
  public void testGetPrivatePropertyValue() throws Exception {
    assertEquals(reflection.getPrivatePropertyValue(ex, "privateProperty"), null);
  }

  @Test
  // 调用方法测试
  public void testInvokeMethod() throws Exception {

    assertEquals(reflection.invokeMethod(ex, "setProperty", new Object[] {"abcd"}), null);
    assertEquals(reflection.getProperty(ex, "publicProperty"), "abcd");

  }

  @Test
  // 调用静态方法测试
  public void testInvokeStaticMethod() throws Exception {

    assertEquals(
        reflection.invokeStaticMethod("learnReflection.Example", "SMethod", new Object[] {"joe"}),
        true);
    assertEquals(reflection.getStaticProperty("learnReflection.Example", "staticProperty"), "joe");

  }

  @Test
  // 新实例测试
  public void testNewInstance() throws Exception {

    Object obj = reflection.newInstance("learnReflection.Example", new Object[] {});
    org.junit.Assert.assertNotNull(obj);
  }

}
