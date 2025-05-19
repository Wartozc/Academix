package academix.com.co.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages = "academix.com.co.usecase", includeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "[^.+UseCase$]")
}, useDefaultFilters = false)
public class UseCaseConfig {
}
