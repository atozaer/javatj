package kr.co.tj;

class BankAccount{
	private int accountNumber;//계좌번호
	private String owner;//예금주
	private int balance;//잔액
	
	public BankAccount() {}
	public BankAccount(int accountNumber, String owner, int balance) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = balance;
	}
	public void deposit(int amount) {//저금
		balance +=amount;
	}
	public void withDraw(int amount) {//인출
		balance -=amount;
	}
	public String print() {
		return "현재잔액은"+balance+"원 입니다.";
	}

	
	
}

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount();
		myAccount.deposit(10000);
		System.out.println(myAccount.print());
		myAccount.withDraw(8000);
		System.out.println(myAccount.print());
	}

	
}
