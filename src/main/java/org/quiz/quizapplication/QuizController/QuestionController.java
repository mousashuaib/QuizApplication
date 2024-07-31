package org.quiz.quizapplication.QuizController;

import org.quiz.quizapplication.Model.DTO.QuestionDto;
import org.quiz.quizapplication.Model.Entity.Question;
import org.quiz.quizapplication.QuizServices.QuesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
public class QuestionController {

    @Autowired
    private QuesServices quesServices;

    @GetMapping("/getAll")
    public List<QuestionDto> getAllQustion() {
        return quesServices.getAllQustion();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<QuestionDto> getQustion(@PathVariable Integer id) {
        QuestionDto questionDto = quesServices.getQuestion(id);
        if (questionDto != null) {
            return ResponseEntity.ok(questionDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/AddQuestion")
    public ResponseEntity<Question> AddQuestion(@RequestBody QuestionDto questionDto) {
        Question savedQuestion = quesServices.addQuestion(questionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestion);
    }

    @PostMapping("/update")
    public QuestionDto Update(@RequestBody QuestionDto qustionto){
        return quesServices.update(qustionto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Integer id) {
        quesServices.delete(id);
    }
}
