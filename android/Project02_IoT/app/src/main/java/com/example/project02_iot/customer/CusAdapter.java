package com.example.project02_iot.customer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;

import java.util.ArrayList;

//2. 1번에 만든 클래스를 이용하여 어떤것을 상속을 받는다.
public class CusAdapter extends RecyclerView.Adapter<CusAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<CustomerVO> list ;
    Context context;
    CusFragment fragment; // new <- 새로운 메모리 번지수를 만들고 참조를 시작한다.

    public CusAdapter(LayoutInflater inflater, ArrayList<CustomerVO> list, Context context, CusFragment fragment) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
        this.fragment = fragment;
    }

    public CusAdapter(LayoutInflater inflater, ArrayList<CustomerVO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override // 만들어놓은 ViewHolder Class를 리턴하는 메소드를 완성하기.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_cus_recv,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //데이터가 있을때 처리해야되는 부분
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();//13
    }

    //3. 상속을 받고나서 필수적으로 재정의되어야할 메소드들의 내용을 작성한다.



    // 1. 내부에 어떤 클래스를 만든다(== ViewHolder , 위젯들을 묶어놓은 위젯용 DTO )
    // extends RecyclerView.ViewHolder 상속 받아야 ViewHolder라고 인식함.
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgv_cus;
        TextView tv_no , tv_name , tv_phone;
        Button btn_detail , btn_update , btn_delete;
        public ViewHolder(@NonNull View v) {
            super(v);
            imgv_cus = v.findViewById(R.id.imgv_cus);
            tv_no = v.findViewById(R.id.tv_no);
            tv_name = v.findViewById(R.id.tv_name);
            tv_phone = v.findViewById(R.id.tv_phone);
            btn_detail = v.findViewById(R.id.btn_detail);
            btn_update = v.findViewById(R.id.btn_update);
            btn_delete = v.findViewById(R.id.btn_delete);
        }
        //상세보기 버튼 클릭 시 => DetailActivity로 가려면 ????
        //
        public void bind(@NonNull ViewHolder holder, int i){
            holder.tv_no.setText(list.get(i).getId()+"");
            holder.tv_name.setText(list.get(i).getName());
            holder.tv_phone.setText(list.get(i).getPhone());

            if(list.get(i).getGender().equals("남")){
                holder.imgv_cus.setImageResource(R.drawable.male);
            }else{
                holder.imgv_cus.setImageResource(R.drawable.female);
            }

           holder.btn_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,CusDetailActivity.class);
                    // 정보중에 선택 된 정보를 => CusDetailActivity로 전송 해보기.
                    //1. id값을 보내고 detailActivity에서 미들웨어를 통해 다시 조회해오기 (1건)
                    intent.putExtra("id" , list.get(i).getId());
                    intent.putExtra("vo" , list.get(i));// 0[vo] 1[vo].....
                    intent.putExtra("isenable" , false);
                    //intent.putExtra("screen" , "정보수정");
                    //2. 데이터 1건의 정보를 모두 detailActivity에 보내기(1건) list<- vo


                    context.startActivity(intent);
                }
            });

           holder.btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,CusDetailActivity.class);
                    intent.putExtra("id" , list.get(i).getId());
                    intent.putExtra("vo" , list.get(i));
                    intent.putExtra("isenable" , true);
                    context.startActivity(intent);
                }
            });

           holder.btn_delete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   // confirm(Web) <=> AlertDialog(And) <- 유저가 어떠한 액션을 했을때 정말로 할것인지를 최종적으로
                   //한번 더 확인하기위한 알림창.
                   checkDelete(list.get(i).getId());
               }
           });

        }//bind

        public void checkDelete(int id){
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("고객 정보 삭제")
                    .setMessage("정말로 삭제하겠습니까?")
                    .setIcon(R.drawable.ic_android_black_24dp);

            builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    CommonConn conn = new CommonConn(context,"delete.cu");
                    conn.addParams("id" , id);
                    conn.excuteConn(new CommonConn.ConnCallback() {
                        @Override
                        public void onResult(boolean isResult, String data) {
                            fragment.recv_select();
                        }
                    });
                }
            });

            builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog dialog = builder.create();//dialog가 생성이 완료됨
            dialog.show();
        }

    }


}
