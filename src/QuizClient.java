import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class QuizClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Address of the server
        int port = 12345; // Port number of the server

        try (Socket socket = new Socket(serverAddress, port);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

            // Receive the quiz list from the server
            @SuppressWarnings("unchecked")
            List<QuizQuestion> quizList = (List<QuizQuestion>) ois.readObject();
            System.out.println("Connected to the server. Get Quiz (Quiz received !)");
            int score = 0;
            Scanner scanner = new Scanner(System.in);

            for (QuizQuestion question : quizList) {
                System.out.println("\n" + question.getQuestionText());
                String[] options = question.getOptions();
                for (String option : options) {
                    System.out.println(option);
                }
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine().trim();
                if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer().substring(0, 1))) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was: " + question.getCorrectAnswer());
                }
            }
            System.out.println("\nQuiz finished! Your score: " + score + "/" + quizList.size());
            feedback(score);

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error processing data from server: " + e.getMessage());
        }
    }

    private static void feedback(int score) {
        switch (score) {
            case 0:
                System.out.println("bad result , perhaps you're not familiar with these concepts!");
                break;
            case 1:
                System.out.println("Not good enough! But you can improve with time.");
                break;
            case 2:
                System.out.println("Keep going you're doing a great job !");
                break;
            case 3:
                System.out.println("Excellent, you're shinning !");
                break;
            default:
                System.out.println("No score provided");
                break;
        }

    }
}
