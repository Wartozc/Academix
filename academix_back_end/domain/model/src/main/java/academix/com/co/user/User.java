package academix.com.co.user;


import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
    private String id;
    private String name;
    private String documentType;
    private String documentNumber;
    private String age;
    private String email;
    private String password;
    private Rol rol;
}
