package academix.com.co.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String documentType;
    private String documentNumber;
    private String age;
    private String email;
    private String password;
    private String rol;
}