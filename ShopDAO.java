package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ShopDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void getCon() {
	
		try {
			
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			con=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	public int getMember(String id, String pass) {
		
		int result=0;
		getCon();
		
		try {
			String sql = "select count(*) from shopmember where id=? and password1=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
