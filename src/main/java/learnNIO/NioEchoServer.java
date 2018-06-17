/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnNIO;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioEchoServer {
  private static final int BUF_SIZE = 256;
  private static final int TIMEOUT = 3000;

  public static void main(String args[]) throws Exception {
      // �򿪷���� Socket
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

      // �� Selector
      Selector selector = Selector.open();

      // ����� Socket ����8080�˿�, ������Ϊ������ģʽ
      serverSocketChannel.socket().bind(new InetSocketAddress(8080));
      serverSocketChannel.configureBlocking(false);

      // �� channel ע�ᵽ selector ��.
      // ͨ�����Ƕ�����ע��һ�� OP_ACCEPT �¼�, Ȼ���� OP_ACCEPT ����ʱ, �ٽ���� Channel �� OP_READ
      // ע�ᵽ Selector ��.
      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

      while (true) {
          // ͨ������ select ����, �����صȴ� channel I/O �ɲ���
          if (selector.select(TIMEOUT) == 0) {
              System.out.print(".");
              continue;
          }

          // ��ȡ I/O ���������� SelectionKey, ͨ�� SelectionKey ����֪����Щ Channel ������ I/O �����Ѿ�����.
          Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

          while (keyIterator.hasNext()) {

              SelectionKey key = keyIterator.next();

              // ����ȡһ�� SelectionKey ��, ��Ҫ����ɾ��, ��ʾ�����Ѿ������ IO �¼������˴���.
              keyIterator.remove();

              if (key.isAcceptable()) {
                  // �� OP_ACCEPT �¼�����ʱ, ���Ǿ��д� ServerSocketChannel �л�ȡһ�� SocketChannel,
                  // ����ͻ��˵�����
                  // ע��, �� OP_ACCEPT �¼���, �� key.channel() ���ص� Channel �� ServerSocketChannel.
                  // ���� OP_WRITE �� OP_READ ��, �� key.channel() ���ص��� SocketChannel.
                  SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
                  clientChannel.configureBlocking(false);
                  //�� OP_ACCEPT ����ʱ, �ٽ���� Channel �� OP_READ ע�ᵽ Selector ��.
                  // ע��, �����������û������ OP_READ �Ļ�, �� interest set ��Ȼ�� OP_CONNECT �Ļ�, ��ô select ������һֱֱ�ӷ���.
                  clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(BUF_SIZE));
              }

              if (key.isReadable()) {
                  SocketChannel clientChannel = (SocketChannel) key.channel();
                  ByteBuffer buf = (ByteBuffer) key.attachment();
                  long bytesRead = clientChannel.read(buf);
                  if (bytesRead == -1) {
                      clientChannel.close();
                  } else if (bytesRead > 0) {
                      key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                      System.out.println("Get data length: " + bytesRead);
                  }
              }

              if (key.isValid() && key.isWritable()) {
                  ByteBuffer buf = (ByteBuffer) key.attachment();
                  buf.flip();
                  SocketChannel clientChannel = (SocketChannel) key.channel();

                  clientChannel.write(buf);

                  if (!buf.hasRemaining()) {
                      key.interestOps(SelectionKey.OP_READ);
                  }
                  buf.compact();
              }
          }
      }
  }
}
