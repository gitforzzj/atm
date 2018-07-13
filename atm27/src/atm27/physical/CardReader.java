package atm27.physical;

import atm27.domain.Account;
import atm27.domain.Card;
import atm27.domain.Session;

public class CardReader {

	
	
	public boolean readCard(String cardId) {
		
		Card card = new Card(cardId);
		Session.getSession().setCard(card);
		Account account = (Account) Session.getSession().get("account");
		if(cardId.equals(account.getCard().getCardId())){
			return true;
		}else{
			return false;
		}
	}

}
