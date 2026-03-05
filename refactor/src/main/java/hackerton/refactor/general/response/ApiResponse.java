package hackerton.refactor.general.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success(int code, String message , T data) {
        return new ApiResponse<>(true, code, message, data);
    }

    public static ApiResponse<?> fail(int code, String message) {
        return new ApiResponse<>(false, code, message, null);
    }
}
