package com.example.project03_last.conn;

import java.util.HashMap;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {


    //실제로 요청할 Url 그리고 넘겨줄 파라메터 등을 설정하는곳.
    //callback
    // get, post 를 미리 지정하는 방식 =x , FormUrlEncoded라는 어노테이션을 이용해서 입력받기 =o

    @FormUrlEncoded
    @POST
    Call<String> getData(@Url String url , @FieldMap HashMap<String,Object> parameters); // @FieldMap 접속 되고 추가 (파라메터)

    //현재 상태에서는 재사용 가능한게 POST방식만 만들어둠. (URL에 파라메터 노출이 없는 형태 보안↑ )
    // 하지만 공공데이터 포털이나 공공의 목적으로 만들어진 API들은 GET방식이 많음. (URL에 파라메터 노출이 있음 보안↓)

    @GET("{url}") // GET방식은 BASE URL + URL(맵핑) + ?뒤에 나오는 파라메터
    Call<String> getDataGET(@Path("url") String url , @QueryMap HashMap<String,String> parameters);

    @POST("file.f")
    @Multipart
    Call<String> sendFile(@Part MultipartBody.Part file ); // @FieldMap 접속 되고 추가 (파라메터)


}
