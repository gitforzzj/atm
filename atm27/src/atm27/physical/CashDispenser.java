package atm27.physical;

import atm27.domain.Session;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;

public class CashDispenser {

	
	public void spitMoney(String withdrawMoney) {
		Parent parent = (Parent) Session.getSession().get("parent");
		TextArea ta = (TextArea)parent.lookup("#spitOutput");
		ta.setText(withdrawMoney);
	} 
	
	
}
