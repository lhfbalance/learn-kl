/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LouHF
 *
 */
public class Echo {
  
  public static void main(String[] args) throws IOException {
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    
    String s;
    
    while((s = stdin.readLine()) != null && s.length() !=0) {
      System.out.println(s);
    }
  }

}
