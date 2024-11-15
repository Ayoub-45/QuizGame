import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class QuizServer {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        int port = 12345; // Server port
        List<QuizQuestion> quizList = prepareQuiz();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Quiz server is running on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                    try (ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) {
                        oos.writeObject(quizList);
                        System.out.println("Quiz list sent to client.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<QuizQuestion> prepareQuiz() {
        // Sample data
        List<QuizQuestion> quizList = new ArrayList<>();
        quizList.add(new QuizQuestion(
                "Which programming language is platform-independent?",
                new String[] { "A. Java", "B. Python", "C. C++", "D. JavaScript" },
                "A. Java"));
        quizList.add(new QuizQuestion(
                "What does OOP stand for?",
                new String[] { "A. Object-Oriented Programming", "B. Overhead Operations Processing",
                        "C. Open Office Protocol", "D. Optimized Output Production" },
                "A. Object-Oriented Programming"));
        quizList.add(new QuizQuestion(
                "Which company developed Java?",
                new String[] { "A. Microsoft", "B. Sun Microsystems", "C. Oracle", "D. IBM" },
                "B. Sun Microsystems"));

        return quizList;
    }
}
