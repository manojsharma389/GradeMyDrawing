package application.com.model;

import java.io.Serializable;

public class AuthenticationResponseModel implements Serializable {
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
