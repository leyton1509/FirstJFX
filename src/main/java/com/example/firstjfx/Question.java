package com.example.firstjfx;
public class Question {

    /**
     * The number of the question
     */
    private int questionNumber;

    /**
     * The title of the question
     */
    private String questionTitle;

    /**
     * The array of answers
     */
    private String[] answers;

    /**
     * The number of the correct question
     */
    private int correctAnswerNumber;

    /**
     * The string of the note
     */
    private String note = "";

    /**
     * The type of question
     */

    private String questionType;

    /**
     * Getter for question number
     */

    public int getQuestionNumber() {
        return questionNumber;
    }

    /**
     * Gets the title
     */

    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * Gets the answers of the scene
     */

    public String[] getAnswers() {
        return answers;
    }

    /**
     * Gets the correct answer
     */

    public int getCorrectAnswerNumber() {
        return correctAnswerNumber;
    }

    /**
     * Gets the amount of answers of the scene
     */


    public int getNumOfAnswers() {
        return answers.length;
    }

    /**
     * @return the type of the question
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * @param _questionType the type of the question
     * @param _qNum the number of the question
     * @param _qTitle the title of the question
     * @param _answers the answers to the question
     * @param _correctAnswer the correct answer number
     */
    public Question(String _questionType, int _qNum, String _qTitle, String[] _answers, int _correctAnswer){
        questionType = _questionType;
        questionNumber = _qNum;
        questionTitle = _qTitle;
        answers = _answers;
        correctAnswerNumber = _correctAnswer;
    }

    /**
     * @return note the note to the end of the question
     */
    public String getNote() {
        return note;
    }

    /**
     * @param _questionType the type of the question
     * @param _qNum the number of the question
     * @param _qTitle the title of the question
     * @param _answers the answers to the question
     * @param _correctAnswer the correct answer number
     * @param _note the note to the end of the question
     */
    public Question(String _questionType, int _qNum, String _qTitle, String[] _answers, int _correctAnswer, String _note){
        questionType = _questionType;
        questionNumber = _qNum;
        questionTitle = _qTitle;
        answers = _answers;
        correctAnswerNumber = _correctAnswer;
        note = _note;
    }





}
