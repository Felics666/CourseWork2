package pro.sky.skyproTermPaperExamQuestions.service.impl;

import org.springframework.boot.autoconfigure.graphql.reactive.GraphQlWebFluxAutoConfiguration;
import org.springframework.stereotype.Service;
import pro.sky.skyproTermPaperExamQuestions.exception.BadRequestException;
import pro.sky.skyproTermPaperExamQuestions.exception.QuestionNotFoundException;
import pro.sky.skyproTermPaperExamQuestions.model.Question;
import pro.sky.skyproTermPaperExamQuestions.service.api.QuestionService;

import java.util.*;
import java.util.function.Supplier;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

   private final Set<Question> questions = new HashSet<>();
   private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {

        return add(new Question(question,answer)) ;
    }

    @Override
    public Question add(Question question) {
        boolean isAdded = questions.add(question);
        if(!isAdded) {
            throw new BadRequestException("The question has already been added");
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return questions.stream()
                .skip(random.nextInt(questions.size()))
                        .findFirst()
                .orElseThrow(() -> new QuestionNotFoundException("The list of questions is empty"));

    }
}
