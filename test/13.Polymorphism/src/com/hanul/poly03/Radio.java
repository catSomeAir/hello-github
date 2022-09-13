package com.hanul.poly03;

//3. interface 상속
public class Radio implements RemoCon {	//Radio 클래스명에 빨간줄. 자동 오버라이딩 가능

	@Override
	public void volUp() {
		System.out.println("Radio 소리를 올린다.");
	}

	@Override
	public void volDown() {
		System.out.println("Radio 소리를 내린다.");
	}

	@Override
	public void internet() {
		System.out.println("인터넷 접속 기능이 없다.");
	}
	
}
