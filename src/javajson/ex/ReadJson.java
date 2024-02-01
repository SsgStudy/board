package javajson.ex;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class ReadJson {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("member.json", Charset.forName("UTF-8")));
        String data = br.readLine();
        br.close();

        //JSON파싱
        JSONObject root = new JSONObject(data);
        System.out.println(root.getString("id"));
        System.out.println(root.getInt("password"));
        System.out.println(root.getBoolean("student"));

        JSONObject tel = root.getJSONObject("tel");
        System.out.println(tel.getString("home"));
        System.out.println(tel.getString("mobile"));

        JSONArray hobby = root.getJSONArray("habbit");
        for (int i = 0; i < hobby.length(); i++) {
        System.out.println(hobby.get(i)+", ");
        }
    }
}
