package com.hanul.phone;
//● 부모클래스 : Phone2 을 상속받은 Phone3 → 인터넷, 웹툰 추가
public class Phone3 extends Phone2 {
	private int internet, webtoon;
	
	//생성자메소드
	public Phone3(int phonename, String color, String model, String state, String channel) {
		super(phonename, color, model, state, channel);
	}

	@Override
	public void newInfo() {
		System.out.println("\n3세대 폰(색상 : " + getColor() + ", 모델명 : " + getModel() + ", 상태 : " + getState() + ", 채널 : 정보없음 )가 지급 되었습니다."+"\n");
	}
	
	//인터넷
	public void internetCheck() {
		if(getInternet() ==1 && getPower() ==1) {
			System.out.println("인터넷을 켭니다");
		}else if(getPower()!=1) {
			System.out.println("전원이 꺼져있어 인터넷 사용이 불가능 합니다.");
		}else if(getInternet() ==2 && getPower() ==1) {
			System.out.println("인터넷을 끕니다.");
		}
	}//internetCheck()
	
	//웹툰
	public void webtoonCheck() {
		if(getPower()!=1) {
			System.out.println("전원이 꺼져있어 웹툰 사용이 불가능 합니다.");
		}else if(getInternet()!=1) {
			System.out.println("인터넷이 꺼져있어 웹툰 사용이 불가능 합니다.");
		}else if(getInternet()==1&& getWebtoon()==1) {
			System.out.println("웹툰을 켭니다.");
		}else if(getWebtoon()==2 && getInternet()==1) {
			System.out.println("웹툰을 끕니다.");
		}else{
			wrongNumber();
		}
	}//webtoonCheck()

	
	@Override
	public void voice() {
		if(getWebtoon()==1) {
			if(getCall()==1 && getVoice()==1) {
				System.out.println("나: 웹툰봅니다.");
				
			}else if(getCall()==1 && getVoice()==2) {	
				System.out.println("상대방 : 뭐하세요?");
			}else {
				System.out.println("통화중 상태가 아닙니다. 음성 전송 & 수신이 불가합니다.");
			}	
		}else{
			super.voice();
		}
		
	}

	public int getInternet() {
		return internet;
	}

	public void setInternet(int internet) {
		this.internet = internet;
	}

	public int getWebtoon() {
		return webtoon;
	}

	public void setWebtoon(int webtoon) {
		this.webtoon = webtoon;
	}
	
	
	
	
}//class
