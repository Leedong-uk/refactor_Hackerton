package hackerton.refactor.general.exception;


import hackerton.refactor.general.enums.BadStatusCode;

public class BadRequestException extends CustomException {
    public BadRequestException(BadStatusCode badStatusCode) {
        super(badStatusCode);
    }
}
