package pro.sky.skyproTermPaperExamQuestions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproTermPaperExamQuestions.model.Question;
import pro.sky.skyproTermPaperExamQuestions.service.api.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class ExamController {
    private final ExaminerService examinerService;

    @GetMapping("/exam")
    public Collection<Question> getQuestions(@RequestParam int amount){
        return examinerService.getQuestion(amount);
    }
}
