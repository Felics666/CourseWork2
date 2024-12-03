package pro.sky.skyproTermPaperExamQuestions.service.api;

import org.springframework.stereotype.Service;
import pro.sky.skyproTermPaperExamQuestions.model.Question;

import java.util.Collection;


public interface ExaminerService {

    Collection<Question> getQuestion(int amount);

}
