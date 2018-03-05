/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * @author LouHF
 *
 */
public class UsingRandomAccessFile {
  
  static String file = "rtest.bat";
  static void display() throws IOException {
    RandomAccessFile raf = new RandomAccessFile(file, "r");
    for(int i = 0; i < 7; i++) {
      System.out.println("value " + i + ": " + raf.readDouble());
    }
    System.out.println(raf.readUTF());
    raf.close();
  }
  
  public static void main(String[] args) throws IOException {
    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
    for (int i = 0; i < 7; i++) {
      randomAccessFile.writeDouble(i * 1.144);
    }
    randomAccessFile.writeUTF("the end of the file");
    randomAccessFile.close();
    
    display();
    randomAccessFile = new RandomAccessFile(file, "rw");
    randomAccessFile.seek(7*8);
    randomAccessFile.writeDouble(47.22);
    randomAccessFile.close();
    display();
  }
  
  

}
