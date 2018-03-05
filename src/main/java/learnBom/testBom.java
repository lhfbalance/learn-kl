package learnBom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import learnXML.Student;

public class testBom {
  
  public static void main(String[] args) throws IOException, JAXBException {
    
    InputStream inputStream = null;
    InputStream inputStream2 =null;
    
    byte[] b1 = null;
    byte[] b2 = null;
    
    try {
      inputStream = new FileInputStream(new File("student.xml"));
      System.out.println(inputStream.available());
      inputStream2 = new FileInputStream(new File("student2.xml"));
      System.out.println(inputStream2.available());
      
      b1 = new byte[inputStream.available()];
      b2 = new byte[inputStream2.available()];
      inputStream.read(b1);
      inputStream2.read(b2);
      
      System.out.println(Arrays.equals(b1, b2));
      
      System.out.println(new String(b1));
      System.out.println(new String(b2));
      
      System.out.println(Byte.toUnsignedInt(b2[0]));
      System.out.println(Byte.toUnsignedInt(b2[1]));
      System.out.println(Byte.toUnsignedInt(b2[2]));
      
      
    } finally {
      inputStream.close();
      inputStream2.close();
    }
    
    JAXBContext context = JAXBContext.newInstance(Student.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    Student student1 = (Student) unmarshaller.unmarshal(new StringReader(new String(b1)));
    System.out.println(student1.getName());
//    Student student2 = (Student) unmarshaller.unmarshal(new StringReader(new String(b2)));
//    System.out.println(student2.getName());
    
    
  }

}
