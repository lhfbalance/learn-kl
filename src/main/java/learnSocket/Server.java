/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnSocket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LouHF
 *
 */
public class Server {

  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(4555);
    Socket socket = ss.accept();
    BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
    System.out.println("someone connected :" + socket.getInetAddress());
    
    System.out.println("read something:");
    byte[] b = new byte[10];
    in.read(b);
    for (int i = 0; i < b.length; i++) {
      System.out.print(b[i]);
    }
    ss.close();
  }

}
