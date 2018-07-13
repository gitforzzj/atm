package atm27.domain;

public class Account {
	private Card card;
	private String password;
	private Cash cash;
	private Customer customer;
	
	public Account() {
		super();
	}

	public Account(Card card, String password, Cash cash, Customer customer) {
		super();
		this.card = card;
		this.password = password;
		this.cash = cash;
		this.customer = customer;
	}

	public Cash getCash() {
		return cash;
	}
	
	public void setCash(Cash cash) {
		this.cash = cash;
	}
	
	
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
