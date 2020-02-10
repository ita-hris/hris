package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Department;
import com.itechart.hris.model.benefits.dto.DepartmentDto;
import com.itechart.hris.repository.benefits.DepartmentRepository;
import com.itechart.hris.service.benefits.CompanyService;
import com.itechart.hris.service.benefits.DepartmentService;
import com.itechart.hris.service.benefits.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
  private final DepartmentRepository repository;
  private final EmployeeService employeeService;
  private final CompanyService companyService;

  @Autowired
  public DepartmentServiceImpl(
      DepartmentRepository repository,
      @Lazy EmployeeService employeeService,
      @Lazy CompanyService companyService) {
    this.repository = repository;
    this.employeeService = employeeService;
    this.companyService = companyService;
  }

  @Override
  public Department getById(Long departmentId) {
    Optional<Department> optionalDepartment = repository.findById(departmentId);
    // TODO throw new ElementNotFoundException() if department is null;
    return optionalDepartment.orElse(null);
  }

  @Override
  public List<Department> getAll() {
    return repository.findAll();
  }

  @Override
  public List<Department> getAllById(List<Long> departmentsId) {
    return repository.findAllById(departmentsId);
  }

  @Override
  public Department create(DepartmentDto dto) {
    return repository.save(toDepartment(dto));
  }

  @Override
  public Department update(Long departmentId, DepartmentDto updatedDto) {
    Optional<Department> optionalDepartment = repository.findById(departmentId);
    if (optionalDepartment.isPresent()) {
      Department updatedDepartment = toDepartment(updatedDto);
      updatedDepartment.setId(departmentId);
      return repository.save(updatedDepartment);
    } else {
      // TODO throw new ElementNotFoundException() if department is null;
      return null;
    }
  }

  @Override
  public void delete(Long departmentId) {
    // TODO throw new ElementNotFoundException() if department is null;
    Department department = repository.findById(departmentId).orElse(null);
    repository.delete(department);
  }

  private Department toDepartment(DepartmentDto dto) {
    return Department.builder()
        .name(dto.getName())
        .employees(employeeService.getAllById(dto.getEmployeesId()))
        .company(companyService.getById(dto.getCompanyId()))
        .build();
  }
}
