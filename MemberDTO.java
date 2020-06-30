package memo;

public class MemberDTO {

	
	 private String nameTxt;
	 private String birthTxt;
	 private String phoneTxt;
	 private String emailTxt;
	 
	public String getNameTxt() {
		return nameTxt;
	}
	public void setNameTxt(String nameTxt) {
		this.nameTxt = nameTxt;
	}
	public String getBirthTxt() {
		return birthTxt;
	}
	public void setBirthTxt(String birthTxt) {
		this.birthTxt = birthTxt;
	}
	public String getPhoneTxt() {
		return phoneTxt;
	}
	public void setPhoneTxt(String phoneTxt) {
		this.phoneTxt = phoneTxt;
	}
	public String getEmailTxt() {
		return emailTxt;
	}
	public void setEmailTxt(String emailTxt) {
		this.emailTxt = emailTxt;
	}
	 
	@Override
    public String toString() {
        return "MemberDTO [nameTxt=" + nameTxt + ", birthTxt=" + birthTxt + ", phoneTxt=" + phoneTxt
                + ", emailTxt=" + emailTxt + "]";
    }
}
	 
	 
