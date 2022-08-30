package com.example.project03_last.conn;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {

    private String url ;//생성 시 URL만 입력받게끔 만들예정
    private HashMap<String,Object> params;
    private Context mContext;
    ProgressDialog dialog;
    private ConnCallback callback;
    public CommonConn(Context mContext , String url) {
        this.url = url;
        this.mContext = mContext;
        this.dialog = new ProgressDialog(mContext);
        params = new HashMap<>();
    }

    public void addParams(String key , Object value){
        params.put(key,value);
    }

    protected void onPreExecute() {
        if(dialog == null) return;
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.setTitle("데이터 처리");
        dialog.setMessage("데이터를 가져오는 중...");
        dialog.show(); //<= 실제 보이게 처리 ※
    }

    public void excuteConn(ConnCallback callback){
        this.callback = callback;

        ApiInterface apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
        Call<String> call = apiInterface.getData(url,params);
        onPreExecute();
        //↓ 작업 실행
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResult(true , response.body());
                onPostExecute();
            }

            //로그 찍고 , 토스트 창으로 서버이상 이라고 메세지나오게 해보기.!
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(mContext, "서버 이상!", Toast.LENGTH_SHORT).show();
                callback.onResult(false , t.getMessage());
                onPostExecute();
            }
        });
    }

    protected void onPostExecute() {
        if(dialog == null) return;
        dialog.dismiss();


    }

    // onResponse <- 결과가 성공이고 데이터가 있을때 true , data
    // onFailure <- 결과가 실패이고 오류메세지가 있음. false , throwble

    public interface ConnCallback{
        public void onResult(boolean isResult , String data);
    }

}
