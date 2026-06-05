package com.app.quiz.controller;

import com.app.quiz.dto.QuestionDTO;
import com.app.quiz.model.Response;
import com.app.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController
{
    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numOfQuestions,
                                             @RequestParam String title)
    {
        return quizService.createQuiz(category, numOfQuestions, title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionDTO>> getQuizQuestions(@PathVariable int id)
    {
        return quizService.getQuestions(id);
    }

    @PostMapping("/result/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.calculateREsult(id, responses);
    }
}