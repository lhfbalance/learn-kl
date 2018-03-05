/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package netty.wnio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LouHF
 *
 */
public class TimeServer {

  public static void main(String[] args) {
    
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(4556);
      TimeServerHandlerExecutePoll singleExecutor = new TimeServerHandlerExecutePoll(50, 10000);
      while(true) {
        Socket socket = serverSocket.accept();
        singleExecutor.execute(new TimeServerHandler(socket));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      
    }

  }

}
