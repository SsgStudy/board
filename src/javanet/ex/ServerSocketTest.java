package javanet.ex;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
    public static void main(String[] args) {
        //서버소켓
        try{
            ServerSocket serverSocket = new ServerSocket(50002);
            Socket socket = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = br.readLine();
            System.out.println("휴 혼날뻔 한 메시지 : "+message);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("서버에서 왔습니다\n");

            bw.flush();

            socket.close();
            br.close();
            bw.close();






        }catch (Exception e){
            e.printStackTrace();
        }

    }




}
