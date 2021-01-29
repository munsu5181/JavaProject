package Buds;

import java.sql.*;
import java.util.Scanner;

public class BudsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BankDTO의 정보를 담는 client객체 선언
		BudsDTO client = new BudsDTO();

		// 서버를 개발하는 BudsDAO클래스
		BudsDAO server = new BudsDAO();

		// 회원가입 정보를 담고 있는 BudsDTO클래스
		BudsDTO buds = new BudsDTO();
		// 계좌정보를 담고 있는 BaccBTO
		Buds2DTO budsModel = new Buds2DTO();

		Scanner sc = new Scanner(System.in);

		// 프로그램 실행을 위한 변수 run
		boolean run = true;
		boolean run2 = true;
		boolean run3 = true;
		boolean run4 = true;

		// 항목을 선택할 때 필요한 변수 menu
		int menu = 0;
		int menu2 = 0;
		int menu3 = 0;
		int menu4 = 0;
		int menu5 = 0;

		System.out.println("EBMarket에 오신걸 환영합니다");
		System.out.println("원하시는 메뉴를 선택해주세요!");
		System.out.println();

		server.connect();
		while (run) {
			System.out.println();
			System.out.println("=====================================");
			System.out.println("1. 회원가입       		2. 로그인");
			System.out.println("3. 나가기");
			System.out.println("=====================================");
			System.out.print("메뉴 선택 >> ");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("회원정보를 입력해주세요!");
				System.out.print("아이디 >> ");
				String bId = sc.next();
				buds.setbId(bId);

				System.out.print("비밀번호 >> ");
				String bpw = sc.next();

				System.out.print("비밀번호 확인 >> ");
				String bpwc = sc.next();

				if (bpw.equals(bpwc)) {
					System.out.println("사용가능한 비밀번호");
					buds.setbPw(bpw);
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}

				System.out.print("이름 >> ");
				String bname = sc.next();
				buds.setbName(bname);

				System.out.println("생년월일 >> ");
				System.out.print("ex)19930816 ");
				String byear = sc.next();

				System.out.print("생년월일 확인 : ");
				System.out.println(byear);
				buds.setbBirth(byear);

				System.out.print("성별 >> ");
				String bgen = sc.next();
				buds.setbGender(bgen);

				System.out.print("이메일 >> ");
				String bemail = sc.next();
				buds.setbEmail(bemail);

				System.out.print("휴대전화 >> ");
				String bphone = sc.next();
				buds.setbPhone(bphone);

				// -------계좌 등록------------
				System.out.print("계좌를 등록해주세요! ");

				System.out.print("계좌번호 >> ");
				String accoountNumber = sc.next();
				buds.setAccountNumber(accoountNumber);

				System.out.print("최초입금액을 넣어주세요 >> ");
				int balance = sc.nextInt();
				buds.setBalance(balance);

				server.memberJoin(buds);
				break;

			case 2:
				System.out.print("아이디 >> ");
				bId = sc.next();

				System.out.print("비밀번호 >> ");
				String bPw = sc.next();

				boolean check = server.idCheck(bId, bPw);
				// boolean타입의 변수 check선언
				// server(NaverDAO)에서 dId와 dPw의 정보를 담은
				// boolean타입의 메소드 idCheck생성

				if (check) {
					System.out.println("로그인 성공하였습니다 !");
					buds.setbId(bId);
					run2 = true;
				} else {
					System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
					break;
				}

				while (run2) {
					System.out.println("=================================================================");
					System.out.println("1. 회원정보 수정          2.내 계좌 관리  3. 내 이어폰 판매하기      4. 내 이어폰 교환하기 ");
					System.out.println("5. 내 이어폰 구매하기   6. 시세보기	 7. 뒤로가기(로그아웃)  8.프로그램 종료 ");
					System.out.println("=================================================================");

					System.out.print("메뉴 선택 >> ");
					menu2 = sc.nextInt();

					switch (menu2) {
					case 1:
						run3 = true;
						while (run3) {
							System.out.println("===============================================");
							System.out.println("1. 회원정보 수정 2.회원탈퇴 3. 회원정보 조회 4. 뒤로가기");
							System.out.println("===============================================");

							System.out.print("메뉴 선택 >> ");
							menu3 = sc.nextInt();

							switch (menu3) {
							case 1: // 회원정보 수정(아이디,비번 확인 후)
								System.out.print("수정할 아이디를 입력하세요>>>");
								bId = sc.next();
								buds.setbId(bId);

								System.out.print("현재 비번을 입력하세요>>>");
								bpw = sc.next();
								buds.setbPw(bpw);

								String bpw1;
								String bpw2;

								System.out.print("수정할 비번을 입력하세요>>>");
								bpw1 = sc.next();

								System.out.print("수정할 비번을 확인하세요>>>");
								bpw2 = sc.next();

								if (bpw1.equals(bpw2)) {
									System.out.println("사용가능한 비밀번호");
									buds.setbPw1(bpw1);
								} else {
									System.out.println("비밀번호가 틀렸습니다.");
									break;
								}

								String bName;
								System.out.println("수정할 이름을 입력하세요>>>");
								bName = sc.next();
								buds.setbName(bName);

								String bBirth;
								System.out.println("수정할 생년월일을 입력하세요>>>");
								bBirth = sc.next();
								System.out.println("생년월일 확인 : ");
								System.out.println(bBirth);
								buds.setbBirth(bBirth);

								String bGender;
								System.out.println("수정할 성별을 입력하세요>>>");
								bGender = sc.next();
								buds.setbGender(bGender);

								String bEmail;
								System.out.println("수정할 이메일을 입력하세요>>>");
								bEmail = sc.next();
								buds.setbEmail(bEmail);

								String bPhone;
								System.out.println("수정할 전화번호을 입력하세요>>>");
								bPhone = sc.next();
								buds.setbPhone(bPhone);

								server.memberModify(buds);
								break;

							case 2: // 회원탈퇴
								System.out.println("삭제할 회원 아이디 조회!");

								System.out.println("삭제할 아이디>>");
								bId = sc.next();

								System.out.println("비밀번호>>");
								bPw = sc.next();

								boolean checkResultForDelete = server.idCheckForDelete(bId, bPw);
								// boolean타입의 변수 check 선언
								// server(NaverDAO)에서 dId와 dPw의 정보를 담은
								// boolean타입의 메소드 idCheck생성

								if (checkResultForDelete == true) {
									server.memberDelete(bId);
								} else {
									System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
								}

								break;

							case 3: // 회원정보 조회
								System.out.println("조회할 아이디를 입력하세요");
								bId = sc.next();

								System.out.println("조회할 아이디의 비밀번호를 입력하세요");
								bPw = sc.next();

								server.memberList(bId, bPw);

								break;
							case 4: // 뒤로가기
								run3 = false;
								break;
							default: // 1-3 외 숫자 대입
								System.out.println("올바른 메뉴 번호를 눌러주세요");
								break;
							}
						}break;
					case 2:
						run4 = true;
						while (run4) {
							System.out.println("=========================");
							System.out.println("1. 계좌정보 수정   2. 잔액조회");
							System.out.println("3. 입금                4. 출금");
							System.out.println("5. 뒤로가기");
							System.out.println("=========================");
							System.out.println("메뉴 선택 >> ");
							menu4 = sc.nextInt();

							switch (menu4) {
							case 1:
								System.out.print("수정할 아이디 >> ");
								bId = sc.next();
								buds.setbId(bId);

								System.out.print("새로운 계좌번호 >> ");
								accoountNumber = sc.next();
								buds.setAccountNumber(accoountNumber);
								
								System.out.print("잔액을 입력해주세요 >> ");
								balance = sc.nextInt();
								buds.setBalance(balance);

								server.AccModify(buds);

								break;
							case 2:
								System.out.println("조회할 계좌번호 >>");
								accoountNumber = sc.next();

								balance = server.checkBalance(accoountNumber);
								
								if(balance>0) {
									System.out.println("남은잔액 : " + balance+"원");
								}
								break;
								
							case 3:
								System.out.println("입금할 계좌번호 >> ");
								accoountNumber = sc.next();

								System.out.println("입금액 (최소입금가능 금액은 100원입니다.) >> ");
								balance = sc.nextInt();

								buds.setAccountNumber(accoountNumber);
								
								//bBalance 값이 최소 100원 이어야 한다
								if(balance>=100) {
								buds.setBalance(balance);
								} else {
									System.out.println("금액을 다시 입력해주세요!");
									break;
								}
								server.deposit(buds);

								break;
							case 4:
								// 잔액조회를 사용해서
								// 출금액이 잔액보다 많을 경우 출금하지 못하도록
								System.out.println("출금할 계좌번호 >> ");
								accoountNumber = sc.next();

								int cBalance = server.checkBalance(accoountNumber);
								// cBalance는현재 출금하고자 하는 계좌의 잔액

								System.out.println("출금액 (최소출금가능 금액은 100원입니다.) >> ");
								balance = sc.nextInt();
								// bBalance는 출금하고자 하는 금액
								
								
								if(balance>=100) {
								buds.setBalance(balance);
								} else {
									System.out.println("금액을 다시 입력해주세요!");
									break;
								}
								if (cBalance >= balance) {
									server.withdraw(buds);
								} else {
									System.out.println("출금액이" + (balance - cBalance) + "원 부족합니다!");
									System.out.println("현재 잔액은" + cBalance + "원, 출금 요청금액은" + balance + "원 입니다.");
								}
								break;
							case 5:
								run4 = false;
								break;
							default :
								System.out.println("메뉴번호를 다시 확인해주세요!");
								break;
							}
							
						}break;

					case 3: // 판매하기
						System.out.println("계좌번호를 입력해주세요");
						String accountNumber = sc.next();
						
						System.out.println("본인의 이어폰을 선택해 주세요");
						System.out.println("1.Buds");
						System.out.println("2.Buds Plus");
						System.out.println("3.Buds Live");
						System.out.println("4.Buds Live Pro");
						
						int bselNum = sc.nextInt();
						
						int resultAnt = 0;
						
						if(bselNum == 1) {
							System.out.println("등급을 선택해주세요");
							System.out.println("1. A등급  2. B등급  3. C등급");
							int bselNum1 = sc.nextInt();
							if(bselNum1 == 1) {resultAnt = 40000;}
							else if(bselNum1 == 2) {resultAnt = 35000;}
							else if(bselNum1 == 3) {resultAnt = 30000;}
							System.out.println("계좌번호에" + resultAnt + "원이 입금되었습니다.");
							
						}else if(bselNum == 2) {
							System.out.println("등급을 선택해주세요");
							System.out.println("1. A등급  2. B등급  3. C등급");
							int bselNum1 = sc.nextInt();
							if(bselNum1 == 1) {resultAnt = 60000;}
							else if(bselNum1 == 2) {resultAnt = 55000;}
							else if(bselNum1 == 3) {resultAnt = 50000;}
							System.out.println("계좌에" + resultAnt + "원이 입금되었습니다.");
							
						}if(bselNum == 3) {
							System.out.println("등급을 선택해주세요");
							System.out.println("1. A등급  2. B등급  3. C등급");
							int bselNum1 = sc.nextInt();
							if(bselNum1 == 1) {resultAnt = 110000;}
							else if(bselNum1 == 2) {resultAnt = 105000;}
							else if(bselNum1 == 3) {resultAnt = 100000;}
							System.out.println("계좌에" + resultAnt + "원이 입금되었습니다.");
							
						}if(bselNum == 4) {
							resultAnt = 220000; resultAnt = 215000; resultAnt = 210000;
							System.out.println("등급을 선택해주세요");
							System.out.println("1. A등급  2. B등급  3. C등급");
							int bselNum1 = sc.nextInt();
							if(bselNum1 == 1) {resultAnt = 110000;}
							else if(bselNum1 == 2) {resultAnt = 105000;}
							else if(bselNum1 == 3) {resultAnt = 100000;}
							System.out.println("계좌에" + resultAnt + "원이 입금되었습니다.");
						}
					
						buds.setAccountNumber(accountNumber);
						buds.setBalance(resultAnt);
						
						// (1) BankDTO(buds)의 정보를 모두 넘긴다
						int resultCnt = server.deposit(buds); //업데이트 처리 건수
						
						if(resultCnt > 0) {
							System.out.println("정상적으로 입금되었습니다.");
						} else {
							System.out.println("입금이 실패되었습니다.");
						}
						
						break;
							
					case 4: // 교환하기
						
						System.out.println("본인의 이어폰을 선택해 주세요");
						System.out.println("1.Buds  (40000원)");
						System.out.println("2.Buds Plus  (60000원)");
						System.out.println("3.Buds Live  (110000원)");
						System.out.println("4.Buds Live Pro  (220000원)");

						int selNum = sc.nextInt();
						int bmt = 0;
						if (selNum == 1) {
							bmt = 40000;
						} else if (selNum == 2) {
							bmt = 60000;
						} else if (selNum == 3) {
							bmt = 110000;
						} else if (selNum == 4) {
							bmt = 220000;
						}

						System.out.println("교환하실 이어폰을 선택해 주세요");

						if (selNum == 1) {
							System.out.println("2.Buds Plus  (60000원)");
							System.out.println("3.Buds Live  (110000원)");
							System.out.println("4.Buds Live Pro  (220000원)");
						} else if (selNum == 2) {
							System.out.println("1.Buds       (40000원)");
							System.out.println("3.Buds Live  (110000원)");
							System.out.println("4.Buds Live Pro  (220000원)");
						} else if (selNum == 3) {
							System.out.println("1.Buds       (40000원)");
							System.out.println("2.Buds Plus  (60000원)");
							System.out.println("4.Buds Live Pro  (220000원)");
						} else if (selNum == 4) {
							System.out.println("1.Buds       (40000원)");
							System.out.println("2.Buds Plus  (60000원)");
							System.out.println("3.Buds Live  (110000원)");
						}

						int changeNum = sc.nextInt();
						int amt = 0;

						if (changeNum == 1) {
							amt = 40000;
						} else if (changeNum == 2) {
							amt = 60000;
						} else if (changeNum == 3) {
							amt = 110000;
						} else if (changeNum == 4) {
							amt = 220000;
						}
						
						int cmt = buds.getBalance();
						
						int resultAmt = 0;
						
						int totalAnt = cmt +(bmt - amt);
						// 입력 값에 따른 처리

						System.out.println("입금받을 계좌번호를 입력해주세요.");
						accountNumber = sc.next();
						
						// 차액이나 그런 금액을 구하기
						if ((bmt - amt) > 0) {
							System.out.println("계좌번호에" + (bmt - amt) + "원이 입금되었습니다.");
						} else {
							System.out.println("계좌번호에" + (amt - bmt) + "원이 출금되었습니다.");
						} // or

						System.out.println("정상적으로 " + changeNum + "번 제품과 교환신청이 되었습니다.");

						buds.setAccountNumber(accountNumber);
						buds.setBalance(totalAnt);
						
						server.deposit(buds);
						
						break;
					case 5:// 구매하기 / 개별 구매하기
						
						System.out.println("1.이어폰 구매하기");
						System.out.println("2.이어폰 개별 구매하기");
						System.out.print("메뉴 선택 >>");
						int nextNum = sc.nextInt();
						

						if(nextNum == 1) { //판매하기
							
							System.out.println("계좌번호를 입력해주세요.");
							accountNumber = sc.next();
							
							System.out.println("구매할 이어폰을 선택해 주세요");
							System.out.println("1.Buds  (40000원)");
							System.out.println("2.Buds Plus  (60000원)");
							System.out.println("3.Buds Live  (110000원)");
							System.out.println("4.Buds Live Pro  (220000원)");
							
							int cselNum = sc.nextInt();
							
							
							int resultBnt1 =0;
							if(cselNum == 1) {
								resultBnt1 = 40000;
								System.out.println("계좌번호에" + "40000" + "원이 출금되었습니다.");
							}else if(cselNum == 2) {
								resultBnt1 = 60000;
								System.out.println("계좌번호에" + "60000" + "원이 출금되었습니다.");
							}if(cselNum == 3) {
								resultBnt1 = 110000;
								System.out.println("계좌번호에" + "110000" + "원이 출금되었습니다.");
							}if(cselNum == 4) {
								resultBnt1 = 220000;
								System.out.println("계좌번호에" + "220000" + "원이 출금되었습니다.");
							}
							buds.setAccountNumber(accountNumber);
							buds.setBalance(resultBnt1);
							
							// (1) BankDTO(buds)의 정보를 모두 넘긴다
							
							int resultCnt1 = server.withdraw(buds); //업데이트 처리 건수
							
							if(resultCnt1 > 0) {
								System.out.println("정상적으로 출금되었습니다.");
							} else {
								System.out.println("출금이 실패되었습니다.");
							}
						break;
						
					} else if(nextNum == 2){
						// 개별 구매하기
						System.out.println("2.이어폰 개별 구매하기");
						System.out.println("계좌번호를 입력해주세요.");
						accountNumber = sc.next();
						
						System.out.println("구매할 이어폰을 선택해 주세요");
						System.out.println("1.Buds L tip (20000원)");
						System.out.println("2.Buds R tip (20000원)");
						System.out.println("3.Buds Case (10000원)");
						System.out.println("4.Buds Plus L tip (25000원)");
						System.out.println("5.Buds Plus R tip (25000원)");
						System.out.println("6.Buds Plus Case (10000원)");
						System.out.println("7.Buds Live L tip (50000원)");
						System.out.println("8.Buds Live R tip (50000원)");
						System.out.println("9.Buds Live Case (10000원)");
						System.out.println("10.Buds Live Pro L tip (105000원)");
						System.out.println("11.Buds Live Pro R tip (105000원)");
						System.out.println("12.Buds Live Pro Case (100000원)");
						
						int cselNum = sc.nextInt();
						
						
						int resultBnt1 =0;
						if(cselNum == 1) {
							resultBnt1 = 20000;
							System.out.println("계좌에서" + "20000" + "원이 출금되었습니다.");
						}else if(cselNum == 2) {
							resultBnt1 = 20000;
							System.out.println("계좌에서" + "60000" + "원이 출금되었습니다.");
						}else if(cselNum == 3) {
							resultBnt1 = 10000;
							System.out.println("계좌에서" + "10000" + "원이 출금되었습니다.");
						}else if(cselNum == 4) {
							resultBnt1 = 25000;
							System.out.println("계좌에서" + "25000" + "원이 출금되었습니다.");
						}else if(cselNum == 5) {
							resultBnt1 = 25000;
							System.out.println("계좌에서" + "25000" + "원이 출금되었습니다.");
						}else if(cselNum == 6) {
							resultBnt1 = 10000;
							System.out.println("계좌에서" + "10000" + "원이 출금되었습니다.");
						}else if(cselNum == 7) {
							resultBnt1 = 50000;
							System.out.println("계좌에서" + "50000" + "원이 출금되었습니다.");
						}else if(cselNum == 8) {
							resultBnt1 = 50000;
							System.out.println("계좌에서" + "50000" + "원이 출금되었습니다.");
						}else if(cselNum == 9) {
							resultBnt1 = 10000;
							System.out.println("계좌에서" + "10000" + "원이 출금되었습니다.");
						}else if(cselNum == 10) {
							resultBnt1 = 105000;
							System.out.println("계좌에서" + "105000" + "원이 출금되었습니다.");
						}else if(cselNum == 11) {
							resultBnt1 = 105000;
							System.out.println("계좌에서" + "1050000" + "원이 출금되었습니다.");
						}else if(cselNum == 12) {
							resultBnt1 = 10000;
							System.out.println("계좌에서" + "10000" + "원이 출금되었습니다.");
						}
						buds.setAccountNumber(accountNumber);
						buds.setBalance(resultBnt1);
						
						// (1) BankDTO(buds)의 정보를 모두 넘긴다
						
						int resultCnt1 = server.withdraw(buds); //업데이트 처리 건수
						
						if(resultCnt1 > 0) {
							System.out.println("정상적으로 출금되었습니다.");
						} else {
							System.out.println("출금이 실패되었습니다.");
						}
					break;
						
					}
						
					case 6:
						System.out.println("=====원하는 정보를 선택해 주세요===============");
						System.out.println("1.기준날짜로 검색 2. 모델명 검색");
						System.out.println("==========입력하기===============");
						menu5 = sc.nextInt();

						if (menu5 == 1) {

							System.out.println("기준날짜를 YYYYMMDD로 입력하세요");
							int mDate = sc.nextInt();
							
							System.out.println("제품리스트를 출력합니다!!");
							server.marketpriceList1(mDate);
						} else if (menu5 == 2) {
							System.out.println("버즈 / 버즈플러스 / 버즈라이브 / 버즈라이브프로");
							System.out.println("모델명을 입력해주세요 >> ");
							String mName = sc.next();
							
							System.out.println("제품리스트를 출력합니다!!");
							server.marketpriceList2(mName);
						} else {
							System.out.println("바른 번호를 선택해주세요");
							break;
						}

						break;
					case 7:
						run2 = false;
						break;
					case 8:
						System.out.println("프로그램을 종료합니다. 감사합니다.");
						run2 = false;
						run = false;

					} // inner switch end (menu2)

				} // inner while end (run2)
				break;
			case 3:
				run = false;
				System.out.println("이용해주셔서 감사합니다!");
				break;
			default:
				System.out.println("다시 입력해주세요!");
				break;

			}// 와일문
		}
	}
}