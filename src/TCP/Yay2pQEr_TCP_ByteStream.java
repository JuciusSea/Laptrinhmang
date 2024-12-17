/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author PC
 */
public class Yay2pQEr_TCP_ByteStream {
       public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109", 2206);
        System.out.println(client);

        OutputStream os = new DataOutputStream(client.getOutputStream());
        
        os.write("B21DCCN317;Yay2pQEr".getBytes());
        
        InputStream dis = new BufferedInputStream(client.getInputStream());
        
        byte[] buffer = new byte[1024];
        
        int numbyte = dis.read(buffer);
        
        String receive = new String(buffer, 0, numbyte);
        
        System.out.println(receive);
        
        String[] numbers = receive.split("\\|");
        
        int sum = 0;
        
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        
        System.out.println(sum);
        
        os.write(Integer.toString(sum).getBytes());
        
        os.close();
        client.close();

    }
}
