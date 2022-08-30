package com.example.project02_iot.hr;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.project02_iot.R;

public class HrDialog extends Dialog {


    public HrDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_hr);
        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();//<= 다이얼로그가 안보이게 하는 처리.
            }
        });
        // 다이얼로그랑 연결될 디자인을 준비를 해야함 ( layout )

    }
}
