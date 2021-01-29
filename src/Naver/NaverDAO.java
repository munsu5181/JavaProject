package Naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NaverDAO {
	// DAO(Data Access Object) : 데이터 접근 객체
	// : 백엔드서버, odbc를 사용하여 SQL을 사용할 수 있다.
	
	Connection conn = null; // DB접속을 위한 변수 conn선언
							// conn은 DB연결상태를 뜻한다.
	
	PreparedStatement pstmt = null; // 쿼리문 전송을 위한 변수 pstmt 선언
	
	ResultSet rs = null; // 조회(select) 결과를 저장하기 위한 변수 rs(result set)선언
	
//======================================================================
	
	
	// 메뉴 1. DB접속 메소드 connent()
	public void connect() {
		conn = DBC.DBConnect(); // conn에 DBC클래스의 DBConnect()메소드의 
								// 리턴값(con)을 저장한다.
	}
	
	// 메뉴 2. DB접속 해제 메소드 conClose()
	public void conClose() {
		try {
			conn.close();  // Connection클래스의 내장메소드
							// close()를 사용하여 접속을 해제한다.
			
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	// 메뉴 3. 회원가입 메소드 memberJoin()
	public void memberJoin(NaverDTO naver) { 
	//위 메소드는 Main클래스에서 server.memberJoin(naver); 를 통해 생성되었다.
		String sql = "INSERT INTO NAVER VALUES(?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// ? 안에 값 넣기
			pstmt.setNString(1, naver.getnId());
			pstmt.setNString(2, naver.getnPw());
			pstmt.setNString(3, naver.getnName());
			pstmt.setNString(4, naver.getnBirth());
			pstmt.setNString(5, naver.getnGender());
			pstmt.setNString(6, naver.getnEmail());
			pstmt.setNString(7, naver.getnPhone());
			
			// 7개의 정보를 다 입력한 후 데이터베이스 실행
			//pstmt.executeUpdate();
			
//			// 첫번째 방법 : int result
//			int result = pstmt.executeUpdate();
//			
//			if(result>0) {
//				System.out.println("회원가입 성공!");
//			}else {
//				System.out.println("회원가입 실패!");
//			}
			
			// 두번째 방법 : boolean result2
			boolean result2 = pstmt.execute();
			if(!result2) {
				System.out.println("회원가입 성공!");
			}else {
				System.out.println("회원가입 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 메뉴 4 . 회원목록을 조회하는 메소드 memberList()
	public void memberList() {
		String sql = "SELECT * FROM NAVER";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			// execute => boolean타입 반환
			// executeUpdate => int타입 반환
			// executeQuery => ResultSet타입 반환
			
			int i = 1;
			while(rs.next()) { // rs에 테이블의 정보가 저장되어있다
				System.out.println(i+"번째 회원");
				System.out.println("아이디 : "+rs.getNString(1));
				System.out.println("비밀번호 : "+rs.getNString(2));
				System.out.println("이름 : "+rs.getNString(3));
				System.out.println("생년월일 : "+rs.getNString(4));
				System.out.println("성별 : "+rs.getNString(5));
				System.out.println("이메일 : "+rs.getNString(6));
				System.out.println("휴대전화 : "+rs.getNString(7));
				System.out.println();
				i++;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 메뉴5 . 회원정보를 수정하는 메소드 memberModify()
	public void memberModify(NaverDTO naver) {
		String sql = "UPDATE NAVER SET NPW=?, NNAME=?,"
				+ "NBIRTH=?, NGENDER=?, NEMAIL=?, NPHONE=?"
				+ "WHERE NID=?"; // WHERE NID=? 인 항목들을 UPDATE SET 한다
		
		try {
			pstmt = conn.prepareStatement(sql); // 위 문장을 준비시켜 놓는것
			
			pstmt.setNString(1, naver.getnPw()); // 물음표에 값을 넣는 작업
			pstmt.setNString(2, naver.getnName());
			pstmt.setNString(3, naver.getnBirth());
			pstmt.setNString(4, naver.getnGender());
			pstmt.setNString(5, naver.getnEmail());
			pstmt.setNString(6, naver.getnPhone());
			pstmt.setNString(7, naver.getnId());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("회원정보 수정성공!");
			}else {
				System.out.println("회원정보 수정실패!");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 메뉴6-1 . 회원정보를 삭제하기 위해
	// 아이디와 비밀번호를 검사하는 메소드 idcheck()
	public boolean idCheck(String dId, String dPw) {
		String sql = "SELECT NID FROM NAVER"
				+ "WHERE NID=? AND NPW=?";
		boolean checkResult = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dId);
			pstmt.setString(2, dPw);
			
			rs = pstmt.executeQuery();
			
			// rs의 결과값이 1개이기 때문에 while이 아닌 if를 사용
			if(rs.next()) {
				checkResult = true;
			}else {
				checkResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkResult;
	}
	
	// 메뉴6 . 회원정보를 삭제하는 메소드 memberDelete()
	public void memberDelete(String dId) {
		String sql = "DELETE NAVER WHERE NID=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dId);
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("회원정보를 삭제했습니다.");
			}else {
				System.out.println("회원정보를 다시 확인해주세요");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	
	
	
	
	
	
	
}
