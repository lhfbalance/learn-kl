/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnNIO;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @author LouHF
 *
 */
public class AvailableCharSets {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    ByteBuffer bb = ByteBuffer.allocate(1024);
    bb.asCharBuffer().put("asfds");
    byte[] ba = new byte[24];
    bb = ByteBuffer.wrap(ba);
    char[] ca = new char[24];
    CharBuffer.wrap(ca);

    SortedMap<String, Charset> charSets = Charset.availableCharsets();
    Iterator<String> iterator = charSets.keySet().iterator();
    while (iterator.hasNext()) {
      String csName = iterator.next();
      System.out.print(csName);
      Iterator<String> aliases = charSets.get(csName).aliases().iterator();
      
      if (aliases.hasNext()) {
        System.out.print(": ");
      }
      while(aliases.hasNext()) {
        System.out.print(aliases.next());
        if (aliases.hasNext()) {
          System.out.print(", ");
        }
      }
      System.out.println("");
    }
  }

}
