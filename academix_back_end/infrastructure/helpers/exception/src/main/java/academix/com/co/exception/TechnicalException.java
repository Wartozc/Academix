package academix.com.co.exception;

import academix.com.co.exception.message.TechnicalExceptionMessage;

public class TechnicalException extends RuntimeException{

    public TechnicalException(TechnicalExceptionMessage technicalExceptionMessage) {
        super(technicalExceptionMessage.getDescription());
    }
}
