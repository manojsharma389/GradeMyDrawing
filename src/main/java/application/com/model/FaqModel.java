package application.com.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FaqModel implements Serializable {
    @NotNull(message = "Faq Id can not be empty")
    private int faqId;
    private String question;
    private String answer;

    public int getFaqId() {
        return faqId;
    }

    public void setFaqId(int faqId) {
        this.faqId = faqId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
