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
    
    //ip地址加端口的方式
//    InetAddress address = InetAddress.getByName("192.168.1.100");
//    InetSocketAddress socketAddress = new InetSocketAddress(address, 5000);
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());
//    System.out.println(socketAddress.isUnresolved());//会调域名解析服务
//    System.out.println(socketAddress.getAddress().getHostAddress());
    
    //ip加端口的方式（构造函数里做得事情跟前一个方式一模一样）
//    InetSocketAddress socketAddress = new InetSocketAddress("192.168.1.100", 5000);//此构造函数第一个参数既可以传入域名又可以传入ip地址
//    
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());//会调域名解析服务
//    System.out.println(socketAddress.isUnresolved());//构造是传入的是ip地址，所以这个标志位不会被置为true
//    System.out.println(socketAddress.getAddress().getHostAddress());
//    System.out.println(socketAddress.getAddress().getHostAddress());
    
    //域名加端口的方式
//    InetSocketAddress socketAddress = new InetSocketAddress("www.test0011.com", 5000);//会掉域名解析服务，填充InetAddress，如果成功，hostname会是null，这个很不理解？？
//    
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());//如果构造函数中域名被成功解析为ip，那这里还会调用域名服务器，如果没有解析成ip，那么这里不会再调用域名服务器了
//    System.out.println(socketAddress.isUnresolved());//true标识hostname不能不解析成ip地址
//    System.out.println(socketAddress.getAddress().getHostAddress());
    
    
    //域名加端口，且不调用域名服务器
//    InetSocketAddress socketAddress = InetSocketAddress.createUnresolved("www.addr.11", 50000);//传入域名，且不调用域名解析服务
//    
//    System.out.println(socketAddress);
//    System.out.println(socketAddress.getHostString());
//    System.out.println(socketAddress.getHostName());
//    System.out.println(socketAddress.getAddress().getHostAddress());//因为不调用域名服务器，所以InetAddress为null，报空指针
    
    
  }

}
