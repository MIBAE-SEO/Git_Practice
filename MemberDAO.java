package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
	private Connection con;
	
	public void insertMember(String nameTxt, String birthTxt, String phoneTxt, String emailTxt) {
		con= DBConnection.DBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(""
					+"INSERT INTO customer"
					+ "(name, birth, phone, email) "
					+ "VALUES"
					+ "('"+nameTxt+"','"+birthTxt+"','"+phoneTxt+"','"+emailTxt+"')");
			int r = pstmt.executeUpdate();
			
			if(r== 1) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
