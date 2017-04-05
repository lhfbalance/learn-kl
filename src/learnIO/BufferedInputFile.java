/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LouHF
 *
 */
public class BufferedInputFile {
  
  public static String read(String filename) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(filename));
    String s;
    StringBuilder sb = new StringBuilder();
    while ((s = in.readLine()) != null) {
      sb.append(s);
    }
    in.close();
    return sb.toString();

  }
  public static String input(String filename) throws IOException {
    BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
    byte[] b = new byte[8012];
    in.read(b);
   
    in.close();
    return new String(b);

  }
  
  public static void main(String[] args) throws IOException {
    System.out.println(read(".\\src\\learnIO\\BufferedInputFile.java"));
    System.out.println(input("E:\\workspace\\learn@koal\\src\\learnIO\\BufferedInputFile.java"));
  }

}
