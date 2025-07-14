package com.ktech.user.service.UserService.payload;
import lombok.*;
import org.springframework.http.HttpStatus;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
