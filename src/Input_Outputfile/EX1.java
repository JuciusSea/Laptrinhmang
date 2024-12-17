/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Input_Outputfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haivi
 */
public class EX1 {
    public static void main(String[] args){
        String file = "src\\test.txt";
        String file2 = "src\\test2.txt";
        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file2);
            
            
            byte[] data = new byte[1024];
            while (fis.available() > 0) {
                fis.read(data);
                
                fos.write(new String(data,"UTF-16").trim().getBytes());
                
                System.out.println(new String(data));
        }
            
        } catch (Exception e) {
                System.out.println(e.getCause());
                }
        }
    }
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(file);
//            byte[] data = new byte[1024];
//            while (fis.available() > 0) {
//                fis.read(data);
//                System.out.println(new String(data, "UTF-8"));
//            }
////            int data = 0;
////            while((data = fis.read()) != -1){
////                System.out.print((char)data);
////            }
//             
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not exist");
//            Logger.getLogger(EX1.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(EX1.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//            if(fis != null){
//                try {
//                    fis.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(EX1.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }


