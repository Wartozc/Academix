package academix.com.co;

import academix.com.co.dbo.UserDBO;
import academix.com.co.user.User;
import academix.com.co.user.gateways.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

@Component
public class DynamoDbAdapter implements UserRepository {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ModelMapper modelMapper;
    private final DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient;
    private final DynamoDbAsyncTable<UserDBO> dynamoDbAsyncTable;
    private final String adminIdValue;

    public DynamoDbAdapter(DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient,
                           @Value("${app.adapters.dynamodb.table-name}") String tableName,
                           @Value("${app.adapters.dynamodb.admin-id}") String adminId) {
        this.modelMapper = new ModelMapper();
        this.dynamoDbEnhancedAsyncClient = dynamoDbEnhancedAsyncClient;
        this.dynamoDbAsyncTable = dynamoDbEnhancedAsyncClient.table(tableName, TableSchema.fromBean(UserDBO.class));
        this.adminIdValue = adminId;
    }


    @Override
    public Mono<User> createUser(User user) {
        return Mono.fromFuture(dynamoDbAsyncTable.putItem(getUserDao(user)))
                .doOnSuccess(isOk -> logger.info("User created"))
                .thenReturn(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return Mono.fromFuture(dynamoDbAsyncTable.putItem(getUserDao(user)))
                .doOnSuccess(isOk -> logger.info("User Updated"))
                .thenReturn(user);
    }

    @Override
    public Flux<User> listAllUsers(String adminId) {
        var pagePublisher = dynamoDbAsyncTable.query(getQuery(adminId));
        return Flux.from(pagePublisher.items().map(userDAO -> modelMapper.map(userDAO, User.class)))
                .doOnComplete(() -> logger.info("Users Listed"));
    }

    @Override
    public Mono<Boolean> deleteUser(String userId) {
        return Mono.fromFuture(dynamoDbAsyncTable.deleteItem(Key.builder()
                        .partitionValue(this.adminIdValue).sortValue(userId).build()))
                .doOnSuccess(isOk -> logger.info("User deleted"))
                .thenReturn(Boolean.TRUE);
    }

    private UserDBO getUserDao(User user) {
        var userDBO = modelMapper.map(user, UserDBO.class);
        userDBO.setAdminId(this.adminIdValue);
        return userDBO;
    }

    private QueryEnhancedRequest getQuery(String partitionKey) {
        return QueryEnhancedRequest.builder()
                .queryConditional(QueryConditional.sortGreaterThan(Key.builder()
                        .partitionValue(partitionKey).sortValue("\u0000").build()))
                .build();
    }
}