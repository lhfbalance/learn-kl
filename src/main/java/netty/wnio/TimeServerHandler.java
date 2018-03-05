/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package netty.wnio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Date;

/**
 * @author LouHF
 *
 */
public class TimeServerHandler implements Runnable {
  
  private Socket socket;
  
  /**
   * @param socket
   */
  public TimeServerHandler(Socket socket) {
    this.socket = socket;
  }

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {

    BufferedReader in = null;
    PrintWriter out = null;
    try {
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out = new PrintWriter(socket.getOutputStream(), true);
      String currentTime = null;
      String body = null;
      while(true) {
        body = in.readLine();
        if (body == null) {
          break;
        }
        System.out.println("The time server receive order : " + body);
        currentTime = new Date(System.currentTimeMillis()).toString();
        out.println(currentTime);
      }
    } catch (IOException e) {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      if (out != null) {
        out.close();
        out = null;
      }
      if (this.socket != null) {
        try {
          this.socket.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
        this.socket = null;
      }
    }
  }

}
