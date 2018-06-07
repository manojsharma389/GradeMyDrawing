package application.com.model;

import javax.validation.constraints.NotNull;

public class ForgotUserIdModel {

    @NotNull(message = "Email Id can not be blank")
    private String email;

    @NotNull(message = "User Type can not be blank")
    private String userType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
