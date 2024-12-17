/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author haivi
 */
public class UDPServer {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket server = new DatagramSocket(2208);
        System.out.println("Server is running...");
        while (true) {            
            byte[] buf = new byte[1024];
            // tiep nhan du lieu 
            DatagramPacket dpReq = new DatagramPacket(buf, buf.length);
            server.receive(dpReq);
            
            String strReq = new String(dpReq.getData()).trim();
            System.out.println(strReq);
            //xu li du lieu 
            String strRes = StrUtils.Reverse(strReq);
            
            //dap tra
            DatagramPacket dpRes = new DatagramPacket(strRes.getBytes(), strRes.length(), dpReq.getAddress(), dpReq.getPort());
            server.send(dpRes);
        }
    }
}
