/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author LouHF
 *
 */
public class FormattedMemoryInput {

  public static void main(String[] args) {
    try {
      DataInputStream in = new DataInputStream(new ByteArrayInputStream(
          BufferedInputFile.read(".\\src\\learnIO\\FormattedMemoryInput.java").getBytes()));

      while (true) {
        System.out.println((char) in.readByte());
      }
    } catch (EOFException e) {
      System.err.println("End of stream");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
