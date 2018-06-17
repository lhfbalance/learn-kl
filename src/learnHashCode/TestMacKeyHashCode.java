/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnHashCode;

import sun.util.logging.resources.logging;

/**
 * @author LouHF
 *
 */
public class TestMacKeyHashCode {
  
  private long handle;
  
  private long createTime;

  public TestMacKeyHashCode(long handle) {
    this.handle = handle;
    this.createTime = System.currentTimeMillis();
  }

  public int hashCode() {
    int result = 1;
    result = 31 * result + (int) (this.createTime ^ this.createTime >>> 32);
    result = 31 * result + (int) (handle ^ handle >>> 32);
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (super.getClass() != obj.getClass()) return false;
    TestMacKeyHashCode other = (TestMacKeyHashCode) obj;
    if (this.createTime != other.createTime) {
      return false;
    }
    return (handle == other.handle);
  }
  
  public static void main(String[] args) {
    TestMacKeyHashCode c1 = new TestMacKeyHashCode(1);
    System.out.println(c1.hashCode());
    TestMacKeyHashCode c2 = new TestMacKeyHashCode(1);
    System.out.println(c2.hashCode());
  }

}
