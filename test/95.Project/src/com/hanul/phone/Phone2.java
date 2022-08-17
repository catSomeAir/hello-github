package com.hanul.phone;

//● 부모클래스 : Phone1 을 상속받은 Phone2 → DMB기능 추가
public class Phone2 extends Phone1 {
	private int dmb;
	private int channel;
	
	//생성자메소드
	public Phone2(int phonename, String color, String model, String state, String channel){
		super(phonename, color, model, state);
	}
	
	@Override
	public void newInfo() {
		System.out.println("\n2세대 폰(색상 : " + getColor() + ", 모델명 : " + getModel() + ", 상태 : " + getState() + ", 채널 : 정보없음 )가 지급 되었습니다."+"\n");
	}//stateInfo()

	@Override
	public void stateInfo() {
		super.stateInfo();
	}
	//DMB메소드
	public void dmbCheck() {
		if(getDmb() ==1 && getPower()==1) {
			System.out.println("DMB방송을 켭니다 : 현재채널 : 정보없음" );
		}else if(getDmb() ==1 &&getPower() !=1) {
			System.out.println("전원이 꺼져있어 DMB방송을 켤수가 없습니다.");
		}else if(getDmb() ==2 &&getPower()==1) {
			System.out.println("DMB방송을 끕니다.");
		}else {
			System.out.println("전원이 꺼져있어 DMB방송을 끌수 없습니다.");
		}//if
	}//dmbCheck()
	
	//채널메소드
	public void channelCheck() {
		if(getDmb() ==1 && getPower()==1) {
			System.out.println("DMB방송의 채널을 변경합니다 : " + getChannel()+"번" );
		}else if(getDmb() != 1 && getPower()==1) {
			System.out.println("DMB가 꺼져있어 채널을 변경할 수 없습니다.");
		}else {
			System.out.println("전원이 꺼져있어 채널을 변경할 수 없습니다.");
		}//if

	}//channelCheck()
	public int getDmb() {
		return dmb;
	}

	public void setDmb(int dmb) {
		this.dmb = dmb;
	}

	public int getChannel() {
		return channel;
	}
	
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	
}//class
