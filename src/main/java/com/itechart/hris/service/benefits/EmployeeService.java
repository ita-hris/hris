package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Employee;

import java.util.List;

public interface EmployeeService {
  Employee getById(Long employeeId);

  List<Employee> getAll();

  Employee create(Employee employee);

  Employee update(Long employeeId, Employee updatedEmployee);

  void delete(Long employeeId);
}
