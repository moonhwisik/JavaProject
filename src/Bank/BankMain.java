package Bank;

import java.*;
import java.util.Scanner;

public class BankMain {

	private static final BankMain StringUtil = null;

	public static void main(String[] args) {

		// BankDTO의 정보를 담는 client객체 선언
		BankDTO client = new BankDTO();
		
		BankDTO securityCD = new BankDTO();

		// BankDAO의 정보를 담는 server객체 선언
		BankDAO server = new BankDAO();

		// 입력을 위한 sc객체 선언
		Scanner sc = new Scanner(System.in);

		// 프로그램 실행을 위한 변수 run 선언
		boolean run = false;
		boolean run1 = false;

		// 항목을 선택할 때 필요한 변수 menu 선언
		int ny = 0;
		int nq = 0;
		int nqq = 0;
		int menu = 0;
		String ccName = null;
		server.connect();
		
		do {
			System.out.println("\n==========<안녕하세요, 항상 최선을 다하는 보름달은행 입니다.>======== \n");
			System.out.println("	[1] 계좌입력	[2] 계좌생성	[3] 종료             \n");
			System.out.println("=========================================================");
			System.out.print("입력>> ");
			run1 = true;
			
			while (run1) {

				ny = sc.nextInt();
				
				switch (ny) {
				case 1:
					System.out.print(" 계좌번호를 입력하세요. >> ");
					String AccountNumber = sc.next();
					
					System.out.print(" 비밀번호를 입력하세요. >> ");
					String CPw = sc.next();
					
					boolean Account = server.checkAccount(AccountNumber);
					boolean check = server.idCheck(AccountNumber,CPw);
					
					if(Account) {
						if (check) {
							ccName = server.checkName(AccountNumber);
							System.out.println("\n [" + ccName + "] 고객님 안녕하세요! 환영합니다");
							run1 = false;
							run = true;
							break;
						} else {
							System.out.println(" 아이디와 비밀번호가 일치하지 않습니다.");
						}
					} else {
						run1 = false;
						System.out.println("해당 계좌번호가 없습니다. 다시 선택하세요.");
						break;
					}
					break;
				case 2:
					
					int accountNumber = server.accountNumber() + 1;
					client.setAccountNumber(accountNumber);
					
					System.out.println(" 고객님 아래 정보를 입력해주세요! ");
					
					System.out.print("이름을 입력하세요 >> ");
					String cName = sc.next();
					
					System.out.print("주민번호 앞자리를 입력하세요 >> ");
					String securityNumber = sc.next();
					
					System.out.print("연락가능한 번호를 입력하세요>> ");
					String cPhone = sc.next();
					
					System.out.print("통장 비밀번호를 입력하세요(숫자 4자리) >> ");
					String cPwb = sc.next();
					if(server.isNumeric(cPwb) ==true) {
						if(cPwb.length() ==4) {
							int cPw = Integer.parseInt(cPwb);
							
							System.out.println("통장 비밀번호를 확인합니다 >> ");
							int cPwc = sc.nextInt();
							
							if(cPw ==cPwc) {
								System.out.println("\n < 비밀번호가 일치합니다. 계속 진행해주세요.> \n");
								client.setcPw(cPw);
							} else {
								System.out.println(" ==============================================");
								System.out.println("\n 비밀번호가 일치하지 않습니다. 처음부터 으로 돌아갑니다. \n");
								run1 = false;
								break;
							}
						} else {
							System.out.println("4자리가 아닙니다.");
							run1 = false;
							break;
						}
					} else {
						System.out.println(" 숫자가 아닙니다.");
						run1 = false;
						break;
					}
					
					System.out.print("초기 입금액을 입력하세요 >> ");
					int balance = sc.nextInt();
					
					client.setcPhone(cPhone);
					client.setSecurityNumber(securityNumber);
					client.setcName(cName);
					client.setBalance(balance);
					
					server.insertClient(client);
					//client = new BankDTO(accountNumber, cPw, balance, cName, securityNumber, cPhone, accountNumber, accountNumber, accountNumber, accountNumber, accountNumber, accountNumber, accountNumber, accountNumber, accountNumber);
		
					System.out.println(" 계좌이체를 위한 보안카드를 생성하겠습니다.");
					System.out.println(" <진행을 위해 아무키나 눌러주세요>");
					System.out.print(" >>");
					sc.next();
					
					int securityNB = server.accountNumber();
					securityCD.setAccountNumber(securityNB);
					
					int card1,card2,card3,card4,card5,card6,card7,card8,card9;
					
					card1 = (int)(Math.random() * 99) + 1;
					securityCD.setCard1(card1);
					
					card2 = (int)(Math.random() * 99) + 1;
					securityCD.setCard2(card2);
					
					card3 = (int)(Math.random() * 99) + 1;
					securityCD.setCard3(card3);
					
					card4 = (int)(Math.random() * 99) + 1;
					securityCD.setCard4(card4);
					
					card5 = (int)(Math.random() * 99) + 1;
					securityCD.setCard5(card5);
					
					card6 = (int)(Math.random() * 99) + 1;
					securityCD.setCard6(card6);
					
					card7 = (int)(Math.random() * 99) + 1;
					securityCD.setCard7(card7);
					
					card8 = (int)(Math.random() * 99) + 1;
					securityCD.setCard8(card8);
					
					card9 = (int)(Math.random() * 99) + 1;
					securityCD.setCard9(card9);
					
					//client = new BankDTO(accountNumber, card1,card2,card3,card4,card5,card6,card7,card8,card9);
					server.insertSecurityCard(securityCD);
					
					System.out.println(" 고객님의 계좌번호는 ["+ securityCD.getAccountNumber() + "]입니다.\n");
					System.out.println("  ▼고객님의 보안카드 ▼ ");
					
					
					System.out.println("┌─────────────────┐");
					System.out.println("│"+securityCD.getCard1()+"	"+ securityCD.getCard2()+"	"+securityCD.getCard3()+"│");
					System.out.println("│"+securityCD.getCard4()+"	"+ securityCD.getCard5()+"	"+securityCD.getCard6()+"│");
					System.out.println("│"+securityCD.getCard7()+"	"+ securityCD.getCard8()+"	"+securityCD.getCard9()+"│");
					System.out.println("└─────────────────┘");
					
					run1 = false;
					run = true;
					
					System.out.println(" 계좌와 보안카드 생성이 완료되었습니다. ");
					System.out.println(" 다음단계를 원하시면 <아무키나 눌러주세요>");
					System.out.print(" >>");
					sc.next();
					
					String aaccountNumber = Integer.toString(accountNumber);
					ccName = server.checkName(aaccountNumber);
					System.out.println("\n ["+ ccName + "] 고객님 안녕하세요! 환영합니다");
					break;
				case 3:
					run1 = false;
					run = false;
					break;
				default:
					System.out.println(" \"잘못 입력했습니다. 다시 입력해주세요!\" ");
					break;
				}
			}

			while (run) {
				
				System.out.println("\n==========<안녕하세요, 항상 최선을 다하는 보름달은행 입니다.>======== \n");
				System.out.println("                \" 원하시는 항목을 선택해주세요! \"                \n");
				System.out.println("	[1] 잔액조회	[2] 예금		[3] 보안카드확인");
				System.out.println("	[4] 출금		[5] 계좌이체	[6] 거래내역조회");
				System.out.println("	[7] 정보변경 	[8] 계좌변경	[9] 종료");
				System.out.println("\n=========================================================");
				System.out.print("번호 선택 >> ");
				menu = sc.nextInt();

				switch (menu) {
				case 1:
					int balance = server.checkBalance(ccName);
					System.out.println("현재  [" + ccName +"] 고객님 통장에 남은 잔액은 [" + balance+ "] 원 입니다." );
					break;
				case 2:
					System.out.print(" 얼마를 입금하시겠습니까? >> ");
					balance = sc.nextInt();

					// (1) BankDTO(client) 의 정보를 모두 넘긴다.
					//server.deposit(client);

					//(2) accountNumer(계좌번호)와 balance(입금액)정보만 넘긴다
					server.deposit(balance, ccName);
					break;
				case 3:
					System.out.print(" 이름을 입력하세요 >> ");
					String cName = sc.next();
					
					System.out.print(" 비밀번호를 입력하세요 >> ");
					String cPw = sc.next();

					server.securityCardCheck(cName,cPw);
					break;
				case 4:
					balance = server.checkBalance(ccName);
					
					System.out.print("출금액을 입력하세요 >> ");
					int cbalance = sc.nextInt();
					
					if( balance >= cbalance ) {
						server.withdraw(cbalance,ccName);
					} else {
						System.out.println("출금액이 " + (cbalance - balance) + "원 부족합니다!");
						System.out.println("현재 잔액은 " + balance + "원, 출금 요청금액은 " + cbalance + "원 입니다.");
					}
					break;
				case 5:
					System.out.print("받는 분의 계좌번호를 적으세요 >> ");
					String rAccountNumber = sc.next();
					
					System.out.print("얼마 보내시겠습니까? >> ");
					balance = sc.nextInt();
					
					System.out.print("내 통장 메모 >> ");
					String mwrite = sc.next();
					
					
					
					System.out.print("받는분 통장 메모 >> ");
					String rwrite = sc.next();
					
					System.out.print("통장 비밀번호 4자리를 입력하세요. >>");
					cPw = sc.next();
					
					if(balance >= 100000) {
						server.securityCheck();
						
					}
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					System.out.println("\n  다른 계좌로 거래하시겠습니까? ");
					System.out.println("	[1] 예	[2] 아니요");
					System.out.print(">> ");
					nq =3;
					while (nq != 1 && nq != 2) {
						nq = sc.nextInt();
						if (nq == 1) {
							run1 = true;
							run = false;
							ny = 1;
							break;
						} else if (nq == 2) {
							run = true;
							break;
						}
						System.out.println(" \"잘못 입력했습니다. 다시 입력해주세요!\" ");
						System.out.print(">> ");
					}
					break;
				case 9:
					run = false;
					ny = 3;
					System.out.println("\n ------  안녕히가세요. 보름달 은행을 이용해주셔서 감사합니다!! -----");
					break;
				default:
					System.out.println(" \"잘못 입력했습니다. 다시 입력해주세요!\" ");
					break;
				}// end switch

				if (menu >= 1 && menu <= 7) {
					System.out.println("\n  이용해 주셔서 감사합니다. 계속 거래하시겠습니까? ");
					System.out.println("	[1] 예	[2] 아니요");
					System.out.print(">> ");
					nqq = 3;
					while (nqq != 1 && nqq != 2) {
						nqq = sc.nextInt();
						if (nqq == 1) {
							ny = 1;
							run1 = false;
							break;
						} else if (nqq == 2) {
							System.out.println("\n  다른 계좌로 거래하시겠습니까? ");
							System.out.println("	[1] 예	[2] 아니요");
							System.out.print(">> ");
							nq = 3;
							while (nq != 1 && nq != 2) {
								nq = sc.nextInt();
								if (nq == 1) {
									run1 = true;
									run = false;
									ny = 1;
									break;
								} else if (nq == 2) {
									run = false;
									ny = 3;
									break;
								}
								System.out.println(" \"잘못 입력했습니다. 다시 입력해주세요!\" ");
								System.out.print(">> ");
							}
						}
						if(nq != 1 && nq != 2) {
						System.out.println(" \"잘못 입력했습니다. 다시 입력해주세요!\" ");
						System.out.print(">> ");
						}
					}
				}
			}
		} while (ny == 1 || ny == 2);// end while
		
		server.conClose();
		
		if (menu != 9) {
			System.out.println("\n ------  안녕히가세요. 보름달 은행을 이용해주셔서 감사합니다!! -----");
		}

	}
}
