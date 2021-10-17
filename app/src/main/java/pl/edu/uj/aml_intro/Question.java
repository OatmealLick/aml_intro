package pl.edu.uj.aml_intro;

import java.util.Arrays;
import java.util.Objects;

class Question {
    private final String ultimateQuestion;
    private final String[] answers;
    private final int[] correctAnswers;

    public Question(String ultimateQuestion, String[] answers, int[] correctAnswers) {
        this.ultimateQuestion = ultimateQuestion;
        this.answers = answers;
        this.correctAnswers = correctAnswers;
    }

    public String getUltimateQuestion() {
        return ultimateQuestion;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int[] getCorrectAnswers() {
        return correctAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(ultimateQuestion, question.ultimateQuestion) && Arrays.equals(answers, question.answers) && Arrays.equals(correctAnswers, question.correctAnswers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ultimateQuestion);
        result = 31 * result + Arrays.hashCode(answers);
        result = 31 * result + Arrays.hashCode(correctAnswers);
        return result;
    }
}
