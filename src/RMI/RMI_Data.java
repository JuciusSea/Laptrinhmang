/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import RMI_int.DataService;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingEnumeration;


public class RMI_Data {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {

            DataService service = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");
            
            int N = (int) service.requestData("B21DCCN317","1lH4u2yk");
            System.out.println(N);
            
            service.submitData("B21DCCN317","1lH4u2yk", scp(N));
            


    }
    private  static List<Integer> scp(int N){
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 1; i*i < N; i++){
            a.add(i*i);
        }
        return a;
    }

}
