/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import RMI.ObjectService;
import java.net.MalformedURLException;
import java.rmi.*;
/**
 *
 * @author haivi
 */
public class RMI_Object {
    public static String genCode(BookX book) {
        
        String author = book.getAuthor();
        int yearPublished = book.getYearPublished();
        String genre = book.getGenre();
        String title = book.getTitle();
        
        String[] authorParts = author.trim().split(" ");
        String firstLetter = String.valueOf(authorParts[0].charAt(0));
        String lastLetter = String.valueOf(authorParts[authorParts.length - 1].charAt(authorParts[authorParts.length - 1].length() - 1));
        
        String yearLastletter = String.valueOf(yearPublished % 100);
        String genreLength = String.valueOf(genre.length());
        String titleLength = String.valueOf(title.length()%10);
        
        return firstLetter + lastLetter + yearLastletter + genreLength + titleLength;
    }   
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        ObjectService service = (ObjectService) Naming.lookup("rmi://203.162.10.109/RMIObjectService");
        
        BookX book = (BookX) service.requestObject("B21DCCN317", "upRvuwLc");
        
        System.out.println(book);
        
        book.setCode(genCode(book));
        System.out.println(book);
        
        service.submitObject("B21DCCN317","upRvuwLc", book);
    }
}
