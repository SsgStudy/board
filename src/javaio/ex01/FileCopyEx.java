package javaio.ex01;

import java.io.*;

//파일 복사 원리
public class FileCopyEx {
    public static void main(String[] args) {
        String originiFileName = "C:/Temp/trump.jpg";
        String targetiFileName = "C:/Temp/trump1.jpg";
        try {
            InputStream is = new FileInputStream(originiFileName);
            OutputStream os = new FileOutputStream(targetiFileName);

    /*byte[] data = new byte[1024];
    while(true){
        int num = is.read(data);
        if (num == -1)break;
        os.write(data, 0, num);
    }    ------->   요 부분을 is.transferTo()로 갈음 할 수 있다.*/

            is.transferTo(os);
            os.flush();
            os.close();
            is.close();
            System.out.println("Copy end!");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
