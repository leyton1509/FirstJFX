package com.example.firstjfx;
public class Question {

    private int questionNumber;
    private String questionTitle;
    private String[] answers;
    private int correctAnswerNumber;
    private String note = "";

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswerNumber() {
        return correctAnswerNumber;
    }

    public int getNumOfAnswers() {
        return answers.length;
    }

    public Question(int _qNum, String _qTitle, String[] _answers, int _correctAnswer){
        questionNumber = _qNum;
        questionTitle = _qTitle;
        answers = _answers;
        correctAnswerNumber = _correctAnswer;
    }

    public String getNote() {
        return note;
    }

    public Question(int _qNum, String _qTitle, String[] _answers, int _correctAnswer, String _note){
        questionNumber = _qNum;
        questionTitle = _qTitle;
        answers = _answers;
        correctAnswerNumber = _correctAnswer;
        note = _note;

    }



}
