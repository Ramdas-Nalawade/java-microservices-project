package com.app.quiz.controller;

import com.app.quiz.model.Question;
import com.app.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController
{
    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Question> getAllQuestions()
    {
        return questionService.findAll();
    }

    @GetMapping("/category/{type}")
    public List<Question> getAllQuestions(@PathVariable String type)
    {
        return questionService.findByCategory(type);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }
}