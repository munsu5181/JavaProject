package Naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	// DB 접속을 위한 메소드 DBConnect()
	public static Connection DBConnect() { // 커넥션이기때문에 return값이 있어야함
									// return값이 필요없는 void나 직접 return 값을 입력
		// DB에 접속정보 저장을 위한 Connection 변수 con 선언
		Connection con = null;
		
		// 접속할 DB의 주소정보
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		// 접속할 DB의 계정정보
		String user = "MOONSU";
		String password = "1111";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ojdbc6 라이브러리를 현재 소스에 적용하는 역할
			
			con = DriverManager.getConnection(url,user,password);
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE,MOONSU,1111");
			// con은 실제 DB와 Java를 연결해주는 역할!
			
			System.out.println("DB접속 성공!");
			
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
			System.out.println("DB접속 실패 : 드라이버 로딩 실패");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB접속 실패 : 계정정보 확인!");
		}
		// printStackTrace() : 에러 발생시 경로를 찾아준다.
		
		// DB접속이 정상적으로 되면 접속상태(con)를 리턴해준다.
		return con;
	}
}
