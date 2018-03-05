package learnBom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bean {

  private String chirld;
  private String chrild2;

  public String getChirld() {
    return chirld;
  }

  public void setChirld(String chirld) {
    this.chirld = chirld;
  }

  public String getChrild2() {
    return chrild2;
  }

  public void setChrild2(String chrild2) {
    this.chrild2 = chrild2;
  }

}
