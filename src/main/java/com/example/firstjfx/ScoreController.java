package com.example.firstjfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScoreController implements Initializable {

    private QuestionAnswers qa;
    @FXML
    protected TextArea FBox;

    @Override @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        qa = QuestionAnswers.getInstance();
        QuestionHandler qh = qa.getQuestionHandler();

        StringBuilder text = new StringBuilder();

        for (Question q : qh.getQuestions()) {
            text.append(q.getQuestionTitle()).append(" \n");
        }

        FBox.setText(text.toString());
    }







}
