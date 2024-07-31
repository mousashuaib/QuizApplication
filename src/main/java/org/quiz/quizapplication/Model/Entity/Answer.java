package org.quiz.quizapplication.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Answers")
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AnsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QueId", nullable = false)
    @JsonBackReference
    private Question question;

    @Column(name = "choiceText", nullable = false)
    private String choiceText;

    @Column(name = "correct", nullable = false)
    private boolean correct;
}
