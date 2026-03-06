package hackerton.refactor.general.exception;


import hackerton.refactor.general.enums.BadStatusCode;

public class NotFoundException extends CustomException {
    public NotFoundException(BadStatusCode badStatusCode) {
        super(badStatusCode);
    }
}
