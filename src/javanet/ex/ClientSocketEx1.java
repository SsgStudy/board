package javanet.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSocketEx1 {

    public static void main(String[] args) {

        try{
            Socket socket = new Socket("127.0.0.1", 50001);

            //server에 보낼 데이터 준비하여 보내기
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("great developer yun");
            bw.newLine();
            bw.flush();


            //server에 보낸 데이터를 받아 출력하기
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = br.readLine();
            System.out.println("message from server : "+serverMessage);






            socket.close();



        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
