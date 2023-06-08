package com.example.termpaper2.service;

import com.example.termpaper2.exception.WrongNumberOfQuestionsException;
import com.example.termpaper2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImp implements ExaminerService {

    private final QuestionService questionService1;
    private final QuestionService questionService2;
    Random random = new Random();

    public ExaminerServiceImp(@Qualifier("javaQuestionService") QuestionService questionService1,
                              @Qualifier("mathQuestionService") QuestionService questionService2) {
        this.questionService1 = questionService1;
        this.questionService2 = questionService2;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService1.getAll().size()
                + questionService2.getAll().size() ) {
            throw new WrongNumberOfQuestionsException();
        }

        Set<Question> questions = new HashSet<>(amount);
        while (questions.size() != amount) {

            int randomInt = random.nextInt(2);
            if(randomInt == 1 && !questionService1.getAll().isEmpty()){
                questions.add(questionService1.getAll().stream()
                        .skip(random.nextInt(questionService1.getAll()
                                .size())).findFirst().orElse(null));
            } else {
                questions.add(questionService2.getAll().stream()
                        .skip(random.nextInt(questionService2.getAll()
                                .size())).findFirst().orElse(null));
            }
        }
        return questions;
    }
}
