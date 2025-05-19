package academix.com.co.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BusinessExceptionMessage {

    UN_EXPECTED_ERROR("UB0001", "An un-expected error was presented"),
    CAN_NOT_CREATE_USER("UB0002", "Can not to create the requested user, an error was presented"),
    CAN_NOT_UPDATE_USER("UB0003", "Can not to update the requested user, an error was presented"),
    CAN_NOT_LIST_ALL_USER("UB0004", "Can not to list the all requested users, an error was presented"),
    CAN_NOT_DELETE_USER("UB0005", "Can not to delete the requested user, an error was presented");

    private final String code;
    private final String message;
}
