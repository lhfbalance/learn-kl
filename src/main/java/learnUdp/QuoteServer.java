/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnUdp;

import java.io.IOException;

/**
 * @author LouHF
 *
 */
public class QuoteServer {

  /**
   * @param args
   * @throws IOException 
   */
  public static void main(String[] args) throws IOException {
    new QuoteServerThread().start();
  }

}
