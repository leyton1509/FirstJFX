package com.example.firstjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;

public class HelloController {


    /**
     * String array of valid usernames
     */
    private final String[] usernames = {"Ted", "Sam", "Tim", "Admin"};
    /**
     * String array of valid passwords
     */
    private final String[] passwords = {"123", "3da", "asddf", "adminps"};

    /**
     * FXML username label
     */
    @FXML
    public Label userNameLabel;

    /**
     * FXML password label
     */
    @FXML
    public Label passwordLabel;

    /**
     * FXML button to submit login details
     */
    @FXML
    public Button submitButton;

    /**
     * FXML button to cancel login details
     */
    @FXML
    public Button cancelButton;

    /**
     * FXML button to clear the username
     */

    @FXML
    public Button clearUserNameButton;

    /**
     * FXML button to clear the password
     */
    @FXML
    public Button clearPasswordButton;

    /**
     * FXML text field to take the username
     */

    @FXML
    public TextField usernameTextField;

    /**
     * FXML text field to take the password
     */
    @FXML
    public TextField passwordTextField;

    /**
     * FXML log in label
     */
    @FXML
    public Label loggedinText;


    /**
     * Sets up the quiz scene
     * @param event Event passed in to set up a new scence
     * @throws IOException for if the file cant be loaded
     */
    @FXML
    protected void setUpQuiz(ActionEvent event) throws IOException {
        // Loads the quiz scene (spelt wrong accidentally)
        Parent root =  FXMLLoader.load(getClass().getResource("quizSceme.fxml"));
        // Change the size of the window, stage is controlled by the scene
        Stage quizStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene quizScene = new Scene(root, 300, 350);
        quizStage.setScene(quizScene);
        quizStage.show();
    }

    /**
     * Called once the submit details button is clicked, checks to see if the details are correct
     * @param event The event so it can be passed to set up quiz method
     * @throws IOException incase the file cant be loaded
     */
    @FXML
    protected void submitDetails(ActionEvent event) throws IOException {
        // If the name is in usernames, and the corresponding password is correct, log the user in
        boolean loggedIn = false;
        if(Arrays.asList(usernames).contains(usernameTextField.getText())){
            // Get the index of this username
            int indexOfUserName = Arrays.asList(usernames).indexOf(usernameTextField.getText());
            // If the password equals that usernames password then return true
            if(passwords[indexOfUserName].equals(passwordTextField.getText())){
                loggedIn = true;
            }

        }
        usernameTextField.setText("");
        passwordTextField.setText("");

        if(loggedIn){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("You have logged in to the text");
            alert.show();
            setUpQuiz(event);
        }

    }

    /**
     * Cancel details sets the text to blank
     */
    @FXML
    protected void cancelDetails() {
        usernameTextField.setText("");
        passwordTextField.setText("");
    }

    /**
     * Clears the username
     */
    @FXML protected void clearUserName() {
        usernameTextField.setText("");
    }

    /**
     * Clears the password
     */

    @FXML protected void clearPassword() {
        passwordTextField.setText("");

    }

}