package com.example.termpaper2.service;

import com.example.termpaper2.exception.WrongNumberOfQuestionsException;
import com.example.termpaper2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImp implements ExaminerService {

    private final QuestionService questionService;
    Random random = new Random();

    public ExaminerServiceImp(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new WrongNumberOfQuestionsException();
        }

        Set<Question> questions = new HashSet<>(amount);
        while (questions.size() != amount) {
            questions.add(questionService.getAll().stream()
                    .skip(random.nextInt(questionService.getAll()
                            .size())).findFirst().orElse(null));
        }
        return questions;
    }
}
