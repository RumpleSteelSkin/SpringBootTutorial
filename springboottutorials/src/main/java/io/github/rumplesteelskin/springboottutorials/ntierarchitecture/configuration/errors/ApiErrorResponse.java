package io.github.rumplesteelskin.springboottutorials.ntierarchitecture.configuration.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiErrorResponse {
    private ErrorBody error;

    @Data
    @AllArgsConstructor
    public static class ErrorBody {
        private List<ErrorDetail> errors;
        private int code;
        private String message;
    }

    @Data
    @AllArgsConstructor
    public static class ErrorDetail {
        private String domain;
        private String reason;
        private String message;
        private String locationType;
        private String location;
    }
}