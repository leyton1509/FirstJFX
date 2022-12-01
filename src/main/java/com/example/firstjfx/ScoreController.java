package com.example.firstjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {

    @FXML
    protected TextArea questionTextArea;

    @FXML
    protected TextArea userTextArea;

    @FXML
    protected TextArea answerTextArea;

    @FXML
    protected Label scoreLabel;

    private QuestionAnswers qaClass;



    @Override @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        qaClass = QuestionAnswers.getInstance();
        QuestionHandler qh = qaClass.getQuestionHandler();
        ArrayList<String> ans = qaClass.getAnswers();


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
