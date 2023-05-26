package com.example.termpaper2.controller;

import com.example.termpaper2.model.Question;
import com.example.termpaper2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("/exam/java")
@RestController
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(value = "/remove")
    public Question remove(@RequestParam("question") Question question) {
        return questionService.remove(question);
    }

    @GetMapping("/find")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
