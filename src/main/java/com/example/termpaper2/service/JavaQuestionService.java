package com.example.termpaper2.service;

import com.example.termpaper2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions;

    public JavaQuestionService(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

//    @Override
//    public Question add(Question question) {
//        questions.add(question);
//        return question;
//    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

//    @Override
//    public Question getRandomQuestion() {
//        Random random = new Random(questions.size());
//        return questions.stream().collect(Collectors.toList()).get(random.nextInt());
//    }
}
