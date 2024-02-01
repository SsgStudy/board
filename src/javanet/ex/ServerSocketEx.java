package javanet.ex;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketEx {

    public static void main(String[] args) {
        try{
            //1. 서버소켓 생성
            ServerSocket serverSocket = new ServerSocket(50001);

            //2. 클라이언트가 socket과 접속(bind)할 수 있도록 accept 서버소케셍 바인드.
            System.out.println("server start");
            Socket socket = serverSocket.accept();



            //3. 소켓 종료
            socket.close();

            //4. 서버소켓 종료
            serverSocket.close();
            System.out.println("server close");


        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
