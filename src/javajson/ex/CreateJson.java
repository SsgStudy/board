package javajson.ex;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

public class CreateJson {

    public static void main(String[] args) throws IOException {
        //JSON 객체 생성
        JSONObject object = new JSONObject();


        //JSON 객체에 속성 추가
        object.put("id", "sin");
        object.put("password", 1234);
        object.put("student",true);

        JSONObject tel = new JSONObject();
        tel.put("home", "02-455-8989");
        tel.put("mobile", "010-7310-2472");

        object.put("tel", tel);

        JSONArray habbit = new JSONArray();
        habbit.put("swimming");
        habbit.put("sleeping");

        object.put("habbit", habbit);


        //속성 확인 하기
        String data = object.toString();


        //콘솔에 출력
        System.out.println(data);


        //파일에 저장
        Writer writer = new FileWriter("member.json", Charset.forName("UTF-8"));
        writer.write(data);
        writer.flush();
        writer.close();
    }

}
