package com.example.project01_botnav.chat;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project01_botnav.R;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    RecyclerView recv_chat;
    ArrayList<ChatDTO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_chat, container, false);

        recv_chat = v.findViewById(R.id.recv_chat);

        for (int i = 0; i < 20; i++) {
            if(i%2==0) {
                list.add(new ChatDTO(R.drawable.and,"친구이름"+i,"메세지"+i,"11:0"+i ));
            }else{
                list.add(new ChatDTO(R.drawable.gear,"친구이름"+i,"메세지"+i,"11:0"+i ));
            }
        }


        View.OnClickListener showToastListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "친구이름", Toast.LENGTH_SHORT).show();
            }
        };

        ChatAdapter adapter = new ChatAdapter(inflater,list,getContext(),showToastListner);

        recv_chat.setAdapter(adapter);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recv_chat.setLayoutManager(manager);

        // 어댑터(레이아웃-칸마다 보여질 정보를 만들어 놓은것) , 레이아웃 매니저


        return v ;
    }
}