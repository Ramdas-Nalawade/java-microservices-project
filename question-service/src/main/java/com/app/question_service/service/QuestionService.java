package com.app.question_service.service;

import com.app.question_service.model.Question;
import com.app.question_service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService
{
    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> findAll()
    {
        try
        {
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> findByCategory(String type)
    {
        try
        {
            return new ResponseEntity<>(questionRepo.findByCategory(type), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question)
    {
        try
        {
            questionRepo.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed to add question.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(int id)
    {
        try
        {
            Optional<Question> question = questionRepo.findById(id);
            if(question.isPresent())
            {
                questionRepo.deleteById(id);
                return new ResponseEntity<>("Question deleted", HttpStatus.OK);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> updateQuestion(int id, Question updatedQuestion)
    {
        try
        {
            Optional<Question> question = questionRepo.findById(id);
            if(question.isPresent())
            {
                Question q = question.get();
                q.setQuestionTitle(updatedQuestion.getQuestionTitle());
                q.setCategory(updatedQuestion.getCategory());
                q.setDifficultyLevel(updatedQuestion.getDifficultyLevel());
                q.setOption1(updatedQuestion.getOption1());
                q.setOption2(updatedQuestion.getOption2());
                q.setOption3(updatedQuestion.getOption3());
                q.setOption4(updatedQuestion.getOption4());
                q.setRightAnswer(updatedQuestion.getRightAnswer());

                questionRepo.save(q);
                return new ResponseEntity<String>("Question updated", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<String>("Question not found", HttpStatus.NOT_FOUND);
    }
}