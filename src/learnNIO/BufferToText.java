/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnNIO;

import java.nio.Buffer;
import java.nio.charset.Charset;

/**
 * @author LouHF
 *
 */
public class BufferToText {
  
  private static final int BSIZE = 1024;

  /**
   * @param args
   */
  public static void main(String[] args) {

    
    String encoding = System.getProperty("file.encoding");
    System.out.println(encoding);
    //Charset.forName(encoding).decode(buffer);
  }

}
