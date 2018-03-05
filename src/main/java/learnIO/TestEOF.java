/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author LouHF
 *
 */
public class TestEOF {

  public static void main(String[] args) throws IOException {
    DataInputStream in = new DataInputStream(
        new BufferedInputStream(new FileInputStream(".\\src\\learnIO\\TestEOF.java")));
    
    while (in.available() != 0) {
      System.out.println((char)in.readByte());
    }
    System.out.println("hhh");
  }
}
