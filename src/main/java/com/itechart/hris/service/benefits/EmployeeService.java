package com.itechart.hris.service.benefits;

import com.itechart.hris.model.benefits.Employee;
import com.itechart.hris.model.benefits.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
  Employee getById(Long employeeId);

  List<Employee> getAll();

  List<Employee> getAllById(List<Long> employeesId);

  Employee create(EmployeeDto dto);

  Employee update(Long employeeId, EmployeeDto updatedDto);

  void delete(Long employeeId);
}
