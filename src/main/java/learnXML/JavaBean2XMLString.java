/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnXML;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author LouHF
 *
 */
public class JavaBean2XMLString {

  /**
   * @param args
   * @throws JAXBException 
   */
  public static void main(String[] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
    Marshaller marshaller = jaxbContext.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
    marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "1231231");
    marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "abcd");
    
    Classroom cr = new Classroom();
    cr.setId(618);
    cr.setGrade(2);
    cr.setName("haifeng");
    Student student = new Student(618, "haifeng", 22, cr);
    
    StringWriter stringWriter = new StringWriter();
    marshaller.marshal(student, stringWriter);
    
    System.out.println(stringWriter.toString());

  }

}
