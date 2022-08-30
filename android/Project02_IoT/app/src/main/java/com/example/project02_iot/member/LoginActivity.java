package com.example.project02_iot.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project02_iot.MainActivity;
import com.example.project02_iot.R;
import com.example.project02_iot.common.CommonMethod;
import com.example.project02_iot.common.CommonVal;
import com.example.project02_iot.conn.CommonAskTask;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {
// -1. Spring을 이용한 Login처리.   -완-
// -2. SharedPrefrerences <- 공유 자원 ( 캐시 지우기 , 데이터 지우기 앱)를 하면 없어지는 부분 -완-
    //-3.소셜로그인 (Naver & Kakao) ~<예정


    EditText edt_id , edt_pw ;
    Button btn_login , btn_join;
    CheckBox chk_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);
        chk_login = findViewById(R.id.chk_login);


        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String userid = preferences.getString("id" , "--");//공유자원에 데이터를 저장을 해놨을때 읽는 방법
        String userpw = preferences.getString("pw" , "--");//공유자원에 데이터를 저장을 해놨을때 읽는 방법
        Log.d("공유자원", "onCreate: " + userid + " : " + userpw);



        // btn_login 클릭 시 에딧텍스트 id , pw에 있는값을 로그에 출력해보기.
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이디 비밀번호가 null이 아니게 넘어가게끔 작업
                if(CommonMethod.isCheckEditText(edt_id) && CommonMethod.isCheckEditText(edt_pw)){
                   //미들웨어 접근
                    login();
                }else{
                    Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        if(!userid.equals("--") && !userpw.equals("--")) {
            chk_login.setChecked(true);
            edt_id.setText(userid);
            edt_pw.setText(userpw);
            login(); // <- 만들어진 기능은 로직에 따라서 다시 사용이 가능하게 한다.
        }


    }//onCreate

    public void login(){
        CommonConn conn = new CommonConn(LoginActivity.this , "login");
        conn.addParams("userid" , edt_id.getText()+"");
        conn.addParams("userpw" , edt_pw.getText()+"");
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                if(isResult) { // 서버와 통신이 성공적으로 끝났을때.
                    CommonVal.loginInfo = new Gson().fromJson(data, MemberVO.class);//<=null
                    if(CommonVal.loginInfo==null){
                        Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호 틀림!", Toast.LENGTH_SHORT).show();
                    }else{
                        //자동로그인은 유저가 선택하기때문에 자동로그인이 체크가 되었는지를 판단하고 체크가 되었을때만! 저장이되어야함.
                        if(chk_login.isChecked()){
                            saveLoginInfo();
                        }

                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        // startActivity()아직 -

                    }
                }
            }
        });
    }

    public void saveLoginInfo(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();//edit()<- Editor객체를 리턴하는 메소드
        editor.putString("id" , CommonVal.loginInfo.getUserid());
        editor.putString("pw" , CommonVal.loginInfo.getUserpw());
        editor.apply();
    }







}