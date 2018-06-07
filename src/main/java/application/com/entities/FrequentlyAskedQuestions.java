package application.com.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "faq_tbl")
public class FrequentlyAskedQuestions implements Serializable {

    public FrequentlyAskedQuestions(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faq_rec_id", nullable = false)
    private int recId;

    @Column(name = "faq_id", unique = true)
    private int faqId;

    @Column(name = "question")
    private String question;

    @Column(name = "answer")
    private String answer;

    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public int getFaqId() {
        return faqId;
    }

    public void setFaqId(int fadId) {
        this.faqId = fadId;
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
