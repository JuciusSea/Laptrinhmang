/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author PC
 */
public class RAFh7PTZ_TCP_DataStream {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2207);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        //gui du lieu
        dos.writeUTF("B21DCCN317;RAFh7PTZ");
        System.out.println("gui du lieu thanh cong");
        
        // nhan du lieu
        
        int a = dis.readInt();
        int b = dis.readInt();
        
        //xu li du lieu
        int c = a;
        int d = b;
        System.out.println(a + " " + b);
        while(a != b){
            if( a > b ) a = a - b;
            else b = b - a;
        }
        int UCLN = b;
        int BCNN = c*d/b;
        dos.writeInt(UCLN);
        dos.writeInt(BCNN);
        dos.writeInt(c+d);
        dos.writeInt(c*d);
        
        dis.close();
        dos.close();
    }
}
