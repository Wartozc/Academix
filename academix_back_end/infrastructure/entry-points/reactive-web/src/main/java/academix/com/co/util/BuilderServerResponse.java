package academix.com.co.util;

import academix.com.co.user.User;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@UtilityClass
public class BuilderServerResponse {
    public Mono<ServerResponse> buildResponseCreateUser(User user) {
        return ServerResponse.status(HttpStatus.CREATED).bodyValue(cipherUser(user));
    }

    public Mono<ServerResponse> buildResponseUpdateUser(User user) {
        return ServerResponse.status(HttpStatus.OK).bodyValue(cipherUser(user));
    }


    public Mono<ServerResponse> buildResponseListUsers(List<User> users) {
        return ServerResponse.status(HttpStatus.OK).bodyValue(users.stream()
                .map(BuilderServerResponse::cipherUser).toList());
    }

    public Mono<ServerResponse> buildResponseDeleteUser(Boolean isOk) {
        return ServerResponse.status(HttpStatus.OK).bodyValue(isOk);
    }

    private User cipherUser(User user) {
        return user.toBuilder().password("********").build();
    }
}
