package org.organization.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Component;
import org.organization.domain.Organization;

@Component
public class OrganizationQueryResolver implements GraphQLQueryResolver {

	private OrganizationRepository repository;

	OrganizationQueryResolver(OrganizationRepository repository) {
		this.repository = repository;
	}

	public Iterable<Organization> organizations() {
		return repository.findAll();
	}

	public Organization organization(Integer id) {
		return repository.findById(id).orElseThrow();
	}
}
