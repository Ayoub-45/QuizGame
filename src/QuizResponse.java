
import java.io.Serializable;
import java.util.ArrayList;

public class QuizResponse implements Serializable {
    private ArrayList<QuizQuestion> quizQuestions;
    private int score;
    private String feedback;

    public QuizResponse(ArrayList<QuizQuestion> quizQuestions, int score, String feedback) {
        this.quizQuestions = quizQuestions;
        this.score = score;
        this.feedback = feedback;
    }

    public String getFeedback() {
        return feedback;
    }

    public ArrayList<QuizQuestion> getQuizQuestions() {
        return quizQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "QuizResponse{" +
                "quizQuestions=" + quizQuestions +
                ", score=" + score +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
