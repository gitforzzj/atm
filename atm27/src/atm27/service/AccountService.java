package atm27.service;

import atm27.domain.Account;
import atm27.domain.Session;
/**
 * 提供account相关的一些服务
 * @author zheng
 *
 */
public class AccountService {

	private Account account;
	
	public AccountService(){
		account=(Account) Session.getSession().get("account");
	}
	
	public double withdrawMoney(double pickmoney) {
		
		double balance = account.getCash().getBalance()-pickmoney;
		account.getCash().setBalance(balance);
		return balance;
		
	}

	public double getAccountBalance() {
		double balance = account.getCash().getBalance();
		return balance;
	}

	public boolean checkPassword(String pass) {
		if(Session.getSession().getCard().getCardId().equals(account.getCard().getCardId())){
			if(pass.equals(account.getPassword())){
				
				return true;
			}
		}
		return false;
	}

}
