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
public class OSExecute {
  public static void command(String command) {
    boolean err = false;
    
    try {
      Process process = new ProcessBuilder(command.split(" ")).start();
      
      BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
      
      String string;
      
      while ((string = results.readLine()) != null) {
        System.out.println(string);
      }
      
      BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
      
      while ((string = errors.readLine()) != null) {
        System.err.println(string);
        err = true;
      }
    } catch (IOException e) {
      if (!command.startsWith("CMD /C")) {
        command("CMD /C" + command);
      } else {
        throw new RuntimeException(e);
      }
    }
    
    if (err) {
      throw new OSExecuteException("Errors executing " + command);
    }
  }
  
  public static void main(String[] args) {
    command("javap .\\bin\\learnIO\\OSExecuteException.class");
  }

}
