package hackerton.refactor.general.advice;

import hackerton.refactor.general.exception.CustomException;
import hackerton.refactor.general.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleCustomException(CustomException e) {
        return ResponseEntity
                .status(e.getBadStatusCode().getHttpStatus())
                .body(ApiResponse.fail(e.getBadStatusCode().getHttpStatus().value(), e.getMessage()));
    }

}
