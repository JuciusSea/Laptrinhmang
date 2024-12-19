/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.rmi.*;

/**
 *
 * @author haivi
 */
public class RMI_character {
    
    public static String asciiDecoded(String input) throws UnsupportedEncodingException{
//        StringBuilder a = new StringBuilder();
//        for (int i = 0; i<input.length(); i++){
//            char c = input.charAt(i);
//            int ascii = c;
//            if (!Character.isDigit(c) && !Character.isAlphabetic(c)){
//                a.append("%");
//                a.append(ascii);
//                continue;
//            }
//            a.append(c);
//        }
//        return a.toString();
            String newencoded = URLEncoder.encode(input, "UTF-8");
            StringBuilder a = new StringBuilder();
            for (int i = 0; i <newencoded.length(); i++){
                char c = newencoded.charAt(i);
                if(c == '+'){
                    a.append("%20");
                    continue;
                }
                a.append(c);
            }
            return a.toString();
    }
    
    public static void main(String[] args) throws NotBoundException, RemoteException, MalformedURLException, UnsupportedEncodingException {
        CharacterService service = (CharacterService) Naming.lookup("rmi://203.162.10.109/RMICharacterService");
        
        String data = (String) service.requestCharacter("B21DCCN317", "zyDnelJi");
        
        System.out.println(data);
        System.out.println(asciiDecoded(data));
        service.submitCharacter("B21DCCN317", "zyDnelJi", asciiDecoded(data));
    }
}
