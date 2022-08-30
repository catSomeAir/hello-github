package com.example.project01_botnav.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_botnav.R;
import com.example.project01_botnav.SplashActivity;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<ViewDTO> list;
    Context context;

    public ViewAdapter(LayoutInflater inflater, ArrayList<ViewDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    public ViewAdapter(LayoutInflater inflater, ArrayList<ViewDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title , tv_date , tv_content;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_title = v.findViewById(R.id.tv_title);
            tv_date = v.findViewById(R.id.tv_date);
            tv_content = v.findViewById(R.id.tv_content);
        }
        public void bind(@NonNull ViewHolder h, int i){
            h.tv_title.setText(list.get(i).getTitle());
            h.tv_content.setText(list.get(i).getContent());
            h.tv_date.setText(list.get(i).getDate());
            // => DetailActivity 상세정보를 볼수있는 액티비티
            // Intent intent = new Intent(현재위치(컨텍스트),다음액티비티클래스)
            h.tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context , SplashActivity.class);
                    context.startActivity(intent);
                }
            });


        }

    }

}
