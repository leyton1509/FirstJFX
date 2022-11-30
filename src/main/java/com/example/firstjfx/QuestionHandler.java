package com.example.firstjfx;

import java.util.ArrayList;

public class QuestionHandler {

    /**
     * The score of the user
     */
    private int score = 0;

    /**
     * The number of questions
     */
    private int numberOfQuestions = 1;

    /**
     * array of questions
     */
    private ArrayList<Question> questions = new ArrayList<>();


    /**
     * Constructor, add any questions here and it automatically updates the UI
     */
    public QuestionHandler(){

        addQuestion("inputType","How heavy is the blue whale? in tonnes, just put the number", new String[]{"200"}, 0, "The heaviest blue whale can be up to 200 tonnes!");
        addQuestion("checkbox", "Which of these animals are venomous?", new String[]{"Cat", "Platypus", "Dart Frog", "Jackal"}, 1, "Male platypus' have a venomous spour on their hind legs!");
        addQuestion("checkbox","True or false, snails kill more people than sharks", new String[]{"False", "True"}, 1, "Snails kill hundreds of thousands, sharks kill < 20, perspective!");
        addQuestion("checkbox","How many people have died to Malaria?", new String[]{"100,000", "1,000,000", "50,000,000", "Half of the humans to ever exist"}, 3, "Half of the human species has died to a bug...!");
        addQuestion("checkbox","Which of these contains the most lethal bacteria known to man?", new String[]{"Honey", "Dart Frog", "Snake Venom", "Botox"}, 0, "Honey contains the spores, botox is a product derived from the bacteria!");
        addQuestion("checkbox","How long is the largest parasite?", new String[]{"10m", "30m", "60m", "120m"}, 2, "Some fish worms can reach up to 60m long!");

    }

    /**
     * @param _qTitle the title of question
     * @param _answers the answers to the question
     * @param _correctAnswer the correct answer
     */
    private void addQuestion(String _questionType, String _qTitle, String[] _answers, int _correctAnswer){
        questions.add(new Question(_questionType, numberOfQuestions, _qTitle, _answers, _correctAnswer));
        numberOfQuestions++;
    }

    /**
     * @param _qTitle the title of question
     * @param _answers the answers to the question
     * @param _correctAnswer the correct answer
     * @param _note the note to the question
     */

    private void addQuestion(String _questionType, String _qTitle, String[] _answers, int _correctAnswer, String _note){
        questions.add(new Question(_questionType, numberOfQuestions, _qTitle, _answers, _correctAnswer, _note));
        numberOfQuestions++;
    }

    /**
     * @return returns the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the number of questions
     */
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    /**
     * @param number the question to return
     * @return the question associated with the number
     */
    public Question returnQuestion(int number){
        number--;
        return questions.get(number);
    }

    /**
     * Increase the score by 1
     */
    public void increaseScore(){
        score++;
    }




}
