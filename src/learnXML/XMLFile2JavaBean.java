/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * @author LouHF
 *
 */
public class XMLFile2JavaBean {

  /**
   * @param args
   * @throws FileNotFoundException 
   */
  public static void main(String[] args) throws FileNotFoundException {
//    String xmlStr =
//        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><age>22</age><classroom><grade>4</grade><id>1</id><name>软件工程</name></classroom><id>101</id><name>张三</name></student>";
    try {
      JAXBContext context = JAXBContext.newInstance(Student.class);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      Student student = (Student) unmarshaller.unmarshal(new FileInputStream(new File("student.xml")));
      //InputStream in = new FileInputStream(new File("student.xml"));
      System.out.println(student.getAge());
      System.out.println(student.getClassroom().getName());
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}
