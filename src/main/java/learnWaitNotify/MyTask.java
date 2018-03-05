/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnWaitNotify;

import org.snmp4j.util.WorkerTask;
/**
 * @author LouHF
 *
 */
public class MyTask implements WorkerTask{
  
  private String name;
  
  /**
   * 
   */
  public MyTask(String name) {
    this.name = name;
  }

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    System.out.println(this.name + " running");
    
  }

  /* (non-Javadoc)
   * @see org.snmp4j.util.WorkerTask#terminate()
   */
  @Override
  public void terminate() {
    
  }

  /* (non-Javadoc)
   * @see org.snmp4j.util.WorkerTask#join()
   */
  @Override
  public void join() throws InterruptedException {
    // TODO Auto-generated method stub
    
  }

  /* (non-Javadoc)
   * @see org.snmp4j.util.WorkerTask#interrupt()
   */
  @Override
  public void interrupt() {
    // TODO Auto-generated method stub
    
  }

}
