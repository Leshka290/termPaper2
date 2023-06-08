package com.example.termpaper2.controller;

import com.example.termpaper2.model.Question;
import com.example.termpaper2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/exam/java")
@RestController
public class JavaController {

    private final QuestionService questionService;

    public JavaController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(value = "/remove")
    public Question remove(@RequestParam("question") String question) {
        return questionService.remove(question);
    }

    @GetMapping("/all")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
