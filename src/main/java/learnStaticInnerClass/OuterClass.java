package learnStaticInnerClass;
/**
 * Copyright(C) 2016,2026,LHF,Inc
 */

/**
 * @author LouHF
 *
 */
public class OuterClass {

  private static class OuterClassHolder {

    private String name;
    private int id;
    private Cert cert;

    /**
     * 
     */
    private OuterClassHolder(Cert cert) {
      this.cert = cert;
      this.name = cert.getCn();
      this.id = Integer.valueOf(cert.getSn());
    }

    private OuterClassHolder(String name, int id) {
      this.id = id;
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public int getId() {
      return id;
    }

    public Cert getCert() {
      return cert;
    }

  }
  
  private final  OuterClassHolder holder;
  
  private OuterClass(int id, String name) {
    
    holder = new OuterClassHolder(name, id);
    
  }
  
  public OuterClass(Cert cert) {
    holder = new OuterClassHolder(cert);
  }
  
  
  public String getName() {
    return holder.getName();
  }
  
  public int getId() {
    return holder.getId();
  }
  
  public Cert getCert() {
    return holder.getCert();
  }
  
  public static OuterClass creatOuterWithoutCert(String name, int id) {
    return new OuterClass(id, name);
  }

}
