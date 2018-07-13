package atm27.controller;

import java.io.IOException;

import atm27.domain.ATM;
import atm27.domain.Session;
import atm27.utils.ATMUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class InsertCardController {
	private final static InsertCardController mainPage = new InsertCardController();
	//通过工具类获取单例atm
	private ATM atm = ATMUtils.getATM();
	@FXML
	private BorderPane bigBP;
	

	@FXML
	private TextField card;
	@FXML
	private Button insertCash;
	@FXML
	private TextArea spitOutput;
	@FXML
	private TextArea printOutput;
	@FXML
	private BorderPane insertBP;
	
	public InsertCardController(){
		Session.getSession().put("mainPage", this);
	}

	// Event Listener on Button[#insertCash].onAction
	@FXML
	public void insertCash(ActionEvent event) throws IOException {
		String cardId = card.getText();
		//通过ATM进行读卡
		boolean result = atm.insertCard(cardId);
		if(result){
			card.setDisable(true);
			insertCash.setDisable(true);
			Parent root = FXMLLoader.load(getClass()
                    .getResource("/atm27/view/password.fxml"));
			bigBP.setCenter(new BorderPane(root));
		}
	}
	//在后面多个界面点击退出回到ATM刚运行的初始状态
	public void rollToFirst(){
		card.setDisable(false);
		insertCash.setDisable(false);
		bigBP.setCenter(insertBP);
	}
	
	public BorderPane getBigBP() {
		return this.bigBP;
	}


	public BorderPane getInsertBP() {
		return insertBP;
	}
	
	public static InsertCardController getInsertCardController() {
		return mainPage;
	}
}
