/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public class Test {

  /**
   * @param args
   * @throws InterruptedException 
   * @throws ExecutionException 
   */
  public static void main(String[] args) throws InterruptedException, ExecutionException {
    /*
     * ���̣߳�˳���ȡ�̵߳�ʹ��Ȩ
     */
//    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
//    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
//    TimeUnit.SECONDS.sleep(10);
//    executor.shutdown();
    
    /*
     * �̳߳ط�ʽ�������߳��������񣬸�������һ���̣߳��ֱ����л�������
     */
//    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
//    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
//    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
//    TimeUnit.SECONDS.sleep(10);
//    executor.shutdown();
    /*
     * �̳߳ط�ʽ��һ���߳��������񣬺͵��߳�ûʲô����
     */
//    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
//    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
//    TimeUnit.SECONDS.sleep(10);
//    executor.shutdown();
    /*
     * �̳߳ط�ʽ�������߳���������
     */
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
    executor.scheduleAtFixedRate(new MyTask1(), 0, 1, TimeUnit.SECONDS);
    executor.scheduleAtFixedRate(new MyTask2(), 0, 1, TimeUnit.SECONDS);
    executor.scheduleAtFixedRate(new MyTask3(), 0, 1, TimeUnit.SECONDS);
    TimeUnit.SECONDS.sleep(10);
    executor.shutdown();

  }

}
