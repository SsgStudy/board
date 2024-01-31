package javaio.ex01;

import java.io.*;

public class BufferReaderEx {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
        String str1 = "text 생성1";
        String str2 = "text 생성2";
        bw.write(str1, 0, str2.length());
        bw.newLine();
        bw.write(str2);
        bw.flush();

        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        String str;
        while (true){
            str = br.readLine();
            if (str == null) break;
            System.out.println(str);

        }
        bw.close();
        br.close();
    }
}
