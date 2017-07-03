package com.example.da08.firebaseuser.domain;

/**
 * Created by Da08 on 2017. 7. 3..
 */

public class User {

    // 멤버필드(속성 , 멤버변수, 전역변수)
    public String username;
    public String email;
    public String pw;

    // 생성자
    public User(){

    }

    // 파라미터가 있는 생성자 오버로드
    public User(String username, String email, String pw){
        this.username = username;
        this.email = email;
        // pw를 단방향 암호화
        this.pw = pw;
    }
}
