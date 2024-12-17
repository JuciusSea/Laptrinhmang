/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author trong
 */
public class setraK3p_TCP_CharacterStream {
     public static void main(String[] args) {
        String serverAddress = "203.162.10.109"; // Địa chỉ server
        int port = 2208; // Cổng server
        String studentCode = "B21DCCN317"; // Mã sinh viên
        String qCode = "setraK3p"; // Mã câu hỏi

        try (
            // Tạo socket kết nối đến server
            Socket socket = new Socket(serverAddress, port);

            // Sử dụng BufferedReader và BufferedWriter
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            // 1. Gửi mã sinh viên và mã câu hỏi
            String request = studentCode + ";" + qCode;
            System.out.println("Đang gửi dữ liệu: " + request);
            writer.write(request);
            writer.newLine(); // Kết thúc dòng
            writer.flush(); // Đảm bảo dữ liệu được gửi đi ngay lập tức

            // 2. Nhận một chuỗi ngẫu nhiên từ server
            String receivedString = reader.readLine();
            System.out.println("Dữ liệu nhận được từ server: " + receivedString);

            // 3. Tách chuỗi thành 2 chuỗi
            String firstPart = extractAlphaNumeric(receivedString);
            String secondPart = extractSpecialCharacters(receivedString);

            // In kết quả các chuỗi đã tách
            System.out.println("Chuỗi 1 (chữ và số): " + firstPart);
            System.out.println("Chuỗi 2 (ký tự đặc biệt): " + secondPart);

            // 4. Gửi lần lượt 2 chuỗi lên server
            writer.write(firstPart);
            writer.newLine();
            writer.flush();

            writer.write(secondPart);
            writer.newLine();
            writer.flush();

            System.out.println("Đã gửi 2 chuỗi lần lượt lên server.");

            // 5. Đóng kết nối
            System.out.println("Đã đóng kết nối.");
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Phương thức tách chuỗi gồm các ký tự chữ và số
    private static String extractAlphaNumeric(String data) {
        StringBuilder alphaNumeric = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                alphaNumeric.append(c);
            }
        }
        return alphaNumeric.toString();
    }

    // Phương thức tách chuỗi gồm các ký tự đặc biệt
    private static String extractSpecialCharacters(String data) {
        
        StringBuilder specialChars = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                specialChars.append(c);
            }
        }
        return specialChars.toString();
    }
}
