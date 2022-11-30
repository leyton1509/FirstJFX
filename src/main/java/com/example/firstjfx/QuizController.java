package com.example.firstjfx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

    /**
     * A list of all the answers
     */

    private ArrayList<String> userAnswers;


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

    @FXML
    protected TextField inputAnswerBox;

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
    protected void nextQuestion(Event event) throws IOException {
        submitQuizAnswerButton.setVisible(true);
        nextQuestionButton.setVisible(false);
        questionNumber++;
        if(questionNumber < questionHandler.getNumberOfQuestions()){
            setQuestion(questionNumber);
        }
        else{
            submitQuizAnswerButton.setVisible(false);
            setVisibleCheckboxes(false, false, false, false);
            quizLabel.setVisible(false);
            noteLabel.setVisible(false);
            numberLabel.setVisible(false);
            questionLabel.setVisible(false);
            // scoreLabel.setVisible(true);
            // scoreLabel.setText("You got : " + questionHandler.getScore() +"/" + (questionHandler.getNumberOfQuestions()-1));
            //ScoreController controller = new ScoreController();
            //controller.initData(questionHandler, userAnswers);
            //loader.setController(controller);

            QuestionAnswers qA =  QuestionAnswers.getInstance(questionHandler, userAnswers);

            // Loads the quiz scene (spelt wrong accidentally)
            Parent root =  FXMLLoader.load(getClass().getResource("score.fxml"));
            // Change the size of the window, stage is controlled by the scene
            Stage quizStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene quizScene = new Scene(root, 300, 350);
            quizStage.setScene(quizScene);
            quizStage.show();
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
        String typeOfQ = questionHandler.returnQuestion(questionNumber).getQuestionType();

        // If the answer and the corresponding checkbox is checked then the user got it right
        if(typeOfQ.equals("checkbox")){
            int ansLoc = questionHandler.returnQuestion(questionNumber).getCorrectAnswerNumber();
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
        else if (typeOfQ.equals("inputType")){
            String ans = questionHandler.returnQuestion(questionNumber).getAnswers()[0];
            if(inputAnswerBox.getText().equals(ans)){
                questionHandler.increaseScore();
                System.out.println("Answer of " + ans + " correct");
            }
        }
    }

    public void setVisibleCheckboxes(boolean one, boolean two, boolean three, boolean four){
        checkbox1.setVisible(one);
        checkbox2.setVisible(two);
        checkbox3.setVisible(three);
        checkbox4.setVisible(four);
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
        inputAnswerBox.setText("");

        // Depending on the amount of answers, display the right amount of checkboxes

        if(currentQuestion.getQuestionType().equals("checkbox")){
            inputAnswerBox.setVisible(false);
            switch (currentQuestion.getNumOfAnswers()){
                case 2:
                    setVisibleCheckboxes(true, true, false,false);

                    checkbox1.setText(currentQuestion.getAnswers()[0]);
                    checkbox2.setText(currentQuestion.getAnswers()[1]);

                    break;
                case 3:
                    setVisibleCheckboxes(true, true, true,false);

                    checkbox1.setText(currentQuestion.getAnswers()[0]);
                    checkbox2.setText(currentQuestion.getAnswers()[1]);
                    checkbox3.setText(currentQuestion.getAnswers()[2]);

                    break;
                case 4:
                    setVisibleCheckboxes(true, true, true,true);

                    checkbox1.setText(currentQuestion.getAnswers()[0]);
                    checkbox2.setText(currentQuestion.getAnswers()[1]);
                    checkbox3.setText(currentQuestion.getAnswers()[2]);
                    checkbox4.setText(currentQuestion.getAnswers()[3]);

                    break;

            }
        } else if (currentQuestion.getQuestionType().equals("inputType")){
            setVisibleCheckboxes(false, false, false,false);
            inputAnswerBox.setVisible(true);
        }


    }



}


