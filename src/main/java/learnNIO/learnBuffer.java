/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnNIO;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * @author LouHF
 *
 */
public class learnBuffer {

  static void efficiencyTest() {
    
    int cycle = 100;

    long point1 = System.currentTimeMillis();

    for (int i = cycle; i > 0; i--)
      ByteBuffer.allocate(1024 * 1024);

    long point2 = System.currentTimeMillis();

    for (int i = cycle; i > 0; i--)
      ByteBuffer.allocateDirect(1024 * 1024);

    long point3 = System.currentTimeMillis();

    System.out.println(point2 - point1);
    System.out.println(point3 - point2);

  }
  
  static void testBuffer() {
    
    ByteBuffer byteBuffer = ByteBuffer.allocate(100);
    byteBuffer.limit(50);
    byte byte1 = 1;
    byteBuffer.put(byte1);

    System.out.println(byteBuffer.capacity());
    System.out.println(byteBuffer.limit());
    System.out.println(byteBuffer.remaining());
    
  }

  public static void main(String[] args) {
    

  }

}
