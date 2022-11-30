package com.example.firstjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class QuizController implements Initializable {


    /**
     * Question number to track the question number
     */
    public int questionNumber = 1;

    /**
     * Label for quiz
     */

    @FXML
    public Label quizLabel;

    /**
     * Label for the note at the end of question
     */

    @FXML
    public Label noteLabel;

    /**
     * Question number
     */
    @FXML
    public Label numberLabel;

    /**
     * Question title
     */

    @FXML
    public Label questionLabel;

    /**
     * Score label
     */

    @FXML
    public Label scoreLabel;

    /**
     * Checkbox answer 1
     */

    @FXML
    public CheckBox checkbox1;

    /**
     * Checkbox answer 2
     */

    @FXML
    public CheckBox checkbox2;

    /**
     * Checkbox answer 3
     */
    @FXML
    public CheckBox checkbox3;

    /**
     * Checkbox answer 4
     */

    @FXML
    public CheckBox checkbox4;

    /**
     * Button to submit answer
     */

    @FXML
    public Button submitQuizAnswerButton;


    /**
     * Button to go to next question
     */
    @FXML
    public Button nextQuestionButton;

    /**
     * Question handler which handles question info
     */

    private QuestionHandler questionHandler = new QuestionHandler();

    /**
     * Calls set question when this scene is initialised
     * @param url url
     * @param resourceBundle resourceBundle
     */
    @Override @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setQuestion(questionNumber);
    }

    /**
     * Sets the correct question info inside the scene
     * if there's no questions then print the score
     */
    @FXML
    protected void nextQuestion() {
        submitQuizAnswerButton.setVisible(true);
        nextQuestionButton.setVisible(false);
        questionNumber++;
        if(questionNumber < questionHandler.getNumberOfQuestions()){
            setQuestion(questionNumber);
        }
        else{
            submitQuizAnswerButton.setVisible(false);
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);
            checkbox4.setVisible(false);
            quizLabel.setVisible(false);
            noteLabel.setVisible(false);
            numberLabel.setVisible(false);
            questionLabel.setVisible(false);
            scoreLabel.setVisible(true);
            scoreLabel.setText("You got : " + questionHandler.getScore() +"/" + (questionHandler.getNumberOfQuestions()-1));
        }
    }

    /**
     * Called when the submit button is clicked
     */
    @FXML
    protected void submitAnswer() {
        submitQuizAnswerButton.setVisible(false);
        nextQuestionButton.setVisible(true);
        noteLabel.setText(questionHandler.returnQuestion(questionNumber).getNote());

        // Gets the correct answer

        int ansLoc = questionHandler.returnQuestion(questionNumber).getCorrectAnswerNumber();

        // If the answer and the corresponding checkbox is checked then the user got it right

        if(ansLoc == 0){
            if(checkbox1.isSelected() && !checkbox2.isSelected() && !checkbox3.isSelected() && !checkbox4.isSelected()){
                questionHandler.increaseScore();
                System.out.println("Answer 1 correct");
            }
        }else if(ansLoc == 1){
            if(!checkbox1.isSelected() && checkbox2.isSelected() && !checkbox3.isSelected() && !checkbox4.isSelected()){
                questionHandler.increaseScore();
                System.out.println("Answer 2 correct");
            }
        }else if(ansLoc == 2){
            if(!checkbox1.isSelected() && !checkbox2.isSelected() && checkbox3.isSelected() && !checkbox4.isSelected()){
                questionHandler.increaseScore();
                System.out.println("Answer 3 correct");
            }
        }
        else if(ansLoc == 3){
            if(!checkbox1.isSelected() && !checkbox2.isSelected() && !checkbox3.isSelected() && checkbox4.isSelected()){
                questionHandler.increaseScore();
                System.out.println("Answer 4 correct");
            }
        }
    }

    /**
     * Sets all the scene info to the correct question information
     * @param questionNumber the question to add
     */
    public void setQuestion(int questionNumber){

        // returns the question from question handler
        Question currentQuestion = questionHandler.returnQuestion(questionNumber);
        numberLabel.setText(questionNumber + ".");
        questionLabel.setText(currentQuestion.getQuestionTitle());
        noteLabel.setText("");

        System.out.println(currentQuestion.getNumOfAnswers());
        System.out.println(Arrays.toString(currentQuestion.getAnswers()));

        // Sets the checkboxes to unselected for every question

        checkbox1.setSelected(false);
        checkbox2.setSelected(false);
        checkbox3.setSelected(false);
        checkbox4.setSelected(false);

        // Depending on the amount of answers, display the right amount of checkboxes

        switch (currentQuestion.getNumOfAnswers()){
            case 2:
                checkbox1.setVisible(true);
                checkbox2.setVisible(true);
                checkbox3.setVisible(false);
                checkbox4.setVisible(false);

                checkbox1.setText(currentQuestion.getAnswers()[0]);
                checkbox2.setText(currentQuestion.getAnswers()[1]);

                break;
            case 3:
                checkbox1.setVisible(true);
                checkbox2.setVisible(true);
                checkbox3.setVisible(true);
                checkbox4.setVisible(false);

                checkbox1.setText(currentQuestion.getAnswers()[0]);
                checkbox2.setText(currentQuestion.getAnswers()[1]);
                checkbox3.setText(currentQuestion.getAnswers()[2]);

                break;
            case 4:
                checkbox1.setVisible(true);
                checkbox2.setVisible(true);
                checkbox3.setVisible(true);
                checkbox4.setVisible(true);

                checkbox1.setText(currentQuestion.getAnswers()[0]);
                checkbox2.setText(currentQuestion.getAnswers()[1]);
                checkbox3.setText(currentQuestion.getAnswers()[2]);
                checkbox4.setText(currentQuestion.getAnswers()[3]);

                break;

        }

    }



}


