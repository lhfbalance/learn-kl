package learnNetty;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    
    void sendPackage(int length) {
        
        byte[] data = new byte[length];
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            InetAddress destination = null;
            destination = InetAddress.getByName("localhost");
            DatagramPacket dp = new DatagramPacket(data, data.length, destination, 1080);
            ds.send(dp);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
    
    public static void main(String[] args) {
        new UdpClient().sendPackage(3000);
    }

}
