package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	
	//커넥션 설정하기 
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//데이터베이스가 커넥션풀을 사용하도록 설정하는 메소드
	
	public void getCon() {
		
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			
			//datasource
			con = ds.getConnection();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//하나의 새로운 게시글이 넘어와서 저장되는 메소드
	public void insertBoard(BoardBean bean) {
		
		//커넥션 연결
		getCon();
		
		//bean클래스에 넘어오지 않았던 데이터들을 초기화해주어야 함.
		int ref=0; //글그룹 = 쿼리를 실행시켜서 가장 큰 ref값을 가져온 후 +1 해주면 됨. 
		int re_step=1; //새글(부모글)
		int re_level=1; 
		
		
		try {
			//가장 큰 ref값을 읽어오는 쿼리 준비
			String refsql = "select max(ref) from board";
			//쿼리실행 객체 
			pstmt = con.prepareStatement(refsql);
			//쿼리실행 후 결과 리턴
			rs = pstmt.executeQuery();
				
			if(rs.next()) {//쿼리가 결과 값이 있다면
				ref=rs.getInt(1)+1; //최대값에 +1해서 글 그룹 설정
			}
			//실제로 게시글 전체값을 테이블에 저장한다.
			
			String sql = "insert into board values(board_seq.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			pstmt = con.prepareStatement(sql);
		
			// ?에 값을 매핑한다
			
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bean.getContent());
			
			//쿼리를 실행하시오.
			
			pstmt.executeUpdate();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//모든 게시글을 리턴해주는 메소드 적용
	public Vector<BoardBean> getAllBoard(){
		
		//리턴객체 선언
		Vector<BoardBean> v = new Vector<>();
		getCon();
		
		try {
			
			//쿼리준비 (re_step과 re_level을 조정(최신글)하여야함.
			String sql = "select * from board order by ref desc, re_step asc ";
			
			//쿼리실행객체 선언
			pstmt = con.prepareStatement(sql);
			//쿼리 실행 후 결과 저장
			rs = pstmt.executeQuery();
			//데이터 개수 몇개인지 모르기에 반복문 이용하여 데이터 추출
			
			while(rs.next()) {
				//데이터를 BoardBean을 이용 해 패키징(가방)해야함. 
				BoardBean bean = new BoardBean();
				bean.setNum(rs.getInt(1));
				bean.setWriter(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setSubject(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setReg_date(rs.getDate(6).toString());
				bean.setRef(rs.getInt(7));
				bean.setRe_step(rs.getInt(8));
				bean.setRe_level(rs.getInt(9));
				bean.setReadcount(rs.getInt(10));
				bean.setContent(rs.getString(11));
				
				//패키징 한 데이터를 Vector(박스)에 저장
				v.add(bean);
				con.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}
	
}
