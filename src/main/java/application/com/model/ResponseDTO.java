package application.com.model;

import java.util.List;

public class ResponseDTO<T> {
    private Boolean status;
    private String message;
    private List<ErrorDTO> errors;
    private T data;

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
