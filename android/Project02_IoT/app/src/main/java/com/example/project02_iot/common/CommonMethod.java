package com.example.project02_iot.common;

import android.widget.EditText;

public class CommonMethod {

    // EditText의 내용이 있는지 없는지,
    // findViewById <- 위젯 연결을 생략해버림.
    // 로그인 액티비티 ( 에딧텍스트 아이디 , 비밀번호 )=>메소드활용
    // 회원가입 액티비티 ( 에딧텍스트 아이디,비밀번호 , 비밀번호 확인 등등에서 활용) =>메소드활용
    // 새글쓰기 액티비티 ( 글제목 , 작성자 ) =>메소드 활용
    public static boolean isCheckEditText(EditText edt) {
        try {
            if (edt == null || edt.getText() == null ||
                    edt.getText().toString() == null || edt.getText().toString().trim().length() < 1) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true; // 에딧텍스트 객체가 null이 아니고 글자수가 1보다 작은게 아닐때.
    }


}
