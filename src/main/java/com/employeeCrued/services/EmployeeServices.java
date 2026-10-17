package com.employeeCrued.services;

import java.util.List;

import com.employeeCrued.modal.Employee;

public interface EmployeeServices {
	public Employee registorEmployee(Employee employee);
	public Employee getEmpDetails(Long id) throws Exception;
	public List<Employee> getAllEmployee();
	public String deleteEmployeeById(long id);
	public Employee comEmployeeUpdate(long id, Employee employee);
	public Employee patchEmployeeUpdate();
	public Iterable<Employee> addAllEmployees(Iterable<Employee> listOfEmployees);
	public long findTotalCountOfEmployees();

}
