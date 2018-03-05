/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author LouHF
 *
 */
public class Redirecting {

  /**
   * @param args
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException {

    PrintStream console = System.out;
    BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(".\\src\\learnIO\\Redirecting.java"));
    PrintStream out = new PrintStream(new FileOutputStream(".\\test.out"));
    System.setIn(inputStream);
    System.setOut(out);
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    String s;
    while ((s = br.readLine()) != null) {
      System.out.println(s);
    }
    
    out.close();
    
    inputStream.close();
    System.setOut(console);
  }

}
