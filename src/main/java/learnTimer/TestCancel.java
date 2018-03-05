package learnTimer;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class TestCancel {

  public static void main(String[] args) throws IOException, InterruptedException {
    
    Timer timer = new Timer(false);
    timer.schedule(new myTimerTask(), 10, 1000);
    
    System.out.println("press 'enter' to stop timer");
    System.in.read();
    System.out.println("cancel have been execute");
    timer.cancel();
    timer.cancel();
    timer.cancel();
    System.out.println("cancel have been executed 3 times");
    
    /*TimeUnit.SECONDS.sleep(5);
    timer.cancel();
    System.out.println("call cancel");
    TimeUnit.SECONDS.sleep(5);
    timer.purge();
    System.out.println("call purge");*/
    
    Thread t = new Thread(new myTimerTask());
    t.start();
    TimeUnit.SECONDS.sleep(5);
    t.interrupt();
    System.out.println("call interrupt");

  }

}


class myTimerTask extends TimerTask {

  @Override
  public void run() {

    while (!Thread.interrupted()) {
      try {
        System.out.println(System.in.read());
        System.out.println(Thread.currentThread().isInterrupted());
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

  }
}
