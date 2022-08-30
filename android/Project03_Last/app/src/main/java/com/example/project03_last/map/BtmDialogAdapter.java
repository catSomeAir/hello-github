package com.example.project03_last.map;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project03_last.R;

import java.util.ArrayList;

public class BtmDialogAdapter extends  RecyclerView.Adapter<BtmDialogAdapter.ViewHolder> {
    ArrayList<MapDTO> list ;
    LayoutInflater inflater;
    MapFragment.MapOnclickEventKYM event ;//null;

    public BtmDialogAdapter(ArrayList<MapDTO> list, LayoutInflater inflater, MapFragment.MapOnclickEventKYM event) {
        this.list = list;
        this.inflater = inflater;
        this.event = event; // fragment에서 메모리에 올려둔 인터페이스
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_btm_dialog_recv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.bind(h, i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name , tv_time ;
        Button btn_move;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_name = v.findViewById(R.id.tv_name);
            tv_time = v.findViewById(R.id.tv_time);
            btn_move = v.findViewById(R.id.btn_move);
        }

        public void bind(@NonNull ViewHolder h, int i){
            h.tv_name.setText(list.get(i).getName());
            h.tv_time.setText(list.get(i).getSyncTime());
            h.btn_move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double lat = 0 ;
                    double lng = 0 ;
                    try{
                        lat = Double.parseDouble(list.get(i).getLat());
                        lng = Double.parseDouble(list.get(i).getLng());//""=>
                        event.cameraUpdate(lat,lng);
                    }catch (Exception e){

                    }
                }
            });
        }
    }
}
