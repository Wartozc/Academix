package academix.com.co;


import academix.com.co.usecase.creator.CreatorUseCase;
import academix.com.co.usecase.deleter.DeleterUseCase;
import academix.com.co.usecase.lister.ListerUseCase;
import academix.com.co.usecase.updater.UpdaterUseCase;
import academix.com.co.util.BuilderServerRequest;
import academix.com.co.util.BuilderServerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {

    private final CreatorUseCase creatorUseCase;
    private final UpdaterUseCase updaterUseCase;
    private final ListerUseCase listerUseCase;
    private final DeleterUseCase deleterUseCase;

    public Mono<ServerResponse> createUser(ServerRequest serverRequest) {
        return BuilderServerRequest.buildRequestCreateUser(serverRequest)
                .flatMap(creatorUseCase::createUser)
                .flatMap(BuilderServerResponse::buildResponseCreateUser);
    }

    public Mono<ServerResponse> updateUser(ServerRequest serverRequest) {
        return BuilderServerRequest.buildRequestUpdateUser(serverRequest)
                .flatMap(updaterUseCase::updateUser)
                .flatMap(BuilderServerResponse::buildResponseUpdateUser);
    }

    public Mono<ServerResponse> listUsers(ServerRequest serverRequest) {
        return BuilderServerRequest.buildRequestListUser(serverRequest)
                .flatMap(userAdmin -> listerUseCase.listAllUsers(userAdmin).collectList())
                .flatMap(BuilderServerResponse::buildResponseListUsers);
    }

    public Mono<ServerResponse> deleteUser(ServerRequest serverRequest) {
        return BuilderServerRequest.buildRequestDeleteUser(serverRequest)
                .flatMap(deleterUseCase::deleteUser)
                .flatMap(BuilderServerResponse::buildResponseDeleteUser);
    }
}