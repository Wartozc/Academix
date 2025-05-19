package academix.com.co.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "user-router.routes")
@Getter
@Setter
public class UserRouterConfig {
    private String create;
    private String update;
    private String delete;
    private String list;
}