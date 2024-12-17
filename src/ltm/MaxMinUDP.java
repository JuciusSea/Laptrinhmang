/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class MaxMinUDP {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        DatagramSocket client = new DatagramSocket();
        
        byte[] msg = new byte[1024];
        msg = ";B21DCCN473;GGWeoKrz".getBytes();
        
        client.send(new DatagramPacket(msg, msg.length, InetAddress.getByName("203.162.10.109"), 2207));
        
        byte[] buff = new byte[1024];
        DatagramPacket dpRec = new DatagramPacket(buff, buff.length);
        
        client.receive(dpRec);
        
        String receivedstr = new String(dpRec.getData(), 0, dpRec.getLength());
        
        System.out.println(receivedstr);
    }
}

