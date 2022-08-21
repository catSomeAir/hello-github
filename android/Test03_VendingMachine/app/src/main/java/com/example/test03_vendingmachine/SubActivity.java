package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SubActivity extends AppCompatActivity {
        TextView blc, cost_total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //수량
        TextView[] qtys = new TextView[8];
        Integer[] Rid_qty = {R.id.qty_1, R.id.qty_2, R.id.qty_3, R.id.qty_4, R.id.qty_5, R.id.qty_6, R.id.qty_7, R.id.qty_8};
        for( int i = 0 ; i < qtys.length; i++){
            qtys[i] = findViewById(Rid_qty[i]);
        }
        //레이아웃
        LinearLayout[] layouts = new LinearLayout[8];
        Integer[] Rid_layout = { R.id.layout_1, R.id.layout_2, R.id.layout_3, R.id.layout_4, R.id.layout_5,R.id.layout_6, R.id.layout_7, R.id.layout_8 };
        for( int i = 0 ; i < layouts.length; i++){
            layouts[i] = findViewById(Rid_layout[i]);
        }
        //잔액
        blc = findViewById(R.id.blc);
        //총 결제금액
        cost_total = findViewById(R.id.cost_total);

        Intent intent = getIntent();
        ArrayList<VendingDTO> list = (ArrayList<VendingDTO>) intent.getSerializableExtra("list");
        for (int i = 0; i < list.size(); i++) {
            qtys[i].setText(list.get(i).getQty()+"");
            if (list.get(i).getQty() == 0) {
                layouts[i].setVisibility(View.GONE);
            }
        }

        //누적입금액
        int insert = Integer.parseInt(intent.getStringExtra("cost_insert"));
        //총 구매금액
        int total = Integer.parseInt(intent.getStringExtra("cost_total"));
       cost_total.setText(total + "");
       blc.setText(insert - total +"");
    }
}

