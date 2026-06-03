package com.app.quiz.controller;

import com.app.quiz.model.Question;
import com.app.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController
{
    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return questionService.findAll();
    }

    @GetMapping("/category/{type}")
    public ResponseEntity<List<Question>> getAllQuestions(@PathVariable String type)
    {
        return questionService.findByCategory(type);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id)
    {
        return (questionService.deleteQuestion(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody Question question)
    {
        return questionService.updateQuestion(id, question);
    }
}