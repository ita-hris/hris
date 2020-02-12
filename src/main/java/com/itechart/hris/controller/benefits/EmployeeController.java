package com.itechart.hris.controller.benefits;

import com.itechart.hris.model.benefits.Employee;
import com.itechart.hris.model.benefits.dto.EmployeeDto;
import com.itechart.hris.service.benefits.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/benefits/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Employee controller", description = "CRUD operations with employees")
public class EmployeeController {
  private final EmployeeService service;

  @Autowired
  public EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping
  @ApiOperation(value = "Get a list of employees")
  public List<Employee> getAllEmployees() {
    return service.getAll();
  }

  @GetMapping("/{employeeId}")
  @ApiOperation(value = "Get an employee by id")
  public Employee getEmployee(@PathVariable("employeeId") Long employeeId) {
    return service.getById(employeeId);
  }

  @PostMapping
  @ApiOperation(value = "Create a new employee")
  public Employee createEmployee(@RequestBody EmployeeDto dto) {
    return service.create(dto);
  }

  @PutMapping("/{employeeId}")
  @ApiOperation(value = "Update an employee")
  public Employee updateEmployee(
      @PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDto dto) {
    return service.update(employeeId, dto);
  }

  @DeleteMapping("/{employeeId}")
  @ApiOperation(value = "Delete an employee")
  public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
    service.delete(employeeId);
  }
}
