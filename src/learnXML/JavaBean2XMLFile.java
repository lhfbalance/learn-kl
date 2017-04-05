/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnXML;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author LouHF
 *
 */
public class JavaBean2XMLFile {

  /**
   * @param args
   * @throws JAXBException 
   */
  public static void main(String[] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
    
    Classroom cr = new Classroom();
    cr.setId(618);
    cr.setGrade(2);
    cr.setName("haifeng");
    Student student = new Student(618, "haifeng", 22, cr);
    marshaller.marshal(student, new File("student2.xml"));

  }

}
