package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Employee;
import com.itechart.hris.repository.benefits.EmployeeRepository;
import com.itechart.hris.service.benefits.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository repository;

  @Autowired
  public EmployeeServiceImpl(EmployeeRepository repository) {
    this.repository = repository;
  }

  @Override
  public Employee getById(Long employeeId) {
    Optional<Employee> optionalEmployee = repository.findById(employeeId);
    // TODO throw new ElementNotFoundException() if Employee is null;
    return optionalEmployee.orElse(null);
  }

  @Override
  public List<Employee> getAll() {
    return repository.findAll();
  }

  @Override
  public Employee create(Employee employee) {
    return repository.save(employee);
  }

  @Override
  public Employee update(Long employeeId, Employee updatedEmployee) {
    Optional<Employee> optionalEmployee = repository.findById(employeeId);
    if (optionalEmployee.isPresent()) {
      updatedEmployee.setId(employeeId);
      return repository.save(updatedEmployee);
    } else {
      // TODO throw new ElementNotFoundException() if Employee is null;
      return null;
    }
  }

  @Override
  public void delete(Long employeeId) {
    // TODO throw new ElementNotFoundException() if Employee is null;
    Employee employee = repository.findById(employeeId).orElse(null);
    repository.delete(employee);
  }
}
