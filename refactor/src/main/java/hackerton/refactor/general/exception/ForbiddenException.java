package hackerton.refactor.general.exception;


import hackerton.refactor.general.enums.BadStatusCode;

public class ForbiddenException extends CustomException {
    public ForbiddenException(BadStatusCode badStatusCode) {
        super(badStatusCode);
    }
}
