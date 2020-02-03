package com.itechart.hris.service.benefits.impl;

import com.itechart.hris.model.benefits.Department;
import com.itechart.hris.repository.benefits.DepartmentRepository;
import com.itechart.hris.service.benefits.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
  private DepartmentRepository repository;

  @Autowired
  public DepartmentServiceImpl(DepartmentRepository repository) {
    this.repository = repository;
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
  public Department create(Department department) {
    return repository.save(department);
  }

  @Override
  public Department update(Long departmentId, Department updatedDepartment) {
    Optional<Department> optionalDepartment = repository.findById(departmentId);
    if (optionalDepartment.isPresent()) {
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
}
