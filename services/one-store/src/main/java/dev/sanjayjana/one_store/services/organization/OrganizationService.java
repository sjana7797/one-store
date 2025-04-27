package dev.sanjayjana.one_store.services.organization;

import dev.sanjayjana.one_store.entities.Organization;
import dev.sanjayjana.one_store.exceptions.NotFoundException;
import dev.sanjayjana.one_store.repositories.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationService implements IOrganizationService {

    private final OrganizationRepository organizationRepository;
    
    @Override
    public Organization getOrganization(String organizationId) {

        return organizationRepository.findById(organizationId)
                .orElseThrow(() -> new NotFoundException("Organization not found with id: " + organizationId));
    }
}
