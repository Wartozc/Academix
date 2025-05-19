package academix.com.co.creator;

import academix.com.co.exception.BusinessException;
import academix.com.co.exception.message.BusinessExceptionMessage;
import academix.com.co.user.User;
import academix.com.co.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreatorUseCase {
    private final UserRepository userRepository;

    public Mono<User> createUser(User user){
        return userRepository.createUser(user)
                .onErrorResume(error -> Mono.defer(()->
                        Mono.error(new BusinessException(BusinessExceptionMessage.CAN_NOT_CREATE_USER))));
    }
}
