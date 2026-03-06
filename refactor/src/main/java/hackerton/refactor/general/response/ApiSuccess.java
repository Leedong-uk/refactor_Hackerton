package hackerton.refactor.general.response;

import org.springframework.http.HttpStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiSuccess {
    HttpStatus statusCode() default HttpStatus.OK;
    String message() default "요청에 성공 했습니다.";

}
