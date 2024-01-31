package javaio.ex01;

import java.io.Serializable;

public class Member implements Serializable {

    private static final long serialVerionUID = 10000000l;
    String name;
    transient Integer age;  // transient -> 직렬화에서 제외

    Member(String name, Integer age){
        this.name = name;
        this.age = age;
    }

}