package com.example.project02_iot.hr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;

import java.util.ArrayList;

public class HrAdapter extends RecyclerView.Adapter<HrAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<HrVO> list;
    Context context;

    public HrAdapter(LayoutInflater inflater, ArrayList<HrVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_hr_recv , parent , false);
        ViewHolder holder = new ViewHolder(itemView);

        return holder;
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
        LinearLayout ln_emp;//<= 텍스트뷰나 이미지뷰를 클릭하게하는게아니라 레이아웃 자체를 클릭하면 상세보기로 이동.
        TextView emp_name , emp_email , emp_id ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            emp_email = itemView.findViewById(R.id.emp_email);
            emp_name = itemView.findViewById(R.id.emp_name);
            emp_id = itemView.findViewById(R.id.emp_id);
            ln_emp = itemView.findViewById(R.id.ln_emp);
        }

        public void bind(@NonNull ViewHolder holder, int position){
            holder.emp_id.setText(list.get(position).getEmployee_id()+"");
            holder.emp_name.setText(list.get(position).getName()+"");
            holder.emp_email.setText(list.get(position).getEmail()+"");
           // holder.emp_id.setText(list.get(position).getEmployee_id()+"");
            holder.ln_emp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HrDialog dialog = new HrDialog(context);
                    dialog.show();
                }
            });
        }
    }
}
