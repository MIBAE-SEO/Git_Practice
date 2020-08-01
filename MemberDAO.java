package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//오라클데이터베이스에 연결하고 insert, select, update, delete작업을 실행해주는 클래스
public class MemberDAO {
	
	
	//접속
	String id = "user2";
	String password = "soldesk";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	
	
	Connection con; // 데이터베이스에 접근할 수 있도록 설정
	PreparedStatement pstmt; //데이터베이스에서 쿼리를 실행시켜주는 객체
	ResultSet rs; //데이터베이스의 테이블의 결과를 리턴받아 자바에 저장해주는 객체  
	
	
	
	//데이터베이스에 접근할 수 있도록 도와주는 메소드
	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url,id,password);
		}catch(Exception e) {
			
		}
	}
	
	//데이터베이스에 한사람의 회원 정보를 저장해주는 메소드
	public void insertMember(MemberBean mbean) {
		try{
			//1.해당 데이터베이스를 사용한다고 선언(클래스를 등록=오라클용사용)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//아파치 톰캣에 ojdbc6.jar 넣었기때문에 
			//2. 해당 데이터베이스에 접속
			Connection con = DriverManager.getConnection(url,id,password);
		
			//3. 접속 후 쿼리준비
			String sql="insert into member2 values(?,?,?,?,?,?,?,?)";
			
			//4. 쿼리사용 
			PreparedStatement pstmt = con.prepareStatement(sql);
			//5. ?에 맞게 데이터를 매핑함
			pstmt.setString(1, mbean.getId());	
			pstmt.setString(2, mbean.getPassword1());	
			pstmt.setString(3, mbean.getEmail());	
			pstmt.setString(4, mbean.getTel());	
			pstmt.setString(5, mbean.getHobby());	
			pstmt.setString(6, mbean.getJob());	
			pstmt.setString(7, mbean.getAge());	
			pstmt.setString(8, mbean.getInfo());	
			
			
			//6. 오라클에서 쿼리를 실행하라는 소스코드
			
			pstmt.executeUpdate();
			
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	//모든회원의 정보를 리턴해주는 메소드 호출
	public Vector<MemberBean> allSelectMember(){
		
		
		Vector<MemberBean> v = new Vector<>();
		
		//무조건 데이터베이스 관련 작업에는 예외처리 쓸 것 
		try {
			
			//커넥션 연결
			getCon();
			
			//쿼리준비
			String sql = "select * from member2";
			
			//쿼리를 실행시키는 객체 선언
			pstmt = con.prepareStatement(sql);
			
			//쿼리를 실행 시킨 결과를 리턴해서 받아줌 (오라클의 테이블에서 검색된 결과에서 자바객체에 저장)
			rs = pstmt.executeQuery();
			
			//반복문을 사용해서 rs에 저장된 데이터를 추출해놔야 함
			while(rs.next()) {//저장된 데이터만큼까지 반복문을 돌려라 
				MemberBean bean = new MemberBean();//컬럼으로 나뉘어진 데이터를 빈클래스에 저장
				bean.setId(rs.getString(1));
				bean.setPassword1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
				
				//패키징 된 멤버인 클래스를 벡터에 저장
				v.add(bean); //0번지부터 순서대로 데이터가 저장
				
				
			}
			
			con.close();
			
		}catch(Exception e) {
			e.getStackTrace();
			
		}
		//다 저장된 벡터를 리턴한다. 
		return v;
	}
	
	
	
		public MemberBean oneSelectMember(String id) {
			
			//한사람에 대한 정보만 리턴하기때문에 bean 클래스 객체 생성함. 
			MemberBean bean = new MemberBean();
			
			try {
				
			//커넥션연결	
			getCon();
			
			//쿼리준비
			String sql = "select * from member2 where id=?"; //어느 id인지 모르기때문
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//쿼리실행
			rs=pstmt.executeQuery();
			if(rs.next()) { //레코드가 있다면?
				bean.setId(rs.getString(1));
				bean.setPassword1(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setTel(rs.getString(4));
				bean.setHobby(rs.getString(5));
				bean.setJob(rs.getString(6));
				bean.setAge(rs.getString(7));
				bean.setInfo(rs.getString(8));
			}
				con.close();
			
			}catch(Exception e) {
			e.printStackTrace();
		}
			//리턴
			return bean; 
		
		}
		
		
		
		//한 사람에 대한 패스워드 값을 리턴하는 메소드 생성
		public String getPassword1(String id) {
			
			//스트링으로 리턴해야하기때문에 스트링 변수 선언
			String password1="";
			
			try {
				getCon();
				
				//쿼리준비
				String sql = "select password1 from member2 where id=?";
				pstmt = con.prepareStatement(sql);
				
				//?에 값을 매핑
				pstmt.setString(1, id);
				
				//쿼리 실행
				rs = pstmt.executeQuery();
				if(rs.next()) {
					password1 = rs.getString(1);
				}
				con.close();
				
			}catch(Exception e) {
			 e.printStackTrace();
		}
			//결과 리턴
			return password1;
		
		
		}	
		
		
		
		//한 회원의 정보를 수정하는 메소드 
		public void updateMember(MemberBean bean) {
			
			getCon();
			
			try {
				//쿼리 준비
				String sql = "update member2 set email=?, tel=? where id=?";
				//쿼리 실행 객체 준비
				pstmt = con.prepareStatement(sql);
				//? 값에 차례대로 매핑한다
				pstmt.setString(1, bean.getEmail());
				pstmt.setString(2, bean.getTel());
				pstmt.setString(3, bean.getId());
				
				//쿼리 실행
				pstmt.executeUpdate();
				
				con.close();
			}catch(Exception e) {
			e.printStackTrace();
		}
		
		}	
		
		
		//한 회원을  삭제하는 메소드 
		
		public void deleteMember(String id) {
			
			try {
				getCon();
				
				//쿼리준비
				String sql = "delete from member2 where id=?";
				//쿼리 실행 객체 선언
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.executeUpdate();
				con.close();
			}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
		
}
