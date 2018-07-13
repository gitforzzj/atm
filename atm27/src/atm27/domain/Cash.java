package atm27.domain;

public class Cash {

	private String cashid;
	private double balance;
	

	public Cash() {
		super();
	}


	public String getCashid() {
		return cashid;
	}


	public void setCashid(String cashid) {
		this.cashid = cashid;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public Cash(String cashid, double balance) {
		super();
		this.cashid = cashid;
		this.balance = balance;
	}

	
	
}
