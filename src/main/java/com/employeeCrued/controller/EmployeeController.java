
package com.employeeCrued.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeCrued.modal.Employee;
import com.employeeCrued.services.EmployeeServices;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired(required = true)
    EmployeeServices employeeServices;

    /*
     * REST API : Register employee
     */
    @PostMapping("/add")
    public ResponseEntity<Employee> regEmployee(@RequestBody Employee emp) {
        log.info("REST Request : Register Employee");

        Employee employee = employeeServices.registorEmployee(emp);

        return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
    }

    /*
     * REST API : Get employee details by ID
     */
    @GetMapping("/getEmpDetails/{id}")
    public ResponseEntity<Employee> getEmpDetails(@PathVariable Long id)
            throws Exception {

        Employee emp = employeeServices.getEmpDetails(id);

        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    /*
     * REST API : Get all employees
     */
    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> getAllEmpDetails() {

        List<Employee> emp = employeeServices.getAllEmployee();

        return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);
    }

    /*
     * REST API : Delete employee by ID
     */
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {

        log.info("REST Request : Delete employee by using ID");

        String emp = employeeServices.deleteEmployeeById(id);

        log.info("Send response to client side");

        return new ResponseEntity<String>(emp, HttpStatus.OK);
    }

    /*
     * REST API : Complete employee details update
     */
    @PutMapping("/{id}/employee")
    public ResponseEntity<Employee> comUpdateDetails(
            @PathVariable long id,
            @RequestBody Employee employee) {

        log.info("REST Request : Complete details update");

        Employee emp = employeeServices.comEmployeeUpdate(id, employee);

        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    /*
     * REST API : Partial employee update
     */
    @PatchMapping("/{id}/employee")
    public ResponseEntity<Employee> patchUpdateDetails(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        log.info("REST Request : Partial employee details update");

        Employee emp = employeeServices.comEmployeeUpdate(id, employee);

        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

    /*
     * REST API : Add multiple employees
     */
    @PostMapping("/addemployees")
    public ResponseEntity<Iterable<Employee>> addMultipleEmployee(
            @RequestBody Iterable<Employee> listOfEmployees) {

        log.info("REST Request : Add multiple employees");

        Iterable<Employee> emp =employeeServices.addAllEmployees(listOfEmployees);

        return new ResponseEntity<Iterable<Employee>>(emp, HttpStatus.CREATED);
    }
    /*
     * REST Api : Count of employee
     */
    @GetMapping("/countofemp")
    public ResponseEntity<Long> countemp(){
    	log.info("REST Request : Count of employee");
    	return ResponseEntity.ok(employeeServices.findTotalCountOfEmployees());
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
