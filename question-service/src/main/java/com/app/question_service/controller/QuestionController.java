package com.app.question_service.controller;

import com.app.question_service.model.Question;
import com.app.question_service.model.QuestionWrapper;
import com.app.question_service.model.Response;
import com.app.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz
            (@RequestParam String category, @RequestParam Integer numQ)
    {
        return questionService.generateQuestions(category, numQ);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId
            (@RequestBody List<Integer> questionIds)
    {
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore
                (@RequestBody List<Response> responses)
    {
        return questionService.calculateScore(responses);
    }
}