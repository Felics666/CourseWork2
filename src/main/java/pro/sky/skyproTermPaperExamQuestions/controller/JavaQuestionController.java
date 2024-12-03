package pro.sky.skyproTermPaperExamQuestions.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproTermPaperExamQuestions.model.Question;
import pro.sky.skyproTermPaperExamQuestions.service.api.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
@RequiredArgsConstructor
public class JavaQuestionController {

    private final QuestionService questionService;

    @RequestMapping("/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @RequestMapping("/all")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @RequestMapping ("/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

}
