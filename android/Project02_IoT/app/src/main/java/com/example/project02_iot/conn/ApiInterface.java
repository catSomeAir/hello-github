package com.example.project02_iot.conn;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {


    //실제로 요청할 Url 그리고 넘겨줄 파라메터 등을 설정하는곳.
    //callback
    // get, post 를 미리 지정하는 방식 =x , FormUrlEncoded라는 어노테이션을 이용해서 입력받기 =o

    @FormUrlEncoded
    @POST
    Call<String> getData(@Url String url , @FieldMap HashMap<String,Object> parameters); // @FieldMap 접속 되고 추가 (파라메터)

}
