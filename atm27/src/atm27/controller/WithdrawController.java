package atm27.controller;

import java.io.IOException;
import java.sql.Timestamp;

import atm27.domain.ATM;
import atm27.domain.Account;
import atm27.domain.Session;
import atm27.utils.ATMUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
/**
 * 取款界面操作相关按钮的controller
 * @author zheng
 *
 */
public class WithdrawController {
	
	//通过工具类获取单例atm
		private ATM atm = ATMUtils.getATM();
	
	private Account account;
	@FXML
	private BorderPane withdrawBT;
	@FXML
	private Button withdrawExit;
	@FXML
	private Button resetBt;
	@FXML
	private Button printReceipt;
	@FXML
	private Button checkBt;
	@FXML
	private Label money;
	@FXML
	private TextField withdrawInput;
	
	private double getmoney;
	
	public WithdrawController() throws IOException{
		 account = (Account) Session.getSession().get("account");
	}
	
	// 退出按钮点击触发事件
	@FXML
	public void withdrawExit(ActionEvent event) {
		
		//退出操作都是界面处理所以没调用ATM处理
		Parent parent = (Parent) Session.getSession().get("parent");
		Parent indexPage = (Parent) Session.getSession().get("indexPage");
		BorderPane bigBP=(BorderPane)parent.lookup("#bigBP");
		bigBP.setCenter(new BorderPane(indexPage));
		
		TextArea taprint = (TextArea)parent.lookup("#printOutput"); 
		TextArea ta = (TextArea)parent.lookup("#spitOutput"); 
		taprint.setText("");
		ta.setText("");
	}
	// 重置按钮点击触发事件
	@FXML
	public void resetBt(ActionEvent event) {
		withdrawInput.setText("");
	}
	// 确定按钮点击触发事件
	@FXML
	public void checkBt(ActionEvent event) {
		
		String withdrawMoney = withdrawInput.getText();
		double pickmoney= Double.parseDouble(withdrawMoney);
		//将取款的值付给getmoney变量，以便在打印凭证方法可用
		getmoney=pickmoney;
		
		//通过ATM控制器调用方法实现取款
		double balance = atm.withdrawMoney(pickmoney);
		money.setText(balance+"");
		
		//通过ATM控制器调用方法实现吐钱
		atm.spitMoney(withdrawMoney);
		
		
		withdrawInput.setText("");
		printReceipt.setDisable(false);
	}
	// 打印凭证按钮点击触发事件
	@FXML
	public void printReceipt(ActionEvent event) {
		
		atm.printReceipt(getmoney);
		printReceipt.setDisable(true);
		
	}
	
}
