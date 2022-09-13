package com.hanul.poly03;

public interface RemoCon {
	//1.추상메소드 abstract 생성 볼륨up,down, 인터넷
	public abstract void volUp();
	public abstract void volDown();
	public void internet();			//interface 내에서 선언된 메소드는 abstract를 생략하더라도 추상메소드로 간주된다.
	
}
