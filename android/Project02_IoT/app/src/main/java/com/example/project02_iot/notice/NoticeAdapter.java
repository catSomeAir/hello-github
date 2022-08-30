package com.example.project02_iot.notice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<NoticeVO> list;

    public NoticeAdapter(LayoutInflater inflater, ArrayList<NoticeVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_noti_recv , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title , tv_content , tv_date , tv_writer;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_content = v.findViewById(R.id.tv_content);
            tv_title = v.findViewById(R.id.tv_title);
            tv_date = v.findViewById(R.id.tv_date);
            tv_writer = v.findViewById(R.id.tv_writer);

        }
        public void bind(@NonNull ViewHolder holder, int i){
            holder.tv_content.setText(list.get(i).getContent());
            holder.tv_title.setText(list.get(i).getTitle());
            holder.tv_date.setText(list.get(i).getWritedate());
            holder.tv_writer.setText(list.get(i).getWriter());
        }
    }
}
