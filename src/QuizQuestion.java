
import java.io.Serializable;
import java.util.Arrays;

public class QuizQuestion implements Serializable {
    private String questionText;
    private String[] options;
    private String correctAnswer;

    public QuizQuestion(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String[] getOptions() {
        return options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "questionText='" + questionText + '\'' +
                ", options=" + Arrays.toString(options) +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}
