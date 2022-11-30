package com.example.firstjfx;

import java.util.ArrayList;

public final class QuestionAnswers {
        private static QuestionAnswers INSTANCE;
        private String info = "Initial info class";
        private QuestionHandler questionHandler;
        private ArrayList<String> answers;

        public QuestionHandler getQuestionHandler() {
            return questionHandler;
        }

        public ArrayList<String> getAnswers() {
            return answers;
        }

        QuestionAnswers(QuestionHandler _questionHandler, ArrayList<String> _answers) {
                questionHandler = _questionHandler;
                answers = _answers;
        }

        QuestionAnswers() {
        }

        public static QuestionAnswers getInstance(QuestionHandler _questionHandler,  ArrayList<String> answers) {
                if(INSTANCE == null) {
                    INSTANCE = new QuestionAnswers(_questionHandler,  answers);
                }

                return INSTANCE;
            }

        public static QuestionAnswers getInstance() {
            if(INSTANCE == null) {
                INSTANCE = new QuestionAnswers();
            }

            return INSTANCE;
        }




            // getters and setters


}
