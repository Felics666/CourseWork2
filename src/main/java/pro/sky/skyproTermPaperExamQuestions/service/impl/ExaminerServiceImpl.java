package pro.sky.skyproTermPaperExamQuestions.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.skyproTermPaperExamQuestions.exception.BadRequestException;
import pro.sky.skyproTermPaperExamQuestions.model.Question;
import pro.sky.skyproTermPaperExamQuestions.service.api.ExaminerService;
import pro.sky.skyproTermPaperExamQuestions.service.api.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService service;

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > service.getAll().size()) {
            throw new BadRequestException("The question limit has been exceeded");
        }

        Set<Question> questions = new HashSet<>();
        while (amount > questions.size()) {
            questions.add(service.getRandomQuestion());
        }
        return questions;
    }
}
