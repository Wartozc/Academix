package academix.com.co.openapi;

import academix.com.co.dto.UserDTO;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.experimental.UtilityClass;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.http.HttpStatus;

@UtilityClass
public class UserOpenApi {
    public Builder buildCreateUser(Builder builder) {
        return builder.operationId("Crear usuario").parameter(org.springdoc.core.fn.builders.parameter.Builder
                        .parameterBuilder().required(true).example("2315615616")
                        .name("document-number").in(ParameterIn.HEADER))
                .requestBody(org.springdoc.core.fn.builders.requestbody.Builder.requestBodyBuilder()
                        .content(org.springdoc.core.fn.builders.content.Builder.contentBuilder()
                                .mediaType("application/json")
                                .schema(org.springdoc.core.fn.builders
                                        .schema.Builder.schemaBuilder()
                                        .description("El cuerpo de la petición")
                                        .implementation(UserDTO.class))))
                .response(org.springdoc.core.fn.builders.apiresponse.Builder
                        .responseBuilder().responseCode(HttpStatus.CREATED.toString())
                        .content(org.springdoc.core.fn.builders.content.Builder.contentBuilder()
                                .mediaType("application/json")
                                .schema(org.springdoc.core.fn.builders.schema.Builder.schemaBuilder()
                                        .implementation(UserDTO.class).description("Respuesta de la petición"))));
    }

    public Builder buildUpdateUser(Builder builder) {
        return builder.operationId("Actualizar usuario");
    }

    public Builder buildListUsers(Builder builder) {
        return builder.operationId("Listar usuarios");
    }

    public Builder buildDeleteUser(Builder builder) {
        return builder.operationId("Eliminar usuario usuarios");
    }
}