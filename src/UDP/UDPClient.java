/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author haivi
 */
public class UDPClient {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        
        //gui du lieu (ban tin)
        String strReq = "ababsb dabdbawu adasjbfja";
        DatagramPacket dpReq = new DatagramPacket(strReq.getBytes(), strReq.length(), InetAddress.getByName("localhost"), 2208);
        client.send(dpReq);
        System.out.println("Send success");
        //nhan ket qua (ban tin)
        
        byte[] buf = new byte[1024];
        DatagramPacket dpRecei = new DatagramPacket(buf, buf.length);
        client.receive(dpRecei);
        String Receive = new String(dpRecei.getData()).trim();
        System.out.println(Receive);
        client.close();
    }
    
}
