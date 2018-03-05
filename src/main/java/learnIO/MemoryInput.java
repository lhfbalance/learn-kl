/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author LouHF
 *
 */
public class MemoryInput {

  /**
   * @param args
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException {

    StringReader in = new StringReader(BufferedInputFile.read(".\\src\\learnIO\\BufferedInputFile.java"));
    int c;
    while ((c = in.read()) != -1) {
      System.out.println((char) c);
      
    }
  }

}
