package org.organization.repository;

import org.springframework.data.repository.CrudRepository;
import org.organization.domain.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
}
