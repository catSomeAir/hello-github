import com.hanul.poly01.Animal;
import com.hanul.poly01.Cat;
import com.hanul.poly01.Dog;

public class Poly01Main02 {
	//1.메인메소드
	public static void main(String[] args) {
	//2. Dog 객체생성
		Dog dog = new Dog();	//일반적인 객체생성방법
		dog.cry();
		
	//3. Cat 객체를 UpCasting으로 객체생성해보기
		Animal animal = new Cat();		//Animal로 받았지만 식별자 animal은 Cat클래스역할임. 이경우는 알파상태를 구현할 수 없다.
		animal.cry();
		//animal.night(); 알파상태 : 구현하는 방법은 다시 Cat객체생성
	
		//4. DownCasting 으로 알파상태 구현하기 : 하위클래스 객체생성 하는데 위에서 상위 클래스 animal을 Cat으로 다운캐스팅
		Cat cat = (Cat) animal;
		cat.night();				//  animal.night →  ((Cat)animal).night();로 18,19 라인을 한번에 쓸 수 도 있다. 
		((Cat)animal).night();
	}//main()
}//class
/*
○ 객체를 생성하는 방법
	- Dog dog = new Dog();			▶ 일반적인 객체 생성 방법
	- Animal animal = new Cat();	▶ 업캐스팅(UpCasting) → 다형성이 발생 : A a  = new B();

○ 다형성의 전제조건
	- 상속관계 : public class 하위클래스(A) extends 상위클래스(B) ▶ A → B
	- Override 필수 : 하위클래스(A)에서는 상위클래스(B)의 기능(메소드)을 재정의 
	- UpCasting으로 객체를 생성 : 상위클래스 쪽으로 객체생성, ex) new Dog를 만드는데 이걸 부모클래스로 받는다.

*/