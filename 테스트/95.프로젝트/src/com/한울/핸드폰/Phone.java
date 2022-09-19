package com.hanul.phone;

import java.util.Scanner;

public class Phone {

	// ▶ 속성: 색상, 모델명, 상태 (+채널),(+인터넷상태) 
	// ▶ 기능
	//① 1세대 : 전원(켜/끄), 전화(받/끊), 음성(송/수)
	//② 2세대 : + dmb(켜/끄/채변) 		조건 : 전원(켜)→ dmb(켜)만 →채변(숫자로입력,콘솔창출력)
	//③ 3세대 : 인터넷(켜/끄),웹툰앱(켜/끄)	조건: 전원(켜)→ 인터넷(켜)만→ 웹툰앱
	//1세대전원,전화,음성 디엠비좋아

	
	//명칭정리 : 색상 color, 모델명 model, 상태 state, 채널 channel, 전원 power, 켜,받, on , 끄 끊 off, 송신 send 수신  receive
	
	//1.멤버변수 선언 :일단은 다 스트링으로 둬버리자
	private String color, model, state, dmb, channel, internet, webtoon;
	private int power;
	private Scanner scanner;
	
	//2. 기본 생성자 메소드
	public Phone(){}
	
	//3. 생성자메소드 초기화 , 오버로딩
	public Phone(String color, String model, String channel, int power, String state) {
		super();
		this.color = color;
		this.model = model;
		this.channel = channel;
		this.power = power;
	}
	public Phone(String color, String model, String channel, int power, String state, String internet) {
		super();
		this.color = color;
		this.model = model;
		this.channel = channel;
		this.power = power;
		this.internet = internet;
	}
	//전원 메소드 
	public void powerCheck() {
		if(power == 1) {
			state = "켜짐";
		}else if(power ==0) {
			state = "꼬짐";
		}
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDmb() {
		return dmb;
	}

	public void setDmb(String dmb) {
		this.dmb = dmb;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getInternet() {
		return internet;
	}

	public void setInternet(String internet) {
		this.internet = internet;
	}

	public String getWebtoon() {
		return webtoon;
	}

	public void setWebtoon(String webtoon) {
		this.webtoon = webtoon;
	}
	
	
	

}//class
