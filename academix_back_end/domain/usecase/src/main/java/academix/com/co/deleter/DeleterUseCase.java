package academix.com.co.deleter;

import academix.com.co.exception.BusinessException;
import academix.com.co.exception.message.BusinessExceptionMessage;
import academix.com.co.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleterUseCase {
    private final UserRepository userRepository;

    public Mono<Boolean> deleteUser(String userId){
        return userRepository.deleteUser(userId)
                .onErrorResume(error -> Mono.defer(()->
                        Mono.error(new BusinessException(BusinessExceptionMessage.CAN_NOT_DELETE_USER))));
    }
}
