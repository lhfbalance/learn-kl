/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @author LouHF
 *
 */
public class TestAddress {
  
  public static void main(String[] args) throws IOException {
    
    //ip��ַ�Ӷ˿ڵķ�ʽ
//    InetAddress address = InetAddress.getByName("192.168.1.100");
//    InetSocketAddress socketAddress = new InetSocketAddress(address, 5000);
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());
//    System.out.println(socketAddress.isUnresolved());//���������������
//    System.out.println(socketAddress.getAddress().getHostAddress());
    
    //ip�Ӷ˿ڵķ�ʽ�����캯�������������ǰһ����ʽһģһ����
//    InetSocketAddress socketAddress = new InetSocketAddress("192.168.1.100", 5000);//�˹��캯����һ�������ȿ��Դ��������ֿ��Դ���ip��ַ
//    
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());//���������������
//    System.out.println(socketAddress.isUnresolved());//�����Ǵ������ip��ַ�����������־λ���ᱻ��Ϊtrue
//    System.out.println(socketAddress.getAddress().getHostAddress());
//    System.out.println(socketAddress.getAddress().getHostAddress());
    
    //�����Ӷ˿ڵķ�ʽ
//    InetSocketAddress socketAddress = new InetSocketAddress("www.test0011.com", 5000);//������������������InetAddress������ɹ���hostname����null������ܲ���⣿��
//    
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());//������캯�����������ɹ�����Ϊip�������ﻹ��������������������û�н�����ip����ô���ﲻ���ٵ���������������
//    System.out.println(socketAddress.isUnresolved());//true��ʶhostname���ܲ�������ip��ַ
//    System.out.println(socketAddress.getAddress().getHostAddress());
    
    
    //�����Ӷ˿ڣ��Ҳ���������������
//    InetSocketAddress socketAddress = InetSocketAddress.createUnresolved("www.addr.11", 50000);//�����������Ҳ�����������������
//    
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());
//    System.out.println(socketAddress.getAddress().getHostAddress());//��Ϊ����������������������InetAddressΪnull������ָ��
    
    
  }

}
