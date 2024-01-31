package javaio.ex01;

import java.io.*;
//UTF-8 문자셋으로 파일에 문자열을 파일에 저장하고, 파일에 저장된 문자를 다시 읽어서 콘솔에 출력하는 프로그램

public class CharachterConversionEx {
    public static void main(String[] args) throws IOException {
        write("너에게 나를 보낸다.");


    }
    public static void write(String str) throws IOException{
        String fileName = "data.txt";
        OutputStream os = new FileOutputStream(fileName);
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
        read(fileName);
        read1(fileName);

    }
    public static String read(String fileName) throws IOException {
        InputStream is = new FileInputStream(fileName);
        Reader reader = new InputStreamReader(is, "UTF-8");
        char[] data = new char[100];
        int num = reader.read(data);
        reader.close();
        String str = new String(data, 0, num);
        System.out.println(str);


        return null;
    }
    public static String read1(String fileName) throws IOException {
        FileReader is = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(is);
        String data = reader.readLine();
        reader.close();
        System.out.println(data);

        return null;
    }

}
