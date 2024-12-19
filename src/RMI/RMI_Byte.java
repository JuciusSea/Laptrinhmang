/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;


import RMI.ByteService;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMI_Byte {
    public static void main(String[] args) {
        try {
            // Kết nối đến RMI Server
            String rmiServerURL = "rmi://203.162.10.109/RMIByteService";
            ByteService byteService = (ByteService) Naming.lookup(rmiServerURL);

            // Thông tin người dùng và mã câu hỏi
            String studentCode = "B21DCCN317";
            String qCode = "UlsFXtDN";

            // Triệu gọi phương thức requestData để nhận mảng byte[]
            byte[] data = (byte[]) byteService.requestData(studentCode, qCode);
            System.out.println("Dữ liệu nhận được từ server: ");
            printByteArray(data);

            // Phân chia mảng byte[] thành hai phần: chẵn và lẻ
            byte[] processedData = processByteArray(data);
            System.out.println("Dữ liệu sau khi phân chia chẵn-lẻ: ");
            printByteArray(processedData);

            // Triệu gọi phương thức submitData để gửi dữ liệu trở lại server
            byteService.submitData(studentCode, qCode, processedData);
            System.out.println("Đã gửi dữ liệu chẵn-lẻ trở lại server.");

        } catch (Exception e) {
            System.err.println("Lỗi khi chạy client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Phương thức phân chia mảng byte[] thành chẵn và lẻ
    private static byte[] processByteArray(byte[] data) {
        byte[] even = new byte[data.length];
        byte[] odd = new byte[data.length];
        int evenIndex = 0, oddIndex = 0;

        for (byte b : data) {
            if (b % 2 == 0) {
                even[evenIndex++] = b;
            } else {
                odd[oddIndex++] = b;
            }
        }

        // Kết hợp hai mảng chẵn và lẻ
        byte[] result = new byte[evenIndex + oddIndex];
        System.arraycopy(even, 0, result, 0, evenIndex);
        System.arraycopy(odd, 0, result, evenIndex, oddIndex);
        return result;
    }

    // Phương thức in mảng byte[]
    private static void printByteArray(byte[] data) {
        for (byte b : data) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}

