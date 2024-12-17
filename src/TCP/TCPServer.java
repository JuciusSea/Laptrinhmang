/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author haivi
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2207);
        System.out.println("Server running ... ");
        while (true) {            
            Socket connection = server.accept();
            System.out.println(connection);
        //Nhan du lieu
            DataInputStream dis = new DataInputStream(connection.getInputStream());
            int a = dis.readInt();
            int b = dis.readInt();
            System.out.format("req (a, b): %d %d \n", a, b);
        //gui du lieu
        
            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            dos.writeDouble(a+b);
        //dong ket noi
        connection.close();
        dis.close();
        dos.close();
        }
    }
}
