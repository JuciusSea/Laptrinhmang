/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI_int;


import java.rmi.*;
/**
 *
 * @author haivi
 */
public interface DataService extends Remote{
    public Object requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
