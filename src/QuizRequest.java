import java.io.Serializable;

public class QuizRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String requestType;

    public QuizRequest(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        return "QuizRequest{" +
                "requestType=" + requestType + '\'' +
                "}";
    }
}
