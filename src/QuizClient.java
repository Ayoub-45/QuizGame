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
            System.out.println("Connected to the server. Quiz received:");

            // Initialize variables for scoring
            int score = 0;
            Scanner scanner = new Scanner(System.in);

            // Iterate through the quiz questions
            for (QuizQuestion question : quizList) {
                System.out.println("\n" + question.getQuestionText());
                String[] options = question.getOptions();

                // Display options
                for (String option : options) {
                    System.out.println(option);
                }

                // Accept user's answer
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine().trim();

                // Check if the answer is correct
                if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer().substring(0, 1))) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was: " + question.getCorrectAnswer());
                }
            }

            // Display the final score
            System.out.println("\nQuiz finished! Your score: " + score + "/" + quizList.size());

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error processing data from server: " + e.getMessage());
        }
    }
}
