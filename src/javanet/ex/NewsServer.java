package javanet.ex;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer {
    private static DatagramSocket datagramSocket = null;
    private static ExecutorService es = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("--------------------------------------------------------------------");

        //UDP 서버 시작
        startServer();

        //키보드 입력
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = scanner.nextLine();
            if (key.toLowerCase().equals("q")) {
                break;
            }
        }
        scanner.close();

        //TCP 서버 종료
        stopServer();
    }


    public static void startServer() {


        //작업 스레드 정의

        es.execute(() -> {
            //DatagramSocket 생성 및 Port 바인딩
            try {
                datagramSocket = new DatagramSocket(50001);
                System.out.println("[서버] 시작됨");


                while (true) {
                    //클라이언트가 구독하고 싶은 뉴스 주제 얻기
                    DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                    datagramSocket.receive(receivePacket);
                    String newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

                    //클라이언트의 IP와 Port 얻기
                    SocketAddress socketAddress = receivePacket.getSocketAddress();

                    //10개의 뉴스를 클라이언트로 전송
                    for (int i = 1; i <= 10; i++) {
                        String data = newsKind + ": 뉴스" + i;
                        byte[] bytes = data.getBytes("UTF-8");
                        DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
                        datagramSocket.send(sendPacket);
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public static void stopServer() {
        //DatagramSocket을 닫고 Port 언바인딩
        datagramSocket.close();
        es.shutdown();
        System.out.println("[서버] 종료됨 ");
    }
}