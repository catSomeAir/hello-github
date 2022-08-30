package com.example.project02_iot.hr;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_iot.R;
import com.example.project02_iot.conn.CommonConn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class HrFragment extends Fragment {
    RecyclerView recv_emp;
    SwipeRefreshLayout swipe_emp;
    SearchView search_emp;
    String keyword = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hr, container, false);

        recv_emp = v.findViewById(R.id.recv_emp);


        swipe_emp = v.findViewById(R.id.swipe_emp);
        swipe_emp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Refresh는 스와이프가 되서 동작하는 상태가 되면 처리할 이벤트를 작성.
                // ※  swipe_emp.setRefreshing(false) <- 를 안주면 계속 해서 돌아감.
                searchEmp();
                swipe_emp.setRefreshing(false);
            }
        });


        search_emp = v.findViewById(R.id.search_emp);

        search_emp.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 돋보기 버튼(Submit) 전송버튼을 누르면 실행되는곳 ( query라는 변수는 입력 된 값이 String있음 )
                keyword = query;
                searchEmp();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                keyword = newText;
                searchEmp();
                // 글자가 바뀔때마다 실행이 되는 부분.
                return true;
            }
        });



        searchEmp();
        return v;
    }

    public void searchEmp(){

        //아이템을 조회해와야함.
        CommonConn conn = new CommonConn(getContext() , "list.hr");
        conn.addParams("keyword" , keyword);
        conn.excuteConn(new CommonConn.ConnCallback() {
            @Override
            public void onResult(boolean isResult, String data) {
                ArrayList<HrVO> list = new Gson().fromJson(data,
                        new TypeToken< ArrayList<HrVO> >(){}.getType());

                HrAdapter adapter = new HrAdapter(getLayoutInflater() , list , getContext());
                RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext() , RecyclerView.VERTICAL , false);
                recv_emp.setLayoutManager(manager);
                recv_emp.setAdapter(adapter);
                swipe_emp.setRefreshing(false);
            }
        });



    }
}