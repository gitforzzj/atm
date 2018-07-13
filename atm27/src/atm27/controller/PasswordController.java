package atm27.controller;

import java.io.IOException;

import atm27.domain.ATM;
import atm27.domain.Session;
import atm27.utils.ATMUtils;
import atm27.view.AtmStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class PasswordController {
	
	@FXML
	private BorderPane passwordBP;
	@FXML
	private TextField password;
	@FXML
	private Button passwordReturn;
	@FXML
	private Button passwordReset;
	@FXML
	private Button passwordOK;

	// Event Listener on Button[#passwordReturn].onAction
	@FXML
	public void passwordReturn(ActionEvent event) {
		InsertCardController mainPage = (InsertCardController) Session.getSession().get("mainPage");
		mainPage.rollToFirst();
	}
	// Event Listener on Button[#passwordReset].onAction
	@FXML
	public void passwordReset(ActionEvent event) {
		password.setText("");
	}
	// Event Listener on Button[#passwordOK].onAction
	@FXML
	public void passwordOK(ActionEvent event) throws IOException {
		//通过工具类获取单例atm
		ATM atm = ATMUtils.getATM();
		//通过ATM进行密码校验
		boolean checkPassword = atm.checkPassword(password.getText());
		if(checkPassword){
			Parent root = FXMLLoader.load(getClass()
                    .getResource("/atm27/view/index.fxml"));
			//把这些图形界面放到session中，方便在不同的类取出修改界面
			Session.getSession().put("indexPage", root);
			InsertCardController mainPage = (InsertCardController) Session.getSession().get("mainPage");
			BorderPane bigBP = mainPage.getBigBP();
			bigBP.setCenter(new BorderPane(root));
		}
	}
}
