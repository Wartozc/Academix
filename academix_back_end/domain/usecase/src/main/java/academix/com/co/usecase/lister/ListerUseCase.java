package academix.com.co.usecase.lister;

import academix.com.co.exception.BusinessException;
import academix.com.co.exception.message.BusinessExceptionMessage;
import academix.com.co.user.User;
import academix.com.co.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ListerUseCase {

    private final UserRepository userRepository;

    public Flux<User> listAllUsers(String adminId){
        return userRepository.listAllUsers(adminId)
                .onErrorResume(error -> Mono.defer(()->
                        Mono.error(new BusinessException(BusinessExceptionMessage.CAN_NOT_LIST_ALL_USER))));
    }
}
