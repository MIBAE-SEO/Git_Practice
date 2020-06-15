package user;

//데이터를 관리하고 관리,처리하는것을 jsp에서 구현하는것을 javaBeans라고 한다
public class User {
	//각각의 회원정보들이 db와 동일하게 java안에 담길 수 있도록 똑같이 선언해줌.
	public String userID;
	public String userPassword;
	public String userName;
	public String userGender;
	public String userEmail;
	
	
	//jsp서버에서 사용할 수 있는 형태로 만듬 (getter/setter)
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

}
