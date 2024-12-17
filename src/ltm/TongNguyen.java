/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author haivi
 */
public class TongNguyen {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        
        InputStream is = new BufferedInputStream(socket.getInputStream());
        
        OutputStream os = new DataOutputStream(socket.getOutputStream());
        
        os.write("B21DCCN317;SIJ9MYLO".getBytes());
        
        byte[] fak = new byte[1024];
        
        int numb = is.read(fak);
        String a = new String(fak, 0, numb);
        System.out.println(a);
        
        String[] num = a.split("\\|");
        
        int sum = 0;
        for(String s : num){
            int val = Integer.parseInt(s);
            sum += val;
        }
        System.out.println(sum);
        os.write(String.valueOf(sum).getBytes());
        //dong me het vao 
        is.close();
        os.close();
        socket.close();
    }
}
