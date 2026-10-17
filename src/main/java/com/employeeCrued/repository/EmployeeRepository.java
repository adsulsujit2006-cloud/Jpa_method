package com.employeeCrued.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employeeCrued.modal.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
