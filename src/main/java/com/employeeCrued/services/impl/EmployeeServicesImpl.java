package com.employeeCrued.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeCrued.modal.Employee;
import com.employeeCrued.repository.EmployeeRepository;
import com.employeeCrued.services.EmployeeServices;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired(required = true)
	public EmployeeRepository employeeRepository;

	@Override
	public Employee registorEmployee(Employee employee) {
		log.info("Request in service layer{}", employee);
		if (employee == null) {
			log.info("Check employee is null or not{}", employee);
			throw new NullPointerException("Employee Details cannot be null" + employee);
		}
		log.info("Send data in repo layer");
		Employee emp = employeeRepository.save(employee);
		log.info("data send to services layer");
		return emp;
	}

	@Override
	public Employee getEmpDetails(Long id) throws Exception {
		if (id == 0) {
			throw new Exception("Employee id cannot be null");
		}
		return employeeRepository.findById(id).orElseThrow(() -> new Exception("Employee not found with id " + id));
	}

	@Override
	public List<Employee> getAllEmployee() {
		/*
		 * first create one Array list and store data to employee list
		 */
		/*
		 * Reason of this Process : CrudRepository.findAll() returns Iterable<Employee>
		 * not return list<Employee> this reason to this process need
		 */
		List<Employee> emp = new ArrayList<Employee>();
		log.info("Iterate theis ");
		for (Employee employee : employeeRepository.findAll()) {
			emp.add(employee);

		}

		return emp;

	}

	@Override
	public String deleteEmployeeById(long id) {
		if (id == 0) {
			log.info("Check id is 0 or not : {}", id);
			throw new NullPointerException("Id must be grater than zero" + id);
		}
		employeeRepository.deleteById(id);
		return "Delete Employee Successfuly";
	}

	@Override
	public Employee comEmployeeUpdate(long id, Employee employee) {
		if(id==0) {
			log.info("Check id null or not ");
			throw new NullPointerException("Enter appropate Id : "+id);
		}
		if(employee==null) {
			log.info("check employee is null or not :{}",employee);
		}
		Employee emp= employeeRepository.save(employee);
		return emp;
	}

	@Override
	public Employee patchEmployeeUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Employee> addAllEmployees(Iterable<Employee> listOfEmployees) {
		log.info("check employee is null or not :{}",listOfEmployees);
		if(listOfEmployees==null) {
			throw new NullPointerException("Employee Details cannot be null" + listOfEmployees);
		}
		Iterable<Employee> employee= employeeRepository.saveAll(listOfEmployees);
		return employee;
	}

	@Override
	public long findTotalCountOfEmployees() {
		
		return employeeRepository.count();
	}
	
	
}
