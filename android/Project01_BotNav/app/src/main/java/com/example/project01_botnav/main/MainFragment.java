package com.example.project01_botnav.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_botnav.R;

import java.util.ArrayList;
import java.util.Random;


public class MainFragment extends Fragment {
    RecyclerView recv_main ;
    int[] imgArr = {
      R.drawable.etc,
      R.drawable.and,
      R.drawable.gear,
      R.drawable.profile,
      R.drawable.shopping,
      R.drawable.talk,
      R.drawable.talkblack,
      R.drawable.ic_launcher_background
    };
    ArrayList<MainDTO> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_main, container, false);
        recv_main = v.findViewById(R.id.recv_main);

        //mainDTO 10개를 가진 ArrayList 만들기 ,.
        for(int i=0 ; i < 30 ; i ++ ){
            int imgIndex = new Random().nextInt(imgArr.length);
            list.add(new MainDTO(imgArr[imgIndex] , "친구이름" + i , "상태"+ i));
            if(i%3==0){
                list.add(new MainDTO(imgArr[imgIndex] , "친구이름" + i , "상태"+ i , true));
            }
        }



        MainAdapter adapter = new MainAdapter(inflater,list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL,false);

        recv_main.setAdapter(adapter);
        recv_main.setLayoutManager(manager);


        return v ;
    }
}