import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main02 {
	public static void main(String[] args) {
	//1. 일반적 객체생성
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		//3. 객체생성후 메소드 호출 : 실인수
		Poly02Main02 poly = new Poly02Main02();
		poly.display(dog);		//6번 실행시★dog로 받은 경우는 display에 Cat에만 있는 night는 실행 되지 못해서 Exception 발생. 
		poly.display(cat);		//cat은 display할수 없어 메소드 생성해야함
	}//main()
	
//	//2.출력 메소드 정의(가인수) 
//	public void display(Dog dog) {
//		//~
//	}//display()
//	
//	//4. cat을 가인수로 가지는 출력메소드 정의 ▶그럼 cat , dog , ..생길때 마다 메소드만들어야하나? 아니그럼?
//	public void display(Cat cat) {
//		//~~
//	}//display()
//	
	//5. 다형성인수 : 매소드 정의 할 때 가인수를 상속받은 상위 클래스인 다형성인수로 받으면 위와같이 메소드를 계속 생성할 필요가 없다.
	public void display(Animal animal) {
		animal.cry();
//		animal.night();		//상위 클래스가 추상클래스이므로 구체적인 하위클래스인 Cat클래스의 메소드인 night는 구현 하기 힘들어서 다운캐스팅하여 받는다.
		//6. 다운캐스팅해야하는 경우 예외가 발생
//		((Cat)animal).night();
		
		//7.그럼 Cat Class Type 인 경우에만 night()메소드가 실행되도록 Type비교를 해주어야한다. ▶ instanceof 를 사용한다.
		if(animal instanceof Cat) {		//animal 의 객체가 Cat이면 이라는 의미
			((Cat) animal).night();		//instanceof 를 해주면 animal.night(); 하면 자동으로 다운캐스팅해서 완성 해준다.
		}
		
	}//display()
}//class
