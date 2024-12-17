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
import java.nio.Buffer;

/**
 *
 * @author haivi
 */
public class vuzGUKvT_UDP_DataType {
    public static String encrypt(String text, int s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((ch - 'A' + s) % 26) + 'A');
                result.append(encryptedChar);
            } else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((ch - 'a' + s) % 26) + 'a');
                result.append(encryptedChar);
            } else {
                result.append(ch); // Không thay đổi ký tự không phải chữ cái
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        DatagramSocket client = new DatagramSocket();
        
        String sendrq = ";B21DCCN317;vuzGUKvT";
        
        DatagramPacket sendRq = new DatagramPacket(sendrq.getBytes(), sendrq.length(), InetAddress.getByName("203.162.10.109"), 2207);
        
        client.send(sendRq);
        
        byte[] buf = new byte[1024];
        DatagramPacket reiData = new DatagramPacket(buf, buf.length);
        
        client.receive(reiData);
        String Reiceive = new String(reiData.getData(), 0, reiData.getLength()).trim();
        
        System.out.println(Reiceive);
        
        String[] part = Reiceive.split(";");
        
        String requestID = part[0];
        String data = part[1];
        String count = part[2];
        
        String decodedData = encrypt(data, Integer.parseInt(count));
        
        System.out.println(decodedData);
        
        String result = String.format("%s;%s", requestID, decodedData);
        
        DatagramPacket sendresult = new DatagramPacket(result.getBytes(), result.length(), InetAddress.getByName("203.162.10.109"), 2207);
        
        client.send(sendresult);
        client.close();
    }
}
