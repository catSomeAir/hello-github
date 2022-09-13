package com.hanul.poly02;
	//1. 추상클래스 ( abstract)
	//	추상메소드가 클래스내에 하나라도 있으면 추상클래스가 된다.
	//	코드구현시 클래스 내 메소드가 추상클래스가 생긴다면 abstract를 직접 입력해주어야한다.
	//	UpCasting 용도로 만들어지는 클래스 , 그래서 객체를 생성할 수 없다. : ★ 다형성 보장하기 위해서 존재
public abstract class Animal {
	//2. 추상메소드 ( abstract)	: body block {} 이 없는 메소드. 즉, 구현부가 없다.
	//	왜? → 상속받은 하위클래스에서 상위클래스가 정의한 메소드를 반드시 재정의(Override) 하기 위해서 만든다. 
	//	왜?	→ Override를 해야 다형성의 전제조건 충족.
	public abstract void cry();		
}
