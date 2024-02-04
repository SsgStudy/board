package javanet.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSocketTest {
    public static void main(String[] args) {
    //서버연결을 위한 클라이언트 소켓
        try{
    Socket socket = new Socket("127.0.0.1",50001);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("가나다라마바사\n");

            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = br.readLine();
            System.out.println("서버에서 받은 메시지 : "+message);

            socket.close();
            bw.close();
            br.close();




        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
