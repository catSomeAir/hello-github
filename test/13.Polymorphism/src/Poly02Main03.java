import com.hanul.poly02.Animal;
import com.hanul.poly02.Cat;
import com.hanul.poly02.Dog;

//Main03에서는... 생성된 객체를 배열(animals[])에 초기화 하기 !

public class Poly02Main03 {
	public static void main(String[] args) {
		//1.일반적 객체생성
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		//2.다형성배열 초기화
		Animal[] animals = {dog, cat};		//import해줘야함
		
		//3.배열에 등록된 원소값 메소드 호출
		for (int i = 0; i < animals.length; i++) {
			animals[i].cry();
			//4.알파상태 비교하여 출력: 타입비교 하기위해 instanceof
			if(animals[i] instanceof Cat) {
				((Cat)animals[i]).night();
			}//if
		}//for
	}//main()
}//class