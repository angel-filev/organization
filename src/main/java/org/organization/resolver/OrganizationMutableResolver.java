package org.organization.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Component;
import org.organization.domain.Organization;
import org.organization.domain.OrganizationInput;

@Component
public class OrganizationMutableResolver implements GraphQLMutationResolver {

	OrganizationRepository repository;

	OrganizationMutableResolver(OrganizationRepository repository) {
		this.repository = repository;
	}

	public Organization newOrganization(OrganizationInput organizationInput) {
		return repository.save(new Organization(null, organizationInput.getName(), null, null));
	}

}
