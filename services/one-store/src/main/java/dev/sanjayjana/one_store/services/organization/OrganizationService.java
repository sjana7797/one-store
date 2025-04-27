package dev.sanjayjana.one_store.services.organization;

import dev.sanjayjana.one_store.entities.Organization;
import dev.sanjayjana.one_store.exceptions.NotFoundException;
import dev.sanjayjana.one_store.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements IOrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization getOrganization(String organizationId) {

        return organizationRepository.findById(organizationId)
                .orElseThrow(() -> new NotFoundException("Organization not found with id: " + organizationId));
    }
}
