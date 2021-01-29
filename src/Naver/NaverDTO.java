package Naver;

public class NaverDTO {
/*
 -- 아이디
-- 비밀번호
-- 이름
-- 생년월일(연도,월,일)
-- 성별
-- 이메일
-- 휴대전화 
 */
	// 위의 필드선언
	private String nId;
	private String nPw;
	private String nName;
	private String nBirth;
	private String nGender;
	private String nEmail;
	private String nPhone;
	
	// getter, setter
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public String getnPw() {
		return nPw;
	}
	public void setnPw(String nPw) {
		this.nPw = nPw;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String getnBirth() {
		return nBirth;
	}
	public void setnBirth(String nBirth) {
		this.nBirth = nBirth;
	}
	public String getnGender() {
		return nGender;
	}
	public void setnGender(String nGender) {
		this.nGender = nGender;
	}
	public String getnEmail() {
		return nEmail;
	}
	public void setnEmail(String nEmail) {
		this.nEmail = nEmail;
	}
	public String getnPhone() {
		return nPhone;
	}
	public void setnPhone(String nPhone) {
		this.nPhone = nPhone;
	}
	
	// to string
	@Override
	public String toString() {
		return "NaverDTO [nId=" + nId + ", nPw=" + nPw + ", nName=" + nName + ", nBirth=" + nBirth + ", nGender="
				+ nGender + ", nEmail=" + nEmail + ", nPhone=" + nPhone + "]";
	}
	
	// 기본생성자
	public NaverDTO() {
		super();
	}
	
	// 매개변수 생성자
	public NaverDTO(String nId, String nPw, String nName, String nBirth, String nGender, String nEmail, String nPhone) {
		super();
		this.nId = nId;
		this.nPw = nPw;
		this.nName = nName;
		this.nBirth = nBirth;
		this.nGender = nGender;
		this.nEmail = nEmail;
		this.nPhone = nPhone;
	}
	
	
}
