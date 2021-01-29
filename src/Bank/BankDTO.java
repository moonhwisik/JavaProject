package Bank;

public class BankDTO {

	private int accountNumber;	// 계좌번호
	private int cPw;			// 통장비밀번호
	private int balance;		// 잔액
	private String cName;			// 이름
	private String securityNumber;	// 주민번호
	private String cPhone;			// 폰번호
	
	private int card1,card2,card3,card4,card5,card6,card7,card8,card9; //보안카드

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getcPw() {
		return cPw;
	}

	public void setcPw(int cPw) {
		this.cPw = cPw;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getSecurityNumber() {
		return securityNumber;
	}

	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public int getCard1() {
		return card1;
	}

	public void setCard1(int card1) {
		this.card1 = card1;
	}

	public int getCard2() {
		return card2;
	}

	public void setCard2(int card2) {
		this.card2 = card2;
	}

	public int getCard3() {
		return card3;
	}

	public void setCard3(int card3) {
		this.card3 = card3;
	}

	public int getCard4() {
		return card4;
	}

	public void setCard4(int card4) {
		this.card4 = card4;
	}

	public int getCard5() {
		return card5;
	}

	public void setCard5(int card5) {
		this.card5 = card5;
	}

	public int getCard6() {
		return card6;
	}

	public void setCard6(int card6) {
		this.card6 = card6;
	}

	public int getCard7() {
		return card7;
	}

	public void setCard7(int card7) {
		this.card7 = card7;
	}

	public int getCard8() {
		return card8;
	}

	public void setCard8(int card8) {
		this.card8 = card8;
	}

	public int getCard9() {
		return card9;
	}

	public void setCard9(int card9) {
		this.card9 = card9;
	}

	@Override
	public String toString() {
		return "BankDTO [accountNumber=" + accountNumber + ", cPw=" + cPw + ", balance=" + balance + ", cName=" + cName
				+ ", securityNumber=" + securityNumber + ", cPhone=" + cPhone + ", card1=" + card1 + ", card2=" + card2
				+ ", card3=" + card3 + ", card4=" + card4 + ", card5=" + card5 + ", card6=" + card6 + ", card7=" + card7
				+ ", card8=" + card8 + ", card9=" + card9 + "]";
	}

	public BankDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDTO(int accountNumber,int card1, int card2, int card3, int card4, int card5, int card6, int card7, int card8, int card9) 
	{
		super();
		this.accountNumber = accountNumber;
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
		this.card6 = card6;
		this.card7 = card7;
		this.card8 = card8;
		this.card9 = card9;
	}

	

}
