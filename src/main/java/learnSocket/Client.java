/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnSocket;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author LouHF
 *
 */
public class Client {

  /**
   * @param args
   * @throws IOException 
   * @throws UnknownHostException 
   */
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("127.0.0.1", 4556);
    //OutputStream outputStream = socket.getOutputStream();
    //ByteArrayOutputStream bStream = new ByteArrayOutputStream(100);
    BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
    byte[] b = {1,2,3,4,5,6,7,8,9,0};
    out.write(b);
    out.flush();//手动flush
    //outputStream.write(b);
    //outputStream.flush();
    socket.close();

  }

}
