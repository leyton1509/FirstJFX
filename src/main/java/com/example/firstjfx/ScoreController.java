package com.example.firstjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {

    /**
     * The questions text area
     */
    @FXML
    protected TextArea questionTextArea;

    /**
     * The iser input text area
     */
    @FXML
    protected TextArea userTextArea;

    /**
     * The answer text area
     */
    @FXML
    protected TextArea answerTextArea;

    /**
     * The score label
     */
    @FXML
    protected Label scoreLabel;

    /**
     * The question answers singleton class
     */
    private QuestionAnswers qaClass;


    /**
     * Called when the scene is created
     * Sets the questions, answers and user inputs to the text boxes
     * and tells the user the score they got
     * @param url The url
     * @param resourceBundle The resources
     */
    @Override @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Gets the instance of question answers, a singleton means theres only ever one instance
        qaClass = QuestionAnswers.getInstance();
        QuestionHandler qh = qaClass.getQuestionHandler();
        ArrayList<String> ans = qaClass.getAnswers();

        // Builds the strings from the variables
        StringBuilder questionText = new StringBuilder();
        StringBuilder answerText = new StringBuilder();
        StringBuilder userAnswerText = new StringBuilder();

        for (Question q : qh.getQuestions()) {
            questionText.append(q.getQuestionNumber() + ". " + q.getQuestionTitle() + " \n");
            answerText.append(q.getAnswers()[q.getCorrectAnswerNumber()] + "\n");
        }

        for (String input : ans) {
            userAnswerText.append(input + "\n");
        }

        questionTextArea.setText(questionText.toString());
        userTextArea.setText(userAnswerText.toString());
        answerTextArea.setText(answerText.toString());
        scoreLabel.setText("You got : " + qaClass.getUserScore() + "!");
    }







}
