package org.quiz.quizapplication.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.quiz.quizapplication.Model.Entity.Answer;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
    public  class AnswerDto {
        private Integer AnsId;
        private String choiceText;
        private boolean correct;
        private Integer QueId;


    }
