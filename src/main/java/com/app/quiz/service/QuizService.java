package com.app.quiz.service;

import com.app.quiz.dto.QuestionDTO;
import com.app.quiz.model.Question;
import com.app.quiz.model.Quiz;
import com.app.quiz.model.Response;
import com.app.quiz.repo.QuestionRepo;
import com.app.quiz.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService
{
    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numOfQuestions, String title)
    {
        List<Question> questions = questionRepo.createQuizByCategory(category, numOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionDTO>> getQuestions(int id)
    {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for(Question q: questions)
        {
            QuestionDTO questionDTO = new QuestionDTO(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionDTOList.add(questionDTO);
        }

        return new ResponseEntity<>(questionDTOList, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateREsult(Integer id, List<Response> responses)
    {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        int result = 0, i = 0;

        for(Response response: responses)
        {
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                result++;
            i++;
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
