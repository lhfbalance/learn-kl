package learnCallable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestMytask {
  
  public static void main(String[] args) throws InterruptedException {
    MyTaskResult r1 = new MyTaskResult();
    MyTaskResult r2 = new MyTaskResult();
    MyTask task1 = new MyTask(r1);
    MyTask task2 = new MyTask(r2);
    
    ExecutorService service = Executors.newFixedThreadPool(2);
    service.submit(task1);
    service.submit(task2);
    
    System.out.println(r1.isDone());
    System.out.println(r2.isDone());
    
    TimeUnit.SECONDS.sleep(2);
    
    System.out.println(r1.isDone());
    System.out.println(r2.isDone());
    
    service.shutdown();
    
  }

}
