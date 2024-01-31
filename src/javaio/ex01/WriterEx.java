package javaio.ex01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx {
    public static void main(String[] args) throws IOException {
        Writer writer = new FileWriter("C:/Temp/test3.text"); //Writer가 파일에 값을 입력할 때 사용 ===> OutputStream
        char a = 'A';
        writer.write(a);
        char b = 'B';
        writer.write(b);

        char[] c = {'윤', '여', '빈'};
        writer.write(c);

        String str = "신세계 자바 과정";
        writer.write(str);

        writer.flush();
        writer.close();


    }
}
