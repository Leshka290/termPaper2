package com.example.termpaper2.service;

import com.example.termpaper2.model.Question;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExaminerServiceImpTest {

    private final Set<Question> questions = new HashSet<>();
    private final QuestionService questionService = new JavaQuestionService(questions);
    ExaminerService examinerServiceImp = new ExaminerServiceImp(questionService);

    Random random = new Random();

    private Collection<Question> addQuestions() {
        questionService.add("question", "answer");
        questionService.add("question1", "answer1");
        questionService.add("question2", "answer2");
        return questionService.getAll();
    }

    @Test
    public void testGetQuestions() {
        int amount = 2;

        Set<Question> questionsTest = new HashSet<>(amount);
        while (questionsTest.size() != amount) {
            questionsTest.add(questionService.getAll().stream()
                    .skip(random.nextInt(addQuestions().size()))
                    .findFirst().orElse(null));

            examinerServiceImp.getQuestions(amount)
                    .add(questionService.getAll()
                            .stream()
                            .skip(random.nextInt(addQuestions()
                                    .size())).findFirst().orElse(null));
        }

        assertEquals(questionsTest, examinerServiceImp.getQuestions(amount));
    }
}