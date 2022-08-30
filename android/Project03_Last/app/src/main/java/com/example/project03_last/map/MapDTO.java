package com.example.project03_last.map;

import com.google.gson.annotations.SerializedName;

public class MapDTO {
    @SerializedName("localSpecialStNm")
    private String name;
    private String addrRoad , addrJibun;
    private String lat , lng ;// 위경도 꼭 필요
    private String mngAgcTel  ;
    private String syncTime  ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddrRoad() {
        return addrRoad;
    }

    public void setAddrRoad(String addrRoad) {
        this.addrRoad = addrRoad;
    }

    public String getAddrJibun() {
        return addrJibun;
    }

    public void setAddrJibun(String addrJibun) {
        this.addrJibun = addrJibun;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getMngAgcTel() {
        return mngAgcTel;
    }

    public void setMngAgcTel(String mngAgcTel) {
        this.mngAgcTel = mngAgcTel;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    /* "id" : "1", 단순 자바 오브젝트 POJO ( Plain Old Java Object ) String Date<= 잘못바꾸면 꺼짐 , double <= NumberFormatException

             "localSpecialStNm" : "건축자재의 거리",
             "localSpecialStIntro" : "구호전사거리에서 대인광장에 이르기까지 넓은 지역에 걸쳐 펼쳐진 건축자재거리는 목재·슬레이트·석고보드 등을 판매하는 건재상, 타일·PVC·변기·장판 등을 판매하는 실내 장식업은 물론 철강·배관·보일러 판매상 등 약 170여개 점포로 이루어져 축에 필요한 모든 자재를 일괄 구입할 수 있는 광주광역시 유일의 건축 자재 집단화·전문화 거리",
             "addrRoad" : "광주광역시 동구 계림로",
             "addrJibun" : "광주 동구 계림동 809번지",
             "lat" : "35.162706", ※
             "lng" : "126.923281", ※
             "ttlLng" : "1500",
             "storeCnt" : "170",
             "dsgnYear" : "2003",
             "mngAgcTel" : "062-410-6547",
             "mngAgcNm" : "광주광역시 북구청",
             "syncTime" : "2021-11-30"*/


}
