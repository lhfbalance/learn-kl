/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author LouHF
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Classroom {

  private int id;
  private String name;
  @XmlAttribute private int grade;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the grade
   */
  public int getGrade() {
    return grade;
  }

  /**
   * @param grade the grade to set
   */
  public void setGrade(int grade) {
    this.grade = grade;
  }

  public Classroom(int id, String name, int grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }

  public Classroom() {}

}
