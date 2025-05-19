package academix.com.co.exception;

import academix.com.co.exception.message.BusinessExceptionMessage;

public class BusinessException extends RuntimeException{

    public BusinessException(BusinessExceptionMessage businessExceptionMessage) {
        super(businessExceptionMessage.getMessage());
    }
}
