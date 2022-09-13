package com.hanul.poly01;
//7. 두번째 하위클래스(Cat.java)생성 : Aniaml 클래스 상속 extends
public class Cat extends Animal {
//8. 상위클레스 cry메소드 
	@Override
	public void cry() {
		System.out.println("야옹");
	}//cry()
	
//9. 하위클래스(Cat)만 가지고 있는 고유 메소드 : 알파상태 - 야행성
	public void night() {
		System.out.println("고양이는 야행성이다.");
	}
	
	
}//class
