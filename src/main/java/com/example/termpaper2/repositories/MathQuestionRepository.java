package com.example.termpaper2.repositories;

import com.example.termpaper2.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{

    private final Set<Question> questions;

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }
    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question remove(String question) {
        Question q = questions.stream()
                .filter(e -> e.getQuestion().equals(question))
                .findAny().orElseThrow();
        questions.remove(q);
        return q;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
