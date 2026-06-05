package com.app.quiz.repo;

import com.app.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>
{
    List<Question> findByCategory(String type);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numOfQuestions", nativeQuery = true)
    List<Question> createQuizByCategory(@Param("category") String category,@Param("numOfQuestions") int numOfQuestions);
}