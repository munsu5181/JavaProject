package Buds;

public class BudsDTO {
	// 회원가입 정보 필드
			private String bId;		// 아이디
			private String bPw;		// 비밀번호
			private String bName;	// 이름
			private String bBirth;	// 생년월일
			private String bGender;	// 성별
			private String bEmail;	// 이메일
			private String bPhone;	// 휴대전화
			
			private String bPw1; // 회원정보 수정시 사용되는 비밀번호
			
			private String AccountNumber;
			private int Balance;
			
			
			public String getbId() {
				return bId;
			}
			public void setbId(String bId) {
				this.bId = bId;
			}
			public String getbPw() {
				return bPw;
			}
			public void setbPw(String bPw) {
				this.bPw = bPw;
			}
			public String getbName() {
				return bName;
			}
			public void setbName(String bName) {
				this.bName = bName;
			}
			public String getbBirth() {
				return bBirth;
			}
			public void setbBirth(String bBirth) {
				this.bBirth = bBirth;
			}
			public String getbGender() {
				return bGender;
			}
			public void setbGender(String bGender) {
				this.bGender = bGender;
			}
			public String getbEmail() {
				return bEmail;
			}
			public void setbEmail(String bEmail) {
				this.bEmail = bEmail;
			}
			public String getbPhone() {
				return bPhone;
			}
			public void setbPhone(String bPhone) {
				this.bPhone = bPhone;
			}
			public String getbPw1() {
				return bPw1;
			}
			public void setbPw1(String bPw1) {
				this.bPw1 = bPw1;
			}
			
			public String getAccountNumber() {
				return AccountNumber;
			}
			public void setAccountNumber(String accountNumber) {
				this.AccountNumber = accountNumber;
			}
			
			public int getBalance() {
				return Balance;
			}
			public void setBalance(int balance) {
				this.Balance = balance;
			}
			@Override
			public String toString() {
				return "BudsDTO [bId=" + bId + ", bPw=" + bPw + ", bName=" + bName + ", bBirth=" + bBirth + ", bGender="
						+ bGender + ", bEmail=" + bEmail + ", bPhone=" + bPhone + ", bPw1=" + bPw1 + ", accountNumber="
						+ AccountNumber + ", balance=" + Balance + "]";
			}
			public BudsDTO() {
				super();
			}
			public BudsDTO(String bId, String bPw, String bName, String bBirth, String bGender, String bEmail,
					String bPhone, String bPw1, String accountNumber, int balance) {
				super();
				this.bId = bId;
				this.bPw = bPw;
				this.bName = bName;
				this.bBirth = bBirth;
				this.bGender = bGender;
				this.bEmail = bEmail;
				this.bPhone = bPhone;
				this.bPw1 = bPw1;
				this.AccountNumber = accountNumber;
				this.Balance = balance;
			}


			
}