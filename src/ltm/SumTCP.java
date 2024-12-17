/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author haivi
 */
public class SumTCP {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
        dos.writeUTF("B21DCCN317;slR49OLh");
        
        int a = dis.readInt();
        int b = dis.readInt();
        
        int sum = a+b;
        int tich = a*b;
        
        dos.writeInt(sum);
        dos.writeInt(tich);
        
        dis.close();
        dos.close();
        socket.close();
    }
}
