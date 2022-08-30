package com.example.project01_botnav;


//옵저버 클래스
public class ObCls {
    // 생성할때 인터페이스를 입력받아서 생성할수있게함.
    Callbackob callbackob;

    public ObCls(Callbackob callbackob) {
        this.callbackob = callbackob;
    }

    public interface Callbackob{
        void onResult(String result); // onClick(View v);
    }

    public void callback(){ // <= 안드로이드 OS
        callbackob.onResult("값을 넣어줌");
    }



}
