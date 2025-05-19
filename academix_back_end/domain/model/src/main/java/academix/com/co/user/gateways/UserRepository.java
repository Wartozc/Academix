package academix.com.co.user.gateways;

import academix.com.co.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Flux<User> listAllUsers(String adminId);
    Mono<User> createUser(User user);
    Mono<User> updateUser(User user);
    Mono<Boolean> deleteUser(String userId);
}
