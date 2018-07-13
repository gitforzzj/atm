package atm27.domain;

import java.util.HashMap;
import java.util.Map;


public class Session {

	private final static Session session = new Session();
	private final Map<String, Object> map=new HashMap<>();
	
	private Account account;
	private Card card;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	

	private Session() {
	}

	

	public static Session getSession() {
		return session;
	}
	
	public  void put(String key, Object value){
		map.put(key, value);
	}

	public  Object get(String key){
		return map.get(key);
	}
	
	
}
