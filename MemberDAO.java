package memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
	
	public List<MemberDTO> getMemList() { 
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		con= DBConnection.DBConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select name, birth, phone, email from customer");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setNameTxt(rs.getString("name"));
				dto.setBirthTxt(rs.getString("birth"));
				dto.setPhoneTxt(rs.getString("phone"));
				dto.setEmailTxt(rs.getString("email"));
				list.add(dto);
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
