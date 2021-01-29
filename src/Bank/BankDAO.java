package Bank;

import java.sql.*;

public class BankDAO {
	
	// DB접속을 위한 변수 선언
	Connection conn = null;
	
	// 쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;
	
	// 조회결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	
	// DB접속을 위한 메소드 connect()
	public void connect() {
		conn = DBC.DBConnect();
	}
	
	
	// DB접속 해제를 위한 메소드 conClose()
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	

	// 계좌번호를 생성하기 위한 메소드 accountNumber()
	public int accountNumber() {
		String sql = "SELECT COUNT(*) FROM BANK";
		int cNumber = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cNumber = rs.getInt(1);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return cNumber;
	}
	
	//계좌가 존재하는지 체크메소드 checkAccount
	public boolean checkAccount(String accountNumber) {
		String sql = "SELECT ACCOUNTNUMBER FROM BANK WHERE ACCOUNTNUMBER=?";
		boolean Account = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Account = true;
			}			
		} catch (SQLException se) {
			se.printStackTrace();
		}		
		
		return Account;
	}
	
	// 문자열이 숫자인지 체크하는 메소드 inNumeric()
	public boolean isNumeric(String cPwb) {
		try{
			Double.parseDouble(cPwb);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	// 고객정보를 저장하기 위한 메소드 insertClient()
	public void insertClient(BankDTO client) {
		String sql = "INSERT INTO BANK VALUES(?,?,?,?,?,?)";
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, client.getAccountNumber());
			pstmt.setInt(2, client.getcPw());
			pstmt.setInt(3, client.getBalance());
			pstmt.setString(4, client.getcName());
			pstmt.setString(5, client.getSecurityNumber());
			pstmt.setString(6, client.getcPhone());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("\n==========================");
				System.out.println("  \" 계정생성이 완료되었습니다 \" ");
				System.out.println("==========================");
			} else {
				System.out.println("============================\n");
				System.out.println("\n		\" 계정생성 실패 \"		\n");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	public void insertSecurityCard(BankDTO securityCD) {
		String sql = "INSERT INTO SECURITYCARD VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, securityCD.getAccountNumber());
			pstmt.setInt(2, securityCD.getCard1());
			pstmt.setInt(3, securityCD.getCard2());
			pstmt.setInt(4, securityCD.getCard3());
			pstmt.setInt(5, securityCD.getCard4());
			pstmt.setInt(6, securityCD.getCard5());
			pstmt.setInt(7, securityCD.getCard6());
			pstmt.setInt(8, securityCD.getCard7());
			pstmt.setInt(9, securityCD.getCard8());
			pstmt.setInt(10, securityCD.getCard9());

			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("\n==========================");
				System.out.println(" \" 보안카드가  생성되었습니다 \" ");
				System.out.println("==========================");
			} else {
				System.out.println("실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}


	public String checkName(String accountNumber) {
		String sql = "SELECT CNAME FROM BANK WHERE ACCOUNTNUMBER = ? ";
		String ccName = "기본";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ccName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ccName;
	}


	public int checkBalance(String ccName) {
		String sql = "SELECT BALANCE FROM BANK WHERE CNAME = ? ";
		int balance = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ccName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				balance = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}


	public boolean idCheck(String accountNumber, String cPw) {
		String sql = "SELECT ACCOUNTNUMBER FROM BANK WHERE ACCOUNTNUMBER = ? AND CPW = ?";
		boolean ckrs = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountNumber);
			pstmt.setString(2, cPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				ckrs = true;
			} else {
				ckrs = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ckrs;
	}

	public void deposit(int balance, String ccName) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE + ? WHERE CNAME = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, balance);
			pstmt.setString(2, ccName);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(" ["+balance +"] 원 입금되었습니다.");
			} else {
				System.out.println("입금 실패!");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}


	public void securityCardCheck(String cName, String cPw) {
		String sql = "SELECT CARD1,CARD2,CARD3,CARD4,CARD5,CARD6,CARD7,CARD8,CARD9 FROM BANK, SECURITYCARD WHERE BANK.ACCOUNTNUMBER = SECURITYCARD.ACCOUNTNUMBER AND CNAME = ? AND CPW = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cName);
			pstmt.setString(2, cPw);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("┌─────────────────┐");
				System.out.println("│"+rs.getInt(1)+"	"+ rs.getInt(2)+"	"+rs.getInt(3)+"│");
				System.out.println("│"+rs.getInt(4)+"	"+ rs.getInt(5)+"	"+rs.getInt(6)+"│");
				System.out.println("│"+rs.getInt(7)+"	"+ rs.getInt(8)+"	"+rs.getInt(9)+"│");
				System.out.println("└─────────────────┘");
			} else {
				System.out.println("이름과 패스워드가 일치하지 않습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void withdraw(int cbalance, String ccName) {
		String sql = "UPDATE BANK SET BALANCE = BALANCE - ? WHERE CNAME = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cbalance);
			pstmt.setString(2, ccName);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println(" ["+cbalance +"] 원 출금했습니다.");
			} else {
				System.out.println("출금 실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}


	public void securityCheck() {
		
		
	}
	

	
	
	
	
	
}
