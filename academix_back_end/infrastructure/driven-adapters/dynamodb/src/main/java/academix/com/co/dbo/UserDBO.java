package academix.com.co.dbo;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@AllArgsConstructor
@DynamoDbBean
@Setter
@Getter
@NoArgsConstructor
public class UserDBO {

    private String id;
    private String name;
    private String documentType;
    private String documentNumber;
    private String age;
    private String email;
    private String password;
    private String rol;
    private String adminId;

    @DynamoDbPartitionKey
    public String getAdminId() {
        return adminId;
    }

    @DynamoDbSortKey
    public String getId() {
        return id;
    }
}
