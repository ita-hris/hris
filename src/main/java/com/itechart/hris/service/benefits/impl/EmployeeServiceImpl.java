package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Employee;
import com.itechart.hris.model.benefits.dto.EmployeeDto;
import com.itechart.hris.repository.benefits.EmployeeRepository;
import com.itechart.hris.service.benefits.CompanyService;
import com.itechart.hris.service.benefits.DepartmentService;
import com.itechart.hris.service.benefits.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository repository;
  private final DepartmentService departmentService;
  private final CompanyService companyService;

  @Autowired
  public EmployeeServiceImpl(
      EmployeeRepository repository,
      @Lazy DepartmentService departmentService,
      @Lazy CompanyService companyService) {
    this.repository = repository;
    this.departmentService = departmentService;
    this.companyService = companyService;
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
  public List<Employee> getAllById(List<Long> employeesId) {
    return repository.findAllById(employeesId);
  }

  @Override
  public Employee create(EmployeeDto dto) {
    return repository.save(toEmployee(dto));
  }

  @Override
  public Employee update(Long employeeId, EmployeeDto updateDto) {
    Optional<Employee> optionalEmployee = repository.findById(employeeId);
    if (optionalEmployee.isPresent()) {
      Employee updatedEmployee = toEmployee(updateDto);
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

  private Employee toEmployee(EmployeeDto dto) {
    return Employee.builder()
        .firstName(dto.getFirstName())
        .lastName(dto.getLastName())
        .department(departmentService.getById(dto.getDepartmentId()))
        .company(companyService.getById(dto.getCompanyId()))
        .build();
  }
}
