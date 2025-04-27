package dev.sanjayjana.one_store.interceptors;

import dev.sanjayjana.one_store.exceptions.BadRequestException;
import dev.sanjayjana.one_store.utils.OrganizationUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@AllArgsConstructor
public class OrganizationCheckInterceptor implements HandlerInterceptor {

    private final OrganizationUtil organizationUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String organizationId = request.getParameter("organizationId");
        if (organizationId == null || organizationId.isEmpty()) {
            throw new BadRequestException("organization id is required");
        }

        organizationUtil.getOrganization(organizationId);

        return true;
    }
}
