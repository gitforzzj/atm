package atm27.view;

import atm27.domain.Session;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AtmStage extends Stage{
	
	public AtmStage(){
		try {
			System.out.println(getClass().getResource("/"));
            Parent root = FXMLLoader.load(getClass()
                    .getResource("/atm27/view/insertCard.fxml"));
            
            Session.getSession().put("parent", root);
            setScene(new Scene(root));// 设置用createScene方法创建的场景
    		setTitle("ATM");
    		show();
        } catch(Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
}
