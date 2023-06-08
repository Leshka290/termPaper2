package com.example.termpaper2.service;

import com.example.termpaper2.model.Question;
import com.example.termpaper2.repositories.JavaQuestionRepository;
import com.example.termpaper2.repositories.MathQuestionRepository;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExaminerServiceImpTest {

    private final Set<Question> questions = new HashSet<>();
    private final JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository(questions);
    private final MathQuestionRepository mathQuestionRepository = new MathQuestionRepository(questions);
    private final QuestionService questionService1 = new JavaQuestionService(javaQuestionRepository);
    private final QuestionService questionService2 = new MathQuestionService(mathQuestionRepository);

    ExaminerService examinerServiceImp = new ExaminerServiceImp(questionService1, questionService2);

    Random random = new Random();

    private Collection<Question> addQuestions() {
        questionService1.add("question", "answer");
        questionService2.add("question1", "answer1");
        return Stream.concat(questionService1.getAll().stream(), questionService2.getAll().stream()).collect(Collectors.toSet());
    }

    @Test
    public void testGetQuestions() {
       final int amount = 2;

        Set<Question> questionsTest = new HashSet<>(amount);
        while (questionsTest.size() != amount) {

                questionsTest.add(addQuestions().stream()
                        .skip(random.nextInt(addQuestions()
                                .size())).findFirst().orElse(null));

                examinerServiceImp.getQuestions(amount).add(addQuestions().stream()
                        .skip(random.nextInt(addQuestions()
                                .size())).findFirst().orElse(null));
        }
        assertEquals(questionsTest.size(), examinerServiceImp.getQuestions(amount).size());
    }

    @Test
    public void testGetQuestionsAmount() {
        int amount = 2;

        Set<Question> questionsTest = new HashSet<>(addQuestions());
        examinerServiceImp.getQuestions(amount).addAll(addQuestions());
        assertEquals(questionsTest.size(), examinerServiceImp.getQuestions(amount).size());
    }
}