package atm27.domain;

import atm27.physical.CardReader;
import atm27.physical.CashDispenser;
import atm27.physical.Log;
import atm27.service.AccountService;

public class ATM {
	
	
	private Card card;
	private Cash cash;
	private Customer customer;
	private CashDispenser cashDispenser;
	private CardReader cardReader;
	private Account account;
	private AccountService accountService;
	private Log log;
	
	public ATM(){
		createBaseObject();
	}
	
	private void createBaseObject() {
		cardReader= new CardReader();
		cashDispenser = new CashDispenser();
		card=new Card("1");
		log = new Log();
		cash = new Cash("1",10000);
		customer = new Customer("1","zheng");
		account = new Account(card,"1",cash,customer);
		accountService = new AccountService();
		Session.getSession().put("account", account);
	}

	public boolean insertCard(String cardId) {
		return cardReader.readCard(cardId);
	}
	
	public boolean checkPassword(String pass){
		return accountService.checkPassword(pass);
	}

	public double withdrawMoney(double pickmoney) {
		return accountService.withdrawMoney(pickmoney);
	}

	public void spitMoney(String withdrawMoney) {
		// TODO Auto-generated method stub
		cashDispenser.spitMoney(withdrawMoney);
	}

	public void printReceipt(double getmoney) {
		// TODO Auto-generated method stub
		log.printReceipt(getmoney);
	}

	public double getAccountBalance() {
		return accountService.getAccountBalance();
	}
	
	

	
}
