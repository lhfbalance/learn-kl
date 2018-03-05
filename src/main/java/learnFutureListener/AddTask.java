package learnFutureListener;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AddTask implements Callable<Integer> {

  private int a, b;

  public AddTask(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public Integer call() throws Exception {

    Integer result = a + b;
    TimeUnit.SECONDS.sleep(2);
    return result;
  }

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // JDK目前为止返回的都是FutureTask的实例
    Future<Integer> future = executor.submit(new AddTask(1, 2));
    Integer result = future.get();// 只有当future的状态是已完成时(future.isDone() = true),get()方法才会返回

    System.out.println(result);
  }
}
