package com.example.termpaper2;

import com.example.termpaper2.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionList {

    public static Collection<Question> getQuestions() {
        return new ArrayList<>(List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4")
        ));
    }
}
