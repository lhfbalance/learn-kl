/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnUdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LouHF
 *
 */
public class QuoteClient {

  public static void main(String[] args) throws IOException {
    InetAddress address;
    DatagramSocket socket = null;
    DatagramPacket packet;
    byte[] sendBuf = new byte[256];

    if (args.length != 1) {
      System.out.println("Usage: java QuoteClient <hostname>");
      return;
    }
    
    socket = new DatagramSocket();
    System.out.println(socket.getLocalPort());
    
    address = InetAddress.getByName(args[0]);
    packet = new DatagramPacket(sendBuf, sendBuf.length, 
                                    address, 4445);
    socket.send(packet);
    
    byte[] buf = new byte[256];
    packet = new DatagramPacket(buf, buf.length);
    
    socket.receive(packet);
    
    String received = new String(packet.getData(), 0, packet.getLength());
    System.out.println("Quote of the Moment: \n" + received);
    
    socket.close();
  }

}
