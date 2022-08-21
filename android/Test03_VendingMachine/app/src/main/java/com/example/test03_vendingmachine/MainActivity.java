package com.example.test03_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //카운트
//    int cnt1 = 0, cnt2 = 0, cnt3 = 0, cnt4 = 0, cnt5 = 0, cnt6 = 0, cnt7 = 0, cnt8 = 0;
//    int[] cnts = {cnt1, cnt2, cnt3, cnt4, cnt5, cnt6, cnt7, cnt8};
    //품목 버튼
    Button[] btns = new Button[8];
    Integer[] Rid_button = {R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8};

    //기능 버튼
    Button btn_9, btn_10;       //9번은 금액입력 , 10번은 주문하기

    //수량 조절 업다운
    ImageView[] imgv_up = new ImageView[8];
    Integer[] Rid_up = {R.id.up_1, R.id.up_2, R.id.up_3, R.id.up_4, R.id.up_5, R.id.up_6, R.id.up_7, R.id.up_8};
    ImageView[] imgv_down = new ImageView[8];
    Integer[] Rid_down = {R.id.down_1, R.id.down_2, R.id.down_3, R.id.down_4, R.id.down_5, R.id.down_6, R.id.down_7, R.id.down_8};

    //추가입력금액 : m_1
    EditText m_1;

    //총 결제금액 , 누적 입금액
    TextView cost_total, cost_insert;

    //왼쪽화면 수량 / 우측하단 수량
    TextView[] qtys_left = new TextView[8];
    TextView[] qtys_right = new TextView[8];
    Integer[] Rid_qty = {R.id.qty_1, R.id.qty_2, R.id.qty_3, R.id.qty_4, R.id.qty_5, R.id.qty_6, R.id.qty_7, R.id.qty_8,
            R.id.qty_1_1, R.id.qty_2_1, R.id.qty_3_1, R.id.qty_4_1, R.id.qty_5_1, R.id.qty_6_1, R.id.qty_7_1, R.id.qty_8_1};


    //우측하단 품목 레이아웃
    LinearLayout[] layouts = new LinearLayout[8];
    Integer[] Rid_layout = {R.id.layout_1_1, R.id.layout_1_2, R.id.layout_1_3, R.id.layout_1_4, R.id.layout_1_5, R.id.layout_1_6, R.id.layout_1_7, R.id.layout_1_8};

    //단가
    TextView[] costs = new TextView[8];
    Integer[] Rid_cost = {R.id.cost_1, R.id.cost_2, R.id.cost_3, R.id.cost_4, R.id.cost_5, R.id.cost_6, R.id.cost_7, R.id.cost_8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼생성
        for (int i = 0; i < btns.length; i++) {
            btns[i] = findViewById(Rid_button[i]);
        }
        btn_9 = findViewById(R.id.btn_9);
        btn_10 = findViewById(R.id.btn_10);

        //수량조절
        for (int i = 0; i < imgv_up.length; i++) {
            imgv_up[i] = findViewById(Rid_up[i]);
            imgv_down[i] = findViewById(Rid_down[i]);
        }
        //입력금액 : 총입력금액 blc에 더해져야한다.
        m_1 = findViewById(R.id.m_1);

        //총 구매금액(cost_total) : 각각의 ost * qty
        cost_total = findViewById(R.id.cost_total);

        //누적 입력금액
        cost_insert = findViewById(R.id.cost_insert);

        //왼쪽수량, 우측하단 수량
        for (int i = 0; i < qtys_left.length; i++) {
            qtys_left[i] = findViewById(Rid_qty[i]);
            qtys_right[i] = findViewById(Rid_qty[i + 8]);
        }

        //우측하단 품목 레이아웃
        for (int i = 0; i < layouts.length; i++) {
            layouts[i] = findViewById(Rid_layout[i]);
        }

        //단가
        for (int i = 0; i < costs.length; i++) {
            costs[i] = findViewById(Rid_cost[i]);
        }
        MainActivity mainActivity = new MainActivity();
        VendingDAO dao = new VendingDAO();


        //주문하기 버튼
        dao.select(btns, qtys_left, qtys_right, costs, cost_total, layouts, MainActivity.this);

        //물품추가 업버튼
        dao.getAdd(btns, imgv_up, qtys_left, qtys_right, costs, cost_total, MainActivity.this);

        //물품제거 다운버튼
        dao.getSum(btns, imgv_down, qtys_left, qtys_right, costs, cost_total, layouts);

        //금액입력란 엔터
        m_1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    try {
                        int sum = Integer.parseInt(m_1.getText().toString());   //누적입금액
                        int insert = Integer.parseInt(cost_insert.getText().toString());    //총 결제금액
                        if (sum < 0) {
                            Toast.makeText(MainActivity.this, "금액을 반환하시려면 상품을 취소하고 \n 결제하기를 누르세요", Toast.LENGTH_LONG).show();
                        } else{
                            cost_insert.setText(insert + sum + "");
                        }
                        m_1.setText("");
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "올바른 금액을 입력하세요", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });

        //금액입력 버튼
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int sum = Integer.parseInt(m_1.getText().toString());   //누적입금액
                    int insert = Integer.parseInt(cost_insert.getText().toString());    //총 결제금액
                    if (sum < 0) {
                        Toast.makeText(MainActivity.this, "금액을 반환하시려면 상품을 취소하고 \n 결제하기를 누르세요", Toast.LENGTH_LONG).show();
                    } else {
                        cost_insert.setText(insert + sum + "");
                    }
                    m_1.setText("");
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "올바른 금액을 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //결제하기 버튼
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                int insert = Integer.parseInt(cost_insert.getText().toString());
                int total = Integer.parseInt(cost_total.getText().toString());
                ArrayList<VendingDTO> list = new ArrayList<>();
                if (insert >= total) {
                    int[] cnts = new int[8];
                    for (int i = 0; i < cnts.length; i++) {
                        cnts[i] = Integer.parseInt(qtys_right[i].getText().toString());
                    }
                    //음료 리스트
                    for (int i = 0; i < 8; i++) {
                        list.add(new VendingDTO(Integer.parseInt(costs[i].getText().toString()), cnts[i]));
                    }
                    intent.putExtra("list", list);
                    intent.putExtra("cost_insert", cost_insert.getText().toString());
                    intent.putExtra("cost_total", cost_total.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "잔액이 부족합니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
