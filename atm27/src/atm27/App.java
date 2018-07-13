package atm27;
import atm27.view.AtmStage;
import javafx.application.Application;
import javafx.stage.Stage;
/**
* <p>Title: Atm启动类</p>  

* @author zheng  

* @date 2018年5月24日
 */
public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		new AtmStage();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
