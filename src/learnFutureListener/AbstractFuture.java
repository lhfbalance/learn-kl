/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnFutureListener;

import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author LouHF
 *
 */
public class AbstractFuture<V> implements IFuture<V> {

  protected volatile Object result;

  protected Collection<IFutureListener<V>> listeners = new CopyOnWriteArrayList<>();

  /**
   * ����������ִ�н��Ϊnullʱ, ���ͻ��˵���{@link AbstractFuture#setSuccess(null)}ʱ, result���øö���
   */
  private static final SuccessSignal SUCCESS_SIGNAL = new SuccessSignal();

  @Override
  public boolean cancel(boolean mayInterruptIfRunning) {
    if (isDone()) {
      return false;
    }

    synchronized (this) {
      if (isDone()) {
        return false;
      }
      result = new CauseHolder(new CancellationException());
      notifyAll();// isDone = true, ֪ͨ�ȴ��ڸö����wait()���߳�
    }
    notifyListeners();
    return false;
  }

  /*
   * 1.δ���֮ǰ
   */
  @Override
  public boolean isCancellable() {

    return result == null;
  }

  /*
   * ��result���ж��Ƿ�ִ�й�cancel()����
   */
  @Override
  public boolean isCancelled() {
    return result != null && result instanceof CauseHolder
        && ((CauseHolder) result).cause instanceof CancellationException;
  }

  @Override
  public boolean isDone() {

    return result != null;
  }

  @Override
  public V get() throws InterruptedException, ExecutionException {
    await(); // �ȴ�ִ�н��

    Throwable cause = cause();
    if (cause == null) { // û�з����쳣���첽������������
      return getNow();
    }
    if (cause instanceof CancellationException) { // �첽������ȡ����
      throw (CancellationException) cause;
    }
    throw new ExecutionException(cause); // �����쳣
  }

  @Override
  public V get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {

    if (await(timeout, unit)) {// ��ʱ�ȴ�ִ�н��
      Throwable cause = cause();
      if (cause == null) {// û�з����쳣���첽������������
        return getNow();
      }
      if (cause instanceof CancellationException) {// �첽������ȡ����
        throw (CancellationException) cause;
      }
      throw new ExecutionException(cause);// �����쳣
    }
    // ʱ�䵽���첽������û�н���, �׳���ʱ�쳣
    throw new TimeoutException();
  }


  /*
   * �Զ����Future����
   */

  @Override
  public boolean isSuccess() {
    return result == null ? false : !(result instanceof CauseHolder);
  }

  @SuppressWarnings("unchecked")
  @Override
  public V getNow() {
    return (V) (result == SUCCESS_SIGNAL ? null : result);
  }

  @Override
  public Throwable cause() {
    if (result != null && result instanceof CauseHolder) {
      return ((CauseHolder) result).cause;
    }
    return null;
  }


  /*
   * û��������
   */
  @Override
  public IFuture<V> await() throws InterruptedException {

    return await0(true);

  }

  @Override
  public IFuture<V> awaitUninterruptibly() {
    try {
      return await0(false);
    } catch (InterruptedException e) { // ���������쳣�˾��޷�������
      throw new java.lang.InternalError();
    }
  }

  private IFuture<V> await0(boolean interruptable) throws InterruptedException {
    if (!isDone()) { // ������ɾ�ֱ�ӷ�����
      // �������ն��ұ��ж������׳��ж��쳣
      if (interruptable && Thread.interrupted()) {
        throw new InterruptedException(
            "thread " + Thread.currentThread().getName() + " has been interrupted.");
      }

      boolean interrupted = false;
      synchronized (this) {
        while (!isDone()) {
          try {
            wait(); // �ͷ�������waiting״̬���ȴ������̵߳��ñ������notify()/notifyAll()����
          } catch (InterruptedException e) {
            if (interruptable) {
              throw e;
            } else {
              interrupted = true;
            }
          }
        }
      }
      if (interrupted) {
        // Ϊʲô����Ҫ���жϱ�־λ����Ϊ��wait�������غ�, �жϱ�־�Ǳ�clear�˵�??//TODO
        // �������������Ա�����������֪�����ﱻ�ж��ˡ�
        Thread.currentThread().interrupt();
      }
    }
    return this;
  }

  /*
   * û��������
   */

  @Override
  public boolean await(long timeoutMillis) throws InterruptedException {
    return await0(TimeUnit.MILLISECONDS.toNanos(timeoutMillis), true);
  }

  @Override
  public boolean await(long timeout, TimeUnit timeunit) throws InterruptedException {
    return await0(timeunit.toNanos(timeout), true);
  }

  private boolean await0(long timeoutNanos, boolean interruptable) throws InterruptedException {
    if (isDone()) {
      return true;
    }

    if (timeoutNanos <= 0) {
      return isDone();
    }

    if (interruptable && Thread.interrupted()) {
      throw new InterruptedException(toString());
    }

    long startTime = timeoutNanos <= 0 ? 0 : System.nanoTime();
    long waitTime = timeoutNanos;
    boolean interrupted = false;

    try {
      synchronized (this) {
        if (isDone()) {
          return true;
        }

        if (waitTime <= 0) {
          return isDone();
        }

        for (;;) {
          try {
            wait(waitTime / 1000000, (int) (waitTime % 1000000));
          } catch (InterruptedException e) {
            if (interruptable) {
              throw e;
            } else {
              interrupted = true;
            }
          }

          if (isDone()) {
            return true;
          } else {
            waitTime = timeoutNanos - (System.nanoTime() - startTime);
            if (waitTime <= 0) {
              return isDone();
            }
          }
        }
      }
    } finally {
      if (interrupted) {
        Thread.currentThread().interrupt();
      }
    }
  }



  /**
   * Ĭ�Ϻ���Ϊ��λ
   * 
   * @param timeoutMillis
   * @return
   */
  @Override
  public boolean awaitUninterruptibly(long timeoutMillis) {
    try {
      return await0(TimeUnit.MILLISECONDS.toNanos(timeoutMillis), false);
    } catch (InterruptedException e) {
      throw new java.lang.InternalError();
    }
  }

  /**
   * 
   * @param timeoutMillis
   * @return
   */
  @Override
  public boolean awaitUninterruptibly(long timeout, TimeUnit timeunit) {
    try {
      return await0(timeunit.toNanos(timeout), false);
    } catch (InterruptedException e) {
      throw new java.lang.InternalError();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see learnFutureListener.IFuture#addListener(learnFutureListener.IFutureListener)
   */
  @Override
  public IFuture<V> addListener(IFutureListener<V> listener) {
    if (listener == null) {
      throw new NullPointerException("listener");
    }
    if (isDone()) { // �������ֱ��֪ͨ�ü�����
      notifyListener(listener);
      return this;
    }
    synchronized (this) {
      if (!isDone()) {
        listeners.add(listener);
        return this;
      }
    }
    notifyListener(listener);
    return this;
  }

/**
 * 
 * @param listener
 * @return
 */
  @Override
  public IFuture<V> removeListener(IFutureListener<V> listener) {
    if (listener == null) {
      throw new NullPointerException("listener");
    }

    if (!isDone()) {
      listeners.remove(listener);
    }

    return this;
  }


  /**
   * �����첽�Ľ��
   * 
   * @param cause
   * @return
   */
  protected IFuture<V> setFailure(Throwable cause) {
    if (setFailure0(cause)) {
      notifyListeners();
      return this;
    }
    throw new IllegalStateException("complete already: " + this);
  }

  private boolean setFailure0(Throwable cause) {
    if (isDone()) {
      return false;
    }

    synchronized (this) {
      if (isDone()) {
        return false;
      }
      result = new CauseHolder(cause);
      notifyAll();
    }

    return true;
  }

  protected IFuture<V> setSuccess(Object result) {
    if (setSuccess0(result)) { // ���óɹ���֪ͨ������
      notifyListeners();
      return this;
    }
    throw new IllegalStateException("complete already: " + this);
  }

  private boolean setSuccess0(Object result) {
    if (isDone()) {
      return false;
    }

    synchronized (this) {
      if (isDone()) {
        return false;
      }
      if (result == null) { // �첽��������ִ����ϵĽ����null
        this.result = SUCCESS_SIGNAL;
      } else {
        this.result = result;
      }
      notifyAll();
    }
    return true;
  }



  private void notifyListeners() {
    for (IFutureListener<V> l : listeners) {
      notifyListener(l);
    }
  }

  private void notifyListener(IFutureListener<V> listener) {
    try {
      listener.operationCompleted(this);// ��������ȥ����listener�鿴future�Ľ��
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static class SuccessSignal {

  }

  private static final class CauseHolder {
    final Throwable cause;

    CauseHolder(Throwable cause) {
      this.cause = cause;
    }
  }

}
