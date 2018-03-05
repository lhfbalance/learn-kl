package learnNetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UdpServer {
    
    private EventLoopGroup workerGroup;
    
    public UdpServer() {
        workerGroup = new NioEventLoopGroup();
    }
    
    
    public void star() {
        int listenUdpPort = 1080;
        try {
            workerGroup = new NioEventLoopGroup();
            Bootstrap b = new Bootstrap();
            b.group(workerGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new UdpServerHandler());
            System.out.println("UDP·þÎñÆô¶¯!");
            b.bind("0.0.0.0", listenUdpPort).sync().channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }
    
    public void close() {
        workerGroup.shutdownGracefully();
    }


    public static void main(String[] args) {
        new UdpServer().star();
    }
    

}
