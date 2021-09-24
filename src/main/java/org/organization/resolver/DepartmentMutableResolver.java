package org.organization.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.organization.repository.DepartmentRepository;
import org.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Component;
import org.organization.domain.Department;
import org.organization.domain.DepartmentInput;
import org.organization.domain.Organization;

@Component
public class DepartmentMutableResolver implements GraphQLMutationResolver {

	DepartmentRepository departmentRepository;
	OrganizationRepository organizationRepository;

	DepartmentMutableResolver(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
		this.departmentRepository = departmentRepository;
		this.organizationRepository = organizationRepository;
	}

	public Department newDepartment(DepartmentInput departmentInput) {
		Organization organization = organizationRepository.findById(departmentInput.getOrganizationId()).get();
		return departmentRepository.save(new Department(null, departmentInput.getName(), null, organization));
	}

}
