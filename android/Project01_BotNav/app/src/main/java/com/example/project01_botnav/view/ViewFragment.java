package com.example.project01_botnav.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_botnav.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ViewFragment extends Fragment {

 TabLayout tabs;
RecyclerView recv_view;
ArrayList<ViewDTO> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view, container, false);

        recv_view = v.findViewById(R.id.recv_view);
        // 1~10 , 10~1
        for (int i = 0; i <10 ; i++) {
            list.add(new ViewDTO("제목" + i , i+"일전" , "내용"+i));
        }


        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        ViewAdapter adapter = new ViewAdapter(inflater,list,getContext());
        recv_view.setAdapter(adapter);
        recv_view.setLayoutManager(manager);




        tabs = v.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("My뷰"));
        tabs.addTab(tabs.newTab().setText("발견"));
        tabs.addTab(tabs.newTab().setText("카카오TV"));
        tabs.addTab(tabs.newTab().setText("코로나9"));
        tabs.addTab(tabs.newTab().setText("잔여백신"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // 포커싱이 되었을때(선택함)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    Log.d("탭", "onTabSelected:  탭 선택 됨!");
                }else if(tab.getPosition()==1){
                    Log.d("탭", "onTabSelected:  탭 선택 됨!");
                }
            }
            // 포커싱을 잃었을때(선택해제)
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            // 다시 눌렀을때
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return v;
    }
}