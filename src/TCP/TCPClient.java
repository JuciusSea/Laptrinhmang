/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author haivi
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 2207);
        //gui du lieu yeu cau 
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeInt(100);
        dos.writeInt(200);
        
        //nha du lieu dap tra
        DataInputStream dis = new DataInputStream(client.getInputStream());
           double sum = dis.readDouble();
        System.out.println("sum = " +sum);
        System.out.println(client);
        dos.close();
        dis.close();
    }
}
