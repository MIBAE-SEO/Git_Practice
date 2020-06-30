package memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {
	
	public static Connection DBConnection() {
		String driver="oracle.jdbc.driver.OracleDriver";//드라이버 가져오기
	      String url="jdbc:oracle:thin:@localhost:1521:xe";//오라클 주소
	      String user="user2";//사용자 이름
	      String pass = "soldesk";//비밀번호
	      Connection conn =null;
	      try {
	         Class.forName(driver);
	         System.out.println("드라이버 연결 성공");
	         conn = DriverManager.getConnection(url,user,pass);
	         System.out.println("오라클 연결 성공");
	      } catch (ClassNotFoundException e) {
	         System.out.println("jdbc driver 없음");
	      }catch(SQLException e) {
	         e.printStackTrace();
	         System.out.println("오라클 연결 실패");
	      }
	return conn;
	}
	
	
}


	

