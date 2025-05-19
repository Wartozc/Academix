package academix.com.co.openapi;

import academix.com.co.dto.UserDTO;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.experimental.UtilityClass;
import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.http.HttpStatus;

import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;
import static org.springdoc.core.fn.builders.content.Builder.contentBuilder;
import static org.springdoc.core.fn.builders.parameter.Builder.parameterBuilder;
import static org.springdoc.core.fn.builders.requestbody.Builder.requestBodyBuilder;
import static org.springdoc.core.fn.builders.schema.Builder.schemaBuilder;

@UtilityClass
public class UserOpenApi {
    public Builder buildCreateUser(Builder builder) {
        return builder.operationId("crearUsuario")
                .summary("Crear un nuevo usuario")
                .parameter(parameterBuilder()
                        .name("document-number")
                        .in(ParameterIn.HEADER)
                        .required(true)
                        .example("2315615616"))
                .requestBody(requestBodyBuilder()
                        .description("Cuerpo con la información del usuario a crear")
                        .content(contentBuilder()
                                .mediaType("application/json")
                                .schema(schemaBuilder()
                                        .implementation(UserDTO.class))))
                .response(responseBuilder()
                        .responseCode(String.valueOf(HttpStatus.CREATED.value()))
                        .description("Usuario creado exitosamente")
                        .content(contentBuilder()
                                .mediaType("application/json")
                                .schema(schemaBuilder()
                                        .implementation(UserDTO.class))));
    }

    public Builder buildUpdateUser(Builder builder) {
        return builder.operationId("actualizarUsuario")
                .summary("Actualizar un usuario existente")
                .parameter(parameterBuilder()
                        .name("id")
                        .in(ParameterIn.PATH)
                        .required(true)
                        .description("ID del usuario a actualizar")
                        .example("54133e25-8207-4746-ad8e-ec6831b531a5"))
                .requestBody(requestBodyBuilder()
                        .description("Datos para actualizar el usuario")
                        .content(contentBuilder()
                                .mediaType("application/json")
                                .schema(schemaBuilder()
                                        .implementation(UserDTO.class))))
                .response(responseBuilder()
                        .responseCode(String.valueOf(HttpStatus.OK.value()))
                        .description("Usuario actualizado correctamente")
                        .content(contentBuilder()
                                .mediaType("application/json")
                                .schema(schemaBuilder()
                                        .implementation(UserDTO.class))));
    }

    public Builder buildListUsers(Builder builder) {
        return builder.operationId("listarUsuarios")
                .summary("Listar todos los usuarios (requiere header de admin)")
                .parameter(parameterBuilder()
                        .name("user-admin")
                        .in(ParameterIn.HEADER)
                        .required(true)
                        .description("Token o identificador de admin")
                        .example("admin123456789"))
                .response(responseBuilder()
                        .responseCode(String.valueOf(HttpStatus.OK.value()))
                        .description("Lista de usuarios")
                        .content(contentBuilder()
                                .mediaType("application/json")
                                .schema(schemaBuilder()
                                        .implementation(UserDTO[].class))));
    }

    public Builder buildDeleteUser(Builder builder) {
        return builder.operationId("eliminarUsuario")
                .summary("Eliminar un usuario por ID")
                .parameter(parameterBuilder()
                        .name("id")
                        .in(ParameterIn.PATH)
                        .required(true)
                        .description("ID del usuario a eliminar")
                        .example("5ac1a96b-2320-4851-aad0-49e2ccbe5759"))
                .response(responseBuilder()
                        .responseCode(String.valueOf(HttpStatus.NO_CONTENT.value()))
                        .description("Usuario eliminado correctamente sin contenido en la respuesta"));
    }
}