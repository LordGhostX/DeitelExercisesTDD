package com.lordghostx.kahoot;

import java.util.Arrays;

public class Question {
    private final int questionID;
    private final String title;
    private final String[] options;
    private final char answer;

    public Question(int questionID, String title, String[] options, char answer) {
        this.questionID = questionID;
        this.title = title;
        this.options = options;
        this.answer = answer;
    }

    public int getQuestionID() {
        return questionID;
    }

    public char getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "ID=" + questionID + "\ntitle=" + title + "\noptions=" + Arrays.toString(options);
    }
}
