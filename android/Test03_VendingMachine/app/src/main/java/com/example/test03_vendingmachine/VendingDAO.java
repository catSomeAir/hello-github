package com.example.test03_vendingmachine;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class VendingDAO {


    //주문하기 버튼
    public int select(Button[] btns, TextView[] qtys_left,
                       TextView[] qtys_right, TextView[] costs, TextView cost_total ,LinearLayout[] layouts,  MainActivity mainActivity){


        for( int i = 0 ; i< 8; i++){
            int finalI = i;
            btns[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int qty_left = Integer.parseInt(qtys_left[finalI].getText().toString());
                    int qty_right = Integer.parseInt(qtys_right[finalI].getText().toString());
                    int cost = Integer.parseInt(costs[finalI].getText().toString());
                    int total = Integer.parseInt(cost_total.getText().toString());

                    if (qty_left == 20) {
                        qtys_right[finalI].setText(qty_right + 1 +"");
                        qtys_left[finalI].setText(qty_left -1 +"");
                        layouts[finalI].setVisibility(View.VISIBLE);
                        cost_total.setText(cost+total + "");


                    } else if(qty_left == 0){
                        Toast.makeText((Context)mainActivity, "재고가 부족합니다", Toast.LENGTH_SHORT).show();

                    }



                }
            });
        }
        return 1;
    }

    //추가 업버튼
    public  void getAdd(Button[] btns, ImageView[] imgv_up,TextView[] qtys_left, TextView[] qtys_right, TextView[] costs, TextView cost_total,MainActivity mainActivity ){
        for( int i = 0 ; i< 8; i++) {
            int finalI1 = i;
            imgv_up[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int total = Integer.parseInt(cost_total.getText().toString());
                    int qty_left = Integer.parseInt(qtys_left[finalI1].getText().toString());
                    int qty_right = Integer.parseInt(qtys_right[finalI1].getText().toString());
                    int cost = Integer.parseInt(costs[finalI1].getText().toString());
                    if (qty_right <= 19) {
                        qtys_left[finalI1].setText(qty_left - 1 + "");
                        qtys_right[finalI1].setText(qty_right + 1 + "");
                        cost_total.setText(total + cost + "");
                        if(qty_right == 19){
                            btns[finalI1].setBackgroundColor(Color.parseColor("#FFE4E4E4"));
                            btns[finalI1].setText("품절");
                        }
                    } else if(qty_right == 20){
                        Toast.makeText(mainActivity, "재고가 부족합니다", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    public void getSum(Button[] btns, ImageView[] imgv_down, TextView[] qtys_left, TextView[] qtys_right,
                       TextView[] costs, TextView cost_total, LinearLayout[] layouts) {
        for( int i = 0 ; i< 8; i++) {

            int finalI2 = i;
            imgv_down[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int total = Integer.parseInt(cost_total.getText().toString());
                    int qty_left = Integer.parseInt(qtys_left[finalI2].getText().toString());
                    int qty_right = Integer.parseInt(qtys_right[finalI2].getText().toString());
                    int cost = Integer.parseInt(costs[finalI2].getText().toString());
                    if (0 <= qty_right) {
                        qtys_left[finalI2].setText(qty_left + 1 + "");
                        qtys_right[finalI2].setText(qty_right - 1 + "");

                        cost_total.setText(total - cost + "");
                        if (qty_right == 1) {
                            layouts[finalI2].setVisibility(View.GONE);
                        }
                        if (qty_right == 20) {
                            btns[finalI2].setBackgroundColor(Color.parseColor("#C93F51B5"));
                            btns[finalI2].setText("주문하기");

                        }

                    }
                }
            });
        }
    }
}
