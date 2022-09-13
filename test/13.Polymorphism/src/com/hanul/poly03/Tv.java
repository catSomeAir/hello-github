package com.hanul.poly03;
//2.interface를 상속하기위해 implements
public class Tv implements RemoCon {	//바로 만들면 Override가 되어있지않아 빨간줄이 뜬다. Alt+Shift+S , V
	

	@Override
	public void volUp() {
		System.out.println("Tv 소리를 올린다.");
	}

	@Override
	public void volDown() {
		System.out.println("Tv 소리를 내린다.");
	}

	@Override
	public void internet() {
		System.out.println("인터넷을 사용한다.");
	}		

}
