package com.example.project01_botnav.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_botnav.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>  {
    LayoutInflater inflater;
    ArrayList<MainDTO> list;

    public MainAdapter(LayoutInflater inflater, ArrayList<MainDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_main , parent , false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size(); // 나중에 데이터를 받아올수있으면 DTO가 준비가되면 변경 예정 (ArrayList)=>2022.08.04에 KYM 수정(완)
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name , tv_msg;
        ImageView imgv , imgv_music;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_name = v.findViewById(R.id.tv_name);
            tv_msg = v.findViewById(R.id.tv_msg );
            imgv = v.findViewById(R.id.imgv);
            imgv_music = v.findViewById(R.id.imgv_music);
        }
        public void bind(@NonNull ViewHolder h, int i){
            h.tv_name.setText(list.get(i).getName());
            h.tv_msg.setText(list.get(i).getMsg());
            h.imgv.setImageResource(list.get(i).getImg_id());

            if(list.get(i).isMusic()){
                h.imgv_music.setVisibility(View.VISIBLE);
            }else{
                h.imgv_music.setVisibility(View.INVISIBLE);
            }

        }
    }
}
