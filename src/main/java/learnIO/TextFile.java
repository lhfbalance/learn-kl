/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author LouHF
 *
 */
public class TextFile extends ArrayList<String> {

  public static String read(String fileName) {
    StringBuilder sb = new StringBuilder();
    BufferedReader in = null;
    try {
      in = new BufferedReader(new FileReader(fileName));

      String s;
      while ((s = in.readLine()) != null) {

        sb.append(s);
        sb.append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        in.close();
      } catch (IOException e) {
        throw new RuntimeException();
      }
    }
    return sb.toString();
  }

  public static void write(String fileName, String text) {

    try {
      PrintWriter out = new PrintWriter(new File(fileName).getAbsolutePath());
      try {
        out.println(text);
      } finally {
        out.close();
      }
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
  
  public TextFile(String filename, String splitter) {
    super(Arrays.asList(read(filename).split(splitter)));
    if (get(0).equals("")) {
      remove(0);
    }
  }
  
  public TextFile(String fileName) {
    this(fileName, "\n");
  }
  
  public void write(String fileName) {
    try {
      PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
      try {
        for (String item : this) {
          out.println(item);
        }
      } finally {
        out.close();
      }
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
  
  public static void main(String[] args) {
    String file = read(".\\src\\learnIO\\TextFile.java");
    write("test.txt", file);
    TextFile textFile = new TextFile("test.txt");
    textFile.write("test2.txt");
    TreeSet<String> words = new TreeSet<String>(new TextFile(".\\src\\learnIO\\TextFile.java", "\\W+"));
    System.out.println(words.headSet("a"));
  }

}
