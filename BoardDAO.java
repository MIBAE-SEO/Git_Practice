package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BoardDAO {

	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	public void getCon() {
		
		try {
			
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			
			con = ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//글쓰기
	public void insertBoard(BoardBean bean) {
		
		getCon();
		
		int ref=0;
		int re_step=1;
		int re_level=1;
		
		try {
			String refsql = "select max(ref) from projectboard";
			pstmt = con.prepareStatement(refsql);
			rs = pstmt.executeQuery();
				
			if(rs.next()) {//쿼리가 결과 값이 있다면
				ref=rs.getInt(1)+1; //최대값에 +1해서 글 그룹 설정
			}
			
			String sql ="insert into projectboard values(PROJECTBOARD_SEQ.NEXTVAL,?,?,?,?,sysdate,?,?,?,0,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getSubject());
			pstmt.setString(4, bean.getPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			pstmt.setString(8, bean.getContent());
			
			pstmt.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		 
		public Vector<BoardBean> getAllBoard(){
			

				Vector<BoardBean> v = new Vector<>();

				getCon();


				try {

				String sql = "select * from projectboard order by ref desc, re_step asc ";


				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();


				while(rs.next()) {

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


				v.add(bean);
				}
				con.close();

				}catch(Exception e) {

				e.printStackTrace();

				}
				return v;

				}
	
}
