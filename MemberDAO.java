package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	
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
		
		//회원 한 사람에 대한 정보를 저장하는 메소드
		public void insertMember(MemberBean bean) {
			getCon();
			
			try {
				//쿼리준비
				String sql = "insert into member2 values(?,?,?,?,?,?,?,?)";
				
				pstmt=con.prepareStatement(sql);
				//?에 값 삽입
				pstmt.setString(1, bean.getId());
				pstmt.setString(2, bean.getPass1());
				pstmt.setString(3, bean.getEmail());
				pstmt.setString(4, bean.getTel());
				pstmt.setString(5, bean.getHobby());
				pstmt.setString(6, bean.getJob());
				pstmt.setString(7, bean.getAge());
				pstmt.setString(8, bean.getInfo());
				//쿼리실행
				pstmt.executeUpdate();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		//모든 회원의 정보를 리턴하는 메소드 작성
		public Vector<MemberBean> getAllMember(){
			
			//리턴타입 선언
			Vector<MemberBean> v = new Vector<>();
			
			getCon();
			
			try {
				String sql = "select * from member2 ";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				//반복문을 돌면서 회원정보 저장
				while(rs.next()) {
					MemberBean bean = new MemberBean();
					bean.setId(rs.getString(1));
					bean.setPass1(rs.getString(2));
					bean.setEmail(rs.getString(3));
					bean.setTel(rs.getString(4));
					bean.setHobby(rs.getString(5));
					bean.setJob(rs.getString(6));
					bean.setAge(rs.getString(7));
					bean.setInfo(rs.getString(8));
					
					//벡터에 Bean클래스 저장
					v.add(bean);
				}
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return v;
		}
		
}
