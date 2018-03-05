/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author LouHF
 *
 */
public class StoringAndRecoveringData {

  public static void main(String[] args) throws IOException {
    File file = new File(".\\Data.txt");
    if (!file.exists()) {
      file.createNewFile();
    }
    //DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    DataOutputStream dout = new DataOutputStream(new FileOutputStream(file));
    dout.writeDouble(3.141592654);
    dout.writeUTF("that is pi");
    dout.writeDouble(1.41431);
    dout.writeUTF("Square root of 2");
    dout.close();
    
    DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
    System.out.println(din.readDouble());
    System.out.println(din.readUTF());
    System.out.println(din.readDouble());
    System.out.println(din.readUTF());
    din.close();
    
    PrintWriter pw = new PrintWriter(file);
    pw.write("1231223131331131313\n");
    pw.write("1231223131331131313\n");
    pw.flush();
    pw.close();
    
    PrintStream ps = new PrintStream(new FileOutputStream(file));
    ps.print("adfbdfadfadfadfasdf\n");
    ps.flush();
    ps.close();
  }
}
