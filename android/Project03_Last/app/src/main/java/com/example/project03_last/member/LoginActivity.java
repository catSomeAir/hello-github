package com.example.project03_last.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project03_last.MainActivity;
import com.example.project03_last.R;
import com.example.project03_last.common.CommonVal;
import com.example.project03_last.conn.CommonAskTask;
import com.example.project03_last.conn.CommonConn;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    NidOAuthLoginButton btn_naver;
    Button btn_login;
    EditText edt_id , edt_pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.tv_join).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
        btn_login= findViewById(R.id.btn_login);
        edt_id= findViewById(R.id.edt_id);
        edt_pw= findViewById(R.id.edt_pw);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //아이디 비밀번호 입력체크 나중에 넣어야함.
                login(edt_id.getText()+"" , edt_pw.getText()+"" , "N");
            }
        });

        //NaverIdLoginSDK.initialize(context, {OAUTH_CLIENT_ID}, {OAUTH_CLIENT_SECRET}, {OAUTH_CLIENT_NAME})
        //코틀린은 객체를 인스턴스화 안해도 자동으로 안에있는 인스턴스 멤버를 접근해서 쓸수가있음
        //함수지향.

        getHashKey();



        NaverIdLoginSDK.INSTANCE.initialize(this,
                "ECYKFbq9Ixg74Rlws7C4",
                "aZ6DrQPqfl" ,
                "Project03_Last" );

        btn_naver = findViewById(R.id.btn_naver);
        btn_naver.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("네이버", "onSuccess: " + NaverIdLoginSDK.INSTANCE.getAccessToken());
                naver_profile();
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("네이버", "onFailure: " + s);
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("네이버", "onError: " + s);
            }
        });

        CommonConn conn = new CommonConn(this,"test.te");


        KakaoSdk.init(this, "baba4d095202e023b2e4b5bb3eb322e1");
        findViewById(R.id.btn_kakao).setOnClickListener(v -> {

        });

        // lamda식 자바코드를 함수형으로 간편하게 줄여서 사용한것
        findViewById(R.id.btn_kakao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //(OAuthToken?, Throwable?) ->Unit
                Function2<OAuthToken, Throwable , Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
                    @Override
                    public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                        if(oAuthToken != null){
                            Log.d("토큰", "invoke: 받아옴");
                            kakao_profile();
                        }
                        if(throwable != null){
                            Log.d("토큰", "invoke: 오류있음");
                        }
                        return null;
                    }
                };


                // 카카오톡 앱 설치 여부를 판단. 깔려있으면 카톡 앱으로 인증.
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)){
                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this,callback);
                }else{
                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this,callback);
                }

                /*    // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
                if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {

                } else {
                    UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
                }*/
            }
        });


    }//oncreate

    //setOAuthLoginCallback 을 이용을 해서 success가 되었을때 (token이있을때) 정보를 받아올수있는 객체를
    //사용해서 정보를 얻어오면된다.
    public void naver_profile(){
        //NidOAuthLogin().callProfileApi(nidProfileCallback) Kotiln
        NidOAuthLogin authLogin = new NidOAuthLogin();
        authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
            @Override
            public void onSuccess(NidProfileResponse res) {
                Log.d("프로필", "onSuccess: ");
                Log.d("프로필", "onSuccess: " + res.getProfile().getEmail());
                Log.d("프로필", "onSuccess: " + res.getProfile().getMobile());
                Log.d("프로필", "onSuccess: " + res.getProfile().getName());

                // 소셜로그인했을때 회원가입이 되어있는 소셜계정인지 아닌지를 판단해서
                // 회원가입이되어있으면 => MainActivity
                // 안되어있으면 해당하는 정보로 => JoinActivity
                login(res.getProfile().getEmail() , null , "Y");
                // AlertDialog <-



            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("프로필", "onFailure: " + s);
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("프로필", "onError: "  + s);
            }
        });
    }

    public void kakao_profile(){
        UserApiClient.getInstance().me((user, throwable) -> {
            if(throwable != null){
                //오류가 났을때 어떤 오류인지 코드로 줌 KOE + 숫자 ( 단무지가 있음 )
            }else{
                Log.d("카카오", "kakao_profile: " +  user.getKakaoAccount().getProfile().getNickname());
                Log.d("카카오", "kakao_profile: " +  user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                Log.d("카카오", "kakao_profile: " +  user.getKakaoAccount().getEmail());
                Log.d("카카오", "kakao_profile: " +  user.getKakaoAccount().getName());
                Log.d("카카오", "kakao_profile: " +  user.getKakaoAccount().getPhoneNumber());
            }


            return null;
        });


     /*   UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                return null;
            }
        });*/
    }

    // 메소드안에 바뀌어야될부분이 고정되어있으면 재활용이 힘든 메소드.
    // => editText로 고정되어있던부분을 파라메터로 빼주기만하면 재활용이 가능한구조가됨.
    public void login(String email , String pw , String social_yn){
        CommonAskTask task = new CommonAskTask(LoginActivity.this,"andlogin");
        task.addParams("email" , email);
        task.addParams("pw" , pw);
        task.addParams("social" , social_yn);
        task.excuteAsk(new CommonAskTask.AsynckTaskCallBack() {
            @Override
            public void onResult(String data, boolean isResult) {

                    Log.d("로그인", "onResult: " + data);
                    CommonVal.loginInfo = new Gson().fromJson(data , AndMemberVO.class);
                    if(social_yn.equals("N") && CommonVal.loginInfo==null){
                        Log.d("로그인", "onResult: 아디비번틀림");
                    }else if(social_yn.equals("Y") && CommonVal.loginInfo==null){
                        //회원가입으로 보내줘야함
                        Intent intent = new Intent(LoginActivity.this , JoinActivity.class);
                        intent.putExtra("email", email );
                        startActivity(intent);
                    }else if(CommonVal.loginInfo != null){
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        startActivity(intent);
                    }else{
                        Log.d("로그", "onResult: 세개의 이프문 모두 실패?? ");
                    }



            }
        });
    }




    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }


}