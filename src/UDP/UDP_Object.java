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
public class UDP_Object {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        
        String sendRq = ";B21DCCN317;a9tbbh4U";
        
        DatagramPacket sendrq = new DatagramPacket(sendRq.getBytes(), sendRq.length(), InetAddress.getByName("203.162.10.109"), 2209);
        
        client.send(sendrq);
        
    }
}
