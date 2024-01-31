package javaio.ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx01 {
    public static void main(String[] args) {


        try {
            InputStream is = new FileInputStream("C:/Temp/test1.text");

            while (true) {

                int data = is.read();
                if (data == -1)break;     //EOF파일의 끝(-1을 반환)
                System.out.println(data);
            }
            is.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException io) {
            io.printStackTrace();

        }

    }
}
