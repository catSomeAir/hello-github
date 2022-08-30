package com.example.project02_iot.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;

public class CusDetailActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    TextView tv_info ;
    RadioButton rdo_man , rdo_woman ;
    RadioGroup rdo_grp;
    EditText edt_email , edt_phone ;
    Button btn_update , btn_close;
    CustomerVO vo ;
    boolean isEnable ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_detail);

        tv_info = findViewById(R.id.tv_info);
        rdo_grp = findViewById(R.id.rdo_grp);
        rdo_man = findViewById(R.id.rdo_man);
        rdo_woman = findViewById(R.id.rdo_woman);
        edt_email = findViewById(R.id.edt_email);
        edt_phone = findViewById(R.id.edt_phone);
        btn_update = findViewById(R.id.btn_update);
        btn_close = findViewById(R.id.btn_close);

        rdo_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdo_man){
                    vo.setGender("남");
                }else{
                    vo.setGender("여");
                }
            }
        });
      //  rdo_man.setOnCheckedChangeListener(this);
      //  rdo_woman.setOnCheckedChangeListener(this);


        // id getIntent()<- 이전 화면에서 보내준 인텐트를 가져옴.
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        isEnable = intent.getBooleanExtra("isenable" , false);
        // 두번째 방법.
        CustomerVO tempVo = (CustomerVO) intent.getSerializableExtra("vo");

        Log.d("두번째방법", "onCreate: " + tempVo.getId());
        CommonConn conn = new CommonConn(this,"detail.cu");
        conn.addParams("id",id);
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("디테일", "onResult: "+data);
                vo = new Gson().fromJson(data,CustomerVO.class);
                setWidget(vo);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vo.setEmail(edt_email.getText()+"");
                vo.setPhone(edt_phone.getText()+"");


                String data = new Gson().toJson(vo);//<-
                CommonConn updateConn = new CommonConn(CusDetailActivity.this , "update.cu");
                updateConn.addParams("data" , data);
                updateConn.excuteConn(new CommonConn.ConnCallback() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(isResult){
                            finish();//액티비티를 꺼버림.
                        }
                    }
                });
            }
        });

    }

    public void setWidget(CustomerVO vo){
        if(isEnable) {
            btn_update.setVisibility(View.VISIBLE);
        }else{
            btn_update.setVisibility(View.INVISIBLE);
        }

        tv_info.setText(vo.getName() + "님의 정보 ");

        if(vo.getGender().equals("남")){
            rdo_man.setChecked(true);
        }else{
            rdo_woman.setChecked(true);
        }
        rdo_man.setEnabled(isEnable);
        rdo_woman.setEnabled(isEnable);
        edt_email.setText(vo.getEmail());
        edt_email.setEnabled(isEnable);
        edt_phone.setText(vo.getPhone());
        edt_phone.setEnabled(isEnable);


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // 체크상태에따라서 코드로 구현을하려면 생각보다 복잡함.
        // 라디오버튼이 더 여러개가 있다면 더 복잡해짐.
        /*rdo_woman.setChecked(false);
        rdo_man.setChecked(false);
        if(buttonView.getId() == R.id.rdo_man){
            rdo_woman.setChecked(true);
        }else{
            rdo_man.setChecked(false);
        }*/
    }
}