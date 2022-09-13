import com.hanul.poly03.Radio;
import com.hanul.poly03.RemoCon;
import com.hanul.poly03.Tv;

public class Poly03Main01 {		//▶ RemoCon.java Tv.java Radio.java 
	//하위클래스인 TV, Radio의 소리를 올리고 내린후 인터넷 접속
	public static void main(String[] args) {
	//4. 방법:1 main에서 상위클래스인 RemoCon 으로 UpCasting 하여 객체생성
		RemoCon remoCon	= new Tv();
		remoCon.volUp();
		remoCon.volDown();
		remoCon.internet();
		
		remoCon = new Radio();
		remoCon.volUp();
		remoCon.volDown();
		remoCon.internet();
		System.out.println("===============================");
		
		//5. 방법2: 다형성 변수를 이용하여 중복된 위 코드를 줄인다. 우선 일반적인 객체생성
		Tv tv = new Tv();
		Radio radio = new Radio();
		
		//7. Main클래스 객체생성
		Poly03Main01 poly = new Poly03Main01();
		poly.play(tv);
		poly.play(radio);
		System.out.println("===============================");
		
		//8. 방법3 :다형성 배열을 이용하여 객체생성
		RemoCon[] remoCons = {tv, radio};
		for (int i = 0; i < remoCons.length; i++) {
			remoCons[i].volUp();
			remoCons[i].volDown();
			remoCons[i].internet();
		}
		System.out.println("===============================");
	}//main()
	
	//6. 중복메소드를 하나로 묶는 play 메소드생성 : ★ 여기의 매개변수를 다형성인수 , 즉 부모클래스로 업캐스팅한 것을 그대로 넣어준다
	
	public void play(RemoCon remoCon) {
		remoCon.volUp();
		remoCon.volDown();
		remoCon.internet();
	}//play()
	
}//class
