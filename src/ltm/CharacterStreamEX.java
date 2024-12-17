/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author haivi
 */
public class CharacterStreamEX {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //gui ma sinh vien va ma cau hoi
        String req = "B21DCCN317;Yo72lIZM";
        
        bw.write(req);
        bw.newLine();
        bw.flush();
        
        //nhan du lieu String gom cac ten mien
        String domainString = br.readLine();
        
        //tao list String luu ten mien edu
        List<String> eduDomains = Arrays.stream(domainString.split(", "))
                                            .filter(domain -> domain.endsWith(".edu"))
                                            .collect(Collectors.toList());
        
        //tao string moi join cac phan tu trong list
        String result = new String().join(", ", eduDomains);
        System.out.println(result);
        
        bw.write(result);
        bw.newLine();
        bw.flush();
        
        //dong ket noi
        socket.close();
    }
}
