import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

public class Poly02Main01 {
	//1.main 메소드 생성
	public static void main(String[] args) {
		//2.Dog 객체를 생성 : UpCasting ▶ 객체를 생성할 때 상위클래스 쪽으로 생성. Animal을 상속받은 Dog는 둘다 객체를 생성해서 지정할 수 있다.
		//Dog객체를 Animal로 받기
		Animal animal = new Dog();
		animal.cry();
		
		//3.Cat 객체를 생성 : UpCasting
		animal = new Cat();
		animal.cry();
		((Cat) animal).night();	//DownCasting
	}
}
