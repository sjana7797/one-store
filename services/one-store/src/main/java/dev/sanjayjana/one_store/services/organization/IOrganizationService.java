package dev.sanjayjana.one_store.services.organization;

import dev.sanjayjana.one_store.model.Organization;

public interface IOrganizationService {
    Organization getOrganization(String organizationId);
}
