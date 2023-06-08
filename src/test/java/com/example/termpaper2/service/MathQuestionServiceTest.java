package com.example.termpaper2.service;

import com.example.termpaper2.model.Question;
import com.example.termpaper2.repositories.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;

import static com.example.termpaper2.QuestionList.getQuestions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MathQuestionServiceTest {

    private QuestionRepository questionRepository;

    private MathQuestionService questionService;

    @BeforeEach
    public void setUp() {
        questionRepository = Mockito.mock(QuestionRepository.class);
        questionService = new MathQuestionService(questionRepository);
    }

    @Test
    public void shouldAddTest() {
        assertNotNull(questionService);
        Question question = new Question("question1", "answer1");

        Mockito.when(questionRepository.add("question1", "answer1")).thenReturn(question);

        assertEquals(questionService.add("question1", "answer1"), question);
    }

    @Test
    public void shouldRemoveTest() {
        assertNotNull(questionService);
        Question question = new Question("question1", "answer1");

        Mockito.when(questionRepository.remove("question1")).thenReturn(question);

        assertEquals(questionService.remove("question1"), question);
    }

    @Test
    public void shouldGetAllTest() {
        assertNotNull(questionService);
        Collection<Question> collection = getQuestions();

        Mockito.when(questionRepository.getAll()).thenReturn(collection);

        assertEquals(questionService.getAll(), collection);
    }
}
