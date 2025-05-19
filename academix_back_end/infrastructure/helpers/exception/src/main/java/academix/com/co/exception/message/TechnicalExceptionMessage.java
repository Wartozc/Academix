package academix.com.co.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TechnicalExceptionMessage {
    UN_EXPECTED_EXCEPTION("TEA0001", "Un un-expected exception was presented");

    private final String code;
    private final String description;
}
