package org.quiz.quizapplication.QuizServices;

import org.quiz.quizapplication.Model.DTO.AnswerDto;
import org.quiz.quizapplication.Model.DTO.QuestionDto;
import org.quiz.quizapplication.Model.Entity.Answer;
import org.quiz.quizapplication.Model.Entity.Question;
import org.quiz.quizapplication.Repository.RepoQus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuesServices {
    @Autowired
    private RepoQus repo;

    public List<QuestionDto> getAllQustion() {
        List<Question> questions = repo.findAll();
        return questions.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public QuestionDto getQuestion(Integer id) {
        return repo.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public Question addQuestion(QuestionDto questionDto) {
        Question question = toEntity(questionDto);
        return repo.save(question);
    }

    public QuestionDto update(QuestionDto questionDto) {
        Question question = toEntity(questionDto);
        return toDTO(repo.save(question));
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    // Convert entity to DTO
    private QuestionDto toDTO(Question question) {
        QuestionDto questionDTO = new QuestionDto();
        questionDTO.setQueId(question.getQueId());
        questionDTO.setQuestionText(question.getQuestionText());
        questionDTO.setCategory(question.getCategory());
        questionDTO.setDifficulty(question.getDifficulty().name());
        questionDTO.setAnswers(question.getAnswers().stream()
                .map(this::toAnswerDTO)
                .collect(Collectors.toList()));
        return questionDTO;
    }


    private Question toEntity(QuestionDto questionDto) {
        System.out.println("Converting QuestionDto to Entity: " + questionDto);
        Question question = new Question();
        question.setQuestionText(questionDto.getQuestionText());
        question.setCategory(questionDto.getCategory());
        question.setDifficulty(Question.Difficulty.valueOf(questionDto.getDifficulty()));

        List<Answer> answers = questionDto.getAnswers().stream()
                .map(answerDto -> {
                    System.out.println("Ans Dto to Entity " + answerDto); // Debugging line
                    Answer answer = new Answer();
                    answer.setChoiceText(answerDto.getChoiceText());
                    answer.setCorrect(answerDto.isCorrect()); // Ensure this is correctly set
                    answer.setQuestion(question);
                    return answer;
                })
                .collect(Collectors.toList());

        question.setAnswers(answers);
        return question;
    }



    private AnswerDto toAnswerDTO(Answer answer) {
        AnswerDto answerDTO = new AnswerDto();
        answerDTO.setAnsId(answer.getAnsId());
        answerDTO.setChoiceText(answer.getChoiceText());
        answerDTO.setCorrect(answer.isCorrect());
        return answerDTO;
    }

    private Answer toEntity2(AnswerDto answerDto, Question question) {
        Answer answer = new Answer();
        answer.setChoiceText(answerDto.getChoiceText());
        answer.setCorrect(answerDto.isCorrect());
        answer.setQuestion(question);
        return answer;
    }

}
