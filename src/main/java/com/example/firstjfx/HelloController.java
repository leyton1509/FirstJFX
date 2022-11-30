package com.example.firstjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;

public class HelloController {


    private final String[] usernames = {"Ted", "Sam", "Tim", "Admin"};
    private final String[] passwords = {"123", "3da", "asddf", "adminps"};
    @FXML
    public Label userNameLabel;
    @FXML
    public Label passwordLabel;

    @FXML
    public Button submitButton;

    @FXML
    public Button cancelButton;

    @FXML
    public Button clearUserNameButton;

    @FXML
    public Button clearPasswordButton;

    @FXML
    public TextField usernameTextField;

    @FXML
    public TextField passwordTextField;

    @FXML
    public Label loggedinText;

    private Stage quizStage;
    private Scene quizScene;



    @FXML
    protected void setUpQuiz(ActionEvent event) throws IOException {
        submitButton.setVisible(false);
        cancelButton.setVisible(false);
        clearUserNameButton.setVisible(false);
        clearPasswordButton.setVisible(false);
        usernameTextField.setVisible(false);
        passwordTextField.setVisible(false);
        userNameLabel.setVisible(false);
        passwordLabel.setVisible(false);

        Parent root =  FXMLLoader.load(getClass().getResource("quizSceme.fxml"));
        // Change the size of the window, stage is controlled by the scene
        quizStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        quizScene = new Scene(root, 375, 300);
        quizStage.setScene(quizScene);
        quizStage.show();
    }



    @FXML
    protected void submitDetails(ActionEvent event) throws IOException {
        boolean loggedIn = false;
        if(Arrays.asList(usernames).contains(usernameTextField.getText())){
            // Get the index of this username
            int indexOfUserName = Arrays.asList(usernames).indexOf(usernameTextField.getText());
            // If the password equals that usernames password then return true
            if(passwords[indexOfUserName].equals(passwordTextField.getText())){
                loggedIn = true;
                //loggedinText.setVisible(true);
            }

        }
        usernameTextField.setText("");
        passwordTextField.setText("");

        if(loggedIn){
            setUpQuiz(event);
        }

    }

    @FXML
    protected void cancelDetails() {
        usernameTextField.setText("");
        passwordTextField.setText("");
    }

    @FXML protected void clearUserName() {
        usernameTextField.setText("");
    }

    @FXML protected void clearPassword() {
        passwordTextField.setText("");

    }

    /*
    In hello view :
    <Circle fx:id ="crcMain" fill="#801803" onMouseClicked="#onCircleClick" radius="100.0" stroke="#247e80" strokeType="INSIDE" />
    <Button fx:id="btnBye" mnemonicParsing="false" onAction="#onByeButtonClick" text="Bye!" />
    <Button fx:id="btnHello" onAction="#onHelloButtonClick" text="Hello!" />
     */
}