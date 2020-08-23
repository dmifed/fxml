package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private PasswordField passID;

    @FXML
    private TextField loginID;

    @FXML
    private Button buttonCheckID;



    @FXML
    private void onClockButtonCheckID() throws Exception{
        if(passID.getText().equals("29071982") && loginID.getText().equals("dmifed")){
            buttonCheckID.setText("OK");
            showGreeting(true, loginID.getText());
        }else {
            buttonCheckID.setText("Wrong");
            showGreeting(false, loginID.getText());
        }
    }



    @FXML
    void showGreeting(boolean isCheck, String login) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("inner.fxml"));
        Stage innerStage = new Stage();
        innerStage.setTitle("Greeting");
        innerStage.initModality(Modality.APPLICATION_MODAL);
        innerStage.setOpacity(1);
        innerStage.setScene(new Scene(root, 200, 200));
        InnerController innerController = new InnerController();
        innerStage.showAndWait();
        innerController.innerPane.setVisible(true);
        if(isCheck){
            innerController.greetingText.setText("Hello, " + login);
        }else {
            innerController.greetingText.setText("Wrong attempt, " + login);
        }
    }


}
