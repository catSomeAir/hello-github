package com.hanul.poly01;
//5. 하위클래스(Dog.java) 생성 : Animal Class를 상속 extends
public class Dog extends Animal{
	//6. Aniaml 클래스의 cry메소드 오버라이딩
	@Override
	public void cry() {
		System.out.println("멍멍");
	}//cry()
	
}//class