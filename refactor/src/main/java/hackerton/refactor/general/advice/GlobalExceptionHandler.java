package hackerton.refactor.general.advice;

import hackerton.refactor.general.exception.CustomException;
import hackerton.refactor.general.response.ApiResponse;
import hackerton.refactor.general.util.StatusCodeHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse> handleCustomException(CustomException e) {
        StatusCodeHelper statusCodeHelper = StatusCodeHelper.of(e.getBadStatusCode());
        log.info("🚨 error 발생: ",e);
        log.info("🔎 stackTrace : {}",e.getStackTrace());
        return ResponseEntity
                .status(statusCodeHelper.getHttpStatus())
                .body(ApiResponse.fail(statusCodeHelper.getStatusValue(), statusCodeHelper.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleAllException(Exception e) {
        log.info("🚨 error 발생: ",e);
        log.info("🔎 stackTrace : {}",e.getStackTrace());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(),"서버 내부 오류가 발생 하였습니다 "));
    }

}
