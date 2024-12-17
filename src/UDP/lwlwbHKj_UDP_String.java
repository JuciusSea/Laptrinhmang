package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author haivi
 */
public class lwlwbHKj_UDP_String {
    
    private static String normalized(String a){
        StringBuilder x = new StringBuilder();
        String[] words = a.split(" ");
        for (String word : words){
            if(!word.isEmpty())
                x.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
        }
        return x.toString().trim();
    }
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        
        String sendrq = ";B21DCCN317;lwlwbHKj";
        
        DatagramPacket dpreq = new DatagramPacket(sendrq.getBytes(), sendrq.length(), InetAddress.getByName("203.162.10.109"), 2208);
        
        client.send(dpreq);
        
        byte[] buf = new byte[1024];
        DatagramPacket dprei = new DatagramPacket(buf, buf.length);
        
        client.receive(dprei);
        
        String Reiceive = new String(dprei.getData(), 0, dprei.getLength()).trim();
        System.out.println(Reiceive);
        
        
        String[] parts = Reiceive.split(";");
            if (parts.length != 2) {
                System.out.println("Invalid response format from server.");
                return;
            }
        String requestId = parts[0];
        String data = parts[1];
        
        String result = String.format("%s;%s", requestId, normalized(data));
        
        DatagramPacket dpfinal = new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2208);
        
        client.send(dpfinal);
        client.close();
    }
}
