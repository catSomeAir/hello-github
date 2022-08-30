package com.example.project02_iot;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.project02_iot.common.CommonVal;
import com.example.project02_iot.conn.CommonAskTask;
import com.example.project02_iot.customer.CusFragment;
import com.example.project02_iot.etc.TabActivity;
import com.example.project02_iot.hr.HrFragment;
import com.example.project02_iot.notice.NoticeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //메인엑티비티에서 버튼 클릭 시 (탭사용버튼)
    // 탭 액티비티로 이동되게 끔 처리해보기.
    Button btn_tab;
    BottomNavigationView btm_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(new CusFragment());



        btm_nav = findViewById(R.id.btm_nav);

        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if(item.getItemId()==R.id.menu_cus){
                    fragment = new CusFragment();
                }else if(item.getItemId()==R.id.menu_emp){
                    fragment = new HrFragment();

                }else if(item.getItemId()==R.id.menu_noti){
                    fragment = new NoticeFragment();
                }
                if(fragment==null) return false;

                changeFragment(fragment);
                return true;
            }
        });

    }


    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }

}