package com.example.termpaper2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Запрошено большее количество вопросов, чем хранится в сервисе")
public class WrongNumberOfQuestionsException extends RuntimeException{

    public WrongNumberOfQuestionsException() {
    }

    public WrongNumberOfQuestionsException(String message) {
        super(message);
    }
}
