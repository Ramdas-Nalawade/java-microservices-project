package com.app.quiz.service;

import com.app.quiz.model.Question;
import com.app.quiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    @Autowired
    private QuestionRepo questionRepo;

    public List<Question> findAll()
    {
        return questionRepo.findAll();
    }
}