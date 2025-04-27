package dev.sanjayjana.one_store.configuration;

import dev.sanjayjana.one_store.enums.route.ProductRoute;
import dev.sanjayjana.one_store.interceptors.OrganizationCheckInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final OrganizationCheckInterceptor organizationCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<>();
        patterns.add(ProductRoute.ALL_ROUTE_REGEX);
        registry.addInterceptor(organizationCheckInterceptor).addPathPatterns(patterns);
    }
}
