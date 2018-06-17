/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnStaticInnerClass;

/**
 * @author LouHF
 *
 */
public class Cert {
  
  private String cn;
  private String sn;
  private String dn;
  private String sign;
  /**
   * @param cn
   * @param sn
   * @param dn
   * @param sign
   */
  public Cert(String cn, String sn, String dn, String sign) {
    super();
    this.cn = cn;
    this.sn = sn;
    this.dn = dn;
    this.sign = sign;
  }
  public String getCn() {
    return cn;
  }
  public void setCn(String cn) {
    this.cn = cn;
  }
  public String getSn() {
    return sn;
  }
  public void setSn(String sn) {
    this.sn = sn;
  }
  public String getDn() {
    return dn;
  }
  public void setDn(String dn) {
    this.dn = dn;
  }
  public String getSign() {
    return sign;
  }
  public void setSign(String sign) {
    this.sign = sign;
  }
  
  

}
