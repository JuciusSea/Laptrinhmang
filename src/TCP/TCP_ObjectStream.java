/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author haivi
 */
public class TCP_ObjectStream {
    
    private static String rightName(String name){
        String[] parts = name.trim().toLowerCase().split(" ");
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < parts.length - 1; i++){
            a.append(Character.toUpperCase(parts[i].charAt(0))).append(parts[i].substring(1)).append(" ");
        }
        return parts[parts.length - 1].toUpperCase()+", " + a.toString();
    }
    
    private static String rightBirth(String birth){
        String[] parts = birth.trim().split("-");
        return parts[1] + "/" + parts[0] +"/" +parts[2];
    }
    private static String createUserName(String name){
        String[] parts = name.trim().toLowerCase().split(" ");
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < parts.length-1; i++){
            a.append(parts[i].charAt(0));
        }
        a.append(parts[parts.length-1]);
        return a.toString();
    }
    
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket client = new Socket("203.162.10.109",2209);
        
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        
        oos.writeObject("B21DCCN317;2lfcVp53");
        
        Customer data = (Customer)ois.readObject();
        System.out.println(data);
        
        data.setUserName(createUserName(data.getName()));
        
        data.setDayOfBirth(rightBirth(data.getDayOfBirth()));
        
        data.setName(rightName(data.getName()));
        
        System.out.println(data);
        
        oos.writeObject(data);
        
        ois.close();
        oos.close();
    }
}
