package BANK;

public class BankDTO {

	private int clientNumber;		// 고객번호
	private String cName;			// 고객이름
	private String accountNumber;	// 계좌번호
	private int balance;			// 잔액
	
	// getter, setter
	public int getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// to string
	@Override
	public String toString() {
		return "BankDTO [clientNumber=" + clientNumber + ", cName=" + cName + ", accountNumber=" + accountNumber
				+ ", balance=" + balance + "]";
	}
	
	// 기본생성자
	public BankDTO() {
		super();
	}
	
	// 매개변수 생성자
	public BankDTO(int clientNumber, String cName, String accountNumber, int balance) {
		super();
		this.clientNumber = clientNumber;
		this.cName = cName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	
}
