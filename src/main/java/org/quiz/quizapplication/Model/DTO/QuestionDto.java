package org.quiz.quizapplication.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.quiz.quizapplication.Model.Entity.Answer;
import org.quiz.quizapplication.Model.Entity.Question;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class QuestionDto {

        private Integer QueId;
        private String questionText;
        private String category;
        private String difficulty;
        private List<AnswerDto> answers;

    }
