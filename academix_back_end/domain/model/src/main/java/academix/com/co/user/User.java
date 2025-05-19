package academix.com.co.user;

import lombok.Builder;

@Builder(toBuilder = true)
public record User(String id,String name, String documentType, String documentNumber, String age,
                   String email, String password, Rol rol) {
}
