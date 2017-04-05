/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author LouHF
 *
 */
public class FileOutputShortcut {

  static String outFile = "FileOutputShortcut.out";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new StringReader(BufferedInputFile.read(".\\src\\learnIO\\BasicFileOutput.java")));
    PrintWriter out = new PrintWriter(outFile);
    int lineCount = 1;
    String s;
    while ((s = br.readLine()) != null) {
      out.println(lineCount++ + ": " + s);
    }
    out.close();
    System.out.println(BufferedInputFile.read(outFile));
  }

}
