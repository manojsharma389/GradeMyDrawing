package application.com.model;


public class GetUserId {
    private String userRole;
    private String email;
    private String securityQuestion1;
    private String securityQuestion2;
    private String securityQuestion3;
    private String answerQuestion1;
    private String answerQuestion2;
    private String answerQuestion3;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityQuestion3() {
        return securityQuestion3;
    }

    public void setSecurityQuestion3(String securityQuestion3) {
        this.securityQuestion3 = securityQuestion3;
    }

    public String getAnswerQuestion1() {
        return answerQuestion1;
    }

    public void setAnswerQuestion1(String answerQuestion1) {
        this.answerQuestion1 = answerQuestion1;
    }

    public String getAnswerQuestion2() {
        return answerQuestion2;
    }

    public void setAnswerQuestion2(String answerQuestion2) {
        this.answerQuestion2 = answerQuestion2;
    }

    public String getAnswerQuestion3() {
        return answerQuestion3;
    }

    public void setAnswerQuestion3(String answerQuestion3) {
        this.answerQuestion3 = answerQuestion3;
    }
}
