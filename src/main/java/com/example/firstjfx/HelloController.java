package com.example.firstjfx;

import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;

public class HelloController {


    private final String[] usernames = {"Ted", "Sam", "Tim", "Admin"};
    private final String[] passwords = {"123", "3da", "asddf", "adminps"};

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


    @FXML
    public Stage stage;
    @FXML
    public Button btnHello;
    @FXML
    public Button btnBye;
    private boolean changed = false;
    @FXML
    private Label welcomeText;

    @FXML
    protected Circle crcMain;

    @FXML
    protected void onCircleClick() {
        welcomeText.setText("Wow you're cool!");
        if(!changed) {
            crcMain.setRadius(50);
            changed = true;
            crcMain.setFill(Paint.valueOf("white"));
        }
        else{
            crcMain.setRadius(100);
            changed = false;
            crcMain.setFill(Paint.valueOf("green"));
        }
    }

    @FXML
    protected void onByeButtonClick() {
        welcomeText.setText("See ya!");
        btnBye.setText("Bye bye");

        if(!changed) {
            changed = true;
            crcMain.setFill(Paint.valueOf("white"));
        }
        else{
            changed = false;
            crcMain.setFill(Paint.valueOf("green"));
        }
    }

    @FXML
    protected void submitDetails() {
        boolean loggedIn = false;
        if(Arrays.asList(usernames).contains(usernameTextField.getText())){
            // Get the index of this username
            int indexOfUserName = Arrays.asList(usernames).indexOf(usernameTextField.getText());
            // If the password equals that usernames password then return true
            if(passwords[indexOfUserName].equals(passwordTextField.getText())){
                loggedIn = true;
            }

            usernameTextField.setText("");
            passwordTextField.setText("");

            loggedinText.setVisible(true);

        }

    }

    @FXML
    protected void cancelDetails() {
        clearPasswordButton.setText("a");
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