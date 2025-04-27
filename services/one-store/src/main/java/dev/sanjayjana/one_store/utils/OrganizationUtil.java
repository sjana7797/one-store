package dev.sanjayjana.one_store.utils;


import dev.sanjayjana.one_store.entities.Organization;
import dev.sanjayjana.one_store.exceptions.UnAuthorizedException;
import dev.sanjayjana.one_store.repositories.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrganizationUtil {

    private final OrganizationRepository organizationRepository;

    public Organization getOrganization(String id) {
        return organizationRepository.findById(id).orElseThrow(UnAuthorizedException::new);
    }
}
