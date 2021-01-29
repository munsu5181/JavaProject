package Naver;

import java.util.Scanner;

public class NaverMain {
	// 프론트엔드, 나중에 웹페이지로 대체
	public static void main(String[] args) {

		NaverDAO server = new NaverDAO(); // 서버를 개발하는 NaverDAO클래스
		NaverDTO naver = new NaverDTO(); // 네이버 회원가입 정보를 담고있는 NaverDTO
		
		Scanner sc = new Scanner(System.in);
		
		// 프로그랭 실행을 위한 변수 run
		boolean run = true;
		
		// 항목을 선택할 때 필요한 변수 menu
		int menu = 0;
		
		// while문을 이용하여 프로그램 실행
		while(run) {
			System.out.println("===========================");
			System.out.println("1.DB접속		2.DB접속해지");
			System.out.println("3.회원가입		4.회원조회");
			System.out.println("5.회원수정		6.회원삭제");
			System.out.println("7.프로그램종료");
			System.out.println("===========================");
			System.out.print("항목 선택 >> ");
			menu = sc.nextInt();
			
			// 입력받은 항목(menu)을 실행하기 위한 switch문
			switch(menu) {
			case 1:
				server.connect();  // DAO클래스를  server로 지정해줬었다.
				break;
			case 2:
				server.conClose();
				break;
			case 3:
				System.out.println("회원정보를 입력해주세요!");
				System.out.print("아이디 >> ");
				String nId = sc.next();
				naver.setnId(nId);
				
				System.out.print("비밀번호 >> ");
				String nPw = sc.next();
				
				System.out.print("비밀번호 확인 >> ");
				String nPwc = sc.next();
				
				if(nPw.equals(nPwc)) { // 문자가 같음을 비교할때 == 이아닌 .equals()사용
					System.out.println("사용가능한 비밀번호 입니다.");
					naver.setnPw(nPw);
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}
				
				System.out.print("이름 >> ");
				String nName = sc.next();
				naver.setnName(nName);
				
				System.out.println("생년월일");
				System.out.print("연도 >> ");
				String nYear = sc.next();
				
				System.out.print("월 >> ");
				String nMonth = sc.next();
				
				System.out.print("일 >> ");
				String nDay = sc.next();
				
				System.out.println("생년월일 확인 : ");
				System.out.println(nYear+nMonth+nDay);
				naver.setnBirth(nYear+nMonth+nDay);
				
				System.out.print("성별 >> ");
				String nGen = sc.next();
				naver.setnGender(nGen);
				
				System.out.print("이메일 >> ");
				String nEmail = sc.next();
				naver.setnEmail(nEmail);
				
				System.out.print("휴대전화 >> ");
				String nPhone = sc.next();
				naver.setnPhone(nPhone);
				
				server.memberJoin(naver);
				// server(NaverDAO)의 memberJoin()메소드에
				// naver(NaverDTO)의 정보를 담아서 이동하겠다.
				
				break;
			case 4:
				server.memberList();
				break;
			case 5:
				
				System.out.print("수정할 회원 아이디 >> ");
				nId = sc.next();
				naver.setnId(nId);
				
				System.out.print("비밀번호 >> ");
				nPw = sc.next();
				
				System.out.print("비밀번호 확인 >> ");
				nPwc = sc.next();
				
				if(nPw.equals(nPwc)) { // 문자가 같음을 비교할때 == 이아닌 .equals()사용
					System.out.println("사용가능한 비밀번호 입니다.");
					naver.setnPw(nPw);
				}else {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}
				
				System.out.print("이름 >> ");
				nName = sc.next();
				naver.setnName(nName);
				
				System.out.println("생년월일");
				System.out.print("연도 >> ");
				nYear = sc.next();
				
				System.out.print("월 >> ");
				nMonth = sc.next();
				
				System.out.print("일 >> ");
				nDay = sc.next();
				
				System.out.println("생년월일 확인 : ");
				System.out.println(nYear+nMonth+nDay);
				naver.setnBirth(nYear+nMonth+nDay);
				
				System.out.print("성별 >> ");
				nGen = sc.next();
				naver.setnGender(nGen);
				
				System.out.print("이메일 >> ");
				nEmail = sc.next();
				naver.setnEmail(nEmail);
				
				System.out.print("휴대전화 >> ");
				nPhone = sc.next();
				naver.setnPhone(nPhone);
				
				server.memberModify(naver);
				break;
				
			case 6:
				System.out.println("삭제할 회원 아이디 조회!");
				
				System.out.println("삭제할 아이디 >>");
				String dId = sc.next();
				
				System.out.println("비밀번호 >>");
				String dPw = sc.next();
				
				boolean check = server.idCheck(dId,dPw);
				// boolean타입의 변수 check선언
				// server(NaverDAO)에서 dId와 dPw의 정보를 담은
				// boolean타입의 메소드 idCheck생성
				
				if(check) {
					server.memberDelete(dId);
				}else {
					System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
				}
				
				break;
			case 7:
				System.out.println("프로그램을 종료합니다!");
				run = false;
				break;
			default:
				System.out.println("다시 입력해주세요!");
				break;
			
			
			} // end switch
			
		} //end while
		
		
		
		
		
	} // end main

} // end class
