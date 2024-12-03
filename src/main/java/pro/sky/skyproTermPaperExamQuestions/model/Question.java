package pro.sky.skyproTermPaperExamQuestions.model;


import lombok.*;

@Data
@EqualsAndHashCode(of = "question")
@NoArgsConstructor
@AllArgsConstructor

public class Question {

    private String question;
    private String answer;
}
