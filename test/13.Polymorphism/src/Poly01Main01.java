import com.hanul.poly01.Animal;
import com.hanul.poly01.Cat;
import com.hanul.poly01.Dog;

//1.Main클래스 생성
public class Poly01Main01 {
//2.Main메소드 생성
	public static void main(String[] args) {
		//10. Case I. Dog 클래스의 cry메소드 실행(자신이 직접만든 경우)
		Dog dog = new Dog();
		dog.cry();

		//11. Case II. Dog 클래스의 cry메소드 실행(다른사람이 만든 Dog클래스 객체화 하는 경우) : 클래스 내용을 알 수 없음
		
		//12. Case III. 다른사람이 만든 Dog, Animal클래스를 객체화 경우 : 하위클래스, 상위클래스, 메소드의 오버라이드 상황을 알려줌.
		
		//객체생성 : 업캐스팅(UpCasting)	▶ 상위클래스쪽으로 객체를 생성 → 다형성이 발생
		Animal animal = new Dog();
		animal.cry();
		
		animal = new Cat();		//객체생성 : 업캐스팅으로 객체를 생성
		animal.cry();
		//13. 하위클래스 Cat Class의 알파상태 night()메소드를 동작시키고싶다!
		//	animal.night();		부모클래스에서 없으므로 새로생성
		Cat cat = new Cat();
		cat.night();
	}//main()
}//class
