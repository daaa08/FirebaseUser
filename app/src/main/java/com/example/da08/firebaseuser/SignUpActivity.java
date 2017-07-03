package com.example.da08.firebaseuser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.da08.firebaseuser.domain.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference userRef;

    EditText editName, editEmail, editPw;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("user");

        editName = (EditText)findViewById(R.id.editName);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPw = (EditText)findViewById(R.id.editPw);

        btnGo = (Button)findViewById(R.id.btnGo);
    }

    public void postData(View v){
        String email = editEmail.getText().toString();
        String name = editName.getText().toString();
        String pw = editPw.getText().toString();

        // 정규식으로 이메일이 맞는지 체크 후

        // 패스워드 자릿수 체크


        // 파이어 베이스에 저장할 User객체 생성
        User user = new User(name,email,pw);  // 들어갈 값 지정

        // 파이어 베이스의 키 자동생성 방법
//        String childKey = userRef.push().getKey();  // hashcode로 된 키를 레퍼런스 아래에 삽입하고, 키를 가져옴 (키의 이름은 임의로 생성)

        String childKey = replaceEmailComma(user.email);
        userRef.child(childKey).setValue(user); // 값 세팅
    }

    public String replaceEmailComma(String email){
        return email.replace(".","_comma_");  // 키값에 .을 사용할 수 없어서 _comma_로 대체해 줌
    }

    public String recoverEmailComma(String convertedEmail){
        return convertedEmail.replace("_comma_",".");
    }
}
