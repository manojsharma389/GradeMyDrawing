package application.com.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class AuthenticationModel implements Serializable {

    @NotEmpty(message = "User Id can not be empty")
    private String userId;
    @NotEmpty(message = "Password can not be empty")
    private String password;
    @NotEmpty(message = "User Type can not be empty")
    private String userType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
