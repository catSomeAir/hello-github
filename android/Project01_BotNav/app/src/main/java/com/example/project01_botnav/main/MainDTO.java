package com.example.project01_botnav.main;

public class MainDTO {
    private int img_id;
    private String name , msg;
    private boolean isMusic = false;

    public MainDTO(int img_id, String name, String msg, boolean isMusic) {
        this.img_id = img_id;
        this.name = name;
        this.msg = msg;
        this.isMusic = isMusic;
    }

    public MainDTO(int img_id, String name, String msg) {
        this.img_id = img_id;
        this.name = name;
        this.msg = msg;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
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

    public boolean isMusic() {
        return isMusic;
    }

    public void setMusic(boolean music) {
        isMusic = music;
    }
}
