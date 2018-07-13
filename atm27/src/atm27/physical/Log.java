package atm27.physical;

import java.sql.Timestamp;

import atm27.domain.Account;
import atm27.domain.Session;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;

public class Log {

	private Account account;
	
	public Log(){
		account=(Account) Session.getSession().get("account");
	}
	
	public void printReceipt(double getmoney) {
		Parent parent = (Parent) Session.getSession().get("parent");
		TextArea ta = (TextArea)parent.lookup("#printOutput"); 
		StringBuffer str = new StringBuffer();
		str.append("ATM\r\n");
		str.append(new Timestamp(System.currentTimeMillis())+"\r\n");
		str.append(account.getCustomer().getName()+"取走了"+getmoney+"元");
		
		ta.setText(str.toString());
	}

	
	
}
