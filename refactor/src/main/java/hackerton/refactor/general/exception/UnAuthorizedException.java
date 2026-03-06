package hackerton.refactor.general.exception;


import hackerton.refactor.general.enums.BadStatusCode;

public class UnAuthorizedException extends CustomException {
    public UnAuthorizedException(BadStatusCode badStatusCode) {
        super(badStatusCode);
    }
}
