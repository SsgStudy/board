package javaio.ex01;

import java.io.*;

public class ReaderEx {
    public static void main(String[] args) throws IOException {
        //문자배열 읽기
        Reader reader = new FileReader("C:/Temp/test3.text");

        char[] data = new char[100];
        while (true){
            int n = reader.read(data);
            if (n == -1)break;
            for (char c : data) System.out.println(c);
        }

        // 1문자씩 읽어들이기
        Reader reader1 = new FileReader("C:/Temp/test3.text");

        while (true){
            int n = reader1.read();
            if (n == -1)break;
            System.out.println((char)n);
        }
        reader1.close();

    }
}
