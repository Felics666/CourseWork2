package pro.sky.skyproTermPaperExamQuestions.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproTermPaperExamQuestions.exception.BadRequestException;
import pro.sky.skyproTermPaperExamQuestions.model.Question;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionServiceImpl questionService;
    private final Question question = new Question(
            "What cycles do you know in java?", "for, while, do-while");
    private final Question question1 = new Question(
            "What is Java?", "A programming language");
    private final Question question2 = new Question(
            "What are collections in Java?",
            "These are data structures in Java designed to store and manage groups of objects.");

    @InjectMocks
    private ExaminerServiceImpl examinerService;


    @Test
    void getQuestion() {
        Mockito.when(questionService.getAll())
                        .thenReturn(Arrays.asList(question,question1,question2));

        Mockito.when(questionService.getRandomQuestion())
                .thenReturn(question, question1, question2);

        Collection<Question> questions = examinerService.getQuestion(3);

        assertTrue(questions.containsAll(Arrays.asList(question,question1,question2)));
    }

    @Test
    void getQuestionAmountToBig() {
       assertThrows(BadRequestException.class,()->examinerService.getQuestion(1));
    }
}