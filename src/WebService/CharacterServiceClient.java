/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WebService;


import java.util.Comparator;
import java.util.List;

/**
 *
 * @author haivi
 */
public class CharacterServiceClient {
    
    
    public static void main(String[] args) {
        List<String> data = requestStringArray("B21DCCN317", "NmIDDjaZ");
        System.out.println(data);
        data.sort(Comparator.comparingInt(String::length));
        submitCharacterStringArray("B21DCCN317", "NmIDDjaZ", data);
    }

    private static java.util.List<java.lang.String> requestStringArray(java.lang.String studentCode, java.lang.String qCode) {
        vn.medianews.CharacterService_Service service = new vn.medianews.CharacterService_Service();
        vn.medianews.CharacterService port = service.getCharacterServicePort();
        return port.requestStringArray(studentCode, qCode);
    }

    private static void submitCharacterStringArray(java.lang.String studentCode, java.lang.String qCode, java.util.List<java.lang.String> data) {
        vn.medianews.CharacterService_Service service = new vn.medianews.CharacterService_Service();
        vn.medianews.CharacterService port = service.getCharacterServicePort();
        port.submitCharacterStringArray(studentCode, qCode, data);
    }
}
