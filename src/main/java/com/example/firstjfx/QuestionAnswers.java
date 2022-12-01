package com.example.firstjfx;

import java.util.ArrayList;

/**
 * A singleton class which can only have one instance
 * Needed to transfer info between scenes
 */
public final class QuestionAnswers {

    /**
     * The static instance of the class
     */
    private static QuestionAnswers INSTANCE;

    /**
     * The question handler needed
     */
    private QuestionHandler questionHandler;

    /**
     * The answers the users provided
     */
    private ArrayList<String> answers;


    /**
     * @return The usersscores
     */
    public String getUserScore() {
        return userScore;
    }

    /**
     * The sco the users provided
     */
    private String userScore = "";

    /**
     * @return The question handler
     */

    public QuestionHandler getQuestionHandler() {
        return questionHandler;
    }

    /**
     * @return the answers
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }

    /**
     * @param _questionHandler Passing in the question handler
     * @param _answers Passing in the answers
     */
    QuestionAnswers(QuestionHandler _questionHandler, ArrayList<String> _answers, String _userScore) {
        questionHandler = _questionHandler;
        answers = _answers;
        userScore = _userScore;
    }

    /**
     * Empty constructor to allow the other class to call it
     */
    QuestionAnswers() {
    }

    /**
     * @param _questionHandler The question handler to add
     * @param answers The users input's
     * @return the instance of the class
     * Only create if it has not been created before
     */
    public static QuestionAnswers getInstance(QuestionHandler _questionHandler,  ArrayList<String> answers, String _userScore) {
            if(INSTANCE == null) {
                INSTANCE = new QuestionAnswers(_questionHandler,  answers,  _userScore);
            }

            return INSTANCE;
        }

    /**
     * @return The instance
     * No parameters for the second class call
     */
    public static QuestionAnswers getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new QuestionAnswers();
        }

        return INSTANCE;
    }




            // getters and setters


}
