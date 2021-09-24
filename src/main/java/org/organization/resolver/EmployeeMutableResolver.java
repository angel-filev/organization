package org.organization.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.organization.repository.DepartmentRepository;
import org.organization.repository.EmployeeRepository;
import org.organization.repository.OrganizationRepository;
import org.springframework.stereotype.Component;
import org.organization.domain.Department;
import org.organization.domain.Employee;
import org.organization.domain.EmployeeInput;
import org.organization.domain.Organization;

@Component
public class EmployeeMutableResolver implements GraphQLMutationResolver {

	DepartmentRepository departmentRepository;
	EmployeeRepository employeeRepository;
	OrganizationRepository organizationRepository;

	EmployeeMutableResolver(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, OrganizationRepository organizationRepository) {
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
		this.organizationRepository = organizationRepository;
	}

	public Employee newEmployee(EmployeeInput employeeInput) {
		Department department = departmentRepository.findById(employeeInput.getDepartmentId()).get();
		Organization organization = organizationRepository.findById(employeeInput.getOrganizationId()).get();
		return employeeRepository.save(new Employee(null, employeeInput.getFirstName(), employeeInput.getLastName(),
				employeeInput.getPosition(), employeeInput.getAge(), employeeInput.getSalary(),
				department, organization));
	}

}
