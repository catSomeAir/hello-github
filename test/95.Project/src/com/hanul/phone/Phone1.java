package com.hanul.phone;

//● 부모클래스 : Phone1
public class Phone1{
		private String color, model, powerstate, state;
		private int power , phonename, call, voice;
		
	public Phone1() {}
	public Phone1(int phonename, String color, String model, String state) {
		this.color = color;
		this.model = model;
		this.state = state;
		this.phonename = phonename;
		newInfo();
		
	}

		
	//상태정보출력
	public void newInfo() {
			System.out.println("1세대 폰(색상 : " + color + ", 모델명 : " + model + ", 상태 : " + state + ")가 지급 되었습니다."+"\n");
	}//stateInfo
	
	//전원정보	
	public void powerCheck() {
		if(power == 1) {
			System.out.println(getModel() + " 전원이 켜졌습니다.");
		}else if(power ==2) {
			System.out.println(getModel() + " 전원이 꺼졌습니다.");
		}
	}//powerCheck()
	
	//전화
	public void call() {
		if(getCall()==1 && getPower()==1) {
			System.out.println("전화가 와서 받았습니다.");
		}else if(getPower() != 1 && getCall()==1) {
				System.out.println("전원이 꺼져있어 전화 받기가 불가 합니다.");
		}else if(getCall()==2 && getPower()==1) {
			System.out.println("전화를 끊습니다.");
		}else if(getCall()==2 && getPower()!=1) {
			System.out.println("전원이 꺼져있어 전화 끊기가 불가 합니다.");
			
		}else {
				System.out.println("정확히 다시 입력해주세요.");
		}//if
	}//call()	
	
	//음성
	public void voice() {
		if(getCall()==1 && getVoice()==1) {
			System.out.println("나: 여보세요?");
			
		}else if(getCall()==1 && getVoice()==2) {	
			System.out.println("상대방 : 여보세요?");
		}else {
			System.out.println("통화중 상태가 아닙니다. 음성 전송 & 수신이 불가합니다.");
		}
	}//voice()
	
	//지원
	public void support() {
		System.out.println(getPhoneName() + "세대폰은 지원하지 않습니다.");
	}
	
	//잘못누름
	public void wrongNumber() {
		System.out.println("정확히 다시 입력해주세요");
	}
	
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
	public void stateInfo() {
		state = powerstate;
		System.out.println(powerstate);
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
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPhoneName() {
		return phonename;
	}
	public void setPhoneName() {
	}
	public int getCall() {
		return call;
	}
	public void setCall(int call) {
		this.call = call;
	}
	
	
	
}//class