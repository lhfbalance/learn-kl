package learnConcurrent;

import java.util.concurrent.TimeUnit;

public class ExceptionReleaseLock {
  
  private int count;
  
  public synchronized void m(){
    while(true){
      System.out.println(Thread.currentThread().getName() + "-------" + count);
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      count ++;
      if (count == 5) {
        int i = 1/0;
      }
    }
  }
  
  public static void main(String[] args) {
    final ExceptionReleaseLock T = new ExceptionReleaseLock();
    
    Runnable r = new Runnable() {
      
        public void run() {
          T.m();
        }
    };
    new Thread(r).start();
    
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    T.m();
  }

}
