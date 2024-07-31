package org.quiz.quizapplication.Repository;

import org.quiz.quizapplication.Model.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoQus extends JpaRepository<Question, Integer> {
}
