package org.quiz.quizapplication.Repository;

import org.quiz.quizapplication.Model.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoAns extends JpaRepository<Answer, Integer> {
}
