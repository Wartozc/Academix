package academix.com.co.updater;

import academix.com.co.exception.BusinessException;
import academix.com.co.exception.message.BusinessExceptionMessage;
import academix.com.co.user.User;
import academix.com.co.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdaterUseCase {
    private final UserRepository userRepository;

    public Mono<User> updateUser(User user){
        return userRepository.updateUser(user)
                .onErrorResume(error -> Mono.defer(()->
                        Mono.error(new BusinessException(BusinessExceptionMessage.CAN_NOT_UPDATE_USER))));
    }
}
