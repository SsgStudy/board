package javaio.ex01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// c://temp/test1.text 파일에 10, 20, 30 요런 데이터값을 쓰자(출력하자)
public class WriterEx01 {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("C:/Temp/test1.text");
            byte[] a = {10, 20, 30, 40, 50};
            os.write(a, 1, a.length - 1);
            os.flush();
            os.close();


        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
