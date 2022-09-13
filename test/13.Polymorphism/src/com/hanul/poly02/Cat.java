package com.hanul.poly02;
//3. 추상 클래스 상속 ▶ 상위 개념인 동물(Animal)은 추상적, 구체적인 하위클래스(고양이,Cat)는 추상적인 상위개념을 상속받으면 구체적 기능을 주어야한다
//그래서 오버라이딩이 필수
public class Cat extends Animal {

	@Override
	public void cry() {
		System.out.println("야옹");
	}//cry
	
	public void night() {
		System.out.println("고양이는 야행성이다.");
	}//night()
	
}//class
