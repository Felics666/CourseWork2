package pro.sky.skyproTermPaperExamQuestions.service.impl;

import org.junit.jupiter.api.Test;
import pro.sky.skyproTermPaperExamQuestions.exception.BadRequestException;
import pro.sky.skyproTermPaperExamQuestions.model.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceImplTest {

    private final JavaQuestionServiceImpl questionService = new JavaQuestionServiceImpl();
    private final Question question = new Question
            ("What cycles do you know in java?", "for, while, do-while");

    @Test
    void add() {
        assertTrue(questionService.getAll().isEmpty());

        questionService.add(question);

        assertFalse(questionService.getAll().isEmpty());
    }

    @Test
    void addAlreadyExists() {
        questionService.add(question);

        assertFalse(questionService.getAll().isEmpty());
        assertThrows(BadRequestException.class, () -> questionService.add(question));
    }

    @Test
    void remove() {
        questionService.add(question);

        assertFalse(questionService.getAll().isEmpty());
        questionService.remove(question);

        assertTrue(questionService.getAll().isEmpty());
    }

    @Test
    void getAll() {
        questionService.add(question);
        Collection<Question> all = questionService.getAll();

        assertFalse(all.isEmpty());
        assertTrue(all.contains(question));
    }

    @Test
    void getRandomQuestion() {
        questionService.add(question);
        Question randomQuestion = questionService.getRandomQuestion();

        assertEquals(question, randomQuestion);
    }

}