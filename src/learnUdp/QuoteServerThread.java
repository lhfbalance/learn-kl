/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnUdp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Date;

/**
 * @author LouHF
 *
 */
public class QuoteServerThread extends Thread {

  DatagramSocket socket;
  BufferedReader in;
  
  boolean stopFlag = false;

  /**
   * @throws SocketException
   * 
   */
  public QuoteServerThread() throws IOException {
    this("QuoteServer");
  }

  /**
   * @throws SocketException
   * 
   */
  public QuoteServerThread(String name) throws IOException {
    super(name);
    socket = new DatagramSocket(4445);

    try {
      in = new BufferedReader(new FileReader("one-liner.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("Couldn't open quote file.  Serving time instead.");
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Thread#run()
   */
  @Override
  public void run() {
    while (true) {

      byte[] buf = new byte[255];
      DatagramPacket dp = new DatagramPacket(buf, buf.length);
      try {
        socket.receive(dp);
      } catch (IOException e) {
        e.printStackTrace();
      }

      String dString = null;
      if (in == null)
        dString = new Date().toString();
      else
        dString = getNextQuote();
      
      if (dString == null) {
        dString = "end";
        stopFlag = true;
      }
      
      buf = dString.getBytes();

      InetAddress address = dp.getAddress();
      int port = dp.getPort();
      System.out.println("client infomation : " + address.getHostAddress() + "/" + port);
      dp = new DatagramPacket(buf, buf.length, address, port);
      try {
        socket.send(dp);
      } catch (IOException e) {
        e.printStackTrace();
      }
      
      if (stopFlag) {
        break;
      }
      
    }
    
    socket.close();
    try {
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @return
   */
  private String getNextQuote() {
    String quote;
    try {
      quote = in.readLine();
    } catch (IOException e) {
      quote = e.getMessage();
    }
    return quote;
  }

}
