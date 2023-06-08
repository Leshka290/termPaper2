package com.example.termpaper2.repository;

import com.example.termpaper2.model.Question;
import com.example.termpaper2.repositories.JavaQuestionRepository;
import com.example.termpaper2.service.JavaQuestionService;
import com.example.termpaper2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;

public class JavaQuestionRepositoryTest {

    private final Set<Question> questions = new HashSet<>();

    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository(questions);
    QuestionService questionService = new JavaQuestionService(javaQuestionRepository);

    private final String questionStr = "question";
    private final String answer = "answer";
    Question question = new Question(questionStr, answer);

    @Test
    public void addTest() {
        questionService.add(questionStr, answer);
        assertEquals(question.getQuestion()
                , questionService.getAll().stream().iterator().next().getQuestion());
    }

    @Test
    public void removeTest() {
        questionService.add(questionStr, answer);
        questionService.remove(questionStr);
        assertFalse("find question", questionService.getAll().contains(question));
    }

    @ParameterizedTest
    @CsvSource({"question1, answer1", "question2, answer2", "question3, answer3"})
    public void getAllTest(String questionStr, String answer) {
        Question question = new Question(questionStr, answer);
        Set<Question> questionsTest = new HashSet<>(List.of(question));
        questionService.add(questionStr, answer);
        assertEquals(questionsTest, questionService.getAll());
    }
}
