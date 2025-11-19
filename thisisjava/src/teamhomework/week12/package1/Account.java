package teamhomework.week12.package1;

public class Account {
	private String account;
	private String owner;
	private int balance;
	
	public Account(String account, String owner, int balance) {
		this.account = account;
		this.owner = owner;
		this.balance = balance;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		if (amount > 0) {
			this.balance += amount;
		}
	}
	
	public boolean withdraw(int amount) {
		if(amount > 0 && this.balance >= amount) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
}
