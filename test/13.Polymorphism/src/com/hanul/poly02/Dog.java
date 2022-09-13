package com.hanul.poly02;

//3. 추상 클래스 상속 ▶ type must implement the inherited abstract method Animal.cry(): 상속받은 추상메소드를 반드시 구현해줘라 (Override의 강제성)
public class Dog extends Animal{		
	@Override
	public void cry() {
		System.out.println("멍멍");
	}//cry()
	
}//class