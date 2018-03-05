/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author LouHF
 *
 */
public class BasicFileOutput {

  static String outFile = "BasicFileOutput.out";
  static String outFile1 = "BasicFileOutput1.out";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(".\\src\\learnIO\\BasicFileOutput.java"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
    PrintWriter pw1 = new PrintWriter(new FileWriter(outFile1));
    
    int lineCount = 1;
    String s;
    while ((s = br.readLine()) != null) {
      pw.println(lineCount + ":" + s + "\n");
      pw1.println(lineCount++ + ":" + s + "\n");
    }

    pw.close();
    pw1.close();
    System.out.println(lineCount);
    System.out.println("outFile:");
    System.out.println(BufferedInputFile.read(outFile));
    System.out.println("outFile1:");
    System.out.println(BufferedInputFile.read(outFile1));
  }
}
