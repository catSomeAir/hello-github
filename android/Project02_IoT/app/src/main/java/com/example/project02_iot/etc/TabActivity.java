package com.example.project02_iot.etc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.project02_iot.R;
import com.google.android.material.tabs.TabLayout;

public class TabActivity extends AppCompatActivity {
    TabLayout tabs;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        toolbar = findViewById(R.id.toolbar);
        /* actionbar <- 현재 상태 NoActionbar 우리가 만든 툴바를 이용해서 액션바를 대체한다.*/
        setSupportActionBar(toolbar);




        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록").setIcon(R.drawable.ic_android_black_24dp));
        tabs.addTab(tabs.newTab().setText("스팸기록").setIcon(R.drawable.ic_android_black_24dp));
        tabs.addTab(tabs.newTab().setText("연락처").setIcon(R.drawable.ic_android_black_24dp));
        tabs.addTab(tabs.newTab().setText("차단목록").setIcon(R.drawable.ic_android_black_24dp));

        //
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition(); // 0번부터임

                getSupportFragmentManager().beginTransaction().replace(R.id.container , new TabFragment(pos+1)).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // onCreate메소드가 끝나면 옵션메뉴를 붙일수있는수명주기가 따로있음
    // override를 통해 재정의를 해놨으면 실행을해줌


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int pos = 0 ;
        if(item.getItemId() == R.id.menu1){
            pos = 1;
        }else if(item.getItemId() == R.id.menu2){
            pos = 2;
        }else if(item.getItemId() == R.id.menu3){
            pos = 3;
        }else if(item.getItemId() == R.id.menu3){
            pos = 4;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container , new TabFragment(pos)).commit();

        return super.onOptionsItemSelected(item);
    }
}