/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author LouHF
 *
 */
public interface IFuture<V> extends Future<V> {

  boolean isSuccess(); // �Ƿ�ɹ�

  V getNow(); // �������ؽ��(����Future�Ƿ������״̬)

  Throwable cause(); // ��ִ��ʧ��ʱ��ԭ��

  boolean isCancellable(); // �Ƿ����ȡ��

  IFuture<V> await() throws InterruptedException; // �ȴ�future�����

  boolean await(long timeoutMillis) throws InterruptedException; // ��ʱ�ȴ�future�����

  boolean await(long timeout, TimeUnit timeunit) throws InterruptedException;

  IFuture<V> awaitUninterruptibly(); // <span style="line-height: 1.5;">�ȴ�future����ɣ�����Ӧ�ж�</span>

  boolean awaitUninterruptibly(long timeoutMillis);// <span style="line-height:
                                                   // 1.5;">//��ʱ</span><span style="line-height:
                                                   // 1.5;">�ȴ�future����ɣ�����Ӧ�ж�</span>

  boolean awaitUninterruptibly(long timeout, TimeUnit timeunit);

  IFuture<V> addListener(IFutureListener<V> l); // ��future���ʱ����֪ͨ��Щ�ӽ����ļ�����

  IFuture<V> removeListener(IFutureListener<V> l);

}
