package com.example.project02_iot.conn;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApriClient {
    // url정보 ( middle웨어 tomcat까지의 정보를 저장해둠 )
    // 여기 클래스까지만 접근하면 바로 사용할수있는 Retrofit 객체를 준비해두기.

    private static final String BASE_URL = "http://192.168.0.2/mid/";
    private static Retrofit retrofit;

    public static Retrofit getApiclient(){
        if(retrofit == null){ // 최초 실행 시 retrofit 객체가 null이라면 그때만 생성하게 만듬
             retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL) // 미들웨어의 주소를 의미함(맵핑을 제외하고)
                     .addConverterFactory(ScalarsConverterFactory.create())//json String형태를 사용가능하게 해준다.
                     .client(new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).build())
                     //미들웨어가 꺼졌거나 응답이 불가능할때 몇초이상경과되면 통신을 끊기위한처리
                    .build();
        }
        return retrofit;


    }

}
