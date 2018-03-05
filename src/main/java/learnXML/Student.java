/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author LouHF
 *
 */
@XmlRootElement
public class Student {

  private int id;
  private String name;
  private int age;
  private Classroom classroom;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  @XmlElement(name = "ID")
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
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * @param age the age to set
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * @return the classroom
   */
  public Classroom getClassroom() {
    return classroom;
  }

  /**
   * @param classroom the classroom to set
   */
  public void setClassroom(Classroom classroom) {
    this.classroom = classroom;
  }

  public Student(int id, String name, int age, Classroom classroom) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.classroom = classroom;
  }

  public Student() {}
}
