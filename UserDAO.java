package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//DAO(데이터베이스 접근 객체) 실질적으로 DB에서 회원정보를 불러오거나 넣을때 사용
public class UserDAO {

	private Connection conn; //DB로 접근하게 해주는 객체
	private PreparedStatement pstmt;
	private ResultSet rs; //결과를 담을 곳 
	
	
	//실제로 mysql에 접속하게 해줌 
	public UserDAO() { //DAO를 하나의 객체로 만들어서 자동으로 DB접속할 수 있게 만듬
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.jdbc.Driver"); //드라이버 : db접근을 가능하게하는 하나의 라이브러리
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch(Exception e) {
			e.printStackTrace(); //오류가 무엇인지 출력하라 
		}
	}
	//실제로 로그인 시도하는 하나의 함수를 만든다
	public int login(String userID, String userPassword) {
		//실제 DB에 적용할 SQL문 작성 
		String SQL = "SELECT userPassword From USER WHERE userID=?";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();//실행결과
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) 
					return 1; // 로그인 성공 
				else
					return 0; //비밀번호 불일치
			}
			return -1; //아이디가 없음 
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류 
				
	}
}
