package com.example.project01_botnav.chat;

public class ChatDTO {
    private int imgv_res; // 0
    private String name , msg , time ; // null
    private boolean isPin , isNoti ; // false

    public ChatDTO(int imgv_res, String name, String msg, String time) {
        this.imgv_res = imgv_res;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getImgv_res() {
        return imgv_res;
    }

    public void setImgv_res(int imgv_res) {
        this.imgv_res = imgv_res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPin() {
        return isPin;
    }

    public void setPin(boolean pin) {
        isPin = pin;
    }

    public boolean isNoti() {
        return isNoti;
    }

    public void setNoti(boolean noti) {
        isNoti = noti;
    }
}
