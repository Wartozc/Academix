package academix.com.co.dbo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    public String getSuperUser() {
        return adminId;
    }

    @DynamoDbSortKey
    public String getUserId() {
        return id;
    }
}
