import java.util.Scanner;

import com.hanul.phone.Phone1;
import com.hanul.phone.Phone2;
import com.hanul.phone.Phone3;

public class SuperPhone {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Phone1 phone = null;
		LABEL1:
		while(true) {
			//세대 선택 
			while(true) {		
				System.out.println();
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■======sss====u====u===pppp====eeeee===rrrrr=======■■■■■");
				System.out.println("■■■■■=====s===s===u====u===p===p===e=======r====r======■■■■■");
				System.out.println("■■■■■======s======u====u===p===p===e=======r====r======■■■■■");
				System.out.println("■■■■■=======ss====u====u===pppp====eeeee===rrrrr=======■■■■■");
				System.out.println("■■■■■=====s===s===u====u===p=======e=======r====r======■■■■■");
				System.out.println("■■■■■======sss=====uuuu====p=======eeeee===r=====r=====■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("=====================================================================");
				System.out.println("      ①. 1세대폰\t②. 2세대폰\t  ③. 3세대폰\t  ④. 종료       ");
				System.out.println("=====================================================================");
				System.out.print("세대 선택 : ");
				
				int th = (Integer.parseInt(scanner.nextLine()));
				
				//세대 선택 if
				if(th == 1) {
					phone = new Phone1(1,"검정","이니셜-1","종료");
					break;
				}else if(th == 2){
					phone = new Phone2(2,"검정","이니셜-2","종료","정보없음");
					break;
				}else if(th == 3){
					phone = new Phone3(3,"검정","이니셜-3","종료","정보없음");
					break;
				}else if(th == 4){
					break LABEL1;
				}else{
					System.out.println("정확히 다시 입력해주세요");
				}//if
			}//while()
			
			//메뉴창 출력
			LABEL2:
			while(true) {
				System.out.println();
				System.out.println(" =========================<   M E N U   >=============================");
				System.out.println(" |  1.전원 2.전화 3.음성 4.DMB 5.채널변경 6.인터넷 7.웹툰앱 8.초기화면|");
				System.out.println(" =====================================================================");
				System.out.print("원하시는 기능을 선택해주세요 : ");
				int menu = Integer.parseInt(scanner.nextLine());
				
				if(menu==1) {
					System.out.print("전원(1.켜기 / 2.끄기) : ");
					phone.setPower(Integer.parseInt(scanner.nextLine()));
					phone.powerCheck();
				}else if(menu==2) {
					System.out.print("전화(1.받기 / 2.끊기) : ");
					phone.setCall(Integer.parseInt(scanner.nextLine()));
					phone.call();
				}else if(menu==3) {
					System.out.print("음성(1.송신 / 2.수신) : ");
					phone.setVoice(Integer.parseInt(scanner.nextLine()));
					phone.voice();
				}else if(menu==4) {
					if(phone.getPhoneName()==1) {
						phone.support();
					}else {
						System.out.print("DMB(1.켜기 / 2.끄기) : ");
						((Phone2)phone).setDmb(Integer.parseInt(scanner.nextLine()));
						((Phone2)phone).dmbCheck();
					}
				}else if(menu==5) {
					if(phone.getPhoneName()==1) {
						
					}else {
						System.out.print("원하시는 채널을 입력하세요 : ");
						((Phone2)phone).setChannel(Integer.parseInt(scanner.nextLine()));
						((Phone2)phone).channelCheck();
					}	
				}else if(menu==6) {
					if(phone.getPhoneName()==1||phone.getPhoneName()==2) {
						phone.support();
					}else {
						System.out.print("인터넷(1.켜기 / 2.끄기) : ");
						((Phone3)phone).setInternet(Integer.parseInt(scanner.nextLine()));
						((Phone3)phone).internetCheck();
					}
				}else if(menu==7) {
					if(phone.getPhoneName()==1||phone.getPhoneName()==2) {
						phone.support();
					}else {
						System.out.print("웹툰(1.켜기 / 2.끄기)");
						((Phone3)phone).setWebtoon(Integer.parseInt(scanner.nextLine()));
						((Phone3)phone).webtoonCheck();
					}	
				}else if(menu==8) {
					System.out.print("초기화면으로 가기(1.예 / 2.아니오) : ");
					int check = Integer.parseInt(scanner.nextLine());
					if(check==2) {
						continue;
					}else if(check==1) {
						break LABEL2;
					}else {
						System.out.println("올바른 번호를 입력해주세요");
					}
				}else {
					System.out.println("올바른 번호를 입력해주세요");
				}//if
				
			}//while
		}//while
		scanner.close();
		System.out.println("슈퍼폰을 완전히 종료합니다.");
	}//main()

}//class
	
	
	
	
//	public static void getMenu(Scanner scanner) {
//	}
//	
//	
////			if(menu==1) {
//				System.out.print("전워어언 킬래끌랭(1.켜 /2.꺼) : ");
//				phone.setPower(Integer.parseInt(scanner.nextLine()));
//				if(phone.getPower()==1) {
//					System.out.println(phone.getModel() + " 전원이 켜졌습니다.");
//					phone.powerCheck();
//					phone.stateInfo();
//				}else if(phone.getPower()==2) {
//					System.out.println(phone.getModel() + " 전원이 꺼졌습니다.");
//					phone.powerCheck();
//					phone.stateInfo();
//				}
//				
//			}else if(menu==2) {
//				//전원여부
//				if(phone.getPower()==1) {
//					System.out.print("전화아아 할래말랭(1.송신/2.수신) : ");
//					int call = Integer.parseInt(scanner.nextLine());
//					if(call==1) {
//						System.out.println("전화를 겁니다 따르릉");
//						System.out.print("전화끊기(1) : ");
//						int callswitch = Integer.parseInt(scanner.nextLine());
//						if(callswitch==1) {
//							break;
//						}
//						
//					}else if(call==2) {
//						System.out.println("전화를 받습니다 따르릉");
//						
//					}else {
//						
//					}
//				}//if	
//			}else if(menu==3) {
//				System.out.println("음서어엉");
//			}else if(menu==4) {
//				if(phone.getTh()==1) {
//					System.out.println(phone.getTh() + "세대는 "+ "지원하지 않습니다.");
//					System.out.println("다시 선택해주세요" + "\n");
//				}
//				System.out.println("뎀비이이이");
//					
//			}else if(menu==5) {
//				if(phone.getTh()==1 || phone.getTh()==2) {
//					System.out.println(phone.getTh() + "세대는 "+ "지원하지 않습니다.");
//					System.out.println("다시 선택해주세요" + "\n");
//				}
//				System.out.println("인도네에엣");
//			}else if(menu==6) {
//				if(phone.getTh()==1 || phone.getTh()==2) {
//					System.out.println(phone.getTh() + "세대는 "+ "지원하지 않습니다.");
//					System.out.println("다시 선택해주세요" + "\n");
//				}
//				System.out.println("웨엡투운");
//			}	else  {
//				System.out.println("제대로좀눌렁");
//			}//if
			





















